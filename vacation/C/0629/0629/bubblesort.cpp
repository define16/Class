#include "config.h"

void main() {

	int data[] = {8, 3, 4, 9, 1};

	for(int i=0 ; i<4 ; i++) {						// ȸ����, ���� ���İ� �Ȱ���.
		for(int j=0 ; j<4-i; j++) {					// ��

//			cout << "i = " << i << ", j = " << j << endl;
			if(data[j] > data[j+1]) {
				swap(data[j], data[j+1]);
			}

		}		// ȸ�� ����
		cout << i + 1 << "ȸ�� ��� : ";
		for(int j=0 ; j<5 ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}			// ���� ����

}