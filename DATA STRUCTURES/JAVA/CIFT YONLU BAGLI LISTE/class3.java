package veri;
import java.util.Random;

public class class3 {
    public static void main(String[] args) {
        class1 class1 = new class1();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int a = random.nextInt(101);
            class1.ekle(a);
        }

        System.out.println("Sıralamadan Önce:");
        class1.yazdir();

        class1.sirala();

        System.out.println("\n Sıralamadan Sonra:");
        class1.yazdir();
    }
}