package manager;

import entity.Kitap;
import entity.Uye;
import java.util.ArrayList;
import java.util.List;

public class Kutuphane {
    private List<Kitap> kitaplar;
    private List<Uye> uyeler;
    private List<Kitap> rezervasyonluKitaplar;

    public Kutuphane() {
        this.kitaplar = new ArrayList<>();
        this.uyeler = new ArrayList<>();
        this.rezervasyonluKitaplar = new ArrayList<>();
    }

    public void kitapEkle(Kitap kitap) {
        kitaplar.add(kitap);
    }

    public void kitapCikar(Kitap kitap) {
        kitaplar.remove(kitap);
    }

    public void kitapDuzenle(Kitap eskiKitap, Kitap yeniKitap) {
        int index = kitaplar.indexOf(eskiKitap);
        if (index != -1) {
            kitaplar.set(index, yeniKitap);
        }
    }

    public Kitap kitapAra(String kitapAdi) {
        for (Kitap kitap : kitaplar) {
            if (kitap.getKitapAdi().equalsIgnoreCase(kitapAdi)) {
                return kitap;
            }
        }
        return null;
    }

    public void kitapRezervasyonYap(Kitap kitap, Uye uye) {
        if (!rezervasyonluKitaplar.contains(kitap)) {
            rezervasyonluKitaplar.add(kitap);
            System.out.println(uye.getKullaniciAdi() + " adli uye " + kitap.getKitapAdi() + " kitabini rezerve etti.");
        } else {
            System.out.println("Kitap su anda baska bir uyeye rezerve edilmistir.");
        }
    }

    public boolean kitapMesgulMu(Kitap kitap) {
        return rezervasyonluKitaplar.contains(kitap);
    }

    // Test için ana metot
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();

        // Kitap ve üye örnekleri oluşturma
        Kitap kitap1 = new Kitap("Java Programlama", "Yazar 1", 2022, "Yayinevi 1", 300);
        Kitap kitap2 = new Kitap("Veritabani Sistemleri", "Yazar 2", 2021, "Yayinevi 2", 400);
        Uye uye1 = new Uye("Ali", "Veli", "ali123", "sifre123");

        // Kitap ekleme
        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapEkle(kitap2);

        // Kitap arama
        System.out.println("Arama sonucu: " + kutuphane.kitapAra("Java Programlama"));

        // Kitap çıkarma
        kutuphane.kitapCikar(kitap2);
        System.out.println("Veritabani Sistemleri kaldirildi, arama sonucu: " + kutuphane.kitapAra("Veritabani Sistemleri"));

        // Kitap rezervasyon işlemi
        kutuphane.kitapRezervasyonYap(kitap1, uye1);

        // Kitabın meşgul olup olmadığını kontrol etme
        System.out.println("Kitap mesgul mu?: " + kutuphane.kitapMesgulMu(kitap1));
    }
}
