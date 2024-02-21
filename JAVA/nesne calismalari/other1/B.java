
public class B {
	
	public int deger = 1;
	

}
   //BAĞIMLILIK: Bir sınıfın içindeki metodun parametresine başka bir sınıftan eleman gelmesi durumu
   //Eğer bir sınıf başka bir sınıfın metotlarını kullanıyorsa veya onun nesnelerine erişiyorsa, bu sınıf diğerine bağımlıdır.
   //Örneğin, bir Araba sınıfının Üretici sınıfına bağımlı olması, arabanın üretici bilgilerine erişmek için Üretici sınıfının metotlarını çağırması 
   //sınıflar arasında sıkı bir bağlantı(bağımlı sınıfın değişmesi durumunda bağımlı olan sınıfı etkileyebilir.)

   //Örneğin, bir Araba sınıfı bir Üretici sınıfına bağımlı olabilir. Araba sınıfı, Üretici sınıfının metotlarını çağırarak üretici bilgilerine erişebilir. Bu durumda, Araba sınıfı Üretici sınıfına sıkı bir şekilde bağlıdır.