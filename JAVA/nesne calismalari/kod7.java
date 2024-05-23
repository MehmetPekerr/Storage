import java.util.Scanner;
public class kod7 {

	public static void main(String[] args) {
		
		//int diziAdi[] = new int[5];     
		//int[] diziAdi1 = new int[5];
		
		//int diziAdi2[] = {1,2,3};
		//int[] diziAdi3 = {10,15,20};
		//int[] tablo4 = new int[]{5,6,7};
		
		int[] liste = new int[4];  //tek boyutlu dizidir. sadece satır var, 4 satır.

		
		liste[0]=1;                //int dizide float tanımlayamayız dizilerin veri tipi vardır.
		liste[1]=2;
		liste[2]=3;
		liste[3]=4;
		
		for(int i=0;i<4;i++) {
			System.out.println(liste[i]);
		}
		
		System.out.println("lutfen 4 sayi giriniz");
		int liste2[] = new int[4];   //length=4 olur satır sayısını verir.
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<liste2.length;i++) {
			liste2[i] = scan.nextInt();
		}
		
		System.out.println("normal yazdırma:");
		for(int i=0;i<liste2.length;i++) {			
			int a = liste2[i];
			System.out.println(a);
			//System.out.println(liste2[i]);
		}
		
		
		System.out.println("foreach yazdırma:");
		
		
		for(int a : liste2) {  //burada uzunluk belirtmedik, i artışı belirtmedik. hepsini otomatik yaptı. tablo4 ün dizi olduğunu daha önce belirtmiştik(araya iki nokta koyarız)
			System.out.println(a);    //burada a 0 dan veya 1 den başlamaz. dizinin elemanlarını sırayla alır.(dizi[0],dizi[1],dizi[2]..}
		}
		
		
	
		


	}

}
