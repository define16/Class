#include "config.h"
#include "func.h"

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
