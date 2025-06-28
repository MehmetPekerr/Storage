from flask import Flask, render_template, request, jsonify
import os
from werkzeug.utils import secure_filename
from music_emotion_analyzer import MusicEmotionAnalyzer
import matplotlib
matplotlib.use('Agg')  # Use Agg backend to avoid threading issues
import matplotlib.pyplot as plt
import base64
from io import BytesIO
from collections import defaultdict
import numpy as np
import mido
import threading

app = Flask(__name__)
app.config['UPLOAD_FOLDER'] = 'uploads'
app.config['MAX_CONTENT_LENGTH'] = 16 * 1024 * 1024  # 16MB max file size

# Create analyzer as a global variable with thread lock
analyzer = None
analyzer_lock = threading.Lock()

def get_plot_base64(emotion_dist):
    """Duygu dağılımı grafiğini base64 formatında döndür"""
    fig = plt.figure(figsize=(10, 6))
    try:
        # Handle both dictionary and list of tuples
        if isinstance(emotion_dist, dict):
            emotions = list(emotion_dist.keys())
            values = list(emotion_dist.values())
        else:
            # Assuming emotion_dist is a list of (emotion, value) tuples
            emotions, values = zip(*emotion_dist) if emotion_dist else ([], [])
        
        plt.bar(emotions, values)
        plt.xticks(rotation=45)
        plt.title('Duygu Dağılımı')
        plt.xlabel('Duygular')
        plt.ylabel('Oran')
        plt.tight_layout()
        
        # Grafiği base64'e çevir
        buffer = BytesIO()
        fig.savefig(buffer, format='png')
        buffer.seek(0)
        image_png = buffer.getvalue()
        return base64.b64encode(image_png).decode('utf-8')
    finally:
        plt.close(fig)
        if 'buffer' in locals():
            buffer.close()

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/analyze', methods=['POST'])
def analyze():
    global analyzer
    
    if 'file' not in request.files:
        return jsonify({'error': 'Dosya yüklenmedi'})
    
    file = request.files['file']
    if file.filename == '':
        return jsonify({'error': 'Dosya seçilmedi'})
    
    if not file.filename.endswith(('.midi', '.mid')):
        return jsonify({'error': 'Sadece MIDI dosyaları kabul edilir'})
    
    try:
        # Initialize analyzer if needed
        with analyzer_lock:
            if analyzer is None:
                analyzer = MusicEmotionAnalyzer()
                analyzer.load_models()
        
        # Geçici dosya oluştur
        temp_path = os.path.join(app.config['UPLOAD_FOLDER'], secure_filename(file.filename))
        file.save(temp_path)
        
        try:
            # Tahmin yap
            predictions, tonality_predictions = analyzer.predict(temp_path)
            
            # En yüksek 3 tahmin edilen duyguyu al
            pred_indices = np.argsort(predictions[0])[-3:]
            predicted_emotions = [analyzer.emotions[idx] for idx in pred_indices]
            
            # Tonaliteyi belirle
            predicted_tonality = "Major" if tonality_predictions[0][0] > 0.5 else "Minor"
            
            # Tonalitenin yansıttığı duyguları al
            tonality_emotions = analyzer.get_tonality_emotions(predicted_tonality)
            
            # Benzerlik oranını hesapla
            common_emotions = set(tonality_emotions) & set(predicted_emotions)
            similarity_ratio = len(common_emotions) / len(tonality_emotions) * 100 if tonality_emotions else 0
            
            # Benzerlik oranı %50'den fazlaysa %100'e tamamla
            if similarity_ratio > 50:
                similarity_ratio = 100
            
            # Test sonuçlarını görselleştir
            fig = plt.figure(figsize=(15, 10))
            try:
                # 1. Duygu Modeli Grafikleri
                plt.subplot(2, 2, 1)
                plt.bar(['Doğruluk', 'Kayıp'], [similarity_ratio, 100-similarity_ratio])
                plt.title('Duygu Modeli Sonuçları')
                plt.ylim(0, 100)
                
                # 2. Tonalite Modeli Grafikleri
                plt.subplot(2, 2, 2)
                tonality_confidence = abs(tonality_predictions[0][0] - 0.5) * 200
                plt.bar(['Doğruluk', 'Kayıp'], [tonality_confidence, 100-tonality_confidence])
                plt.title('Tonalite Modeli Sonuçları')
                plt.ylim(0, 100)
                
                # 3. Duygu Dağılımı
                plt.subplot(2, 2, 3)
                emotion_values = predictions[0][pred_indices]
                plt.bar(predicted_emotions, emotion_values)
                plt.title('Tahmin Edilen Duygular')
                plt.xticks(rotation=45)
                
                # 4. Tonalite Dağılımı
                plt.subplot(2, 2, 4)
                plt.pie([tonality_predictions[0][0], 1-tonality_predictions[0][0]], 
                        labels=['Major', 'Minor'],
                        autopct='%1.1f%%')
                plt.title('Tonalite Dağılımı')
                
                plt.tight_layout()
                
                # Grafiği base64'e çevir
                buffer = BytesIO()
                fig.savefig(buffer, format='png', dpi=300, bbox_inches='tight')
                buffer.seek(0)
                image_png = buffer.getvalue()
                
                return jsonify({
                    'tonality': predicted_tonality,
                    'tonality_emotions': tonality_emotions,
                    'predicted_emotions': predicted_emotions,
                    'similarity_ratio': float(similarity_ratio),
                    'plot': base64.b64encode(image_png).decode('utf-8')
                })
            finally:
                plt.close(fig)
                if 'buffer' in locals():
                    buffer.close()
        finally:
            # Geçici dosyayı sil
            if os.path.exists(temp_path):
                os.remove(temp_path)
                
    except Exception as e:
        return jsonify({'error': str(e)})

if __name__ == '__main__':
    # Initialize the analyzer in the main thread
    analyzer = MusicEmotionAnalyzer()
    analyzer.load_models()
    
    # Uploads klasörünü oluştur
    if not os.path.exists(app.config['UPLOAD_FOLDER']):
        os.makedirs(app.config['UPLOAD_FOLDER'])
    
    # Uygulamayı başlat
    app.run(debug=True, port=5000, threaded=True)