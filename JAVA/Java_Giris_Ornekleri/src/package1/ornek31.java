package package1;
import java.util.Scanner;
public class ornek31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("lutfen dizi boyutunu giriniz");
		
		int boyut = scan.nextInt();
		
		int[] dizi = new int[boyut];
		
		for(int i=0; i<boyut ; i++) {
			System.out.println("lutfen dizinin " + (i+1) + ". sayisini giriniz");
			dizi[i] = scan.nextInt();
		}
		
		int min = dizi[0];
		
		int max = dizi[0];
		
		for(int j=0; j<boyut; j++) {
			if(dizi[j]<min) {
				min = dizi[j];
			}
			if(dizi[j]>max) {
				max=dizi[j];
			}
		}
						
		System.out.println("min: "+min);
		
		System.out.println("max: "+max);

	}

}
