#include "config.h"

void main() {

	int cpp, java, jsp;
	cout << "3과목 점수를 입력하세요 : ";
	cin >> cpp >> java >> jsp;
	int total = cpp + java + jsp;
	double average = (double)total / 3;

//	key는 정수를 기억하는 변수 또는 연산 결과가 정수인 수식만 올 수 있다.
//	switch(key) {
//		case value:
//			key와 value 값이 일치할 경우 실행할 문장;
//			...;
//			[break;]							// {} 블록을 탈출한다.
//		...;
//		[default:
//			key와 일치하는 value 값이 없을 경우 실행할 문장;]
//	}

	switch((int)average / 10) {
		case 10:
			cout << "★★★★★ 참잘했어요 ★★★★★" << endl;
//			cout << "A" << endl; break;
		case 9:
			cout << "A" << endl; break;
		case 8:
			cout << "B" << endl; break;
		case 7:
			cout << "C" << endl; break;
		case 6:
			cout << "D" << endl; break;
		default:
			cout << "F" << endl;
	}

}