#include<stdio.h>
#include<stdlib.h>
#define BOYUT 5

int kuyruk[BOYUT];
int ilk=-1;
int son=-1;

isFull(){
	if(son==BOYUT-1){
		return 1;
	}
	else{
		return 0;
	}
}

isEmpty(){
	if(ilk==-1){
		return 1;
	}
	else{
		return 0;
	}
}






void enqueue(int x){
	
	if(isFull()){
		printf("kuyruk dolu\n");
		return;
	}
	
	else if(ilk==-1){
		ilk=0;
		printf("ilk=0 oldu \n");
	}
	son++;
	kuyruk[son]=x;
	printf("%d eklendi\n",x);
	
}
int dequeue(){
	if(isEmpty()){
		printf("kuyruk zaten bos\n");
		return -1;
	}
	int x=kuyruk[ilk];
    if (ilk==son){
		ilk=-1;
		son=-1;

	}
	
	else{
		//ilk++;
		int i;
		for(i=0;i<son;i++){
			kuyruk[i]=kuyruk[i+1];
		}
		son=son-1;
	}
	printf("%d cikarildi \n",x);
	return x;
}

yazdir(){
	int i;
	for(i=ilk;i<=son;i++){
		printf("%d\n",kuyruk[i]);
	}
}

int main(){
	enqueue(5);
	enqueue(9);
	enqueue(3);
	enqueue(16);
	enqueue(27);
	int a=dequeue();
	int b=dequeue();
	yazdir();
}
