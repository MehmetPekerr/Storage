package graff;

import java.util.Arrays;
import java.util.Random;

public class Graff {
    static final int SABİT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int dugumSayisi = 5; 
        int[][] graff = rasgelegraffOlustur(dugumSayisi);

        

        for (int baslangicDugumu = 0; baslangicDugumu < dugumSayisi; baslangicDugumu++) {
            int[] enKisaYol = dijkstra(graff, baslangicDugumu);

            System.out.println((baslangicDugumu + 1) + ". dugumden tum dugumlere minimum maliyetler:");
            for (int hedefDugumu = 0; hedefDugumu < dugumSayisi; hedefDugumu++) {
                if (baslangicDugumu != hedefDugumu) {
                    int maliyet = enKisaYol[hedefDugumu];
                    System.out.println("dugum " + (baslangicDugumu + 1) + " - dugum " + (hedefDugumu + 1) + ": " + maliyet);
                }
            }
            System.out.println();
        }
        System.out.println("Her calistirmada farklı rastgele sonuclar verecek");
        System.out.println("Baslangic maliyetleri icin lutfen en uste kaydirin");
    }

    static int[][] rasgelegraffOlustur(int dugumSayisi) {
        int[][] graff = new int[dugumSayisi][dugumSayisi];
        Random rastgele = new Random();

        System.out.print("  ");
        for (int i = 0; i < dugumSayisi; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < dugumSayisi; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < dugumSayisi; j++) {
                if (i != j) {
                    graff[i][j] = rastgele.nextInt(10);
                    System.out.print(graff[i][j] + " ");
                } else {
                    graff[i][j] = 0;
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }

      
        graff[0][1] = graff[1][0] = rastgele.nextInt(10);
        graff[0][2] = graff[2][0] = rastgele.nextInt(10);
        graff[0][3] = graff[3][0] = rastgele.nextInt(10);
        graff[1][4] = graff[4][1] = rastgele.nextInt(10);
        graff[2][4] = graff[4][2] = rastgele.nextInt(10);
        graff[3][4] = graff[4][3] = rastgele.nextInt(10);
        graff[1][2] = graff[2][1] = rastgele.nextInt(10);
        graff[2][3] = graff[3][2] = rastgele.nextInt(10);
        //buradaki atamaları indisler üzerinde yaptım
        
        return graff;
    }

    static int[] dijkstra(int[][] graff, int baslangic) {
        int dugumSayisi = graff.length;
        int[] mesafe = new int[dugumSayisi];
        boolean[] ziyaretEdildi = new boolean[dugumSayisi];

        Arrays.fill(mesafe, SABİT);
        mesafe[baslangic] = 0;

        for (int i = 0; i < dugumSayisi - 1; i++) {
            int minMesafeDugumu = enKucukMesafeDugumu(mesafe, ziyaretEdildi);
            ziyaretEdildi[minMesafeDugumu] = true;

            for (int j = 0; j < dugumSayisi; j++) {
                if (!ziyaretEdildi[j] && graff[minMesafeDugumu][j] != SABİT
                        && mesafe[minMesafeDugumu] != SABİT
                        && mesafe[minMesafeDugumu] + graff[minMesafeDugumu][j] < mesafe[j]) {
                    mesafe[j] = mesafe[minMesafeDugumu] + graff[minMesafeDugumu][j];
                }
            }
        }

        return mesafe;
    }

    static int enKucukMesafeDugumu(int[] mesafe, boolean[] ziyaretEdildi) {
        int min = SABİT, minIndex = -1;

        for (int i = 0; i < mesafe.length; i++) {
            if (!ziyaretEdildi[i] && mesafe[i] <= min) {
                min = mesafe[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    
}