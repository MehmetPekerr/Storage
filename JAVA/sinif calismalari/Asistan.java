
public class Asistan extends Akademisyen{
	
	private String yuksekLisans;

	public Asistan(String adSoyad, String eposta, String telefon, String bolum, String gorevler, String ders, String yuksekLisans) {
		super(adSoyad, eposta, telefon, bolum, gorevler, ders);
		this.yuksekLisans = yuksekLisans;
	}

	protected String getYuksekLisans() {
		return yuksekLisans;
	}

	protected void setYuksekLisans(String yuksekLisans) {
		this.yuksekLisans = yuksekLisans;
	}
	

}
