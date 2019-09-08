#include "config.h"

//Call By Reference�� ����� 2���� �̻� ������ؼ� ���

//C���� �����͸� �̿��ϴ� Call By Reference
//�Լ��� ȣ���Ҷ��� ���μ��� �����Ͱ� ����� �������� �ּҸ� �����ش�. 
//�Լ��� ȣ�� ���ϸ� ���μ��� �Ѿ���� �ּҰ��� �����ͷ� �޾��ش�.
 void change(int *p1, int *p2)	//������ ��ȯ�ϴ� �Լ�
 {
	 int temp = *p1;
	 *p1 = *p2;
	 *p2 = temp;
 }

//�Լ� �����ε� : �ϳ��� ���Ͽ� ���� �̸��� �Լ��� ������ ���ü� �ִ´�.
//C++�����Ϸ��� �Լ��� �̸��� ������ �μ��� ������ ������ �Լ��� �ĺ� ���� �μ��� ������ ���ٸ� �μ��� ������ Ÿ������ �ĺ�.

  void change(double *p1, double *p2) //�Ǽ��� ��ȯ�ϴ� �Լ�
 {
	 double temp = *p1;
	 *p1 = *p2;
	 *p2 = temp;
 }


//C++���� �����͸� �̿��ϴ� Call By Reference
//�Լ��� ȣ�� ���ϸ� ���μ��� �Ѿ���� �ּҰ��� ������ ������ �޾��ش�.

 void change(int &p1, int &p2)	//������ ��ȯ�ϴ� �Լ�
 {
	 int temp = p1;
	 p1 = p2;
	 p2 = temp;
 }

   void change(double &p1, double &p2) //�Ǽ��� ��ȯ�ϴ� �Լ�
 {
	 double temp = p1;
	 p1 = p2;
	 p2 = temp;
 }

void main()
{
	int a = 3, b = 4;
	swap(a,b);	// C++�� �ش�.

	cout << "a = " << a<<", b = " << b << endl;
	printf("a = %d, b = %d",a,b);

//C�� call by reference�� ���μ��� �����Ͱ� ����� �ּҸ� �����ش�.
	change(&a,&b);
	cout  << "a = " << a << ", b = " <<  b << endl;

//C++�� call by reference�� ���μ��� �����Ͱ� ����� ������ �����ش�.
		change(a ,b);
		cout  << "a = " << a << ", b = " <<  b << endl;

	double c = 3.1, d = 4.9;

	swap(c,d);
	cout << "c = " << c<<", d = " << d << endl;

	change(&c,&d);
	cout << "c = " << c<<", d = " << d << endl;

}
