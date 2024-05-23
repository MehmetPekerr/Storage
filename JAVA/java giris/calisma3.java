
public class calisma3 {

	static double fonksiyon(int x) {   //main dışında tanımladık. Static olan main de çağıracağımız için burada da static olmalı
		int a =(x+2)*6;
		System.out.println(a);
		return a;
	}
	
	public static void main(String[] args) {
		
		
		double i=fonksiyon(3); //ekrana 30 yazdı. Fonksiyon double ise burası da double
		System.out.println(i); //ekrana 30.0 yazdı

	}

}
