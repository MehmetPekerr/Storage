#include<stdio.h>
#include<stdlib.h>

struct Node{
	int data;
	struct Node *sonraki;
};



struct Node *ilk=NULL;



void sonaEkle(int veri){
	struct Node *yeni=(struct Node*)malloc(sizeof(struct Node));
	yeni->data=veri;
	yeni->sonraki=NULL;	
	if(ilk==NULL){
		ilk=yeni;
	}
	else{
		struct Node *gecici=ilk;
		while(gecici->sonraki!=NULL){
			gecici=gecici->sonraki;
		}
		gecici->sonraki=yeni;
	}
	printf("%d sona eklendi \n",veri);
}




void basaEkle(int veri){
	struct Node *yeni=(struct Node*)malloc(sizeof(struct Node));
	yeni->data=veri;
	yeni->sonraki=NULL;
	if(ilk==NULL){
		ilk=yeni;
	}
	else{
		yeni->sonraki=ilk;
		ilk=yeni;
	}
	printf("%d basa eklendi \n",veri);
}




void arayaEkle(int veri,int aranan){
	struct Node *yeni=(struct Node*)malloc(sizeof(struct Node));
	yeni->data=veri;
	yeni->sonraki=NULL;	
	if(ilk==NULL){
		ilk=yeni;
	}	
	else{
		struct Node *gecici=ilk;
		while(gecici!=NULL){
		if(gecici->data==aranan){
			yeni->sonraki=gecici->sonraki;
			gecici->sonraki=yeni;
			printf("%d araya eklendi \n",veri);
			return;
			
		}
		gecici=gecici->sonraki;
		
	}
}
}



void elemanSil(int aranan){
	if(ilk==NULL){
		printf("liste zaten bos \n");
	}
	else{
		struct Node *gecici=ilk;		
		if(ilk->data==aranan){
			ilk=ilk->sonraki;
			free(gecici);
		}
		else{
			struct Node *silinecek;
			while(gecici->sonraki!=NULL){
				if(gecici->sonraki->data==aranan){
					
					silinecek=gecici->sonraki;
					gecici->sonraki=silinecek->sonraki;
					free(silinecek);
					printf("%d silindi \n",aranan);
					return;
				}
				gecici=gecici->sonraki;

				
			}
		}
	}
}




void listele(){
		printf("\nListe:");
	struct Node *gecici=ilk;
	while(gecici!=NULL){
		printf("%d ",gecici->data);
		gecici=gecici->sonraki;
	}
	printf("\n");
}




int ara(int aranan){
	if(ilk==NULL){
		printf("Liste bos \n");
	}
	else{
		struct Node *gecici=ilk;
		while(gecici!=NULL){
			if(gecici->data==aranan){
				return gecici;
			}
			gecici=gecici->sonraki;
		}
	}
	return NULL;
}

void konumAra(int konum){
	if(ilk==NULL){
		printf("Liste bos \n");
		return;
	}
	struct Node *gecici=ilk;
	int sayac=0;

	while(gecici!=NULL){
		sayac++;
		if(sayac==konum){
			printf("%d. sayi %d. \n",konum,gecici->data);
			return;
		}
		gecici=gecici->sonraki;
	}
	printf("%d.konum listede bulunamadi. \n",konum);
}

int main(){
	
	sonaEkle(22);
	sonaEkle(25);
	sonaEkle(44);
	listele();
	basaEkle(15);
	arayaEkle(24,22);
	listele();
	elemanSil(44);
	listele();
	struct Node* sonuc=ara(22);
	if(sonuc==NULL){
		printf("Bulunamadi. \n");
			}
	else{
		printf("%d bulundu. sonrasindaki sayi=%d \n",sonuc->data,sonuc->sonraki->data);
	}
	konumAra(3);
	
}


