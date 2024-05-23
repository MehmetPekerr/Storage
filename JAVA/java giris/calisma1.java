
//import java.util // java utildeki tüm kütüphaneleri import eder.(scanner dahil)
import java.util.Scanner;  //Scan işlemi için bu kütüphaneyi import ederiz. Scanner s si her zaman büyük



public class calisma1 {

	public static void main(String[] args) {
		
Scanner giris = new Scanner(System.in); //Scanner büyük harfle baslar burada tipini belirtmemize gerek yok. Bunu 1 defa yazmak yeterli. System S si de büyük. main içinde tanımlanır
		
System.out.println(10+15); //sadece s buyuk
System.out.print("Hello "
		+ "world\t1");


int a = 120;

System.out.println("a");
System.out.println(a);
System.out.println("1 5"+  a);
System.out.println("Deger:"+ a);
System.out.println("Deger:"+ 200);



float sayi1 = 35.3f;
System.out.println(sayi1); //println de herhangi bir harf sembolü(%) belirtmeye gerek yok. Her şeye artı(+) işareti koyarız.
float sayi2 = 47.8F;
System.out.println(sayi2);
float sayi3 = 20; //20.00
System.out.println(sayi3);

double ondalikliSayi1=3; //double da harf eklemeye gerek yok
ondalikliSayi1=5;
System.out.println(ondalikliSayi1);
double ondalikliSayi2=3.14;
System.out.println(ondalikliSayi2);

char karakter1=117; //ascıı nin 117 karşılığı u harfini atar
System.out.println(karakter1);
char karakter2='u';
System.out.println(karakter2);


boolean mantik1= true;
System.out.println(mantik1);
boolean mantik2= false;
System.out.println(mantik2);



String metin1 = "Hello world"; //String büyük harfle başlar çünkü char dan türetilmiş bir sınıftır.
System.out.println(metin1);
System.out.println("Hello world");




int x = 10;
int y = 5;

int cikarma = x-y;
System.out.println("cikarma:"+cikarma);


boolean kosul= (x / y)==2; //true
System.out.println(kosul); 

boolean kosul1 = x > y;  //true
System.out.println(kosul1);
boolean kosul2 = x < y;  //false
System.out.println(kosul2);

boolean sonuc1 = kosul1 && kosul2; //ikisi de doğruysa true
System.out.println(sonuc1);
boolean sonucc1 = (x > y) && (x < y); //biri doğruysa true
System.out.println(sonucc1);

boolean sonuc2 = kosul1 || kosul2; //biri doğruysa true
System.out.println(sonuc2);
boolean sonucc2 = (x > y) || (x < y); //biri doğruysa true
System.out.println(sonucc2);


String cevap = (x==y) ? "İfade doğru" : "ifade yanlış" ; //true ise başta olanı yazdırır


System.out.println(cevap); //ekrana ifade doğru yazar


int sonuc3 = x++ - --y;  //x henüz güncellenmedi y güncellendi
System.out.println(sonuc3);

System.out.println(x); //x güncellendi
System.out.println(y); 

x-=y; //x=x-y
System.out.println(x); 



int m,n;
System.out.println("Lutfen m degerini giriniz");
m = giris.nextInt(); //m degerini girer integer oldugu için nextInt. fonksiyondur sonunda parantez() vardır.
System.out.println("Lutfen n degerini giriniz");
n= giris.nextInt();
System.out.println("m:" + m + " dir"); 
System.out.println("n:"+n); //yanında metin oldugu icin artı(+) ekledik yoksa direkt n de yazabilirdik


double g;
System.out.println("Lutfen g double degerini giriniz");
g = giris.nextDouble(); //konsola girerken araya nokta değil virgül koymalıyız.(SADECE KONSOLA GİRİSLERDE GERİ KALAN YERLERDE ARAYA NOKTA KOY. Tam sayıysa normal yaz 
System.out.println("g:"+g);

giris.nextLine();  //Önceki girişlerden kalan newline karakterini temizler (newline=satırsonu karakteri)satır sonu karakteri veya boş bir satır alana kadar okuma yapar ve bu nedenle bir önceki girişten kalan newline karakterini okuyarak hemen sonlanabilir. Kullanıcı bir şey girmese bile bu durum meydana gelebilir.
String p;
System.out.println("Lutfen p metinini giriniz istediginiz kadar bosluk");
p = giris.nextLine(); //bütün metini alabilir
System.out.println(p);


String k;
System.out.println("Lutfen k metinini giriniz bosluk olmayacak");
k = giris.next();  //Line olmadıgı icin bosluktan sonraki kısmı almaz
System.out.println("k:"+k);  //burada String de tırnak içine almaya gerek yok


if(p.equals("Hello world")) {  //p=Hello world ise (p tipi string olmasaydı yapamazdık)
	System.out.println("P=Hello world");
}



System.out.println("sıfır(0) olana kadar sayı gireceksin ve cift sayilar toplanacak");
int eleman1;
int toplam=0;
while(true) {
	System.out.println("Bir sayi giriniz");
	eleman1 = giris.nextInt();
	
	if(eleman1==0) {
		System.out.println("Dongu bitti");
		break;
	}
	
	if(eleman1%2==0) {
		toplam=toplam+eleman1;
	}
		
}
System.out.println("cift sayi toplam= "+toplam);



System.out.println("Tek sayilar toplanacak negatif girilirse döngü sona erecek");
int eleman2,toplam2=0;
do{
	
	System.out.println("Bir sayi giriniz");
	eleman2 = giris.nextInt();	//sag tarafta sadece veri tipini al sabit. Sona parantezi unutma
	if(eleman2%2==1) {
		toplam2=toplam2+eleman2;
	}
}
while(eleman2>=0);  //do kullandigimiz icin baslangic degeri vermeye gerek kalmadi. Do da önce ilk satir calisir sonra döngüye girer.
	System.out.println("tek sayilar toplami= "+toplam2);	




int eleman3;
for(eleman3=0;eleman3<=10;eleman3++) {
	
	if(eleman3==3 || eleman3==5) { //ya da		
		System.out.println(eleman3 + " atlandi");
		continue;
	}
	System.out.println(eleman3);
}

System.out.println("kac satir yildiz olacagini giriniz");
int yildiz = giris.nextInt();
int u;
for(u=1;u<=yildiz;u++) {
	int c=1;
	while(c<=u) {
		System.out.print("*"); //yan yana yazdırmak icin sadece print
		c++;
	}
	
	System.out.println("\n"); // (\n) oldugu icin toplam 2 satir bosluk birakti
	
	
}



int input,e;
boolean asal = true;

do {
	System.out.println("asal mi kontrol etmek icin 2 veya daha büyük bir deger giriniz");
	input = giris.nextInt();
	
}while(input<2);


for(e=2;e<input;e++) {  
	
	if(input%e==0) {
		asal=false;
		break;
	}
}

if(asal) {
	System.out.println(input + " asal"); //asal true ise yani degismediyse
}

else {
	System.out.println(input + " asal degil");
}





System.out.println("lutfen 1 ile 3 aralıgında bir deger giriniz");
int deger = giris.nextInt();
switch(deger) {
case 1: System.out.println("1 sayisini girdiniz");  //case 1 den sonra iki nokta (:)
	break;                                           //break olmazsa hepsini yazar
case 2: System.out.println("2 sayisini girdiniz");
	break;
case 3: System.out.println("3 sayisini girdiniz");
    break;
default: System.out.println("lutfen gecerli bir deger giriniz");
}



int s1=3 ,s2=5 ;
int min = (s1<s2) ? s1 : s2; 
System.out.println(min); //ekrana 3 degerini yazar




	}

}
