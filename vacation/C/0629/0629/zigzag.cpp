#include "config.h"

void main() {

	int a[4][5] = {0, };
	int count = 0;

	for(int i=0 ; i<4 ; i++) {

		if(i % 2 == 0) {			// ¦�����ΰ�?
//			��(j)�� 0 ���� �����ؼ� 5 ���� ������ ���� 1�� ������Ų��.
			for(int j=0 ; j<5 ; j++) {
				a[i][j] = ++count;
			}
		} else {
//			��(j)�� 4 ���� �����ؼ� -1 ���� Ŭ�� ���� 1�� ���ҽ�Ų��.
			for(int j=4 ; j>-1 ; j--) {
				a[i][j] = ++count;
			}
		}

	}

	for(int i=0 ; i<4 ; i++) {
		for(int j=0 ; j<5 ; j++) {
			cout << setw(2) << a[i][j] << " ";
		}
		cout << endl;
	}

}