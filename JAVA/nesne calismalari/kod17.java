
public class kod17 {

	private int model;       //hiçbir sınıf erişemez(sadece kendi içinde kullanılır.)
	public int hız;          //bütün sınıflar erişebilir
	protected String color;  //aynı pakettekiler ve alt sınıflar erişebilir.
	int süspansiyon;         //aynı pakettekiler erişebilir(default-ön tanımlı)(bir şey yazmıyor)(protected ile benziyor)
	
	
	kod17(){ //bu örnekte değerleri zaten kendimiz atadığımız için kod17(int model,int hız,String color,int süspansiyon) bu yapıya gerek kalmadı!!!
		this.model = 2018; 
		this.hız = 120;
		this.color = "gri";
	}
	
	private void yazdir() { 
		System.out.println(model);
	}
	
	public void yazdir1() { 
		yazdir(); //private tanımlanan ifadeyi bu şekilde public sınıfta çağırabiliriz.
	}
	protected void yazdir2() { 
		yazdir(); //private tanımlanan ifadeyi bu şekilde protected sınıfta çağırabiliriz.
	}
	
	void yazdir3() {
		yazdir(); //private tanımlanan ifadeyi bu şekilde default sınıfta çağırabiliriz.
		//System.out.println(model); 
	}
	
}
