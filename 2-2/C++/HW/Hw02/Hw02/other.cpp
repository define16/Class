#include <iostream>
#include <string>
using namespace std;
 
int main( )
{
	int i = 0;
	int num = 10;
	
	while(i== 0)
	{
		printf("�Է�");
		scanf("%d",&num);
		switch(num)
		{
			case 1 : 
		
				printf("1��");
				break;
			case 2 :
			
				printf("2��");
				break;
			case 3 :
				
				printf("3��");
				break;
			case 4 :
		
				printf("4��");
				break;
			case 5 :
			
				printf("5��");
				break;
			case 6 :
			
				printf("6��");

				break;
			case 7 :
				printf("7��");
				i = 1;
				break;
			default :
				printf("0��");
		
		}
	}
}


