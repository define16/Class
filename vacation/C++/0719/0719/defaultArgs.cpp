#include "config.h"

//	�Լ��� ����Ʈ �μ�
//	����Ʈ �μ��� �Լ��� ȣ��� �� �μ��� �Ѿ���� �Ѿ���� �μ��� �޾Ƽ� �Լ��� �����ϰ�
//	�μ��� �Ѿ���� ������ ����Ʈ�� ������ �μ��� ������ �Լ��� �����Ѵ�.
/*
int total(int n = 100) {
	int sum = 0;
	for(int i=1 ; i<=n ; i++) {
		sum += i;
	}
	return sum;
}
*/

//	�Լ��� main() �Լ� �ڿ��� ������ ��� �ݵ�� main() �Լ� �տ� �Լ��� ������ ����� �Ѵ�.
//	�Լ��� ������ ������ ������ ���� �ʾƵ� ���� ����.
int total();					// int total() �Լ��� ����
int total(int);					// int total(int n) �Լ��� ����

void main() {

	cout << "1~100�� �հ� : " << total() << endl;
	int n;
	cout << "�հ踦 ����� �� �Է� : ";
	cin >> n;
	cout << "1~" << n << "�� �հ� : " << total(n) << endl;

}

int total() {
	int sum = 0;
	for(int i=1 ; i<=100 ; i++) {
		sum += i;
	}
	return sum;
}

int total(int n) {
	int sum = 0;
	for(int i=1 ; i<=n ; i++) {
		sum += i;
	}
	return sum;
}
