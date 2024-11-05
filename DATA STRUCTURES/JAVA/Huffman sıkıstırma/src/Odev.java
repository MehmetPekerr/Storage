import java.io.*;
import java.util.*;

class HuffmanNode {
    char karakter;
    int frekans;
    HuffmanNode sol, sag;

    public HuffmanNode(char karakter, int frekans) {
        this.karakter = karakter;
        this.frekans = frekans;
        sol = null;
        sag = null;
    }
}

public class Odev {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Metin giriniz: ");
        String metin = scanner.nextLine();

        String sikistirilmisDosyaAdi = "sikistirilmis_metin.txt";

        Map<Character, Integer> frekansHaritasi = frekansHaritasiOlustur(metin);
        PriorityQueue<HuffmanNode> huffmanAgaci = huffmanAgaciOlustur(frekansHaritasi);

        HuffmanNode kok = huffmanAgaciOlustur(huffmanAgaci);

        Map<Character, String> huffmanKodlari = new HashMap<>();
        huffmanKodlariOlustur(kok, "", huffmanKodlari);

        String sikistirilmisMetin = metniSikistir(metin, huffmanKodlari);

        dosyayaYaz(sikistirilmisDosyaAdi, sikistirilmisMetin);

        scanner.close();
    }

    public static Map<Character, Integer> frekansHaritasiOlustur(String metin) {
        Map<Character, Integer> frekansHaritasi = new HashMap<>();
        for (char c : metin.toCharArray()) {
            frekansHaritasi.put(c, frekansHaritasi.getOrDefault(c, 0) + 1);
        }
        return frekansHaritasi;
    }

    public static PriorityQueue<HuffmanNode> huffmanAgaciOlustur(Map<Character, Integer> frekansHaritasi) {
        PriorityQueue<HuffmanNode> huffmanAgaci = new PriorityQueue<>((a, b) -> a.frekans - b.frekans);

        for (Map.Entry<Character, Integer> entry : frekansHaritasi.entrySet()) {
            HuffmanNode node = new HuffmanNode(entry.getKey(), entry.getValue());
            huffmanAgaci.add(node);
        }
        return huffmanAgaci;
    }

    public static HuffmanNode huffmanAgaciOlustur(PriorityQueue<HuffmanNode> huffmanAgaci) {
        while (huffmanAgaci.size() > 1) {
            HuffmanNode sol = huffmanAgaci.poll();
            HuffmanNode sag = huffmanAgaci.poll();

            HuffmanNode birlesik = new HuffmanNode('-', sol.frekans + sag.frekans);
            birlesik.sol = sol;
            birlesik.sag = sag;

            huffmanAgaci.add(birlesik);
        }
        return huffmanAgaci.poll();
    }

    public static void huffmanKodlariOlustur(HuffmanNode kok, String kod, Map<Character, String> huffmanKodlari) {
        if (kok == null) {
            return;
        }

        if (kok.sol == null && kok.sag == null) {
            huffmanKodlari.put(kok.karakter, kod);
        }

        huffmanKodlariOlustur(kok.sol, kod + "0", huffmanKodlari);
        huffmanKodlariOlustur(kok.sag, kod + "1", huffmanKodlari);
    }

    public static String metniSikistir(String metin, Map<Character, String> huffmanKodlari) {
        StringBuilder sikistirilmisMetin = new StringBuilder();
        for (char c : metin.toCharArray()) {
            sikistirilmisMetin.append(huffmanKodlari.get(c));
        }
        return sikistirilmisMetin.toString();
    }

    public static void dosyayaYaz(String dosyaAdi, String icerik) {
        try {
            BufferedWriter yazici = new BufferedWriter(new FileWriter(dosyaAdi));
            yazici.write(icerik);
            yazici.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*huffman kodlamasını her elemanı iki boyutunda bir bağlı liste olan bir dizi, 
her bir hücresinde bir düğüm nesnesi tutan n*3 boyutunda bir matris kullanarak yapılacak.
Sonra bu yapı üzerinde ya aşağıdan yukarı şekilde geri gelerek, ya da yukarıdan aşağı
gelip elde ettiği ikili diziyi ters çevirerek huffman kodları elde edilecek. O bölüm 
bri txt den okunacak. yani bir metin verilecek, o metnin harf histogramını çıkaracak,  
daha sonra huffman kodunu bulacak ve sıkıştırılmış halini tekrar bir txt dosyasına yazacak.
Önce dosyadan okuma işlemi yapılacak.  ilk karakterleri oku, karakterlere sayısal bir sembol ver, 
karakterlerin frekansını bul. bitler kullan örn 4 tane bit her eleman 2 elemana bağlı. Sonra 
huffman kodunu yaz, son olarak huffman çıktısını dosyaya yaz. n*2 lik matris kullan ya da 
bağlı liste oluştur.*/
  