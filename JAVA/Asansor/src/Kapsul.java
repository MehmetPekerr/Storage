
public class Kapsul {

	private boolean kapiAcik = false;
	private boolean durdu = true;
	private Kat guncelKat = Kat.GIRIS;
	private int agirlik = 0;

	private final int KAPASITE = 1200;

	public void kapiAc() {
		if (durdu)
			kapiAcik = true;
		System.out.println("Kapı açık.");
	}

	public void kapiKapat() {
		kapasiteHesapla();
		if (agirlik <= KAPASITE) {
			kapiAcik = false;
			System.out.println("Kapı kapalı.");
		} else
			System.out.println("Asansör kapasitesi aşıldı, kapılar biri çıkana kadar açık kalacak!");
		return;
	}

	private void kapasiteHesapla() {
		agirlik = (int) (Math.random() * 1400);
		System.out.println("Ağırlık " + agirlik);
	}

	public void yukariGit() {
		if (kapiAcik)
			kapiKapat();
		if (guncelKat.compareTo(Kat.SEKIZINCI) < 0) {
			System.out.println("Yukarı gidiyor!");
			durdu = false;
			guncelKat = guncelKat.yukariGit();
			System.out.println(guncelKat);
		} else
			System.out.println("Zaten en üst katta.");
		durak();
	}

	public void asagiGit() {
		if (kapiAcik)
			kapiKapat();
		if (guncelKat.compareTo(Kat.GIRIS) > 0) {
			System.out.println("Aşağı gidiyor!");
			durdu = false;
			guncelKat = guncelKat.asagiGit();
			System.out.println(guncelKat);
		} else 
			System.out.println("Zaten en alt katta.");
		durak();
	}

	public void git(Kat istenenKat) {
		int karsilastir = guncelKat.compareTo(istenenKat);
		while (karsilastir != 0) {
			if (karsilastir < 0)
				yukariGit();
			else
				asagiGit();
			karsilastir = guncelKat.compareTo(istenenKat); 
		}
		durak();
	}
	
	private void durak() {
		durdu = true;
		kapiAc();
	}

	public boolean getKapiDurumu() {
		return kapiAcik;
	}
}