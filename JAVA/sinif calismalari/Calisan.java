
public class Calisan { //ana sınıf(alt sınıfların sadece ortak özelliklerini barındırır, daha geneldir, üsttür)
	private String adSoyad, eposta, telefon;
	
	public Calisan(String adSoyad,String eposta,String telefon) { //alt sınıflarda da bu sırada olmalı
		this.adSoyad = adSoyad;
		this.eposta = eposta;
		this.telefon = telefon;
	}

	protected String giris() {
		return this.adSoyad +  " giris yapti"; //return unutma
	}
	
	static int i=0;
	protected static int girisSayisi() {
		return ++Calisan.i;
	}

	
	protected String getAdSoyad() {
		return adSoyad;
	}

	protected void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	protected String getEposta() {
		return eposta;
	}

	protected void setEposta(String eposta) {
		this.eposta = eposta;
	}

	protected String getTelefon() {
		return telefon;
	}

	protected void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	protected static int getI() {
		return i;
	}

	protected static void setI(int i) {
		Calisan.i = i;
	}
	
	public static void listele(Calisan[] girisYapanlar) { //polymorphizm
		for(Calisan c : girisYapanlar) {
			//c=  //Calisan c = new Akademisyen("Ahmet","a@gmail.com","05550000000","CENG","Öğretmen","Matematik");
			System.out.println(c.giris());
		}
	}
		
}



//alt sınıf üst sınıfa erişebilir, üst sınıf alt sınıfa erişemez. (üst sınıf geneldir)