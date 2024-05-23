#include<stdio.h>
#include<stdlib.h>

void secmeliSirala(int dizi[], int N){
	int i,j,gecici;
	for(i=0;i<N;i++){
		for(j=i+1;j<N;j++){
			if(dizi[j]<dizi[i]){
				gecici=dizi[i];
				dizi[i]=dizi[j];
				dizi[j]=gecici;
			}
		}
	}
}

main(){
	int dizi[]={7,26,9,12,11};
	secmeliSirala(dizi,5);
	int i;
	for(i=0;i<5;i++){
		printf("%d \n",dizi[i]);
	}
}
