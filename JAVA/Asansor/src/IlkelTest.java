
public class IlkelTest {

	public static void main(String args[]) {

		Ilkel ılkelTest = new Ilkel();

		ılkelTest.kapiAc();
		ılkelTest.kapiKapat();
		ılkelTest.yukariGit();
		ılkelTest.kapiAc();
		ılkelTest.kapiKapat();
		ılkelTest.asagiGit();
		ılkelTest.kapiAc();
		ılkelTest.kapiKapat();

		

		int mevcutKat = ılkelTest.getKat();

		if (mevcutKat != 8 && !ılkelTest.getKapiDurumu()) {
			ılkelTest.git(8);
		}

		ılkelTest.git(-1000_0000);
		ılkelTest.kapiAc();
	}
}