package package1;
import java.util.Scanner;

public class ornek1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		
		int matematik, turkce, kimya, sonuc;
		System.out.println("Matematik notunuzu giriniz:");
		matematik= scan.nextInt();
		
		System.out.println("Turkce notunuzu giriniz:");
		turkce= scan.nextInt();
		
		System.out.println("Kimya notunuzu giriniz:");
		kimya= scan.nextInt();
		
		sonuc= (matematik+turkce+kimya)/3;
		
		System.out.println("Ortalama: " + sonuc);
		
		
	}

}
