package package1;
import java.util.Scanner;
public class ornek10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a,b,c;
		System.out.println("Lutfen a sayisini giriniz: ");
		a = scan.nextInt();
		System.out.println("Lutfen b sayisini giriniz: ");
		b= scan.nextInt();
		System.out.println("Lutfen c sayisini giriniz: ");
		c= scan.nextInt();
		
		
		if(a<b && a<c) {
			if(b<c) {
				System.out.println("a<b<c");
			}
			else {
				System.out.println("a<c<b");
			}
		}
		else if(b<a && b<c) {
			if(a<c) {
				System.out.println("b<a<c");
			}
			else {
				System.out.println("b<c<a");
			}
		}
		else {
			if(c<a) {
				System.out.println("c<a<b");
			}
			else {
				System.out.println("c<b<a");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
