package package1;

import java.util.Scanner;

public class ornek22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int sayi,max=0,min=0,c;
		
		System.out.println("lutfen 5 sayi giriniz");
		
		for(int i=1; i<6; i++) {
			System.out.println("lutfen "+i+". sayiyi giriniz");
			
			sayi= scan.nextInt();
			
			if(sayi<min || min==0 ) {
				min=sayi;
			}
			
			if(sayi>max) {
				max=sayi;
			} 

		}
		
		System.out.println("max: "+max);
		
		System.out.println("min: "+ min);	

	}

}
