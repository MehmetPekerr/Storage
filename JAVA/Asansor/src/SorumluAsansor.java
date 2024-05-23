public class SorumluAsansor implements Asansor {

    private boolean kapiAcik = false;
    private boolean durdu = true;
    private Kat guncelKat = Kat.GIRIS;
    private int agirlik = 0;

    private final int KAPASITE = 1200;

    @Override
    public void kapiAc() {
        if (durdu)
            kapiAcik = true;
        System.out.println("Kapı açık.");
    }

    @Override
    public void kapiKapat() {
        hesaplaKapasite();
        if (agirlik <= KAPASITE) {
            kapiAcik = false;
            durdu = false;
            System.out.println("Kapı kapalı.");
        } else
            System.out.println("Asansör kapasitesi aşıldı, kapılar birisi çıkana kadar açık kalacak!");
        return;
    }

    @Override
    public void git(Kat istenenKat) {
        int karsilastir = guncelKat.compareTo(istenenKat);
        while (karsilastir != 0) {
            if (karsilastir < 0)
                yukariGit();
            else
                asagiGit();
            karsilastir = guncelKat.compareTo(istenenKat);
        }
        durdu = true;
        
    }

    private void yukariGit() {
        if (kapiAcik)
            kapiKapat();
        if (guncelKat.compareTo(Kat.SEKIZINCI) < 0) {
            System.out.println("Yukarı gidiyor!");
            guncelKat = guncelKat.arttir();
            System.out.println(guncelKat);
        } else
            System.out.println("Zaten en üst katta.");
        durdu = true;
    }

    private void asagiGit() {
        if (kapiAcik)
            kapiKapat();
        if (guncelKat.compareTo(Kat.GIRIS) > 0) {
            System.out.println("Aşağı gidiyor!");
            guncelKat = guncelKat.azalt();
            System.out.println(guncelKat);
        } else
            System.out.println("Zaten en alt katta.");
        durdu = true;
        kapiAc();
    }

    private void hesaplaKapasite() {
        agirlik = (int) (Math.random() * 1400);
        System.out.println("Ağırlık: " + agirlik);
    }
}