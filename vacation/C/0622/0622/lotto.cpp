#include "config.h"

void main() {

//	추첨기를 준비한다.
	int lotto[45];
//	추첨기에 공을 넣는다.
	for(int i=0 ; i<45 ; i++) {
		lotto[i] = i + 1;
	}
	for(int i=0 ; i<45 ; i++) {
		cout << setw(2) << lotto[i] << " ";
		if((i + 1) % 10 == 0) {
			cout << endl;
		}
	}
	cout << endl << "===================== 섞기전 =====================" << endl;

//	섞는다.
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
	cout << endl << "===================== 섞은후 =====================" << endl;

//	lotto 배열의 앞 6개가 1등 번호 7번째 숫자는 뽀나스
	cout << "1등 번호 : ";
	int start = time(NULL);						// 1등 번호를 출력하는 시작 시간을 저장한다.
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
	cout << " 뽀나스 : " << lotto[6] << endl;
}