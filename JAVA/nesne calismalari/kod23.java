
public class kod23 {
	private String isim, yazar, yayımcı;
	private int sayfaSayisi; 	
	
	kod23(String isim, int sayfaSayisi,String yazar, String yayımcı){ //constructor tanımlamadan hepsini set metodu ile de alabiliriz.
		this.isim = isim;
		this.yazar = yazar;
		this.yayımcı = yayımcı;
		if(sayfaSayisi<1) {       //Sayfa sayisi 1 den küçükse 10 değeri verilecek.
			this.sayfaSayisi = 10;          
		}
		else {
			this.sayfaSayisi = sayfaSayisi;
		}
				
	}
	
	/*public void cevir() {        //metodlar constructor dışında olmalı. Private ifadeyi çağırabilmek için bunu yaptık.
		System.out.println(sayfaSayisi); //diğer sınıfa sadece görüntü gidecek, sayfaSayisi değişkeni diğer sınıfta kullanılmayacak.
	} */
	
	public int getSayfaSayisi() { //değer döndürüyorsa int. Buradaki isimlendirme jargondan kaynaklanır. Get değişse sorun olmaz. (Baştaki S nin büyük olması da jargondan kaynaklı.)   
		return this.sayfaSayisi;
	} 
	
	public void setSayfaSayisi(int yeni) { //set metodu void yazdık. burada dış sınıf sadece yeni ye erişebilir.(Encapsulation)
		if(yeni<1) {  //kullanıcının girdiği değer 1 den küçükse hata ver.
			System.out.println("lutfen pozitif bir deger giriniz"); 
			this.sayfaSayisi = 10; 
			
		}
		else {
			this.sayfaSayisi = yeni; //yeni deger 1 den küçük değilse yeni deger sayfa sayisina aktarilsin.		
	}

}
	
	public String getİsim() { //veri tipi gette fonksiyon adından önce belirtilir. 
		return this.isim; //gette eski parametre sadece çağırılıyor
	}
	
	public void setİsim(String yeniAd) { //veri tipi sette fonksiyon parantezi içinde belirtilir. (void)
		this.isim = yeniAd; //sette yeni bir parametre var ve eski parametreyi değiştirmemizi sağlıyor. (yeni parametrede this yoktur.)
		
	}
	
	public String getYazar() {
		return this.yazar;
	}
	
	public void setYazar(String yeniYazar) { 
		this.yazar = yeniYazar;
		
	}
	
	public String getYayımcı() {
		return this.yayımcı;
	}
	
	public void setYayımcı(String yeniYayımcı) { 
		this.yayımcı = yeniYayımcı;
		
	}
}

//tüm değişkenler için kapsülleme yaptık. Diğer sınıfta hepsini fonksiyonla çağırıp güvenliği arttırıyoruz.
//encapsulation sayesinde sınıftaki değişkenler sadece o sınıfa ait metodlar tarafından değiştirilebilir. Asıl sınıfın iç mantığı güvenlik için gizlenir.

//private yap.

//get sayesinde private değişkeni dış sınıfta çağırabildik. (return)

//set sayesinde private değişkeni dış sınıfta değiştirilebildik. (void)