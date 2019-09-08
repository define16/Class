#include "config.h"

void main() {

//	��÷�⸦ �غ��Ѵ�.
	int lotto[45];
//	��÷�⿡ ���� �ִ´�.
	for(int i=0 ; i<45 ; i++) {
		lotto[i] = i + 1;
	}
	for(int i=0 ; i<45 ; i++) {
		cout << setw(2) << lotto[i] << " ";
		if((i + 1) % 10 == 0) {
			cout << endl;
		}
	}
	cout << endl << "===================== ������ =====================" << endl;

//	���´�.
	srand((unsigned)time(NULL));
	for(int i=0 ; i<1000000 ; i++) {
		int r = rand() % 44 + 1;
		int temp = lotto[0];
		lotto[0] = lotto[r];
		lotto[r] = temp;
	}
	for(int i=0 ; i<45 ; i++) {
		cout << setw(2) << lotto[i] << " ";
		if((i + 1) % 10 == 0) {
			cout << endl;
		}
	}
	cout << endl << "===================== ������ =====================" << endl;

//	lotto �迭�� �� 6���� 1�� ��ȣ 7��° ���ڴ� �ǳ���
	cout << "1�� ��ȣ : ";
	int start = time(NULL);						// 1�� ��ȣ�� ����ϴ� ���� �ð��� �����Ѵ�.
	for(int i=0 ; i<6 ; i++) {
		if(i > 0) {
			cout << ", ";
		}
		cout << lotto[i];
		while(true) {
			if((start + i + 1) == time(NULL)) {
				break;
			}
		}
	}
	cout << " �ǳ��� : " << lotto[6] << endl;
}