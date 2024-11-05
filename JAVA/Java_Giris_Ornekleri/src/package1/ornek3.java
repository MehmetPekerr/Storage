package package1;

import java.util.Scanner;

public class ornek3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. kenari giriniz: ");		
		int a = scan.nextInt();
		
		System.out.println("2. kenari giriniz: ");
		int b = scan.nextInt();
		
		double c = Math.sqrt((a*a)+(b*b));
		
		System.out.println("Hipotenus = "+ (int)c);

	}

}
