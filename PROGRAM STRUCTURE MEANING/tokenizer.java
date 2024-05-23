package tokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class tokenizer {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) { //Scanner nesnesi try bloğundan çıkıldığında veya bir hata oluştuğunda otomatik olarak kapatılır.
			System.out.println("Lütfen bir dosya adı giriniz");
			String dosyaAdi = scanner.nextLine();  // Kullanıcıdan dosya adını al

			try {
			    BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi)); // Dosyayı okuma işlemi başlat

			    ArrayList<String> CS = new ArrayList<String>(); // Komutları ve etiketleri tutacak ArrayList oluştur
			    String line; // Satırı tutacak String

			    while ((line = reader.readLine()) != null) { // Dosyayı satır satır oku

			        if (line.endsWith(":")) { // Satırın sonunda ":" karakteri varsa true
			            CS.add(line); // Etiket satırını ArrayList'e ekle

			        } else { // Satırda ":" karakteri yoksa
			            StringBuilder tokenBuilder = new StringBuilder(); // Yeni bir StringBuilder nesnesi oluşturuluyor.

			            for (char c : line.toCharArray()) { // Her bir 'c' karakteri, 'line' dizesindeki her bir karakteri temsil eder. Satırdaki her karakter için döngü başlat                      
			                if (c == ',' || Character.isWhitespace(c)) { // c Karakteri virgül veya boşluk ise true olur.
			                    if (tokenBuilder.length() > 0) { //TokenBuilder'da karakter varsa true
			                        CS.add(tokenBuilder.toString());  // TokenBuilder'ın içeriğini diziye dönüştürüp CS ArrayList'ine ekle
			                        tokenBuilder = new StringBuilder(); //Sonraki işlemler için TokenBuilder'ı sıfırla
			                    }
			                } else {
			                    tokenBuilder.append(c); // Karakteri tokenBuilder'a ekler. Bu sayede tokenBuilder içinde karakterler birikir
			                }
			            }

			            if (tokenBuilder.length() > 0) { // TokenBuilder içinde karakter var mı kontrol eder varsa true.
			                CS.add(tokenBuilder.toString());  // True ise CS ArrayList'ine ekle
			            }
			        }
			    }

			    reader.close(); // Dosyayı kapat

			    for (String command : CS) { // CS ArrayList'indeki her bir komut veya etiketi işle
			        System.out.println(command);  //Komut veya etiketi ekrana yazdır
			    }

			} catch (IOException e) { // Hata durumunda
			    System.out.println("Dosya okuma hatası " + e.getMessage()); // Hata mesajını yazdır
			}
		}
    }
}
