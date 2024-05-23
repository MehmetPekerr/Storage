
public class GetterSetterTest {
    private static GetterSetter getterSetter = new GetterSetter();

    public static void main(String args[]) {
        getterSetter.setKapiAcik(true);
        printStatus();

        getterSetter.setKapiAcik(false);
        printStatus();

        getterSetter.setGuncelKat(getterSetter.getGuncelKat() - 1);
        printStatus();

        getterSetter.setGuncelKat(-2);
        printStatus();

        getterSetter.setKapiAcik(true);
        printStatus();

        getterSetter.setKapiAcik(false);
        printStatus();

        getterSetter.setGuncelKat(0);
        printStatus();

        getterSetter.setKapiAcik(true);
        printStatus();
        
        getterSetter.setKapiAcik(false);
        printStatus();

        getterSetter.setGuncelKat(getterSetter.getGuncelKat() + 1);
        printStatus();

        getterSetter.setKapiAcik(true);
        printStatus();
        
        getterSetter.setKapiAcik(false);
        printStatus();
        
        

        getterSetter.setGuncelKat(getterSetter.getGuncelKat() - 1);
        printStatus();

        getterSetter.setKapiAcik(true);
        printStatus();
        
        getterSetter.setKapiAcik(false);
        printStatus();
    }

    private static void printStatus() {
        System.out.println("Kapı Açık: " + getterSetter.isKapiAcik());
        System.out.println("Güncel Kat: " + getterSetter.getGuncelKat());
        System.out.println("-----------");
    }
}