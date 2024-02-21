
public class kod25 {

	public static void main(String[] args) {
		C c = new C();
		D d = new D();
		d.c = c; //burada oluşturduğumuz d nesnesinin c değişkenine burada oluşturduğumuz yeni c nesnesinin değerini atadık (jargongan dolayı ikisinin ismi de c)
                 //(D sınıfındaki c değişkeni C sınıfının özelliklerine ulaşıyordu)
		         //D sınıfındaki c değişkenine yeni c değerini atadık
				// atama için ikisi de aynı türde olmalı (d.c ve c ikisi de c türünde!!!)			
	}
   
}
   //D , C ye sahiptir.  D has C 
   //D ve C birleştirme.
   //bağımlılıkta sadece çağırma yapmıştık. burada ise atama da yaptık
	
   
   //Örneğin, Araba sınıfı içinde Motor sınıfının bir nesnesini barındırabilir. Bağımlılık durumunda Araba sınıfı, Motor sınıfının metotlarını çağırıyor veya onun nesnelerine erişiyorsa, bu durumda bağımlı oluyor demektir. Ancak birleştirme durumunda Araba sınıfı, Motor sınıfının nesnesini içinde barındırır ve Motor sınıfının iç yapısını bilmek zorunda olmadan sadece onu kullanabilir.

   //başka bir sınıfın nesnesini içinde tutar ve bu nesne üzerinden sadece belirli özelliklere veya davranışlara erişebilir. Bu, içeren sınıfın içerilen sınıfın tüm detaylarını bilmek zorunda olmadığı anlamına gelir. Sadece içerilen sınıfın belirli bir parçasını kullanırken, geri kalan detaylar içeriden gizlenmiş olur.

   //Örneğin, Araba sınıfı bir Motor sınıfını içinde barındırabilir. Araba sınıfı Motor nesnesini içerir, ancak Araba sınıfı yalnızca Motor'un hızını değiştirebilir veya Motor'u başlatıp durdurabilir. Araba sınıfı, Motor sınıfının iç yapısını (örneğin, içerideki parçalar, motorun nasıl çalıştığı vb.) ayrıntılı olarak bilmek zorunda değildir. Sadece Motor sınıfının belirli özelliklerini kullanırken, geri kalan ayrıntılar içeriden gizlenmiş olur.

   //İçeren sınıf, içerilen sınıfın özelliklerine veya davranışlarına erişebilir, ancak tüm detayları bilmek zorunda değildir. 

   //Örneğin, bir sınıf başka bir sınıfı içinde barındırırken, içerilen sınıfın private bir değişkenine doğrudan erişemez; sadece içerilen sınıfın public veya protected metotlarını kullanarak bu değişkene erişebilir.

   //Bu farklılık, bağımlılıkta bir sınıfın doğrudan diğer sınıfın private öğelerine erişebilmesine karşılık, birleştirme durumunda içeren sınıfın içerilen sınıfın private detaylarına dolaylı yoldan, genellikle public veya protected metotlar aracılığıyla erişmesidir. Bu durum birleştirme durumunda daha esnek ve modüler bir ilişki sunar.

   //Birleştirme de içine ekliyoruz

   //birleştirme durumu genellikle daha özgül,spesifik ve tek yönlü bir ilişkiyi ifade eder.

   //Genellikle içeren içerilene erişir ama içerilen içerenin detaylarına doğrudan erişemez.






