
public class Veri {
	
	private static Veri publicElevator = new Veri();
	static boolean durdu = false;
	private boolean kapiAcik;
	private int guncelKat;

	public static void main(String args[]) {
		
		
		publicElevator.kapiAcik = true; 
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = false; 
		asansorDurumunuYazdir();		
		publicElevator.guncelKat--;
		publicElevator.guncelKat++;		
		publicElevator.guncelKat = 7;
		publicElevator.kapiAcik = true; 		
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = false;
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = true;
		publicElevator.guncelKat = -3; 
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = false; 
		asansorDurumunuYazdir();
		publicElevator.guncelKat++; 
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = false;
		publicElevator.guncelKat++;
		asansorDurumunuYazdir();
		publicElevator.guncelKat++;
		publicElevator.kapiAcik = true;
		asansorDurumunuYazdir();
		publicElevator.kapiAcik = false;
		asansorDurumunuYazdir();
		
		System.out.println("SON DURUM:");
		asansorDurumunuYazdir();
		
	}
	
	public static void asansorDurumunuYazdir(){
		String kapiDurumuString = "KAPALI";
		if(publicElevator.kapiAcik)
			kapiDurumuString = "AÇIK";
		
		System.out.println("Asansör " + publicElevator.guncelKat + ". katta ve kapı " + kapiDurumuString);
	}
}