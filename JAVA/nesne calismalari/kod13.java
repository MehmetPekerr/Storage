
public class kod13 {

	public static void main(String[] args) {
		String str = "kapak" , tmp=""; //tmp yi bos olarak tanımlarız.
		
		for(int i=str.length()-1 ; i>=0 ; i--) { //eleman sayısı-1 den yani son harften baslayıp sıfırıncı indise kadar azalt
			tmp = tmp + str.charAt(i); //charAt(harfin indisini bulur) saymaya sıfırdan baslıyordu.
		}                              //tmp str nin tersten yazılmış hali oldu
		
		if(tmp.equals(str)) {   //equals eşit mi kontrol eder, yerleri değişse de fark etmez.
			System.out.println("Palindromiktir");
		}
		else {
			System.out.println("Palindromik degil");
		}
		tmp = tmp + str; //string ifadeleri bu sekilde toplayabiliriz.(sagına ekler)
		System.out.println(tmp); 

	}

}
