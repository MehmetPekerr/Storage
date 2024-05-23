public class Mainn {
	public static void main(String[] args) {

		Akademisyen a = new Akademisyen("Ahmet","a@gmail.com","05550000000","CENG","Öğretmen","Matematik");
		
		OgretimUyesi o = new OgretimUyesi("Mehmet", "m@gmail.com", "000", "Kimya", "Mühendis", "Laboratuvar", "Simyacı");
		
		Guvenlik g = new Guvenlik("Serhat","s@gmail.com","03330000000","Okul Guvenligi","Güvenlik sertifikası");
		
		//Calisan c = new Akademisyen("Ahmet","a@gmail.com","05550000000","CENG","Öğretmen","Matematik"); //diğeriyle aynı işlevi yapar.
				
		a.derseGir();
		System.out.println(a.giris());
		System.out.println(o.giris());
		System.out.println(g.giris()); //Burada Overriding yok
		
		System.out.println(Akademisyen.girisSayisi());
		System.out.println(Memurlar.girisSayisi());
		
		System.out.println(a.getAdSoyad());
		
		System.out.println();
			
		Calisan[] girisListesi = {a,o,g};  //polymorphizm sayesinde sonradan değişiklik yapmamız gerektiğinde zorlanmayız.
		                                   //Calisan sinifini referans göstererek alt sınıflarını geziyoruz.
		Calisan.listele(girisListesi);    					
	}
}
//Calisan sinifini cagirmadan ulasabiliriz.
//OgretimUyesi Akademisyenin altındadır, o yüzden daha çok parametre alır.
