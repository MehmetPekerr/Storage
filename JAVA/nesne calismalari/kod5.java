
public class kod5 {

	public static void main(String[] args) {
	
		kod6 personel = new kod6("Osman",3000,75,1990); //1. PERSONEL bu kısım hepsinde aynı
		personel.ekranaBastir(personel); //bu kısım farklı olan kısım. kod6 yı başta yazdık tekrar gerek yok.
		
		System.out.println();
		
		
		
		
		kod6 personel2 = new kod6("Ali",1000,15,1997); //2. PERSONEL
		personel2.ekranaBastir2();  //bu this ile yapılışı.(en kolayı)
		
		System.out.println();
		
        
		
		
		
		kod6 personel3 = new kod6("Mehmet",2000,45,1985); //3. PERSONEL fonksiyon kullanmadan.(bu yolda her seferinde hepsini yeniden yazmamız gerekiyor.)
		
		System.out.println("Tax: "+personel3.tax());
		System.out.println("Bonus: "+personel3.bonus());
		System.out.println("Maas artisi: "+personel3.increase());
		
		double toplamMaas = personel.salary - personel3.tax() + personel3.bonus();
		System.out.println("Toplam maas: "+toplamMaas);
		System.out.println("Zamlı maas: "+ (personel3.salary + personel3.increase())); //burada parantez içine aldık çünkü println de + işareti birleşme anlamında da kullanılır parantez içine alarak toplama işlemi olduğunu belirttik.

		
		
		
		

	}

}
