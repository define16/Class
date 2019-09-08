#include "config.h"

//	리턴타입 함수명([인수, ...]) {			// 함수의 머리
//		함수가 실행할 문장;					// 함수의 몸체
//		...;
//		[return 값;]						// return이 생략되면 리턴 타입은 void이다.
//	}
//	함수는 return을 만나거나 함수의 "}"를 만나면 함수가 호출된 곳으로 되돌아간다.

//	C언어의 call by reference 함수가 호출 당하면 실인수로 넘어오는 주소값을 포인터로 받아준다.
void change(int *p1, int *p2) {				// 정수를 교환하는 함수
	int temp = *p1;
	*p1 = *p2;
	*p2 = temp;
}

void change(double *p1, double *p2) {		// 실수를 교환하는 함수
	double temp = *p1;
	*p1 = *p2;
	*p2 = temp;
}

//	C++의 call by reference 함수가 호출 당하면 실인수로 넘어오는 주소값을 참조형 변수로 받아준다.
void change(int &p1, int &p2) {
	int temp = p1;
	p1 = p2;
	p2 = temp;
}

void change(double &p1, double &p2) {
	double temp = p1;
	p1 = p2;
	p2 = temp;
}

//	함수 오버로딩 : 하나의 파일에 같은 이름의 함수가 여러개 나올수 있다.
//	C++ 컴파일러는 함수의 이름이 같으면 인수의 개수로 함수를 식별하고 인수의 개수도 같다면
//	인수의 데이터 타입으로 함수를 식별한다.

void main() {

	int a = 3, b = 4;
	swap(a, b);
	cout << "a = " << a << ", b = " << b << endl;
	printf("a = %d, b = %d\n", a, b);

//	C언어의 call by reference는 실인수로 데이터가 저장된 주소를 적어준다.
	change(&a, &b);
	cout << "a = " << a << ", b = " << b << endl;
//	C++의 call by reference는 실인수로 데이터가 저장된 변수만 적어준다.
	change(a, b);
	cout << "a = " << a << ", b = " << b << endl;

	double c = 3.1, d = 4.9;
	swap(c, d);
	cout << "c = " << c << ", d = " << d << endl;
	change(&c, &d);
	cout << "c = " << c << ", d = " << d << endl;

}