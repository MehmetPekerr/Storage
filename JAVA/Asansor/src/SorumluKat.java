
public enum SorumluKat {
	GIRIS(0), BIRINCI(1), IKINCI(2), UCUNCU(3), DORDUNCU(4), BESINCI(5), ALTINCI(6), YEDINCI(7), SEKIZINCI(8);

	private int intKat;

	private SorumluKat(int intKat) {
		this.intKat = intKat;
	}

	int getIntKat() {
		return intKat;
	}

	SorumluKat arttir() {
		SorumluKat ustKat = null;
		if (this == GIRIS)
			ustKat = BIRINCI;
		else if (this == BIRINCI)
			ustKat = IKINCI;
		else if (this == IKINCI)
			ustKat = UCUNCU;
		else if (this == UCUNCU)
			ustKat = DORDUNCU;
		else if (this == DORDUNCU)
			ustKat = BESINCI;
		else if (this == BESINCI)
			ustKat = ALTINCI;
		else if (this == ALTINCI)
			ustKat = YEDINCI;		
		else
			ustKat = SEKIZINCI;

		return ustKat;
	}

	SorumluKat azalt() {
		SorumluKat altKat = null;
		
		if (this == SEKIZINCI)
			altKat = YEDINCI;
		else if (this == YEDINCI)
			altKat = ALTINCI;
		else if (this == ALTINCI)
			altKat = BESINCI;
		else if (this == BESINCI)
			altKat = DORDUNCU;
		else if (this == DORDUNCU)
			altKat = UCUNCU;
		else if (this == UCUNCU)
			altKat = IKINCI;
		else if (this == IKINCI)
			altKat = BIRINCI;
		else
			altKat = GIRIS;

		return altKat;
	}

	@Override
	public String toString() {
		String string = null;
		string = "Kat: " + getIntKat();
		return string;
	}
}