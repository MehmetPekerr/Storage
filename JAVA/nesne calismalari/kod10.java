
public class kod10 {

	public static void main(String[] args) {
		
		char[] str = {'M','e','h','m','e','t'}; //char ı dizi olarak tanimla. Tek tirnak kullan.
		String yazi = new String(str);
		System.out.println(yazi);
		
		
		
		String metin = "Mehmet Peker"; //burada paranteze veya ayraca gerek yok
		String metin1 = " Ankara";
		
		System.out.println(metin.length()); //uzunlugunu yazar.(1 den baslar)(bosluklari da sayar)
		System.out.println(metin+metin1); //ikisini yan yana yazar
		System.out.println(metin.concat(metin1)); //bi üstteki satirla ayni isi yapar
		System.out.println(metin.indexOf('e')); //tek tirnak (ilk e kacinci indexte) (index 0 dan baslar)
		System.out.println(metin.charAt(1));; //1. indexte ne var. 
		System.out.println(metin.compareTo(metin1));
		System.out.println(metin.compareToIgnoreCase(metin1));
		System.out.println(metin.contains("ehm")); //çift tirnak (icinde ehm geciyor mu?)(bosluga duyarli)(büyük kücük harfe duyarli)
		System.out.println(metin.endsWith("er")); //çift tirnak (sonu met ile mi bitiyor?)(sadece en son kelimenin sonuna bakar)(bosluga duyarli)(büyük kücük harfe duyarli)
		System.out.println(metin.replace("Pek","Adc")); //tüm Pek gördüğü yerlere Adc yazar. (Büyük kücük harfe duyarli)(bosluga duyarli)
		System.out.println(metin.toLowerCase()); //hepsini kücük harf yapar
        System.out.println(metin.toUpperCase()); //hepsini büyük harf yapar
	}

}
