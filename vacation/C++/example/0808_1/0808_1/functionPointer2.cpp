#include "config.h"

// ó���� �����Ϳ� �����͸� ó���ϴ� �Լ��� �μ��� �޴� �Լ�
int func(int a, int b, int (*pFunc)(int, int)) { //int (*pFunc)(int, int) : ��������Ʈ��� �θ���, �Լ������Ͷ�� �Ѵ�.
// �μ��� �Ѱܹ��� �Լ��� ������ ����� �����ϹǷ� func �տ� "*"�� ������ �ʴ´�.
	return  (*pFunc)(a,b);
}

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
	int a,b;
	cout << "���� 2���� �Է��ϼ��� : ";
	cin >> a >> b;

// int (*pFunc)(int, int)
	int (*add)(int , int) = Add;		// Add�Լ��� �ּҰ� ������ a�� ����ȴ�.
// func�Լ��� ó���� ������ a,b�� �����͸� ó���� �Լ��� �ּҰ� ����� ������ add�� �μ���
// �Ѱ��ָ� func�� �Ѱܹ��� �����͸� �Ѱܹ��� �Լ��� ó���� ����� ������ �ش�.
	cout << func(a,b,add) << endl;
	
	int (*sub)(int, int) = Sub;
	cout << func(a,b,sub) << endl;
	int (*mul)(int, int) = Sub;
	cout << func(a,b,sub) << endl;
	int (*div)(int, int) = Sub;
	cout << func(a,b,sub) << endl;
}