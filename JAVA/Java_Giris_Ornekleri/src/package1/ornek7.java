package package1;
import java.util.Scanner;
public class ornek7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int km,fiyat;
		System.out.println("Lutfen kilometreyi giriniz: ");
		km = scan.nextInt();
		
		fiyat = 10 + (km*3);
		
		if (fiyat<20) {
			fiyat = 20;
		}
		
		
		System.out.println("fiyat = "+fiyat);
	}

}
