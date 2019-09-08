#include "config.h"

typedef int (*Func)(int, int);		// C언어에서 함수 포인터 선언하기
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

//	함수 포인터에 대입될 함수의 이름을 함수 포인터 배열로 만들어 준다.
//	함수 포인터 배열에는 함수가 생성된 메모리의 주소가 저장된다.
	Func func[] = {Add, Sub, Mul, Div};
//	for(int i=0 ; i<4 ; i++) {
//		cout << func[i](5, 3) << endl;			// 함수가 실행된 결과가 출력된다.
//		cout << func[i] << endl;				// 함수의 주소가 출력된다.
//	}

	int a, b;
	cout << "숫자 2개를 양수로 입력하세요 : ";
	cin >> a >> b;

	int menu = 0;
	while(menu != 5) {
		do {
			cout << "==============================================" << endl;
			cout << " 1.더하기  2.빼기  3.곱하기  4.나누기 5. 종료 " << endl;
			cout << "==============================================" << endl;
			cout << "원하는 메뉴를 선택하세요 : ";
			cin >> menu;
		} while(menu < 1 || menu > 5);
		switch(menu) {
			case 1: cout << a << " + " << b << " = " << func[0](a, b) << endl; break;
			case 2: cout << a << " - " << b << " = " << func[1](a, b) << endl; break;
			case 3: cout << a << " * " << b << " = " << func[2](a, b) << endl; break;
			case 4:
				cout << a << " / " << b << " = ";
				if(func[3](a, b) != -1) {
					cout << func[3](a, b);
				} else {
					cout << "나눗셈을 0으로 할 수 없습니다.";
				}
				cout << endl;
		}
	}
	cout << "바이바이~~~~~" << endl;

}