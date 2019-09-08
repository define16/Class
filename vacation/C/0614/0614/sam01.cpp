#include "config.h"

void main() {

	int year;							// 변수를 선언만 한 상태, 변수를 선언만 하면 변수에는 쓰레기가 들어있다.
	cout << "윤년/평년을 판단할 년도를 입력하세요 : ";
	cin >> year;						// 키보드로 값을 입력받아 변수에 값을 할당한다.

//	윤년/평년 판별식
//	년도가 4로 나눠 떨어지고(&&) 100으로 나눠 떨어지지 않거나(||) 400으로 나눠 떨어지면 윤년, 그렇치 않으면 평년

//	if(조건식) {
//		조건식이 참일 경우 실행할 문장;
//		...;
//	} else {
//		조건식이 거짓일 경우 실행할 문장;
//		...;
//	}

//	프로그램에서 동일한 값이 여러번 사용되면 변수에 저장해 사용하면 편리하다.
//	논리값(참 또는 거짓)을 기억하는 변수의 이름은 "is"로 시작하는것이 관행이다.
	bool isYoun = year%4 == 0 && year%100 != 0 || year%400 == 0;

	if(isYoun) {
		cout << year << "년은 윤년입니다." << endl;
	} else {
		cout << year << "년은 평년입니다." << endl;
	}

//	삼항 연산자(?:) : if의 조건이 따라 실행할 문장이 각각 1문장일 경우 사용하면 편리하다.
//	조건식 ? 조건식이 참일 경우 실행할 문장 : 조건식이 거짓일 경우 실행할 문장
	cout << year << "년은 " << (isYoun ? "윤" : "평") << "년입니다." << endl;

}