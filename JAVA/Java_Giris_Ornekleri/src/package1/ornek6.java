package package1;

import java.util.Scanner;

public class ornek6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		double pi=3,r,alan,cevre;
		
		System.out.println("Lutfen yaricapi giriniz: ");
		
		r = scan.nextInt();
		
		alan = pi * ( r*r );
		
		cevre = 2*pi*r;
		
		System.out.println("alan= "+ alan);
		
		System.out.println("cevre= "+ cevre);
		

	}

}
