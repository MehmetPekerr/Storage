import java.util.Scanner;

public class kod14 {
	
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	int satir,sütun;
	System.out.println("Mayın Tarlasına Hoşgeldiniz");
	System.out.println("Lütfen oynamak istediginiz boyutlari giriniz");
	
	System.out.println("Satır sayısı:"); 
	satir = scan.nextInt();
	
	System.out.println("Sütun sayısı");
	sütun = scan.nextInt();
	
	kod15 mayin = new kod15(satir,sütun); //mayin isminde kod15 sınıfının özelliklerine erişebilen nesne oluşturduk.
	//kod15 mayin = new kod15(4,4); //böyle otomatikte tanımlayabiliriz.
	mayin.run(); //kod15 sınıfındaki run fonksiyonunu çağırdık.
	}
	
}
