#include <iostream>
#include <string>
using namespace std;
 
int main( )
{
	int i = 0;
	int num = 10;
	
	while(i== 0)
	{
		printf("입력");
		scanf("%d",&num);
		switch(num)
		{
			case 1 : 
		
				printf("1번");
				break;
			case 2 :
			
				printf("2번");
				break;
			case 3 :
				
				printf("3번");
				break;
			case 4 :
		
				printf("4번");
				break;
			case 5 :
			
				printf("5번");
				break;
			case 6 :
			
				printf("6번");

				break;
			case 7 :
				printf("7번");
				i = 1;
				break;
			default :
				printf("0번");
		
		}
	}
}


