
public class Calisma5 {

	static int f(int x) {
		int i,toplam=0;
		for(i=0;i<=x;i++) {
			toplam=toplam+i;
		}
		return toplam;         //1 den 10 a kadar olan sayilari normal toplama
	}
	
	static int r(int x) {  //recursive metodlar her zaman return dür (void yok)
		if(x==1) {
			return 1;      //1 den 10 a kadar toplam = 55     54 + 1(buradaki 1 return 1 den geliyor)
		}
                             // bu sefer i ve toplam tanımlamamıza gerek yok 
		return x + r(x-1);   // f(10)=f(9)+10    f(9)=f(8)+9 ... 1 den x e kadar olan sayıları recursive toplama
	}
	
	
	
	
	public static void main(String[] args) {  
		 
		
        System.out.println(f(10));
		System.out.println(r(10));
		
		
	}

}
