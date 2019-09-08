#include "config.h"

//	처리할 데이터와 데이터를 처리하는 함수를 인수로 받는 함수
int func(int a, int b, int (*pFunc)(int, int)) {
//	인수로 넘겨받은 함수를 실행한 결과를 리턴하므로 func 앞에 "*"을 붙이지 않는다.
	return (*pFunc)(a, b);
}

int Add(int a, int b) {
	return a + b;
}
int Sub(int a, int b) {
	return a - b;
}
int Mul(int a, int b) {
	return a * b;
}
int Div(int a, int b) {
	if(b != 0) {
		return a / b;
	} else {
		return -1;
	}
}

void main() {

	int a, b;
	cout << "숫자 2개를 양수로 입력하세요 : ";
	cin >> a >> b;

//	int (*pFunc)(int, int)
	int (*add)(int, int) = Add;		// Add 함수의 주소가 포인터 a에 저장된다.
//	cout << a << endl;
//	func 함수로 처리할 데이터 a, b와 데이터를 처리할 함수의 주소가 저장된 포인터 add를 인수로
//	넘겨주면 func는 넘겨받은 데이터를 넘겨받은 함수로 처리한 결과를 리턴해 준다.
	cout << func(a, b, add) << endl;

	int (*sub)(int, int) = Sub;
	cout << func(a, b, sub) << endl;
	int (*mul)(int, int) = Mul;
	cout << func(a, b, mul) << endl;
	int (*div)(int, int) = Div;
	cout << func(a, b, div) << endl;

}