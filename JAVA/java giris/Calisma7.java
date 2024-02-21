	            import java.util.Scanner;
	            public class Calisma7 {

	            	public static void main(String[] args) {
	            		 int Sayi;
	            	        int birler;
	            	        int onlar;
	            	        int yüzler;
	            	        int binler;

	            	        Scanner scanner = new Scanner(System.in);

	            	        System.out.println("Lütfen 4 basamaklı bir sayı giriniz: ");

	            	        Sayi = scanner.nextInt();

	            	        if (Sayi<1000){

	            	            System.out.println("Lütfen 4 basamaklı bir sayı giriniz!!!... ");

	            	        }
	            	        else if (Sayi > 10000){

	            	            System.out.println("Lütfen 4 basamaklı bir sayı giriniz!!!... ");

	            	        }

	            	        else if (999 < Sayi && Sayi<10000 ){

	            	            // 1234

	            	            birler = Sayi % 10;

	            	            onlar = (Sayi/10)%10;

	            	            yüzler = (Sayi/100)%10;

	            	            binler = (Sayi/1000);

	            	            System.out.println("binler basamağı: "+binler);     //else if icinde deger verdigimiz icin degerleri sadece burada kullanırız
	            	            System.out.println("yüzler basamağı: "+yüzler);
	            	            System.out.println("onlar basamağı: "+onlar);
	            	            System.out.println("birler basamağı: "+birler);

	            	            System.out.println((binler*1000)+(yüzler*100)+(onlar*10)+(birler)); //else if dışında yazdıramazdik. Degerleri yok kabul edilirdi
	            	        }


	            	        
	            	
	            	    }

	            	


	        }

  
	        
	
	    

	


