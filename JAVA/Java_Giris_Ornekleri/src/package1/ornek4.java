package package1;

import java.util.Scanner;
public class ornek4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		double boy,kilo,index;
		
		System.out.println("Lutfen boyunuzu metre cinsinden giriniz");
		
		boy = scan.nextDouble();
		
		System.out.println("Lutfen kilonuzu giriniz");
		
		kilo = scan.nextDouble();
		
		index = (kilo/((boy)*(boy)));
		
		System.out.println("Vucut kitle endeksiniz: "+index);
		
		
		
				
		

	}

}
