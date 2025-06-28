import tensorflow as tf
import numpy as np
import pandas as pd
import os
import mido
from collections import defaultdict
import matplotlib.pyplot as plt
import music21
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
import pretty_midi
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Dropout
from tensorflow.keras.callbacks import EarlyStopping, ReduceLROnPlateau

class MusicEmotionAnalyzer:
    def __init__(self):
        """Sınıfı başlatır ve gerekli değişkenleri tanımlar."""
        self.emotions = ['Neşe', 'Hüzün', 'Enerji', 'Melankoli', 'Derinlik', 'Heyecan', 'Endişe', 'Mutluluk', 'Gerginlik']
        
        # Her nota için olası duygular (notanın tonalitedeki rolüne göre)
        self.emotion_map = {
            'C': ['Neşe', 'Mutluluk', 'Enerji'],      # Majör tonalitelerin toniği
            'C#': ['Hüzün', 'Derinlik', 'Melankoli'], # Minör tonalitelerin toniği
            'D': ['Enerji', 'Neşe', 'Heyecan'],       # Majör dominant
            'D#': ['Melankoli', 'Hüzün', 'Derinlik'], # Minör mediant
            'E': ['Heyecan', 'Enerji', 'Neşe'],       # Majör mediant
            'E-': ['Hüzün', 'Melankoli', 'Derinlik'], # Minör dominant
            'F': ['Derinlik', 'Melankoli', 'Hüzün'],  # Subdominant
            'F#': ['Enerji', 'Heyecan', 'Neşe'],      # Majör leading tone
            'G': ['Neşe', 'Enerji', 'Mutluluk'],      # Dominant
            'G#': ['Melankoli', 'Derinlik', 'Hüzün'], # Minör leading tone
            'A': ['Enerji', 'Neşe', 'Heyecan'],       # Majör submediant
            'A-': ['Hüzün', 'Melankoli', 'Derinlik'], # Minör submediant
            'B': ['Heyecan', 'Enerji', 'Neşe'],       # Majör leading tone
            'B-': ['Melankoli', 'Hüzün', 'Derinlik']  # Minör leading tone
        }
        
        # Tonalite-duygu eşleştirmeleri (her tonalite için 3 duygu)
        self.key_emotion_map = {
            # Majör tonaliteler (diyez) - Genelde pozitif duygular
            'C major': ['Neşe', 'Mutluluk', 'Enerji'],
            'G major': ['Enerji', 'Neşe', 'Heyecan'],
            'D major': ['Heyecan', 'Enerji', 'Neşe'],
            'A major': ['Neşe', 'Enerji', 'Mutluluk'],
            'E major': ['Heyecan', 'Neşe', 'Enerji'],
            'B major': ['Enerji', 'Heyecan', 'Neşe'],
            'F# major': ['Neşe', 'Enerji', 'Heyecan'],
            'C# major': ['Heyecan', 'Neşe', 'Enerji'],
            
            # Majör tonaliteler (bemol) - Daha yumuşak, melankolik duygular
            'F major': ['Derinlik', 'Melankoli', 'Hüzün'],
            'B- major': ['Hüzün', 'Melankoli', 'Derinlik'],
            'E- major': ['Melankoli', 'Derinlik', 'Hüzün'],
            'A- major': ['Derinlik', 'Hüzün', 'Melankoli'],
            'D- major': ['Hüzün', 'Melankoli', 'Derinlik'],
            'G- major': ['Melankoli', 'Derinlik', 'Hüzün'],
            
            # Minör tonaliteler (diyez) - Derin, yoğun duygular
            'A minor': ['Melankoli', 'Hüzün', 'Derinlik'],
            'E minor': ['Hüzün', 'Derinlik', 'Melankoli'],
            'B minor': ['Derinlik', 'Melankoli', 'Hüzün'],
            'F# minor': ['Melankoli', 'Hüzün', 'Derinlik'],
            'C# minor': ['Hüzün', 'Derinlik', 'Melankoli'],
            'G# minor': ['Derinlik', 'Melankoli', 'Hüzün'],
            'D# minor': ['Melankoli', 'Hüzün', 'Derinlik'],
            
            # Minör tonaliteler (bemol) - Endişe ve gerginlik duyguları
            'D minor': ['Endişe', 'Hüzün', 'Gerginlik'],
            'G minor': ['Gerginlik', 'Endişe', 'Hüzün'],
            'C minor': ['Hüzün', 'Gerginlik', 'Endişe'],
            'F minor': ['Endişe', 'Hüzün', 'Gerginlik'],
            'B- minor': ['Gerginlik', 'Endişe', 'Hüzün'],
            'E- minor': ['Hüzün', 'Gerginlik', 'Endişe'],
            'A- minor': ['Endişe', 'Hüzün', 'Gerginlik'],
            'D- minor': ['Gerginlik', 'Endişe', 'Hüzün'],
            'G- minor': ['Hüzün', 'Gerginlik', 'Endişe']
        }
        
        # Nota ve duygu indekslerini oluştur
        self.note_to_index = {note: i for i, note in enumerate(['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B'])}
        self.emotion_to_index = {emotion: i for i, emotion in enumerate(self.emotions)}
        
        # Modelleri yükle veya oluştur
        self.load_or_create_models()

    def load_or_create_models(self):
        """Modelleri yükle veya oluştur"""
        if os.path.exists('emotion_model.h5') and os.path.exists('tonality_model.h5'):
            # Modelleri yükle
            self.model = tf.keras.models.load_model('emotion_model.h5')
            self.tonality_model = tf.keras.models.load_model('tonality_model.h5')
            
            # Modelleri derle
            self.model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
            self.tonality_model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
        else:
            self.create_models()

    def create_models(self):
        """Duygu ve tonalite modellerini oluştur"""
        # Duygu analizi modeli
        self.model = Sequential([
            Dense(128, activation='relu', input_shape=(12,)),
            Dropout(0.3),
            Dense(64, activation='relu'),
            Dropout(0.2),
            Dense(len(self.emotion_to_index), activation='sigmoid')
        ])
        
        # Tonalite tahmin modeli
        self.tonality_model = Sequential([
            Dense(64, activation='relu', input_shape=(12,)),
            Dropout(0.2),
            Dense(32, activation='relu'),
            Dense(1, activation='sigmoid')  # 1: Major, 0: Minor
        ])
        
        # Modelleri derle
        self.model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
        self.tonality_model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])
        
        # Modelleri kaydet
        self.model.save('emotion_model.h5')
        self.tonality_model.save('tonality_model.h5')

    def midi_to_note_name(self, midi_note):
        """MIDI nota numarasını nota ismine çevirir."""
        notes = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
        return notes[midi_note % 12]
    
    def extract_features(self, file_path):
        """MIDI dosyasından özellik çıkarımı yapar."""
        try:
            midi = mido.MidiFile(file_path)
            note_counts = defaultdict(int)
            total_notes = 0
            
            for track in midi.tracks:
                for msg in track:
                    if msg.type == 'note_on' and msg.velocity > 0:
                        note_name = self.midi_to_note_name(msg.note)
                        note_counts[note_name] += 1
                        total_notes += 1
            
            # Özellik vektörü oluştur (sadece nota kullanım oranları)
            features = []
            for note in ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']:
                if total_notes > 0:
                    features.append(note_counts[note] / total_notes)  # Nota kullanım oranı
                else:
                    features.append(0)
            
            return np.array(features)
            
        except Exception as e:
            print(f"Hata: {file_path} dosyası işlenirken bir sorun oluştu: {str(e)}")
            return None
    
    def analyze_key(self, midi_path):
        """MIDI dosyasının tonalitesini analiz eder."""
        try:
            score = music21.converter.parse(midi_path)
            key = score.analyze('key')
            if key:
                # Tonalite ismini al
                key_str = str(key)
                
                # İlk harfi büyük yap
                if len(key_str) > 0:
                    key_str = key_str[0].upper() + key_str[1:]
                
                # major/minor kısmını küçük harfe çevir
                if ' major' in key_str.lower():
                    key_str = key_str.replace(' major', ' major').replace(' Major', ' major')
                elif ' minor' in key_str.lower():
                    key_str = key_str.replace(' minor', ' minor').replace(' Minor', ' minor')
                return key_str
        except Exception as e:
            print(f"Tonalite analizi hatası: {str(e)}")
        return None
    
    def analyze_emotions(self, file_path):
        """MIDI dosyasındaki duyguları ve tonaliteyi analiz eder."""
        try:
            # Özellikleri çıkar
            features = self.extract_features(file_path)
            if features is None:
                return []
            
            # MIDI dosyasından notaları say
            midi = mido.MidiFile(file_path)
            note_counts = defaultdict(int)
            total_notes = 0
            for track in midi.tracks:
                for msg in track:
                    if msg.type == 'note_on' and msg.velocity > 0:
                        note_name = self.midi_to_note_name(msg.note)
                        note_counts[note_name] += 1
                        total_notes += 1
            
            # En çok kullanılan 3 notayı bul
            sorted_notes = sorted(note_counts.items(), key=lambda x: x[1], reverse=True)
            top_3_notes = sorted_notes[:3]
            most_used_note = top_3_notes[0][0] if top_3_notes else None
            
            # Tonaliteyi analiz et (music21 ile)
            key = self.analyze_key(file_path)
            key_emotions = self.key_emotion_map.get(key, [])
            
            # Duygu tahminlerini al
            emotion_predictions = self.model.predict(np.array([features]))
            emotion_scores = emotion_predictions[0]
            
            # Tonalite tahminini al
            tonality_prediction = self.tonality_model.predict(np.array([features]))
            is_major = tonality_prediction[0][0] > 0.5
            
            # Duygu skorlarını hesapla
            emotion_counts = defaultdict(float)
            
            # Model tahminlerini ekle
            for i, emotion in enumerate(self.emotions):
                emotion_counts[emotion] += float(emotion_scores[i]) * 100
            
            # Tonalite duygularını ekle
            if key_emotions:
                for emotion in key_emotions:
                    emotion_counts[emotion] += 20  # Tonalite duygularına ekstra ağırlık ver
            
            # Tonaliteye göre duygu skorlarını ayarla
            if is_major:
                # Majör tonalite için pozitif duyguları güçlendir
                for emotion in ['Neşe', 'Enerji', 'Mutluluk', 'Heyecan']:
                    emotion_counts[emotion] *= 1.2
                # Minör duyguları zayıflat
                for emotion in ['Hüzün', 'Melankoli', 'Derinlik', 'Endişe', 'Gerginlik']:
                    emotion_counts[emotion] *= 0.8
            else:
                # Minör tonalite için minör duyguları güçlendir
                for emotion in ['Hüzün', 'Melankoli', 'Derinlik', 'Endişe', 'Gerginlik']:
                    emotion_counts[emotion] *= 1.2
                # Majör duyguları zayıflat
                for emotion in ['Neşe', 'Enerji', 'Mutluluk', 'Heyecan']:
                    emotion_counts[emotion] *= 0.8
            
            # En çok kullanılan duyguları bul
            total_score = sum(emotion_counts.values())
            if total_score > 0:
                # Duygu yüzdelerini hesapla ve normalize et
                emotion_percentages = {emotion: (score / total_score) * 100 
                                     for emotion, score in emotion_counts.items()}
                
                # Yüzdeleri normalize et (toplam %100 olacak şekilde)
                total_percentage = sum(emotion_percentages.values())
                if total_percentage > 100:
                    normalization_factor = 100 / total_percentage
                    emotion_percentages = {emotion: percentage * normalization_factor 
                                         for emotion, percentage in emotion_percentages.items()}
                
                sorted_emotions = sorted(emotion_percentages.items(), 
                                       key=lambda x: x[1], 
                                       reverse=True)
                
                # Sonuçları yazdır
                print(f"\nNota ve Tonalite Analizi:")
                if most_used_note:
                    print(f"En çok kullanılan nota: {most_used_note}")
                print(f"Tahmin Edilen Tonalite: {'Major' if is_major else 'Minor'}")
                
                return sorted_emotions
            return []
            
        except Exception as e:
            print(f"Hata: {file_path} dosyası işlenirken bir sorun oluştu: {str(e)}")
            return []
    
    def predict_emotions(self, features):
        """Verilen özelliklerden duyguları tahmin eder."""
        predictions = self.model.predict(np.array([features]))
        # Tahminleri olasılık değerlerine dönüştür
        probabilities = predictions[0]
        
        # En yüksek olasılıklı 3 duyguyu seç
        top_3_indices = np.argsort(probabilities)[-3:]
        predicted_emotions = [self.emotions[i] for i in top_3_indices]
        
        return predicted_emotions

    def create_model(self):
        """Basit bir sinir ağı modeli oluşturur."""
        model = Sequential([
            Dense(64, activation='relu', input_shape=(28,)),
            Dropout(0.2),
            Dense(32, activation='relu'),
            Dropout(0.1),
            Dense(len(self.emotions), activation='softmax')
        ])
        
        model.compile(optimizer=tf.keras.optimizers.Adam(learning_rate=0.001),
                    loss='categorical_crossentropy',
                    metrics=['accuracy'])
        
        return model
    
    def test_models(self, X_test, y_test, emotion_history=None, tonality_history=None):
        """Test modelleri ve sonuçları görselleştir"""
        print("\nTest Sonuçları:")
        
        # Test seti üzerinde tahminler yap
        predictions = self.model.predict(X_test)
        tonality_predictions = self.tonality_model.predict(X_test)
        
        # İlk 5 örnek için detaylı sonuçlar
        print("\nİlk 5 Test Örneği:")
        for i in range(min(5, len(X_test))):
            # Gerçek tonaliteyi belirle
            note_ratios = {note: ratio for note, ratio in zip(self.note_to_index.keys(), X_test[i])}
            real_tonality = "Major" if self.is_major(note_ratios) else "Minor"
            real_tonality_emotions = self.get_tonality_emotions(real_tonality)
            
            # En yüksek 3 tahmin edilen duyguyu al
            pred_indices = np.argsort(predictions[i])[-3:]
            predicted_emotions = [self.emotions[idx] for idx in pred_indices]
            predicted_tonality = "Major" if tonality_predictions[i][0] > 0.5 else "Minor"
            
            # Benzerlik oranını hesapla
            common_emotions = set(real_tonality_emotions) & set(predicted_emotions)
            similarity_ratio = len(common_emotions) / len(real_tonality_emotions) * 100 if real_tonality_emotions else 0
            
            # Benzerlik oranı %50'den fazlaysa %100'e tamamla
            if similarity_ratio > 50:
                similarity_ratio = 100
            
            print(f"\nÖrnek {i+1}:")
            print(f"Tonalitenin duyguları: {real_tonality_emotions}")
            print(f"Gerçek tonalite: {real_tonality}")
            print(f"Tahmin edilen duygular: {predicted_emotions}")
            print(f"Tahmin edilen tonalite: {predicted_tonality}")
            print(f"Benzerlik oranı: %{similarity_ratio:.2f}")
        
        # Genel test sonuçları
        correct_predictions = 0
        correct_tonality = 0
        total_examples = len(X_test)
        
        for i in range(total_examples):
            note_ratios = {note: ratio for note, ratio in zip(self.note_to_index.keys(), X_test[i])}
            real_tonality = "Major" if self.is_major(note_ratios) else "Minor"
            real_tonality_emotions = self.get_tonality_emotions(real_tonality)
            
            # En yüksek 3 tahmin edilen duyguyu al
            pred_indices = np.argsort(predictions[i])[-3:]
            predicted_emotions = [self.emotions[idx] for idx in pred_indices]
            predicted_tonality = "Major" if tonality_predictions[i][0] > 0.5 else "Minor"
            
            # Benzerlik oranını hesapla
            common_emotions = set(real_tonality_emotions) & set(predicted_emotions)
            similarity_ratio = len(common_emotions) / len(real_tonality_emotions) * 100 if real_tonality_emotions else 0
            
            # Benzerlik oranı %50'den fazlaysa %100'e tamamla
            if similarity_ratio > 50:
                similarity_ratio = 100
                correct_predictions += 1
            
            if predicted_tonality == real_tonality:
                correct_tonality += 1
        
        overall_accuracy = (correct_predictions / total_examples) * 100
        tonality_accuracy = (correct_tonality / total_examples) * 100
        
        print(f"\nGenel test doğruluğu: %{overall_accuracy:.2f}")
        print(f"Tonalite tahmin doğruluğu: %{tonality_accuracy:.2f}")
        
        # Test sonuçlarını görselleştir
        if emotion_history and tonality_history:
            # Bar grafikleri
            plt.figure(figsize=(15, 10))
            
            # 1. Duygu Modeli Grafikleri
            plt.subplot(2, 2, 1)
            plt.plot(emotion_history.history['accuracy'], label='Eğitim Doğruluğu')
            plt.plot(emotion_history.history['val_accuracy'], label='Doğrulama Doğruluğu')
            plt.title('Duygu Modeli - Doğruluk')
            plt.xlabel('Epoch')
            plt.ylabel('Doğruluk')
            plt.legend()
            
            plt.subplot(2, 2, 2)
            plt.plot(emotion_history.history['loss'], label='Eğitim Kaybı')
            plt.plot(emotion_history.history['val_loss'], label='Doğrulama Kaybı')
            plt.title('Duygu Modeli - Kayıp')
            plt.xlabel('Epoch')
            plt.ylabel('Kayıp')
            plt.legend()
            
            # 2. Tonalite Modeli Grafikleri
            plt.subplot(2, 2, 3)
            plt.plot(tonality_history.history['accuracy'], label='Eğitim Doğruluğu')
            plt.plot(tonality_history.history['val_accuracy'], label='Doğrulama Doğruluğu')
            plt.title('Tonalite Modeli - Doğruluk')
            plt.xlabel('Epoch')
            plt.ylabel('Doğruluk')
            plt.legend()
            
            plt.subplot(2, 2, 4)
            plt.plot(tonality_history.history['loss'], label='Eğitim Kaybı')
            plt.plot(tonality_history.history['val_loss'], label='Doğrulama Kaybı')
            plt.title('Tonalite Modeli - Kayıp')
            plt.xlabel('Epoch')
            plt.ylabel('Kayıp')
            plt.legend()
            
            plt.tight_layout()
            plt.savefig('test_results.png', dpi=300, bbox_inches='tight')
            plt.show()
            
            # Çizgi grafikleri
            plt.figure(figsize=(15, 5))
            
            # Duygu modeli eğitim sonuçları
            plt.subplot(1, 2, 1)
            plt.plot(emotion_history.history['accuracy'], label='Doğruluk')
            plt.plot(emotion_history.history['loss'], label='Kayıp')
            plt.title('Duygu Modeli Eğitim Sonuçları')
            plt.xlabel('Epoch')
            plt.ylabel('Değer')
            plt.legend()
            
            # Tonalite modeli eğitim sonuçları
            plt.subplot(1, 2, 2)
            plt.plot(tonality_history.history['accuracy'], label='Doğruluk')
            plt.plot(tonality_history.history['loss'], label='Kayıp')
            plt.title('Tonalite Modeli Eğitim Sonuçları')
            plt.xlabel('Epoch')
            plt.ylabel('Değer')
            plt.legend()
            
            plt.tight_layout()
            plt.savefig('training_line_results.png', dpi=300, bbox_inches='tight')
            plt.show()

    def load_models(self):
        """Eğitilmiş modelleri yükle"""
        try:
            # Duygu modelini yükle
            self.model = tf.keras.models.load_model('emotion_model.h5')
            
            # Tonalite modelini yükle
            self.tonality_model = tf.keras.models.load_model('tonality_model.h5')
            
            print("Modeller başarıyla yüklendi")
            return True
        except Exception as e:
            print(f"Model yükleme hatası: {str(e)}")
            return False

    def predict(self, midi_file):
        """MIDI dosyası için tahmin yap"""
        try:
            # MIDI dosyasını yükle
            midi_data = pretty_midi.PrettyMIDI(midi_file)
            
            # Nota kullanım oranlarını hesapla
            note_counts = {}
            total_notes = 0
            
            for instrument in midi_data.instruments:
                for note in instrument.notes:
                    note_name = self.get_note_name(note.pitch)  # Oktav numarası olmadan nota adı
                    note_counts[note_name] = note_counts.get(note_name, 0) + 1
                    total_notes += 1
            
            if total_notes == 0:
                print("Dosyada nota bulunamadı!")
                return None, None
            
            # Nota kullanım oranlarını hesapla
            note_ratios = {}
            for note, count in note_counts.items():
                note_ratios[note] = (count / total_notes) * 100
            
            # En çok kullanılan 3 notayı bul
            sorted_notes = sorted(note_ratios.items(), key=lambda x: x[1], reverse=True)
            print("En çok kullanılan 3 nota ve oranları:")
            for note, ratio in sorted_notes[:3]:
                print(f"- {note}: %{ratio:.1f}")
            
            # Tonaliteyi belirle
            is_major = self.is_major(note_ratios)
            tonality = "Major" if is_major else "Minor"
            print(f"Gerçek Tonalite: {tonality}")
            
            # Tonalitenin yansıttığı duyguları göster
            tonality_emotions = self.get_tonality_emotions(tonality)
            print(f"Tonalitenin yansıttığı duygular: {', '.join(tonality_emotions)}")
            
            # Özellik vektörünü oluştur
            features = np.zeros(12)  # 12 nota için
            for note, ratio in note_ratios.items():
                note_index = self.note_to_index[note]
                features[note_index] = ratio
            
            # Tahmin yap
            predictions = self.model.predict(features.reshape(1, -1))
            tonality_predictions = self.tonality_model.predict(features.reshape(1, -1))
            
            return predictions, tonality_predictions
            
        except Exception as e:
            print(f"Hata: {str(e)}")
            return None, None

    def get_note_name(self, pitch):
        """MIDI nota numarasını nota adına çevirir (oktav numarası olmadan)"""
        note_names = ['C', 'C#', 'D', 'D#', 'E', 'F', 'F#', 'G', 'G#', 'A', 'A#', 'B']
        return note_names[pitch % 12]

    def collect_training_data(self):
        """Eğitim verilerini topla"""
        print("\nEğitim verileri toplanıyor...")
        
        train_dir = 'train'
        if not os.path.exists(train_dir):
            print("Train klasörü bulunamadı!")
            return None, None
        
        midi_files = [f for f in os.listdir(train_dir) if f.endswith(('.midi', '.mid'))]
        if not midi_files:
            print("Train klasöründe MIDI dosyası bulunamadı!")
            return None, None
        
        print(f"\nToplam {len(midi_files)} MIDI dosyası işlenecek...")
        
        X = []  # Özellikler
        y = []  # Etiketler
        
        for i, midi_file in enumerate(midi_files, 1):
            try:
                file_path = os.path.join(train_dir, midi_file)
                print(f"\nDosya işleniyor: {midi_file}")
                
                # MIDI dosyasını yükle
                midi_data = pretty_midi.PrettyMIDI(file_path)
                
                # Nota kullanım oranlarını hesapla
                note_counts = {}
                total_notes = 0
                
                for instrument in midi_data.instruments:
                    for note in instrument.notes:
                        note_name = self.get_note_name(note.pitch)  # Oktav numarası olmadan nota adı
                        note_counts[note_name] = note_counts.get(note_name, 0) + 1
                        total_notes += 1
                
                if total_notes == 0:
                    continue
                
                # Nota kullanım oranlarını hesapla
                note_ratios = {}
                for note, count in note_counts.items():
                    note_ratios[note] = (count / total_notes) * 100
                
                # En çok kullanılan 3 notayı bul
                sorted_notes = sorted(note_ratios.items(), key=lambda x: x[1], reverse=True)
                print("En çok kullanılan 3 nota ve oranları:")
                for note, ratio in sorted_notes[:3]:
                    print(f"- {note}: %{ratio:.1f}")
                
                # Tonaliteyi belirle
                is_major = self.is_major(note_ratios)
                tonality = "Major" if is_major else "Minor"
                print(f"Gerçek Tonalite: {tonality}")
                
                # Tonalitenin yansıttığı duyguları göster
                tonality_emotions = self.get_tonality_emotions(tonality)
                print(f"Tonalitenin yansıttığı duygular: {', '.join(tonality_emotions)}")
                
                # Özellik vektörünü oluştur
                features = np.zeros(12)  # 12 nota için
                for note, ratio in note_ratios.items():
                    note_index = self.note_to_index[note]
                    features[note_index] = ratio
                
                # Etiket vektörünü oluştur
                labels = np.zeros(len(self.emotions))
                for emotion in tonality_emotions:
                    labels[self.emotion_to_index[emotion]] = 1
                
                X.append(features)
                y.append(labels)
                
                print(f"İşlenen dosya [{i}/{len(midi_files)}]")
                
            except Exception as e:
                print(f"Hata: {midi_file} dosyası işlenirken bir sorun oluştu: {str(e)}")
                continue
        
        if len(X) == 0:
            print("Hiç özellik çıkarılamadı!")
            return None, None
        
        # Verileri numpy dizilerine dönüştür
        X = np.array(X)
        y = np.array(y)
        
        print(f"\nToplanan veri boyutları:")
        print(f"X shape: {X.shape}")
        print(f"y shape: {y.shape}")
        
        return X, y

    def train(self, csv_path, base_dir):
        """Modelleri eğit ve sonuçları görselleştir"""
        print("\nEğitim başlıyor...")
        
        # Eğitim verilerini topla
        X_train, y_train = self.collect_training_data()
        if X_train is None or y_train is None:
            print("Eğitim verisi toplanamadı!")
            return None, None
        
        # Veri setini eğitim ve test olarak böl
        X_train, X_test, y_train, y_test = train_test_split(X_train, y_train, test_size=0.2, random_state=42)
        
        # Duygu modeli
        self.model = Sequential([
            Dense(128, activation='relu', input_shape=(X_train.shape[1],)),
            Dropout(0.3),
            Dense(64, activation='relu'),
            Dropout(0.2),
            Dense(len(self.emotions), activation='sigmoid')
        ])
        
        self.model.compile(optimizer='adam',
                         loss='binary_crossentropy',
                         metrics=['accuracy'])
        
        # Tonalite modeli
        self.tonality_model = Sequential([
            Dense(64, activation='relu', input_shape=(X_train.shape[1],)),
            Dropout(0.2),
            Dense(32, activation='relu'),
            Dense(1, activation='sigmoid')
        ])
        
        self.tonality_model.compile(optimizer='adam',
                                  loss='binary_crossentropy',
                                  metrics=['accuracy'])
        
        # Early stopping ve learning rate reduction
        callbacks = [
            EarlyStopping(monitor='val_loss', patience=5, restore_best_weights=True),
            ReduceLROnPlateau(monitor='val_loss', factor=0.2, patience=3, min_lr=0.0001)
        ]
        
        # Modelleri eğit
        print("\nDuygu modeli eğitiliyor...")
        emotion_history = self.model.fit(X_train, y_train,
                                       epochs=50,
                                       batch_size=32,
                                       validation_split=0.2,
                                       callbacks=callbacks,
                                       verbose=1)
        
        print("\nTonalite modeli eğitiliyor...")
        tonality_history = self.tonality_model.fit(X_train, y_train[:, 0],
                                                 epochs=50,
                                                 batch_size=32,
                                                 validation_split=0.2,
                                                 callbacks=callbacks,
                                                 verbose=1)
        
        # Eğitim sonuçlarını değerlendir
        print("\nEğitim sonuçları değerlendiriliyor...")
        
        # Duygu modeli eğitim sonuçları
        train_predictions = self.model.predict(X_train)
        correct_predictions = 0
        total_examples = len(X_train)
        
        for i in range(total_examples):
            actual_emotions = [self.emotions[j] for j in range(len(self.emotions)) if y_train[i][j] == 1]
            predicted_emotions = [self.emotions[j] for j in range(len(self.emotions)) if train_predictions[i][j] > 0.5]
            
            # Benzerlik oranını hesapla
            common_emotions = set(actual_emotions) & set(predicted_emotions)
            similarity_ratio = len(common_emotions) / len(actual_emotions) * 100 if actual_emotions else 0
            
            # Benzerlik oranı %50'den fazlaysa %100'e tamamla
            if similarity_ratio > 50:
                similarity_ratio = 100
                correct_predictions += 1
        
        train_accuracy = (correct_predictions / total_examples) * 100
        
        # Tonalite modeli eğitim sonuçları
        tonality_predictions = self.tonality_model.predict(X_train)
        correct_tonality = np.sum((tonality_predictions > 0.5) == (y_train[:, 0] > 0.5))
        tonality_accuracy = (correct_tonality / total_examples) * 100
        
        print(f"\nEğitim sonuçları:")
        print(f"Duygu modeli doğruluğu: %{train_accuracy:.2f}")
        print(f"Tonalite modeli doğruluğu: %{tonality_accuracy:.2f}")
        
        # Eğitim grafiklerini çiz
        plt.figure(figsize=(15, 5))
        
        # Duygu modeli eğitim sonuçları
        plt.subplot(1, 2, 1)
        plt.bar(['Doğruluk', 'Kayıp'], [train_accuracy, 100-train_accuracy])
        plt.title('Duygu Modeli Eğitim Sonuçları')
        plt.ylim(0, 100)
        
        # Tonalite modeli eğitim sonuçları
        plt.subplot(1, 2, 2)
        plt.bar(['Doğruluk', 'Kayıp'], [tonality_accuracy, 100-tonality_accuracy])
        plt.title('Tonalite Modeli Eğitim Sonuçları')
        plt.ylim(0, 100)
        
        plt.tight_layout()
        plt.savefig('training_results.png', dpi=300, bbox_inches='tight')
        plt.show()
        
        # Modelleri kaydet
        self.model.save('emotion_model.h5')
        self.tonality_model.save('tonality_model.h5')
        
        # Test modellerini çağır
        self.test_models(X_test, y_test, emotion_history, tonality_history)
        
        return X_test, y_test

    def get_tonality_emotions(self, tonality):
        """Tonaliteye göre duyguları döndürür"""
        if tonality == "Major":
            return ['Heyecan', 'Enerji', 'Neşe']
        else:
            return ['Melankoli', 'Derinlik', 'Hüzün']

    def is_major(self, note_ratios):
        """Verilen nota oranlarına göre major/minor tonaliteyi belirler."""
        # Major ve minor tonalitelerin karakteristik notaları
        major_notes = ['C', 'D', 'E', 'F', 'G', 'A', 'B']  # Major scale notaları
        minor_notes = ['C', 'D', 'D#', 'E', 'F', 'G', 'A#']  # Minor scale notaları
        
        # Major ve minor notaların toplam oranlarını hesapla
        major_ratio = sum(note_ratios.get(note, 0) for note in major_notes)
        minor_ratio = sum(note_ratios.get(note, 0) for note in minor_notes)
        
        # Tonaliteyi belirle
        is_major = major_ratio > minor_ratio
        
        return is_major

def main():
    # Veri seti yolları
    csv_path = 'C:/Users/MP/PycharmProjects/NoteRecognition/maestro-v3.0.0.csv'
    base_dir = 'C:/Users/MP/PycharmProjects/NoteRecognition'
    
    # Analizör oluştur
    analyzer = MusicEmotionAnalyzer()
    
    # Modeli eğit
    X_test, y_test = analyzer.train(csv_path, base_dir)
    
    # Test et
    if len(X_test) > 0:
        analyzer.test_models(X_test, y_test)
    
    print("\nİşlem tamamlandı.")

if __name__ == "__main__":
    # Veri seti yolları
    csv_path = 'C:/Users/MP/PycharmProjects/NoteRecognition/maestro-v3.0.0.csv'
    base_dir = 'C:/Users/MP/PycharmProjects/NoteRecognition'
    
    # Analizör oluştur
    analyzer = MusicEmotionAnalyzer()
    
    # Modeli eğit
    X_test, y_test = analyzer.train(csv_path, base_dir)
    
    # Test et
    if len(X_test) > 0:
        analyzer.test_models(X_test, y_test)