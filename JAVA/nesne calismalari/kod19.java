
public class kod19 {
	public String ad; 
	public int no,puan;
	private static int sayac=0; //static olarak tanımlarsak tekrar tekrar kullanmamız kolaylaşır. Tüm nesnelerde kullanılabilir.(örn sayac)
	
	kod19(String ad, int no, int puan){ //bu parametreleri kullanıcıdan alacağız.
		
		this.ad = ad;
		this.no = no;
		this.puan = puan;
		kod19.sayac++; //ana sınıfın yanına bu şekilde ekleyerek her yerde çağırabiliriz.
	}
	
	public void çıkar() { //burada static tanımlamaya gerek yok, bir yerde kullanmıyoruz, sadece arka planda değer azaltacak.(void)
		kod19.sayac--; //sayacı azalttık.
	}
	
	public static int ogrenciDurum() { //burada static tanımladık ve bu sayede ogrenciDurum fonksiyonunu hiç nesne tanımlamadan normal şekilde direkt yazdırabildik.
		return kod19.sayac; 
	}
	
	public static double ortalama(int dizi[]) { //Static sayesinde bu fonksiyon içine yazılan dizinin elemanlarının ortalamasını nesne tanımlamadan return ediyor.
		                                        
		double toplam=0; //double tanımlamalıyız!
		for(int i=0;i<dizi.length;i++) {
			toplam +=dizi[i];
			
		}
		return toplam / dizi.length;
	}

}
//sinifadi.fonkadi -> burada statigi böyle cagiririz.

//static fonksiyon icinde this tanımlanmaz.
//int varsa void olmaz.
//static ile bellekte nesne oluşturmasak bile her zaman otomatik yer ayrılır.
//dinamikte nesne oluşturduğumuzda o nesne için bellekte yer ayrılır. Nesne oluşturmazsak bellekte yer ayrılmaz.
//static fonksiyon sayesinde nesne oluşturmadan farklı sınıfta direkt kullanabiliriz.
//private public kuralı değişmez. Static fonksiyon sadece nesne oluşturmadan çağırmayı kolaylaştırır.
//en başta static tanımladığımız elemanları static veya void fonksiyonda this kullanmadan çağırabiliriz.
//this ile belirlediğimiz nesneler static fonksiyon içinde kullanılamaz.
//static kullanım sayacta vb kullanılır. Normal nesnede bir nesneyi değiştirince diğerlerinin etkilenmemesi için static kullanmayız.
