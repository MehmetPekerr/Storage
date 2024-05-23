
public class kod4 {
public int sayi1;
public int sayi2;
public String renk;

                             
kod4(int sayi1, int sayi2, String renk){ //ismi class ismi ile aynı olmalıdır. Başında bir şey yazmıyorsa class oldugunu anlarız. (void metoddur)
	this.sayi1=sayi1; //üstteki sayi1 degerine alttaki sayi1 degerini atadik.(this olan ustteki)(üstteki int yeterli)
	this.sayi2=sayi2; //ikisine aynı ismi vermemiz jargondan dolayı.(this den sonra nokta var)
	this.renk=renk; //tırnaga gerek yok
}

public int toplama() {                 //metod içine cagirirken this ile cagiririz.
	return this.sayi1 + this.sayi2;
}


public int carpma() {
	return this.sayi1 * this.sayi2;
}

}
//hepsinde public diye belirttik (metodlarda sadece başta)(çağırılan)
//burada main yok