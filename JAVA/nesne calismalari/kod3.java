
public class kod3 {

	public static void main(String[] args) {
		
		
		kod4 osman;             //bu yolla da nesne tanımlayabiliriz, aynı şeyi ifade eder.
		osman = new kod4(7,8," mavi");  //en sondaki kod4() kısmı constructor dur.(tanımlanmasa bile her class da gizli constructor vardır, başlatıcı-yapıcı metoddur.)
		
		System.out.println(osman.sayi1 + " " + osman.sayi2 + osman.renk);
		
		osman.sayi1 = 5;
		
		System.out.println(osman.sayi1 + " " + osman.sayi2 + osman.renk);
		
		//sınıf özelliklerine nokta ile erisilir 
		//nesne=obje
                                                     		
		kod4 ahmet = new kod4(14,2,"yesil");
		System.out.println(ahmet.toplama());
        System.out.println(ahmet.carpma());
        System.out.println(ahmet.renk);
	}

}
