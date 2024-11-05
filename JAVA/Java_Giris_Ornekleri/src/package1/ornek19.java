package package1;

public class ornek19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int satirSayisi = 5; // Üçgenin yüksekliği



        for (int i = 1; i <= satirSayisi; i++) {
        	for(int k= 0; k<satirSayisi-i; k++) {
        		System.out.print(" ");
        	}
            for (int j = 1; j <= (i*2)-1; j++) {
                System.out.print("*");
            }
            System.out.println(); // Bir satırı bitir
        }
    }
}