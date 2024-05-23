import java.util.Scanner;

class Dugum {
    int veri;
    Dugum sol, sag;

    public Dugum(int eleman) {
        veri = eleman;
        sol = sag = null;
    }
}

public class VeriYap_Mehmet_Peker {
    Dugum kok;

    VeriYap_Mehmet_Peker() {
        kok = null;
    }

    void ekle(int veri) {
        kok = ekleRec(kok, veri);
    }

    Dugum ekleRec(Dugum kok, int veri) {
        if (kok == null) {
            kok = new Dugum(veri);
            return kok;
        }

        if (veri < kok.veri)
            kok.sol = ekleRec(kok.sol, veri);
        else if (veri > kok.veri)
            kok.sag = ekleRec(kok.sag, veri);

        return kok;
    }

    void inorder() {
        inorderRec(kok);
    }

    void inorderRec(Dugum kok) {
        if (kok != null) {
            inorderRec(kok.sol);
            System.out.print(kok.veri + " ");
            inorderRec(kok.sag);
        }
    }

    int[][] gecisMatrisiOlustur() {
        int dugumSayisi = dugumSayisiniSay(kok);
        int[][] matris = new int[dugumSayisi][dugumSayisi];
        etiketAta(kok);
        matrisOlustur(kok, matris);
        return matris;
    }

    int dugumSayisiniSay(Dugum kok) {
        if (kok == null)
            return 0;
        return 1 + dugumSayisiniSay(kok.sol) + dugumSayisiniSay(kok.sag);
    }

    int etiketAta(Dugum kok) {
        if (kok == null)
            return 0;
        kok.veri = etiketAta(kok.sol) + etiketAta(kok.sag) + 1;
        return kok.veri;
    }

    void matrisOlustur(Dugum kok, int[][] matris) {
        if (kok != null) {
            if (kok.sol != null)
                matris[kok.veri - 1][kok.sol.veri - 1] = 1;
            if (kok.sag != null)
                matris[kok.veri - 1][kok.sag.veri - 1] = 1;
            matrisOlustur(kok.sol, matris);
            matrisOlustur(kok.sag, matris);
        }
    }

    Dugum araVeSil(Dugum kok, int veri) {
        if (kok == null)
            return kok;

        if (veri < kok.veri)
            kok.sol = araVeSil(kok.sol, veri);
        else if (veri > kok.veri)
            kok.sag = araVeSil(kok.sag, veri);
        else {
            if (kok.sol == null)
                return kok.sag;
            else if (kok.sag == null)
                return kok.sol;

            kok.veri = enKucukDeger(kok.sag);
            kok.sag = araVeSil(kok.sag, kok.veri);
        }

        return kok;
    }

    int enKucukDeger(Dugum kok) {
        int enKucuk = kok.veri;
        while (kok.sol != null) {
            enKucuk = kok.sol.veri;
            kok = kok.sol;
        }
        return enKucuk;
    }

    public static void main(String[] args) {
        VeriYap_Mehmet_Peker agac = new VeriYap_Mehmet_Peker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenü:");
            System.out.println("1. Veri Ekle");
            System.out.println("2. Veri Ara ve Sil");
            System.out.println("3. Ağacı Yazdır");
            System.out.println("4. Geçiş Matrisi Oluştur ve Yazdır");
            System.out.println("5. Çıkış");

            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Eklenecek sayıyı girin: ");
                    int ekleVeri = scanner.nextInt();
                    agac.ekle(ekleVeri);
                    break;
                case 2:
                    System.out.print("Silinecek sayıyı girin: ");
                    int silVeri = scanner.nextInt();
                    agac.kok = agac.araVeSil(agac.kok, silVeri);
                    break;
                case 3:
                    System.out.println("Ağaç İçeriği:");
                    agac.inorder();
                    break;
                case 4:
                    System.out.println("Geçiş Matrisi:");
                    int[][] gecisMatrisi = agac.gecisMatrisiOlustur();
                    for (int[] satir : gecisMatrisi) {
                        for (int hucre : satir) {
                            System.out.print(hucre + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Programdan çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        }
    }
}