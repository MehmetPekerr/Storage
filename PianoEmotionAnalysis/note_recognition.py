import tensorflow as tf
import numpy as np
import pandas as pd
import os
import mido
from collections import defaultdict
import matplotlib.pyplot as plt

def midi_to_note_name(midi_note):
    """MIDI nota numarasını nota adına dönüştürür."""
    note_names = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
    return note_names[midi_note % 12]

def extract_features(file_path):
    """MIDI dosyasından temel özellik çıkarımı yapar."""
    try:
        midi = mido.MidiFile(file_path)
        # Her nota için [count, total_duration, avg_velocity]
        note_features = defaultdict(lambda: [0, 0, 0])
        last_note_time = defaultdict(int)
        
        for track in midi.tracks:
            current_time = 0
            for msg in track:
                current_time += msg.time
                
                if msg.type == 'note_on' and msg.velocity > 0:
                    note = msg.note
                    if 21 <= note <= 108:  # MIDI notaları 21-108 arası
                        note_features[note][0] += 1  # Nota sayısı
                        note_features[note][2] += msg.velocity  # Velocity toplamı
                        last_note_time[note] = current_time
                
                elif msg.type == 'note_off' or (msg.type == 'note_on' and msg.velocity == 0):
                    note = msg.note
                    if 21 <= note <= 108:
                        duration = current_time - last_note_time[note]
                        note_features[note][1] += duration  # Nota süresi
        
        # 88 tuşlu piyano için özellik vektörü (3 özellik × 88 nota = 264)
        feature_vector = np.zeros(264)
        for note in range(21, 109):
            idx = (note - 21) * 3
            features = note_features[note]
            
            if features[0] > 0:  # Eğer nota kullanılmışsa
                feature_vector[idx] = features[0]  # Nota sayısı
                feature_vector[idx + 1] = features[1]  # Toplam süre
                feature_vector[idx + 2] = features[2] / features[0]  # Ortalama velocity
        
        # Özellik normalizasyonu
        feature_vector = np.log1p(feature_vector)  # Log normalizasyon
        if np.max(feature_vector) > 0:
            feature_vector = feature_vector / np.max(feature_vector)  # Min-max normalizasyon
        
        return feature_vector
    
    except Exception as e:
        print(f"Hata: {file_path} dosyası işlenirken bir sorun oluştu: {str(e)}")
        return None
    except Exception as e:
        print(f"Hata: {file_path} dosyası işlenirken bir sorun oluştu: {str(e)}")
        return None

def load_dataset(csv_path, base_dir):
    """Veri setini yükler ve özellik çıkarımı yapar."""
    try:
        df = pd.read_csv(csv_path)
        features = []
        labels = []
        
        # Sadece train klasöründeki dosyaları işle
        train_files = [f for f in os.listdir(base_dir) if f.endswith('.midi') or f.endswith('.mid')]
        
        for _, row in df.iterrows():
            midi_filename = row['midi_filename'].split('/')[-1]
            if midi_filename in train_files:
                midi_path = os.path.join(base_dir, midi_filename)
                feature_vector = extract_features(midi_path)
                if feature_vector is not None:
                    features.append(feature_vector)
                    labels.append(row['canonical_composer'])
                    print(f"İşlenen dosya: {midi_path}")
        
        return np.array(features), np.array(labels)
    except Exception as e:
        print(f"Veri seti yüklenirken bir hata oluştu: {str(e)}")
        return None, None

def create_model(input_shape, num_classes):
    """Gelişmiş model mimarisi oluşturur (Bidirectional LSTM, Attention ve Residual bağlantılar)."""
    
    # Giriş katmanı
    inputs = tf.keras.Input(shape=input_shape)
    
    # Nota özelliklerini yeniden şekillendir (88 nota, 3 özellik)
    note_reshape = tf.keras.layers.Reshape((88, 3))(inputs)
    
    # Bidirectional LSTM katmanları
    lstm1 = tf.keras.layers.Bidirectional(tf.keras.layers.LSTM(128, return_sequences=True))(note_reshape)
    lstm1_dropout = tf.keras.layers.Dropout(0.3)(lstm1)
    
    # Attention mekanizması
    attention = tf.keras.layers.Dense(1, use_bias=False)(lstm1_dropout)
    attention_weights = tf.keras.layers.Softmax(axis=1)(attention)
    context_vector = tf.keras.layers.Multiply()([lstm1_dropout, attention_weights])
    context_vector = tf.keras.layers.Lambda(lambda x: tf.reduce_sum(x, axis=1))(context_vector)
    
    # İkinci LSTM katmanı
    lstm2 = tf.keras.layers.Bidirectional(tf.keras.layers.LSTM(64))(lstm1_dropout)
    lstm2_dropout = tf.keras.layers.Dropout(0.3)(lstm2)
    
    # Tüm özellikleri birleştir
    concat = tf.keras.layers.Concatenate()([context_vector, lstm2_dropout])
    
    # Dense katmanları (Residual bağlantılar)
    dense1 = tf.keras.layers.Dense(256, activation='relu')(concat)
    dense1_dropout = tf.keras.layers.Dropout(0.3)(dense1)
    
    # Residual bağlantı
    dense2 = tf.keras.layers.Dense(256, activation='relu')(dense1_dropout)
    dense2_dropout = tf.keras.layers.Dropout(0.3)(dense2)
    residual = tf.keras.layers.Add()([dense1_dropout, dense2_dropout])
    
    # Son katmanlar
    dense3 = tf.keras.layers.Dense(128, activation='relu')(residual)
    dense3_dropout = tf.keras.layers.Dropout(0.2)(dense3)
    outputs = tf.keras.layers.Dense(num_classes, activation='softmax')(dense3_dropout)
    
    # Model oluştur
    model = tf.keras.Model(inputs=inputs, outputs=outputs)
    
    # Model derleme
    optimizer = tf.keras.optimizers.Adam(
        learning_rate=tf.keras.optimizers.schedules.ExponentialDecay(
            initial_learning_rate=0.001,
            decay_steps=1000,
            decay_rate=0.9
        )
    )
    
    model.compile(
        optimizer=optimizer,
        loss='sparse_categorical_crossentropy',
        metrics=['accuracy']
    )
    
    return model

def main():
    # Veri seti yolları
    csv_path = 'C:/Users/MP/PycharmProjects/NoteRecognition/maestro-v3.0.0.csv'
    base_dir = 'C:/Users/MP/PycharmProjects/NoteRecognition/train'
    
    # Veri setini yükle
    print("\nVeri seti yükleniyor...")
    X, y = load_dataset(csv_path, base_dir)
    
    if X is None or y is None:
        print("Veri seti yüklenemedi. Program sonlandırılıyor.")
        return
    
    # Etiketleri sayısal değerlere dönüştür
    from sklearn.preprocessing import LabelEncoder
    le = LabelEncoder()
    y = le.fit_transform(y)
    
    # Veriyi eğitim ve test setlerine ayır
    from sklearn.model_selection import train_test_split
    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)
    
    # Model oluştur
    print("\nModel oluşturuluyor...")
    model = create_model((X.shape[1],), len(le.classes_))
    
    # Early stopping ve model checkpoint ekle
    early_stopping = tf.keras.callbacks.EarlyStopping(
        monitor='val_loss',
        patience=10,
        restore_best_weights=True
    )
    
    model_checkpoint = tf.keras.callbacks.ModelCheckpoint(
        'best_model.h5',
        monitor='val_accuracy',
        save_best_only=True
    )
    
    # Modeli eğit
    print("\nModel eğitiliyor...")
    history = model.fit(X_train, y_train,
                       epochs=100,  # Daha fazla epoch
                       batch_size=16,  # Daha küçük batch size
                       validation_split=0.2,
                       callbacks=[early_stopping, model_checkpoint],
                       verbose=1)
    
    # Modeli değerlendir
    print("\nModel değerlendiriliyor...")
    test_loss, test_acc = model.evaluate(X_test, y_test, verbose=2)
    print(f"\nTest doğruluğu: {test_acc:.4f}")
    
    # Eğitim geçmişini görselleştir
    plt.figure(figsize=(12, 4))
    
    plt.subplot(1, 2, 1)
    plt.plot(history.history['accuracy'], label='Eğitim Doğruluğu')
    plt.plot(history.history['val_accuracy'], label='Doğrulama Doğruluğu')
    plt.title('Model Doğruluğu')
    plt.xlabel('Epoch')
    plt.ylabel('Doğruluk')
    plt.legend()
    
    plt.subplot(1, 2, 2)
    plt.plot(history.history['loss'], label='Eğitim Kaybı')
    plt.plot(history.history['val_loss'], label='Doğrulama Kaybı')
    plt.title('Model Kaybı')
    plt.xlabel('Epoch')
    plt.ylabel('Kayıp')
    plt.legend()
    
    plt.tight_layout()
    plt.savefig('training_history.png')
    plt.close()
    
    # Modeli kaydet
    model.save('note_recognition_model.h5')
    print("\nModel 'note_recognition_model.h5' olarak kaydedildi.")
    
    print("\nEğitim tamamlandı ve sonuçlar kaydedildi.")

if __name__ == "__main__":
    main() 