package testpaket;

import manager.Kutuphane;
import entity.Kitap;
import entity.Uye;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KutuphaneTest {

    private Kutuphane kutuphane;
    private Kitap kitap1;
    private Kitap kitap2;
    private Uye uye1;

    @BeforeEach
    public void setUp() {
        kutuphane = new Kutuphane();
        kitap1 = new Kitap("Java Programlama", "Yazar 1", 2022, "Yayinevi 1", 300);
        kitap2 = new Kitap("Veritabani Sistemleri", "Yazar 2", 2021, "Yayinevi 2", 400);
        uye1 = new Uye("Ali", "Veli", "ali123", "sifre123");
    }

    @Test
    public void testKitapEkle() {
        kutuphane.kitapEkle(kitap1);
        assertEquals(kitap1, kutuphane.kitapAra("Java Programlama"));
    }

    @Test
    public void testKitapCikar() {
        kutuphane.kitapEkle(kitap2);
        kutuphane.kitapCikar(kitap2);
        assertNull(kutuphane.kitapAra("Veritabani Sistemleri"));
    }

    @Test
    public void testKitapDuzenle() {
        kutuphane.kitapEkle(kitap1);
        Kitap yeniKitap = new Kitap("Java İleri Seviye", "Yazar 3", 2023, "Yayinevi 3", 350);
        kutuphane.kitapDuzenle(kitap1, yeniKitap);
        assertEquals(yeniKitap, kutuphane.kitapAra("Java İleri Seviye"));
    }

    @Test
    public void testKitapAra() {
        kutuphane.kitapEkle(kitap1);
        assertNotNull(kutuphane.kitapAra("Java Programlama"));
        assertNull(kutuphane.kitapAra("Python Programlama"));
    }

    @Test
    public void testKitapRezervasyonYap() {
        kutuphane.kitapEkle(kitap1);
        kutuphane.kitapRezervasyonYap(kitap1, uye1);
        assertTrue(kutuphane.kitapMesgulMu(kitap1));
    }

    @Test
    public void testKitapMesgulMu() {
        kutuphane.kitapEkle(kitap1);
        assertFalse(kutuphane.kitapMesgulMu(kitap1));
        kutuphane.kitapRezervasyonYap(kitap1, uye1);
        assertTrue(kutuphane.kitapMesgulMu(kitap1));
    }
}
