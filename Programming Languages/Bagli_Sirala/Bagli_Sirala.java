package Bagli_Sirala;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bagli_Sirala {
    private static class BagliListeElemani {
        int veri;
        int adres;

        public BagliListeElemani(int veri, int adres) {
            this.veri = veri;
            this.adres = adres;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dosya adını girin:");
        try {
            String dosyaAdi = br.readLine();
            dosyadanOkuVeSirala(dosyaAdi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dosyadanOkuVeSirala(String dosyaAdi) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
            String satir;
            ArrayList<BagliListeElemani> dizi = new ArrayList<>();
            int adres = 0;
            while ((satir = reader.readLine()) != null) {
                int veri = Integer.parseInt(satir.trim());
                dizi.add(new BagliListeElemani(veri, adres++));
            }
            System.out.println("Orijinal Liste-----");
            for (BagliListeElemani eleman : dizi) {
                System.out.println(eleman.veri + " " + eleman.adres);
            }

            // İndekslerin yazdırılması
            System.out.println("Yeni İndeksler-----");
            for (BagliListeElemani eleman : dizi) {
                int siradakiKucukluk = 0;
                for (BagliListeElemani digerEleman : dizi) {
                    if (eleman.veri > digerEleman.veri) {
                        siradakiKucukluk++;
                    }
                }
                System.out.println(eleman.veri + " " + siradakiKucukluk);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}