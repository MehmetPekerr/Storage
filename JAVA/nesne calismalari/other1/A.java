
public class A {
	
	public void calistir(B b) { //2. b fonksiyon için jargondan dolayı ilk b nin küçüğü (ilk B diğer sınıfın ismi olmak zorunda)
		
		System.out.println(b.deger); //b nesnesi B sınıfına bağımlı
	}                                //calistir fonksiyonuna B sınıfındaki bir degisken gelirse ekrana degeri yazdırıyor.

}

//calistir fonksiyonu B sınıfından b nesnesini yazdırıyor. B sınıfı olmazsa A sınıfı bir şey yapamaz. A sınıfı B sınıfına bağımlıdır diyebiliriz.
//B b referansı ile B sınıfının konumuna erişiriz ama değer ataması yapamayız. 
