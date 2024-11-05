package package1;
import java.util.Scanner;
public class ornek17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen harmonik toplami bulunacak sayiyi giriniz.");
		int sayi = scan.nextInt();
		double i=1,toplam=0;
		
		/*while(i<=sayi) {
			toplam=toplam+(1/i);
			i++;
		}*/
		
		for(i=1;i<=sayi;i++) {
			toplam=toplam+(1/i);
		}
		System.out.println("Harmonik toplam= "+ toplam);

	}

}
