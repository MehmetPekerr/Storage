
public class GetterSetter {

	private boolean kapıAcik = false;
	private int guncelKat = 0;
	private int agirlik = 0;

	private final int KAPASITE = 1200;
	private final int EN_UST_KAT = 8;
	private final int EN_ALT_KAT = 0;

	public boolean isKapiAcik() {
		return kapıAcik;
	}

	public void setKapiAcik(boolean kapıAcik) {
		this.kapıAcik = kapıAcik;
	}

	public int getGuncelKat() {
		return guncelKat;
	}

	public void setGuncelKat(int guncelKat) {
		this.guncelKat = guncelKat;
	}

	public int getAgirlik() {
		return agirlik;
	}

	public void setAgirlik(int agirlik) {
		this.agirlik = agirlik;
	}

	public int getKAPASITE() {
		return KAPASITE;
	}

	public int getEN_UST_KAT() {
		return EN_UST_KAT;
	}

	public int getEN_ALT_KAT() {
		return EN_ALT_KAT;
	}
}