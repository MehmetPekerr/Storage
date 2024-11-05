package package1;
import java.util.Scanner;
public class ornek14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int k,b,i=1;
		
		System.out.println("k degerini giriniz");
		k = scan.nextInt();
		System.out.println("b degerini giriniz");
		b = scan.nextInt();
		
		/*for(i=1;i<=b;i*=k) {
			System.out.println(i);
		}
		*/
		
		while(i<=b) {
			System.out.println(i);
			i=k*i;
		}
		
		
		
		
		
		
		

	}

}
