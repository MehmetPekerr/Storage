package package1;
import java.util.Scanner;
public class ornek13 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int toplam=0,sayi;
		
		System.out.println("lutfen pozitif sayilar giriniz");

		while(true) {
			sayi = scan.nextInt();
			
			if(sayi<0) {
				break;
			}
			else {
			if(sayi%2==1) {
				toplam +=sayi;
			}
			}


		}
		System.out.println("Tekler toplami= "+ toplam);

	}

}
