import java.util.Scanner;

public class kod11 {

	public static void main(String[] args) {
		int[] notlar = new int[5];
		int toplam = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("notlarinizi sirayla giriniz");
		
		System.out.println("Matematik:");  //int mat,turkce vb. belirtmeye gerek kalmadı sadece notlar dizisi ile gösterdik.
		notlar[0] = scan.nextInt();
		
		System.out.println("Turkce");
		notlar[1] = scan.nextInt();
		
		System.out.print("Fizik");
		notlar[2] = scan.nextInt();
		
		System.out.println("Kimya");
		notlar[3] = scan.nextInt();
		
		System.out.println("Biyoloji");
		notlar[4] = scan.nextInt();

		for(int i : notlar ) { // 1 den notlara kadar döngüyü döndürür
			toplam=toplam+i;
		}
		
		System.out.println("Ortalama: "+ (toplam/notlar.length)); //length dersek ekleyip sildiğimizde burayı degistirmemize gerek yok (length=5)
	}

}
