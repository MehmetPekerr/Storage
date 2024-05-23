package gramer;

import java.util.Scanner;

public class gramer {
    public static void main(String[] args) {
        String[] ozneKumesi = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneKumesi = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemKumesi = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

        Scanner scan = new Scanner(System.in);
        System.out.println("Cümleyi giriniz:");
        String cumle = scan.nextLine();

        // Cümleyi boşluklardan ayırarak kelimelere böler
        String[] kelimeler = cumle.split("\\s+");

        // Eğer cümle 3 kelime içeriyorsa ve her kelime ilgili kümede varsa, cümle geçerli kabul edilir
        if (kelimeler.length == 3 && isKumeIcinde(kelimeler[0], ozneKumesi) && isKumeIcinde(kelimeler[1], nesneKumesi) && isKumeIcinde(kelimeler[2], yuklemKumesi)) {
            System.out.println("EVET");
        } else {
            System.out.println("HAYIR");
        }
    }

    // Elemanın, verilen küme içinde olup olmadığını kontrol eder
    public static boolean isKumeIcinde(String eleman, String[] kume) {
        for (String elemanKume : kume) {
            if (eleman.equals(elemanKume)) {
                return true;
            }
        }
        return false;
    }
}