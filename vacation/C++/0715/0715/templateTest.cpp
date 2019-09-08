#include "config.h"
/*
int mymin(int a, int b) {
	int min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
double mymin(double a, double b) {
	double min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
char mymin(char a, char b) {
	char min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
*/

//	���ø��� �ڷ����� �Ѱܹ޴´�. ���ø��� �� ���� ���� ù ��° �ڷ����� �޴´�.
//	�Լ��� �Ѿ���� �ڷ����� ���� ��� ����Ѵ�.
template <class T>
T mymin(T a, T b) {
	T min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}

//	���� ���ø��� �� ���� �������� �ִ�.
//	���� ���ø��� �����Ϸ��� ���ø��� ȣ���� �� �� �μ��� ������ Ÿ���� �ݵ��
//	���ƾ� ������ �߻����� �ʴ´�.
//	���ø����� �Ѿ���� ������ �μ��� Ÿ���� �ٸ� ��� �Ʒ��� ���� �����ϸ� �ȴ�.
//	ù ��° �μ��� �ڷ����� T1���� �� ��° �μ��� �ڷ����� T2�� �Ѿ�´�.
//	T1�� T2�� �ڷ����� �ٸ��� �� �ս��� �߻��� �� �ִ�. �� �� �̸� �ذ��ϴ� �����
//	T1���� ũ�Ⱑ ū �ڷ����� �Ѱ��ָ� �ȴ�.
template <class T1, class T2>
T1 mymin(T1 a, T2 b) {
	T1 min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}

template <class T>
void change(T *a, T *b) {
	T temp = *a;
	*a = *b;
	*b = temp;
}

template <class T>
void change(T &a, T &b) {
	T temp = a;
	a = b;
	b = temp;
}

void main() {
	
	int a = 2, b = 10;
	cout << "���� �� : " << mymin(a, b) << endl;
	double c = 3.4, d = 2.5;
	cout << "���� �� : " << mymin(c, d) << endl;
	char ch1 = 'a', ch2 = 'A';
	cout << "���� �� : " << mymin(ch1, ch2) << endl;
//	template <class T>�� ����� ��� mymin(a, d)�� a�� d�� �ڷ����� �ٸ��� ������
//	�߻��ȴ�.
	cout << "���� �� : " << mymin(d, a) << endl;

	change(&a, &b);
	cout << "a = " << a << ", b = " << b << endl;
	change(a, b);
	cout << "a = " << a << ", b = " << b << endl;

}