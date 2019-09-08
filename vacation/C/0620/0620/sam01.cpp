#include "config.h"

void main() {

	int dec;						// 10진수를 입력받아 저장할 변수
	int bin[8] = {0, };				// 계산된 2진수를 저장할 배열
	cout << "10진수 : ";
	cin >> dec;

//	입력받는 10진수의 크기에 따라 반복 횟수가 달라져서 몇 번 반복하면 되는지 모르므로 while을 이용해 반복시킨다.
//	while이 무한 Loop이므로 반드시 반복 중간에 조건을 지정해서 무한 Loop를 탈출시켜야 한다.
	int i = 7;						// bin 배열의 첨자로 사용할 변수
	while(true) {
		int mok = dec / 2;			// 10진수를 2로 나눈 몫을 구한다.
		int nmg = dec % 2;			// 10진수를 2로 나눈 나머지를 구한다.
		bin[i] = nmg;				// 2진수를 기억할 배열에 계산된 2진수를 저장시킨다.
		i--;						// 다음 처리를 위해서 첨자를 1작게 만든다.

		if(mok == 0) {				// 무한 Loop 탈출 조건
			break;					// 무한 Loop를 탈출한다.
		}

		dec = mok;					// 다음 연산을 위해 dec를 mok으로 변경한다.
	}

	for(int i=0 ; i<8 ; i++) {
		cout << bin[i] << " ";
	}
	cout << endl;

}