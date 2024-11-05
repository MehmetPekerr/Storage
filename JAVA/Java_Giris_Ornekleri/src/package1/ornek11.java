package package1;
import java.util.Scanner;
public class ornek11 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int year;		
		String animal = "";
		System.out.println("Lutfen dogum yilinizi giriniz: ");
		
		year = scan.nextInt();		
		int result = year % 12;		
		switch(result) {
		
		case 0:
			animal = "Maymun";
			break;
		
		case 1:
			animal = "Horoz";
			break;
			
		case 2:
			animal = "Kopek";
			break;
			
			default:
			animal = "Diger";
		    break;	
		}
		

		
		System.out.println("Cin zodyagi burcunuz: "+ animal);
		
	}
}
