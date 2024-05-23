import java.util.Scanner;	
public class Calisma8 {
	
	/*static int fibo(int n) {
		if(n==1 || n==2 ) {
			return 1;
		}
		return fibo(n-1)+fibo(n-2);
	}*/
	
	
	static int fibo2(int n) {
		if(n==0) 
			return 0;
		
		
		if(n==1) 
			return 1;
		
		return fibo2(n-1)+fibo2(n-2);
	}
    
	public static void main(String[] args) {
		  Scanner scan = new Scanner(System.in);
		  System.out.println("Lutfen x degeri giriniz");
		  int x = scan.nextInt();
          System.out.println(fibo2(x));
          
          //System.out.println(fibo(x)); // sifir icin calismaz

	}

}
