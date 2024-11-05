package package1;
import java.util.Scanner;
public class ornek29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("lutfen sayi giriniz");
		int sayi = scan.nextInt();
		int sayac=0;
		
		for(int i=2; i<sayi; i++) {
			if(sayi%i==0) {
				sayac++;
				break;
			}
			
		}
		
		if(sayac!=0) {
		System.out.println("sayi asal degildir");	
		}
		
		else {
			System.out.println("sayi asaldir.");
		}

	}

}
