package package1;
import java.util.Scanner;
public class ornek30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int toplam=0;
		System.out.println("lutfen dizi boyutunu giriniz: ");
		int boyut = scan.nextInt();
		int[] dizi = new int[boyut];
		
		for(int i = 0 ; i<boyut ; i++) {
			System.out.println("lutfen "+ (i+1) +". sayiyi giriniz:");
			dizi[i]= scan.nextInt();
			toplam = toplam+dizi[i];
		}
		
		System.out.println("ortalama: " + toplam/boyut);

	}

}
