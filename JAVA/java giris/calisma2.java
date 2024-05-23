
public class calisma2 {

	public static void main(String[] args) {
		
		
		fonksiyon(4);
				

	}

	
	static void fonksiyon(int x) {   //main dışında tanımladık. Static olan main de çağıracağımız için burada da static olmalı
		int a =(x+2)*6;
		System.out.println(a);
	}
}
