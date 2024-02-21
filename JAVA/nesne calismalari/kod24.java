
public class kod24 {

	public static void main(String[] args) {
		
		A a = new A(); //jargondan dolayı yeni oluşturulan nesnenin adı o sınıfın adının küçük harfle başlayan halidir.
		B b = new B(); //2. b de jargondan dolayı ilkinin küçüğü, başka harfte olabilirdi
		a.calistir(b); //A sınıfında oluşturduğumuz a nesnesini çağırırız ve A sınıfındaki calistir fonksiyonunu calistiririz.
                       //Calistir fonksiyonunda cagirmak icin B sınıfında ürettiğimiz b nesnesini yazarız.
		               //(A sınıfındaki calistira B sınıfından bir x gelince x.deger yazdırıyordu.)
		               
	}

}

// A sınıfındaki calistir fonksiyonunu cagırmak icin B sınıfına ulasmamız gerekti bu yüzden A sınıfı, B sınıfına bağımlıdır.
// Hem A sınıfından hem B sınıfından nesne üretiriz.
//A , B ye bağımlı ( A uses B)
//A , B yi kullanıyor, B ye bağımlı


//sınıflar arası bağımlılıkların artması birlikte yönetilmesi gereken sınıf sayısını da arttırır. Bu kodun yönetimini ve okunmasını zorlaştırır.
//bağımlılığın minimum olması istenir.(design pattern ler yardımcı olur)

//bağımlılıkta tüm sınıfa ulaşıyor, birleştirme de kullanacağı kısmı alıyor.

//Bağımlılık ilişkisi, genellikle iki sınıf arasında bir çeşit karşılıklı etkileşimi ifade edebilir. Bu, geniş ve çift yönlü bir etkileşim anlamına gelebilir.