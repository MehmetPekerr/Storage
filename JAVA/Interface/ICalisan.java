
public interface ICalisan { //class yerine interface
	
	final String okul = "İNÜ";
	
	public void giris();
	public void cikis();
	public boolean yemek(int saat);

}

//Abstract ta değişkenler ve constructor var ama Interface sadece bir kalıp, alt sınıfları o kalıba uyacak.

//Abstract metod tanımladıgımızda tanımlanan sınıfın altındaki sınıflarda da o metod olmak zorunda.

//alt sınıfın içi boşta olabilir ama override etmek zorunda.

//alt sınıfta neler olması gerektiğini belirliyoruz.

//abstact ve interface ile nesne üretemeyiz, soyutlardır.

//public abstract class A   //public interface A
//extends(normaldeki)       //implements


//public abstract void metod(){}
