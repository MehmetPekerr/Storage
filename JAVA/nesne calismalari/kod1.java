        
public class kod1 {
         
	public static void main(String[] args) {  
		
	                             //kod2 sınıfı türünde ahmet nesnesi(objesi) türettik
		kod2 ahmet = new kod2(); //Ahmetin hesap makinesi olsun (buradan kod2 deki class a erişmemizi sağlayan kod)
		ahmet.sayi1=3; //burada tekrar int diye belirlememize gerek kalmadı
		ahmet.sayi2=4; //kod2 deki sayi2 degiskenine 4 degerini atadık
		ahmet.renk="kırmızı";
		
		
		kod2 osman = new kod2(); //kod2 isimli sınıf türünde ismi osman olan yeni bir nesne oluşturur (kod2 deki her sey osman nesnesinin elemanıdır)
	    osman.sayi1=37; //osman nesnesinin sayi1 elemani. 
	    osman.sayi2=45; 
	    osman.renk="turuncu";
		
	    
	    System.out.println(ahmet.sayi1); //3 yazar. Kod2 deki sayi1 degiskenini yazdirir.
	    System.out.println(osman.sayi1); //37 yazar.
	    System.out.println(osman.renk); //turuncu yazar.
	    
	    
	    //kod1 ve kod2 aynı package(şuan default package) içinde olmasaydı çağıramazdık(public olsa bile)
	    //public private küçük harfle başlar.

	    
	    
	}
	
	    
		
}
