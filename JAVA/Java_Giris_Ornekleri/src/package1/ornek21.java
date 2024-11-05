package package1;
import java.util.Scanner;
public class ornek21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		
		int ebob=1, ekok;
		System.out.println("lutfen 1. sayiyi giriniz");
		int sayi1 = scan.nextInt();
		System.out.println("lutfen 2. sayiyi giriniz");
		int sayi2 = scan.nextInt();
		
		
		int n = Math.min(sayi1, sayi2);
		
		for(int i=n;i>=1;i--) {
			if(sayi1%i==0 && sayi2%i==0) {
				ebob = i;
				break;
			}
		}
		
		
		ekok = (sayi1*sayi2)/ebob;
		
		System.out.println("ebob: "+ ebob);
		
		System.out.println("ekok: "+ ekok);

	}

}
