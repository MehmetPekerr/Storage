
public class kod21 {
	public int sayi1;
	public int sayi2;
	public String renk; 
	final static double pi = 3.14; //final sayesinde pi degiskenini hic bir yerde degistiremiyoruz, her zaman 3.14 olarak kalıyor.(static sayesinde her yere çağırıyoruz.)
	
	kod21(int sayi1, int sayi2, String renk){  //iki nokta ile bitmez, ayrac vardır.
		this.sayi1=sayi1; //sağdaki dışardan gelen parametreydi.!(kod21 deki sayi1 degiskeninin degeri sagdaki olacak)
		this.sayi2=sayi2;
		this.renk=renk;
	}
	
	public int toplama(){ //public int i unutma
		return this.sayi1 + this.sayi2; //return unutma
	}
	
	public int cikarma(){
		return this.sayi1 - this.sayi2;
	}
	
	public int carpma(){
		return this.sayi1 * this.sayi2;
	}
	
	public int bolme() {
		return this.sayi1 / this.sayi2;
	}
	
	public double alan(int r) {
		return kod21.pi * Math.pow(r, 2); //burada pow metodu static metoddur çünkü math sınıfından nesne tanımlamadan metoda erişim sağladı.
	}                                     //alan = pi * r nin karesi
	

}

//print içine print yazdıramayız.