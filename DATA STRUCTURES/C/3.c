#include<stdio.h>
#include<stdlib.h>

void kabarcikSirala(int dizi[], int N){
	int i,j,gecici;
	for(i=0;i<N;i++){
		for(j=0;j<N-1-i;j++){
			if(dizi[j]>dizi[j+1]){
				gecici=dizi[j];
				dizi[j]=dizi[j+1];
				dizi[j+1]=gecici;
			}
		}
	}
}


int main(){
	int dizi[]={7,30,22,13,17};
	kabarcikSirala(dizi,5);
	int i;
	for(i=0;i<5;i++){
		printf("%d \n",dizi[i]);
	}
	
}
