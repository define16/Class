#include "config.h"

//	4~10000 ������ �������� �������� ������ ����ϴ� ����ó����� �˰���

void main() {

	int count = 0;

	for(int n=4 ; n<=10000 ; n++) {

		int sum = 0;
		for(int i=1 ; i<=n/2 ; i++) {

			if(n % i == 0) {
				sum += i;
			}

		}
		if(n == sum) {
			cout << ++count << "��° ������ : " << setw(4) << n << endl;
		}

	}

	cout << "�������� ���� : " << count << "��" << endl;

}