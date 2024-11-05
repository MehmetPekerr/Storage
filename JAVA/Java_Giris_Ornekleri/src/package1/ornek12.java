package package1;
import java.util.Scanner;
public class ornek12 {
	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);

int sayi;

System.out.println("lutfen sayi giriniz: ");
sayi = scan.nextInt();


System.out.println("cift sayilar");
for(int i = 0;i<sayi;i++) {
	if(i%2==0) {
		System.out.println(i);
	}
}

}
}