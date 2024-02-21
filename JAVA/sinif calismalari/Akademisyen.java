
public class Akademisyen extends Calisan { //akademisyen calisana erisir ama calisan akademisyene erisemez.
	private String bolum, gorevler, ders; //getter setter için erişim belirleyici belirtilmeli
	
	public Akademisyen(String adSoyad,String eposta,String telefon, String bolum, String gorevler, String ders) {
		super(adSoyad,eposta,telefon);
		this.bolum = bolum;
		this.gorevler = gorevler;
		this.ders=ders; 
	}
	
	public void derseGir() {
		System.out.println("Derse girildi");
	}

	public String giris() { //Calisan sinifindaki(üst sınıftaki) metod overriding yapıldı, ezildi. (Akademisyen ve alt sınıflarına geçerli olur)
		return super.giris() + " " + this.bolum + " A kapısından";   //super ile bir ust sınıfın giris fonksiyonuna eristik.
	}
	
	protected String getBolum() {
		return bolum;
	}

	protected void setBolum(String bolum) {
		this.bolum = bolum;
	}

	protected String getGorevler() {
		return gorevler;
	}

	protected void setGorevler(String gorevler) {
		this.gorevler = gorevler;
	}

	protected String getDers() {
		return ders;
	}

	protected void setDers(String ders) {
		this.ders = ders;
	}

	
}