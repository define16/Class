#include "config.h"

//	C/C++�� �Լ��� main() �Լ� �ڿ��� �����ϸ� �����Ͻ� �ĺ��ڸ� ã�� �� ���ٴ� ������ �߻��ȴ�.
//	�Լ��� main() �Լ� �ڿ��� ���Ǹ� �Ϸ��� �����Ϸ����� main() �Լ� �ڿ��� ������ �Լ��� �Լ����� �˷���� �Ѵ�.
//	�����Ϸ����� �Լ����� �˸��� ���ؼ� main() �Լ� �ڿ��� �����ϴ� �Լ��� �ݵ�� main() �Լ� �տ��� �Լ��� ������
//	������ ��� �Ѵ�.
//	�Լ��� ������ �Լ��� �Ӹ� �κи� �����ָ� �ȴ�. �Լ��� ������ ���� �̸��� ����� ���� ����.
int total();							// int total() �Լ��� ����
int total(int);							// int total(int n) �Լ��� ����
int total(int, int);					// int total(int n, int m) �Լ��� ����

void main() {

	cout << "1~100�� �հ� : " << total() << endl;
	int n;
	cout << "���ڸ� �Է��ϼ��� : ";
	cin >> n;
	cout << "1~" << n << "�� �հ� : " << total(n) << endl;
	cout << "���μ� n�� ����� �� : " << n << endl;
	int m;
	cout << "���� 2���� �Է��ϼ��� : ";
	cin >> n >> m;
	cout << n << "~" << m << "�� �հ� : " << total(n, m) << endl;

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

int total(int n, int m) {
	int sum = 0;
	for(int i=n ; i<=m ; i++) {
		sum += i;
	}
	return sum;
}
