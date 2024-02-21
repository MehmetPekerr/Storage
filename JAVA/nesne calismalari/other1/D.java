
public class D {
	
	public C c; //C sınıfı türünde c adında bir referans değişkeni oluşturduk. (ama henüz hiç bir nesnenin konumuyla eşitlenmedi)
                //Bu sayede D sınıfından C sınıfına ulaşacağız
	
	   
}
     //BİRLEŞTİRME: Bir sınıfa ait değişkenin diğer sınıfın nesnesi olması durumudur (bir sınıfın diğer bir sınıfı içinde kullanması)
     //Bu şekilde, sınıf içinde başka sınıfların özelliklerine sahip olabilir.
     //Örneğin, bir Araba sınıfı içinde Motor sınıfının bir nesnesini tutmak (ömür boyu birleştirme)
     //Daha kapsayıcı ve genellikle daha soyut ve daha esnek(çünkü bir sınıfın içindeki nesnelerin değişmesi durumunda dışarıdaki sınıfı direkt olarak etkilemez.)
     //Birleştirme durumunda, içerilen sınıfın değişmesi durumunda dışarıdaki sınıfın direkt olarak etkilenmemesi sağlanır.
     //Bir sınıfın başka bir sınıfın nesnesini içinde tutarak onun özelliklerine ve davranışlarına erişmesini sağlar.

     //Bir Araba sınıfı bir Motor sınıfı nesnesini içinde barındırabilir. Bu durumda, Araba sınıfı Motor sınıfını içinde tutar ve Motor sınıfının özelliklerine ve davranışlarına erişebilir. Ancak Araba sınıfı, Motor sınıfının iç yapısını bilmek zorunda olmaz, sadece onu kullanır.