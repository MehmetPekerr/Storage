package package1;
import java.util.Scanner;
public class ornek27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("lutfen sayi giriniz:");
		int sayi = scan.nextInt();
		
		int kalan, tutulan=0, original;
		
		original = sayi;
		
		while(sayi!=0) {
			
			kalan = sayi%10;
			
			tutulan = tutulan*10 + kalan;
			sayi = sayi/10;
			
		}
		
		if(original==tutulan) {
			System.out.println("Palindrom sayidir.");
		}
		else {
			System.out.println("Palindrom sayi degildir");
		}

	}

}
