
public enum Kat {
    GIRIS(0), BIRINCI(1), IKINCI(2), UCUNCU(3), DORDUNCU(4), BESINCI(5), ALTINCI(6), YEDINCI(7), SEKIZINCI(8);

    private int intKat;

    private Kat(int intKat) {
        this.intKat = intKat;
    }

    int getIntKat() {
        return intKat;
    }

    Kat yukariGit() {
        Kat ustKat = null;
        if (this != SEKIZINCI) {
            ustKat = values()[ordinal() + 1];
        }
        return ustKat;
    }

    Kat asagiGit() {
        Kat altKat = null;
        if (this != GIRIS) {
            altKat = values()[ordinal() - 1];
        }
        return altKat;
    }

    @Override
    public String toString() {
        return "Kat: " + getIntKat();
    }

    Kat arttir() {
        return yukariGit();
    }

    Kat azalt() {
        return asagiGit();
    }
}