package package1;
import java.util.Scanner;
public class ornek23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int toplam=0;
		System.out.println("lutfen bir sayi giriniz");
		int sayi = scan.nextInt();
		
		for(int i =1 ; i<sayi; i++) {
			if(sayi%i==0) {
				toplam+=i;
			}
		}
		
		if(toplam==sayi) {
			System.out.println("mukemmel sayidir");
		}
		else {
			System.out.println("mukemmel sayi degildir");
		}

	}

}
