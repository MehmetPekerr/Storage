package package1;
import java.util.Scanner;
public class ornek16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan= new Scanner(System.in);
		int sayi,i=1;
		System.out.println("lutfen faktoriyeli alinacak sayiyi giriniz");
		sayi=scan.nextInt();
		
		while(sayi>=2) {
			i=sayi*i;
			sayi--;
		}
		
		System.out.println(i);

		

	}

}
 