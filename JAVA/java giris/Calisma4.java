
public class Calisma4 {


	static int add(int a, int b) {
		System.out.println("1. metod");
		return a + b;
	}
	
	
	static int add(int a, int b, int c) { //Overloading sayesinde aynı add ismindeki toplama metoduna farklı karakterler ekledik
		System.out.println("2. metod");
		return a + b + c;
	}
	
	
	static double add(int a, int b , double c) { //double farkını java anlıyor
		System.out.println("3. metod");
		return a + b + c;
	}
	
		
	public static void main(String[] args) {
		
		System.out.println(add(1,2));  //int,int metodunu cagirdi
		System.out.println(add(1,2,3));  //int,int,int metodunu cagirdi
		System.out.println(add(1,2,3.0));  //int,int,double metodunu cagirdi. Double da araya nokta koyulur. (Değer konsoldan alınsaydı araya virgül koyardık.)
		


	}

}
