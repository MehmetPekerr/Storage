#include<stdio.h>
#include<stdlib.h>
#define BOYUT 5

int yigit[BOYUT];
int top=-1;


push(int x){
	if(top==BOYUT-1){
		printf("yigit dolu");
	}
	else{		
	top++;
	yigit[top]=x;
    printf("%d eklendi \n",x);
	}
}	
	
pop(){
	if(top==-1){
		printf("yigit bos");
	}
	
	else{
		int x=yigit[top];
		top--;
		return x;
	}
	
    
	}
	
	void yazdir(){
		int i;
		for(i=0;i<=top;i++){
			printf("%d \n",yigit[i]);
		}
	}
	
	
	main(){
		push(8);
		push(7);
		push(15);
		push(26);
		push(3);
		int a=pop();
		printf("\n%d cikarildi \n",a);
		int b=pop();
		printf("%d cikarildi \n\n",b);
		yazdir();
		
	}
	


