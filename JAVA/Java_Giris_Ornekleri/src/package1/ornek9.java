package package1;
import java.util.Scanner;
public class ornek9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sicaklik;
	    String event;
		System.out.println("Lutfen derece giriniz; ");
		
		sicaklik = scan.nextInt();
		
		if(sicaklik<5) {
			event = "Kayak";
		}
		else if (5<=sicaklik && sicaklik<25) {
			event = "Sinema";
		}
		else {
			event = "Yuzme";
		}
		
		
		System.out.println("onerilen etkinlik:"+ event);
		
		
		
		
		
		
		
		
		
	}

}
