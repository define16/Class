#include "config.h"

//int total();	//�Լ��� main()�Լ� �ڿ� ������ ��� �ݵ��; mian �տ� �Լ��� ������ �����־���Ѵ�.
//int total(int);

// �Լ��� ����Ʈ �μ�
// ����Ʈ �μ��� �Լ��� ȣ��� �� �μ��� �Ѿ���� �μ��� �޾Ƽ� �Լ��� �����ϰ�
// �μ��� �Ѿ���� ������ ����Ʈ�� ������ �μ��� ������ �Լ��� �����Ѵ�. 
int total(int n = 100)
{
	int i, sum = 0;

	for(i=1;i<=n;i++)
		sum += i;

	return sum;
}

void main()
{
	cout << "1~100�� �հ� : " << total() << endl;
	int n;
	cout << "�հ踦 ����� �� �Է� : ";
	cin >> n;
	cout << "1~" << n << "�� �հ� : " << total(n) << endl;
}

//int total()
//{
//	int i, sum = 0;
//
//	for(i=1;i<=100;i++)
//		sum += i;
//	return sum;
//
//}
//
//int total(int n)
//{
//	int i, sum = 0;
//
//	for(i=1;i<=n;i++)
//		sum += i;
//
//	return sum;
//}
