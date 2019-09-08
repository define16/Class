#include "config.h"

typedef int (*Func)(int , int);		//C���� �Լ� ������ �����ϱ�.

int Add(int a, int b)
{
	return a+b;
}
int Sub(int a, int b)
{
	return a-b;
}
int Mul(int a, int b)
{
	return a*b;
}
int Div(int a, int b)
{
	if(b != 0)
		return a/b;
	else
		return -1;
}

void main(){
//�Լ� �����Ϳ� ���Ե� �Լ��� �̸��� �Լ� ������ �迭�� ����� �ش�.
	Func func[] = {Add,Sub,Mul,Div};
	//for(int i = 0;i<4;i++){
	//	cout << func[i](5,3) << endl;
	//}

	int a,b;
	cout << "���� 2���� �Է��ϼ��� : ";
	cin >> a >> b;

	int menu = 0;
	while(menu != 5){
		do{
			cout << "-------------------------------------------------" <<endl;
			cout << "1. ���ϱ�  2. ����  3. ���ϱ�  4. ������  5. ����" <<endl;
			cout << "-------------------------------------------------" <<endl;
			cout << "���ϴ� �޴��� �����ϼ��� : ";
			cin >> menu;
		}while(menu < 1 || menu > 5);
		switch(menu){
		case 1  : 
			cout << a << " + " << b << " = " << func[0](a,b) << endl; break;
		case 2  : 
			cout << a << " - " << b << " = " << func[1](a,b) << endl; break;
		case 3  : 
			cout << a << " * " << b << " = " << func[2](a,b) << endl; break;
		case 4  : 
			cout << a << " / " << b << " = ";
			if(func[3](a,b) != -1)
				 cout << func[3](a,b) << endl;
			else
				cout << "�������� 0���� �� �� �����ϴ�." << endl;	break;
			cout << endl;
		case 5  :  	cout << "���α׷��� �����մϴ�"<<endl;	exit(0);
		}
	}

}