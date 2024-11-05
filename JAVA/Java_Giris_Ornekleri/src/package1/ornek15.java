package package1;
import java.util.Scanner;
public class ornek15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int sayi,us,sayac=0,i=1;
		
		System.out.println("lutfen sayiyi giriniz");
		sayi = scan.nextInt();
		System.out.println("lutfen us degerını giriniz");
		us = scan.nextInt();
		
		/*while(sayac<us) {
			i*=sayi;
			sayac++;
		}*/
		
		for(sayac=0;sayac<us;sayac++) {
			i*=sayi;
		}
		
		System.out.println(i);

	}

}
