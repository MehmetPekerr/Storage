package package1;

public class ornek24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int satirSayisi = 5; // Üçgenin yüksekliği



        for (int i = 1; i <= satirSayisi; i++) {
        	for(int k= satirSayisi-i; k>0; k--) {
        		System.out.print(" ");
        	}
            for (int j = (i*2)-1; j >=1 ; j--) {
                System.out.print("*");
            }
            System.out.println(); // Bir satırı bitir
        }

	}

}
