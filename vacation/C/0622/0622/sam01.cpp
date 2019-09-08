#include "config.h"
#include <time.h>							// C���� time() �Լ��� ����� �� �ְ� ���ִ� ��� ����
#include <stdlib.h>							// C���� rand(), srand() �Լ��� ����� �� �ְ� ���ִ� ��� ����

void main() {

//	rand() : 0 �̻��� ����(��������)�� �߻���Ų��. ������ �׳� �߻���Ű�� �Ź� ���� ���� �����Ƿ� �ݵ�� rand() �Լ���
//	�����ϱ� ���� ���� �ʱ�ȭ �۾��� ����� �Ѵ�.
//	srand() : ��ȣ ���� �ð��� �̿��� ������ �ʱ�ȭ �Ѵ�.
//	time(NULL) : 1970�� 1�� 1�� 0�� ���� �� �Լ��� ����Ǵ� �������� ������ �ð��� �� ������ ǥ���Ѵ�.
//	cout << time(NULL) << endl;

	srand((unsigned)time(NULL));						// ���� �ʱ�ȭ
//	for(int i=0 ; i<10 ; i++) {
//		int r1 = rand() % 6 + 1;
//		int r2 = rand() % 6 + 1;
//		cout << r1 << ", " << r2 << endl;
//	}
//	cout << "========================================" << endl;

	int count[6] = {0, };
	for(int i=0 ; i<10 ; i++) {
//		int r = rand() % 6 + 1;
//		cout << r << endl;
//		count[r-1]++;
		count[rand() % 6]++;
	}
	for(int i=0 ; i<6 ; i++) {
		cout << i + 1 << " : " << setw(2) << count[i] << endl;
	}

}