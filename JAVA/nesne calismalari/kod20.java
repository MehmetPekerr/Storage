
public class kod20 {

	public static void main(String[] args) {
		kod21 hesap = new kod21(10,5,"gri"); //iki nokta ile biter. Diğer tarafta parametre verilmişse burada da içinde belirtmek zorundayız. Diğer tarafta parametre verilmeseydi aşağıda nesne.parametre şeklinde tanımlardık.
		System.out.println(hesap.sayi1);     
		System.out.println(hesap.pi); //normal yolla yazdırma
        System.out.println(kod21.pi); //static yoluyla yazdırma
        
        System.out.println(hesap.alan(2)); //r=2    (3.14) * (2^2)
	}

}
