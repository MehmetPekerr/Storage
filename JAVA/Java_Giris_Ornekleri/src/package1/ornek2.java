package package1;

import java.util.Scanner;

public class ornek2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		double fiyat,toplam,kdv;
		
		System.out.println("Lütfen fiyat giriniz:");
		
		fiyat= scan.nextDouble();
		
		kdv = fiyat * (18.0/100);
		
		toplam= kdv + fiyat;
		
		System.out.println("KDV'li tutar: "+ (int) toplam );
		
		
		
		
	}

}
