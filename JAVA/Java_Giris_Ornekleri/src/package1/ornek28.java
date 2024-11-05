package package1;
import java.util.Scanner;
public class ornek28 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		System.out.println("lutfen bir sayi giriniz");
		
		int sayac=0;
		int sayi = scan.nextInt();
		
		while(sayi>0) {
			sayi = sayi/10;
			sayac++;
		}
		
		System.out.println(sayac + " basamakli");

	}

}
