package package1;

import java.util.Scanner;

public class ornek5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int domatesFiyat=10,elmaFiyat=20,salatalikFiyat=15,toplam=0;
		int domatesKilo, elmaKilo, salatalikKilo;
		
		System.out.println("Kac kilo domates:");		
		domatesKilo = scan.nextInt();
		
		System.out.println("Kac kilo elma:");
		elmaKilo = scan.nextInt();
		
		System.out.println("Kac kilo salatalik:");
		salatalikKilo = scan.nextInt();
		
		toplam += domatesFiyat*domatesKilo;
		toplam += elmaFiyat*elmaKilo;
		toplam += salatalikFiyat*salatalikKilo;
		
		System.out.println("Sepet tutari: "+ toplam);
	}
	
	

}
