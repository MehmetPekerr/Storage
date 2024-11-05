package tokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class tokenizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Dosya adini girin (ornegin: tokenizer.txt): ");
        String dosyaAdi = scanner.nextLine();
        scanner.close();

        try {
            File dosya = new File(dosyaAdi);
            Scanner dosyaScanner = new Scanner(dosya);

            while (dosyaScanner.hasNextLine()) {
                String satir = dosyaScanner.nextLine();
                kelimelestir(satir);
            }
            dosyaScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya okuma hatasi: " + e.getMessage());
        }
    }

    public static void kelimelestir(String metin) {
        String sonuc = "";
        boolean sonBosluk = false;

        int metinUzunluk = 0;
        while (true) {
            try {
                char gecici = metin.charAt(metinUzunluk); 
                metinUzunluk++;
            } catch (IndexOutOfBoundsException e) {
                break; 
            }
        }

        for (int i = 0; i < metinUzunluk; i++) {
            char karakter = metin.charAt(i);

            if (karakter >= '0' && karakter <= '9') {
                sonuc += karakter;
                sonBosluk = false;
            } else if (isOperator(karakter)) {
                if (!sonBosluk) {
                    sonuc += ' ';
                }
                sonuc += karakter;
                sonuc += ' ';
                sonBosluk = true;
            } else if (karakter == ' ') {
                sonBosluk = true;
            }
        }

        if (sonuc.length() > 0 && sonuc.charAt(sonuc.length() - 1) == ' ') {
            int yeniUzunluk = sonuc.length() - 1; 
            for (int j = 0; j < yeniUzunluk; j++) {
                System.out.print(sonuc.charAt(j)); 
            }
            System.out.println(); // Satır sonuna geldiğinde yeni bir satır başlat
        } else {
            System.out.println(sonuc); // Sonuç boş değilse yazdır ve yeni satıra geç
        }
    }


    public static boolean isOperator(char karakter) {
        return karakter == '+' || karakter == '-' || karakter == '*' || karakter == '/' || karakter == '(' || karakter == ')';
    }
}
