



import java.util.Scanner;
public class Calisma6 {

	static boolean isPalindrom(int input){
		int temp,terssayi=0,kalan; 
		temp=input;
		while(temp!=0) {  //sıfırdan sonra virgül varsa int yine sıfır kabul eder
			kalan=temp%10;

			terssayi=terssayi*10+kalan;

			System.out.println(terssayi);	

			temp=temp/10;  
					
		}
		
		if(input==terssayi)
			return true;
		else
			return false;	
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Lutfen x degeri giriniz");
		int x = scan.nextInt();
		System.out.println(isPalindrom(x));

	}

}
