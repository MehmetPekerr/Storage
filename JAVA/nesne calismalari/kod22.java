
public class kod22 {

	public static void main(String[] args) {
		
		kod23 kitap1 = new kod23("kasagı", -8, "omerSeyfettin", "isBankasi" ); 
		
		
		//kitap.cevir(); //fonksiyonlar main içine yazılır.
		
		System.out.println(kitap1.getSayfaSayisi()); //suanki sayfa sayisini yazdir.        //-8 i diğer sınıfta 10 yaptık.
		
		kitap1.setSayfaSayisi(80);  //sayfa sayisini 80 olarak güncelle
		
		System.out.println(kitap1.getSayfaSayisi());  //yeni sayfa sayisini yazdirir.
		
		System.out.println();
		
		kod23 kitap2 = new kod23("tengomlek",180,"halideEdip","canYayin");
		System.out.println(kitap2.getİsim()); //ismi yazdır.
		kitap2.setİsim("AtestenGomlek");      //ismi değiştir.
		System.out.println(kitap2.getİsim()); //yeni ismi yazdır.
										
	}		
}
//Private olduğu için erişemiyoruz ve encapsulation yoluyla erişim sağlıyoruz.
