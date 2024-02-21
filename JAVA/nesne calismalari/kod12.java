import java.util.Random; //R büyük harfle
import java.util.Scanner;
public class kod12 {

	public static void main(String[] args) {
		int tahmin, can= 5, i=0, sayac= 0;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		
		int sayi = rand.nextInt(100); //0 ile 99 arasında rastgele bir sayiyi int e atar.
		boolean oyunDurum = false;
		boolean hata=false;     //ilk başta 2 defa yanlış girme hakkımız oldu
		int[] tahminler = new int[5];
		System.out.println(sayi);
		System.out.println("Sayi tahmin oyununa hosgeldiniz");
		System.out.println("0 ile 99 arasinda bir sayi tuttum");
		
		while(can>0) {
			System.out.print("tahmininiz: ");
			tahmin = scan.nextInt();
			
			if(tahmin<0 || tahmin>99) {
				if(hata) {
					System.out.println("Cok fazla hatali giris yaptiniz, 1 can kaybettiniz.");
					System.out.println("Kalan can: "+ --can); //önce canı azalt, sonra azalmış halini yaz. 
				}
				
			
			else {
				hata=true;
				System.out.println("lutfen 0 ve 99 arasinda bir sayi giriniz");
				continue; //while tekrar baştan çalışır
			}
				
			}
			tahminler[i++] = tahmin;
			sayac++;
			if (tahmin == sayi) {
				oyunDurum = true; //oyunDurum başta false tanımlanmıştı. Tahmin dogruysa true olacak.
				System.out.println(sayac + ". denemede bulundu");
				break;
			}
			else {
				System.out.println("Yanlis tekrar deneyiniz. Kalan can: "+ --can);
			}
						
		}
		
		
		if(oyunDurum) { //oyunDurum true olmuşsa burası calisir
			System.out.println("tebrikler dogru tahmin");
			System.out.println("sayimiz" + sayi);
			System.out.println("can"+can);
		}
		else { //oyunDurum true olmamışsa burası calisir
			System.out.println("basaramadiniz");
		}
		
		
		System.out.println("tahminleriniz: ");
		for(int value : tahminler) {
			if(value!=0) {
				System.out.print(value + ",");
			}
		}

	}

}
