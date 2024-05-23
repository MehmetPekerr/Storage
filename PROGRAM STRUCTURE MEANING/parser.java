package parser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class parser {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Lütfen dosya adını girin: ");
        String dosyaAdi = scanner.nextLine();


        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            int satirSayisi = 0;

            while ((satir = br.readLine()) != null) {
                satirSayisi++;

                boolean dogruMu = kontrolEt(satir);

                if (dogruMu) {
                    System.out.println("Yazım hatası yok! Satır: " + satirSayisi + " -> " + satir);
                } else {
                    System.out.println("Yazım hatası var! Satır: " + satirSayisi + " -> " + satir);
                }
            }

            System.out.println("Tarama tamamlandı.");
        } catch (IOException e) {
            System.err.println("Dosya okuma hatası: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


    private static boolean kontrolEt(String satir) {
        String[] komutlar = {"HRK", "TOP", "CRP", "BOL", "CIK", "D", "DB", "DK", "DKE", "DBE", "DED", "DE", "VE", "VEY", "DEG", "OKU", "YAZ"};

        String[] parcalar = satir.split("\\s+");
        if (parcalar.length > 0) {
            String komut = parcalar[0];
            boolean dogruKomut = false;

            for (String k : komutlar) {
                if (k.equals(komut)) {
                    dogruKomut = true;
                    break;
                }
            }

            if (dogruKomut) {
                if (parcalar.length == 1 || parcalar.length == 2) {
                    if (parcalar.length == 2) {
                        String[] argumanlar = parcalar[1].split(",");
                        for (String arguman : argumanlar) {
                            if (!arguman.matches("[a-zA-Z0-9]+")) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}