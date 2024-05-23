#include<stdio.h>
#include<stdlib.h>
void ikiliArama(int dizi[], int N, int aranan){
	int sol=0;
	int sag=N-1;
	int orta=(sol+sag)/2;
	while(sol<=sag){
		if(dizi[orta]==aranan){
			printf("%d sayisi %d. konumda bulundu",aranan,orta+1);
			return orta;
		}
		else if(dizi[orta]<aranan){
			sol=orta+1;
		}
		else{
			sag=orta-1;
		}
		printf("%d sayisi bulunamadi",aranan);
		return 0;
		
	}

}


int main(){
	int dizi[]={25,30,13,27,6};
	ikiliArama(dizi,5,31);
	
}
