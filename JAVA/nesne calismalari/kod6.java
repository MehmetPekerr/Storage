
public class kod6 {
	
    private String name;
    public double salary;
    private int workHours,hireYear;

    kod6(String name,double salary,int workHours,int hireYear){
    	this.name=name;
    	this.salary=salary;
    	this.workHours=workHours;
    	this.hireYear=hireYear;
    }
    
    public double tax() {
    	if(this.salary>=1000) {
    		return salary*0.03;
    	}
    	return 0;
    }
    
    public double bonus() {
    	int extraHours = this.workHours-40;
    	if(extraHours>0) {
    		return extraHours*30;
    	}
    	return 0;
    }
    
    public double increase() {
    	int year = 2020-this.hireYear;
    	if(year<10) {
    		return salary*0.5;
    	}
    	else if(year>=10 && year<20) {
    		return salary*0.10;
    	}
    	else {
    		return salary*0.15;
    	}
    }
    
    
    public void ekranaBastir(kod6 yeni) {   //string metodlar her zaman void olur. this yerine bunu kullanabiliriz, sınıfı ve nesneyi yazarız.
    	System.out.println("Tax: "+yeni.tax());  //yeni yerine herhangi bir şey gelebilir. kod6 ya başta eşitledikten sonra tekrar bir şeye gerek yok
		System.out.println("Bonus: "+yeni.bonus());
		System.out.println("Maas artisi: "+yeni.increase());
		
		double toplamMaas = yeni.salary - yeni.tax() + yeni.bonus();
		System.out.println("Toplam maas: "+toplamMaas);
		System.out.println("Zamlı maas: "+ (yeni.salary + yeni.increase())); //burada parantez içine aldık çünkü println de + işareti birleşme anlamında da kullanılır parantez içine alarak toplama işlemi olduğunu belirttik.

    }
    
    public void ekranaBastir2() {    //fonksiyon parametre almıyor. (daha kolay) (this var)
        System.out.println("Tax: " + this.tax());
        System.out.println("Bonus: " + this.bonus());
        System.out.println("Maas artisi: " + this.increase());
        
        double toplamMaas = this.salary - this.tax() + this.bonus();
        System.out.println("Toplam maas: " + toplamMaas);
        System.out.println("Zamlı maas: " + (this.salary + this.increase())); 
    }
    
}
