
public class Ilkel {

	private boolean kapiAcik = false;
	private int guncelKat = 0;
	private int agirlik = 0;

	private final int KAPASITE = 1200;
	private final int EN_UST_KAT = 8;
	private final int EN_ALT_KAT = 0;

	public void kapiAc() {
		if (!kapiAcik)
			kapiAcik = true;
		else
			System.out.println("Kapı zaten açık.");
	}

	public void kapiKapat() {
		agirlikHesapla();

		if (agirlik <= KAPASITE) {
			kapiAcik = false;
		} else {
			System.out.println("Asansör kapasitesi aşıldı.");
			System.out.println("Kapılar, birisi çıkana kadar açık kalacak!");
			return;
		}
	}

	
	private void agirlikHesapla() {
		agirlik = (int) (Math.random() * 1500);
		System.out.println("Ağırlık: " + agirlik);
	}

	public void yukariGit() {
		if (!kapiAcik) {
			if (guncelKat < EN_UST_KAT) {
				
				System.out.println("Güncel kat: " + guncelKat);
				guncelKat++;
			} else
				System.out.println("Zaten en üst katta.");
		} else
			System.out.println("Hala kapılar açık!");
	}

	public void asagiGit() {
		if (!kapiAcik) {
			if (guncelKat > EN_ALT_KAT) {
				guncelKat--;
				System.out.println("Güncel kat: " + guncelKat);
			} else
				System.out.println("Zaten en alt katta.");
		} else
			System.out.println("Hala kapılar açık!");
	}

	public void git(int istenenKat) {
		if ((istenenKat >= EN_ALT_KAT) && (istenenKat <= EN_UST_KAT)) {

			while (guncelKat != istenenKat) {
				if (guncelKat < istenenKat)
					yukariGit();
				else
					asagiGit();
			}
		} else
			System.out.println("Geçersiz Kat");
	}

	public int getKat() {
		return guncelKat;
	}

	public boolean getKapiDurumu() {
		return kapiAcik;
	}
}