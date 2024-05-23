import java.util.Random;
import java.util.Scanner;

public class kod15 {
	
	int satirSayisi, sütunSayisi, boyut;
	int[][] map;
	int[][] board;
	boolean oyun = true;
	
	Random rand = new Random();
	Scanner scan = new Scanner(System.in);
	
	kod15(int satirSayisi, int sütunSayisi){ 
		this.satirSayisi = satirSayisi;
		this.map = new int[satirSayisi][sütunSayisi]; //matrisler böyle tanımlanabilir.(Burada varsayılan olarak tüm konumlara sıfır değeri verilmiştir.
		this.board = new int[satirSayisi][sütunSayisi];
		this.sütunSayisi = sütunSayisi;
		this.boyut = satirSayisi * sütunSayisi;  //eşitleyerek tanımladık.
	}
	
	public void run() {
		int row,col,basari=0;
		hazirlik(); //rastgele konumlara -1 değeri girdik
		yazdir(map);//ekrana kullanıcının görmeyeceği mayın tarlasını yazdırdık(mayınların yeri görünen)
		System.out.println("Oyun Başladı");	
		
		while(oyun) {	//oyun true olduğu sürece devam et(başta oyun true tanımladık.				
			yazdir(board);	//ekrana kullanıcının değer gireceği boş tahtayı yazdırdık.		
				System.out.println("Satır:");
				row = scan.nextInt();		//satırı girdik.		
				System.out.println("Sütun:");
				col = scan.nextInt();	    //sütunu girdik.
				
				if(row<0 || row>=satirSayisi || col<0 || col>=sütunSayisi) { //Bunlar olmamalı(sıfırdan başlamalı, en fazla satır sayısından 1 eksik olmalı)
					System.out.println("Geçersiz koordinat");
					continue;	
				}
				
	
					 if(map[row][col] == -1) { //konumda mayın varsa burası çalışır (konum -1 ise)
						 oyun = false; //while false olur döngüden çıkar.
							System.out.println("Game Over");
							
						}
				
				else { //konumda mayın yoksa burası çalışır(konum -1 değilse)
					kontrol(row,col);	//etrafında kaç mayın olduğunu yazdırdık.
					basari++;           //basariyi arttiriyoruz. (hala while döngüsündeyiz)						    

					if(basari == (boyut - (boyut/4))) { // else içinde if tanımladık. Basari boyutun çeyreğine eşit olduğuna kazanıyoruz.
						System.out.println("Kazandınız. Hiç bir mayına basmadınız.");
						break;   //while döngüsünden çıkarız.                     //(break ne olursa olsun çıkar, continue false olursa çıkar.)
							}
					
															
		}
					/*  if(map[row][col] != -1) { //konumda mayın yoksa burası çalışır (konum -1 değilse)
							kontrol(row,col);	//etrafında kaç mayın olduğunu yazdırdık.
							basari++;           //basariyi arttiriyoruz. 						    

							if(basari == (boyut - (boyut/4))) { // if içinde if tanımladık. Basari boyutun çeyreğine eşit olduğuna kazanıyoruz.
								System.out.println("Kazandınız. Hiç bir mayına basmadınız.");
								break;   //while döngüsünden çıkarız.                     //(break ne olursa olsun çıkar, continue false olursa çıkar.)
									}
						}

						else { //konumda mayın varsa burası çalışır(konum -1 ise)
						oyun = false; //while false olur döngüden çıkar.
						System.out.println("Game Over");
															
						}
					  */
		}
			}
				
				
			
				
				
			public void kontrol(int r, int c) { // etrafında kaç mayın olduğunu kendi üstüne yazdık.(Başta otomatik olarak sıfır gelmişti.)
				if(map[r][c] == 0) {
					
					if((c<satirSayisi-1) && (map[r][c+1] == -1)) { //sağ kontrol (burada en sağdakini kontrole gerek yok, sağı -1 ise bos tahtadaki değeri 1 arttırırız.)
						board[r][c]++;
					}
					if((r<sütunSayisi-1) && (map[r+1][c] == -1)) { //aşağı kontrol (aşağı kontrol için satırı arttırdık.
						board[r][c]++;
					}
					if((r>0) && (map[r-1][c] == -1)) { //yukarı kontrol 
						board[r][c]++;
					}
					if((c>0) && (map[r][c-1] == -1)) { //sol kontrol
						board[r][c]++;
					}
							
				}
				if(board[r][c] == 0) { //eğer hala sıfır ise etrafında mayın olmadığını belirtmek için -2 verdik.
					board[r][c]= -2;
				}
			}
			
			
			
			
			public void hazirlik() {//rastgele konumlara -1 değeri verdik.
				int randSatir, randSütun, sayac=0;
				while (sayac != (boyut/4)) { //sayac sıfırdan baslamıştı.
					randSatir = rand.nextInt(satirSayisi); //0 ile satirsayisi-1 aralığında. (0. satır, 1. satır, 2. satır...)
					randSütun = rand.nextInt(sütunSayisi); //rastgele bir satır ve sütun seçtik.
					if(map[randSatir][randSütun] != -1) { //seçtiğimiz konum -1 değilse -1 yaptık.(toplam boyut/4 tane -1 oldu.)
						map[randSatir][randSütun] = -1;
						sayac++; //önce -1 yaptık, sonra sayaci arttirdik.
					}
				}
			}
				
				
				
			public void yazdir(int[][] dizi) { //diziyi yazdırdık
				for(int i=0;i<dizi.length;i++) {
					for(int j=0;j<dizi[0].length;j++) {
						if(dizi[i][j]>=0) //nizami görünmesi için yaptık.
							System.out.print(" "); //negatif işaretinden dolayı pozitiflere bir boşluk ekledik.
						
						System.out.print(dizi[i][j] + " "); //hepsinin yanına bir boşluk
					}
					System.out.println(); //her satır bittiğinde bir alt satıra geçer.
				}
			}
				
	
	}
	
	//continue break if içinde kullanılır.
    //continue while ı baştan çalıştırıyor. Break ise while ı direkt bitiriyor.
	// for(i=0;i<5;i++) i==2 için continue ve ardından printf varsa : 0 1 3 4 yazdırır. (continue başa sardı, başta i++ olduğu için 2 yi atlamış oldu.
                      //i==2 için break ve ardından printf varsa: 0 1 yazdırır.
	
	
	
	

