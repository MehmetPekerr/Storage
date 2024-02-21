
public class OgretimUyesi extends Akademisyen{
	
	String unvan;

	public OgretimUyesi(String adSoyad, String eposta, String telefon, String bolum, String gorevler, String ders,
			String unvan) {
		super(adSoyad, eposta, telefon, bolum, gorevler, ders);
		this.unvan = unvan;
	}

}
