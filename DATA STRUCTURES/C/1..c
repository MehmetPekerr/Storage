#include<stdio.h>
#include<stdlib.h>

int dogrusalArama(int dizi[], int N, int aranan){
	int i=0;
	while(i<N){
		if(dizi[i]==aranan){
			printf("%d sayisi %d. konumda bulundu",aranan,i+1);
			return i;
		}
	i++;
	}
		printf("%d sayisi bulunamadi",aranan);
		return -1;

}

main(){
	int dizi[]={1,30,15,27,6};
    dogrusalArama(dizi,5,27);
	
}
