#include "config.h"

void main() {

	srand((unsigned)time(NULL));
	int lotto[45];
	for(int i=0 ; i<45 ; i++) {
		lotto[i] = i + 1;
	}
	int money;
	cout << "���� ���� �ݾ��� �Է��ϼ��� : ";
	cin >> money;

//	���� �ݾ׸�ŭ �ݺ��ϸ� �ζ� ��ȣ�� ������ ����Ѵ�.
	for(int i=0 ; i<money/1000 ; i++) {
		for(int j=0 ; j<1000000 ; j++) {
			int r = rand() % 44 + 1;
			swap(lotto[0], lotto[r]);
		}
		cout << setw(2) << i + 1 << " Game : ";
		for(int j=0 ; j<6 ; j++) {
			printf("%02d ", lotto[j]);
		}
		cout << endl;
	}

}