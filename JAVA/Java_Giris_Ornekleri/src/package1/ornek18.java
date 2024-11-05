package package1;
import java.util.Scanner;
public class ornek18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sayi,kopya,sayac=0,i;
		double toplam=0;
		Scanner scan = new Scanner(System.in);
		sayi = scan.nextInt();
		kopya = sayi;
		while(kopya>=1) {
			sayac++;
			kopya=kopya/10;
		}
		
		kopya = sayi;
		
		while(sayi>=1) {
			i= sayi%10;
			toplam= toplam+ Math.pow(i, sayac);
			sayi = sayi/10;
		}
		
		if(toplam==kopya) {
			System.out.println("armstrong sayidir");
		}
		else {
			System.out.println("değildir.");
		}

	}

}
