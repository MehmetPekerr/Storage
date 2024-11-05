package package1;
import java.util.Scanner;

public class ornek8 {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		double a,b,sonuc=0; 
		int islem;
		System.out.println("Lutfen 1. sayiyi giriniz");
		a = scan.nextInt();
		System.out.println("Lutfen 2. sayiyi giriniz");
		b = scan.nextInt();
		
		System.out.println("Lutfen islem seciniz");
		
		System.out.println("1 - toplama");
		System.out.println("2 - cikarma");
		System.out.println("3 - carpma");
		System.out.println("4 - bolme");
		
		int secilen = scan.nextInt();
		
		if ( secilen == 1) {
			sonuc = a+b;
			System.out.println("sonuc = "+ sonuc);
		}
		else if ( secilen == 2 ) {
			sonuc = a-b;
			System.out.println("sonuc = "+ sonuc);
		}
		else if ( secilen == 3 ) {
			sonuc = a*b;
			System.out.println("sonuc = "+ sonuc);
		}
		else if ( secilen == 4 ) {
			if(b==0) {
				System.out.println("bolen sifir olamaz.");
			}
			else {
			sonuc = a/b;
			System.out.println("sonuc = "+ sonuc);
			}
		}
		else {
			System.out.println("Lutfen gecerli bir islem seciniz");
		}

	}

}
