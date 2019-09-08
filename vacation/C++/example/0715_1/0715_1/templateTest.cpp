#include "config.h"

//int mymin(int a, int b)
//{
//	return a < b ? a : b;
//}
//
//double mymin(double a, double b)
//{
//	return a < b ? a : b;
//}
//
//char mymin(char a, char b)
//{
//	return a < b ? a : b;
//}

template <class T>		//C++ ����
T mymin(T a, T b)
{
	return a < b ? a : b;
}
// ���� ���ø��� �� ���� �������� �ִ�.
// ���� ���ø��� �����Ϸ��� ���ø��� ȣ���� �� �� �μ��� ������ Ÿ���� �ݵ��
// ���ƾ� ������ �߻����� �ʴ´�.

// ���ø����� �Ѿ���� �������� �̼��� Ÿ���� �ٸ� ��� �Ʒ��� ���� ���� �Ѵ�.
// ���� ���ø��� �����Ϸ��� ���ø��� ȣ�� �Ҷ� �� �μ��� ������ Ÿ���� �ݵ�� ���ƾ�
// ������ �߻����� �ʴ´�.
// ù��° �μ��� T1, �� ��° �μ��� T2�� �Ѿ�´�. T1�� T2�� �ڷ����� �ٸ��� �� �ս��� �Ͼ �� �ִ�.
template <class T1,class T2>		//C++ ����
T1 mymin(T1 a, T2 b)
{
	return a < b ? a : b;
}

//���ø��� �ϳ��� ���� ù ��° �ڷ����� �޴´�.
//�Լ��� �Ѿ���� �ڷ����� ���� ��� ����Ѵ�.
template <class T>
void change(T &a,T &b)
{
	T temp = a;
	a = b;
	b = temp;
}


void main()
{
	int a = 2, b = 10;
	cout << "���� �� : " << mymin(a,b) << endl;
	double c = 3.4, d = 2.5;
	cout << "���� �� : " << mymin(c,d) << endl;
//	mymin(a,d)�� a�� d�� �ڷ����� �ٸ��� ������ �߻��Ѵ�.
//	cout << "���� �� : " << mymin(a,d) << endl;+

	change(a, b);
	cout << "a = " << a<<", b = " << b <<endl;

}
