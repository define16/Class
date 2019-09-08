#include "config.h"

//	C/C++은 함수를 main() 함수 뒤에서 정의하면 컴파일시 식별자를 찾을 수 없다는 에러가 발생된다.
//	함수를 main() 함수 뒤에서 정의를 하려면 컴파일러에게 main() 함수 뒤에서 정의한 함수가 함수임을 알려줘야 한다.
//	컴파일러에게 함수임을 알리기 위해서 main() 함수 뒤에서 정의하는 함수는 반드시 main() 함수 앞에서 함수의 원형을
//	정의해 줘야 한다.
//	함수의 원형은 함수의 머리 부분만 적어주면 된다. 함수의 원형은 변수 이름을 안적어도 관계 없다.
int total();							// int total() 함수의 원형
int total(int);							// int total(int n) 함수의 원형
int total(int, int);					// int total(int n, int m) 함수의 원형

void main() {

	cout << "1~100의 합계 : " << total() << endl;
	int n;
	cout << "숫자를 입력하세요 : ";
	cin >> n;
	cout << "1~" << n << "의 합계 : " << total(n) << endl;
	cout << "실인수 n에 저장된 값 : " << n << endl;
	int m;
	cout << "숫자 2개를 입력하세요 : ";
	cin >> n >> m;
	cout << n << "~" << m << "의 합계 : " << total(n, m) << endl;

}

int total() {
	int sum = 0;
	for(int i=1 ; i<=100 ; i++) {
		sum += i;
	}
	return sum;
}

int total(int n) {
	int sum = 0;
	for(int i=1 ; i<=n ; i++) {
		sum += i;
	}
	return sum;
}

int total(int n, int m) {
	int sum = 0;
	for(int i=n ; i<=m ; i++) {
		sum += i;
	}
	return sum;
}
