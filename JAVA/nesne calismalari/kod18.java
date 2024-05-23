
public class kod18 {

	public static void main(String[] args) { //main metodu her zaman statik tanımlanır.
		System.out.println("Ogrenci Durumu: "+kod19.ogrenciDurum()); //ekrana sıfır yazar(default olarak)
		kod19 ogrenci1 = new kod19("Ahmet",2,75); //nesne oluşturma fonksiyonu içine sayac++ eklemiştik. Her nesne oluşturduğumuzda arka planda gizli şekilde sayac 1 artar.
		kod19 ogrenci2 = new kod19("Osman",5,60);  //constructor ile tüm değişkenlere değer atanabilir.
		kod19 ogrenci3 = new kod19("Ali",9,80);
		System.out.println("Ogrenci Durumu: "+kod19.ogrenciDurum()); //ekrana 3 yazar.
        ogrenci2.çıkar(); //sayac-- calısır
        System.out.println("Ogrenci Durumu: "+kod19.ogrenciDurum()); //ekrana 2 yazar.
        
        
        int[] notlar = new int[3]; 
        notlar[0]=ogrenci1.puan;
        notlar[1]=ogrenci2.puan;
        notlar[2]=ogrenci3.puan;
        System.out.println(kod19.ortalama(notlar)); //oluşturduğumuz notlar dizisini statik olan ortalama fonksiyonuna attık.
                                                    //dizi cagirirken sadece dizinin ismini yazmamız yeterli.
	}

}
// class nesne = new class();    nesneadi.fonkadi -> normal fonk bu sekilde cagirilir.(nesne tanımladık ayrıca her nesne icin farklı sekilde cagırdık)
//digersinifadi.fonkadi() -> static fonk bu sekilde cagırılır (her yerde aynı sekilde cagırdık ve nesne tanımlamadık.)