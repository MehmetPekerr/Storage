
public class kod8 {

	public static void main(String[] args) {
		//int[][] tablo = new int[5][3];
		//int tablo1[][] = new int[5][3];
		
		//int[][] tablo2 = { {1,2,3},{4,5,6}}; //en dışta bir parantez daha var
		//int tablo3[][] = { {1,2,3},{4,5,6}};
		
		//int[][] tablo4= {}; 
		int[][] tablo4 = new int[][] {{1,75,10},{2,87,13},{3,95,15},{4,103,18},{5,110,19}};
		for(int i=0;i<tablo4.length;i++) { //satır sayısı
			for(int j=0;j<tablo4[4].length;j++) { //5. satırın sütun sayısını döndürür(burada tüm sütunlar aynı uzunlukta)
				System.out.print(tablo4[i][j] + " "); //bir bosluk bırakarak yan yana yazalım
			}
			System.out.println(); //alt satıra geçer
		}
		 
        
		System.out.println("foreach kullanım");
		
		for(int[] i : tablo4) { // tablo4 dizisi içinde i dizisi tanımlarız.(satır)
			for(int j : i) {    //her i satırı için o satırdaki sütunları sırayla seçer (java da kolaylık sağlar)
				System.out.print(j + " "); //j leri yazdırırız
			}
			System.out.println();
		}
		
		
		
		
}


}