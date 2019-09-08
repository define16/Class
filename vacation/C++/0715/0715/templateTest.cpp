#include "config.h"
/*
int mymin(int a, int b) {
	int min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
double mymin(double a, double b) {
	double min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
char mymin(char a, char b) {
	char min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}
*/

//	템플릿은 자료형을 넘겨받는다. 템플릿을 한 개만 쓰면 첫 번째 자료형만 받는다.
//	함수로 넘어오는 자료형이 같을 경우 사용한다.
template <class T>
T mymin(T a, T b) {
	T min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}

//	위의 템플릿은 한 가지 문제점이 있다.
//	위의 템플릿을 실행하려면 템플릿을 호출할 때 두 인수의 데이터 타입이 반드시
//	같아야 에러가 발생되지 않는다.
//	템플릿으로 넘어오는 데이터 인수의 타입이 다를 경우 아래와 같이 선언하면 된다.
//	첫 번째 인수의 자료형이 T1으로 두 번째 인수의 자료형이 T2로 넘어온다.
//	T1과 T2의 자료형이 다르면 값 손실이 발생될 수 있다. 이 때 이를 해결하는 방법은
//	T1으로 크기가 큰 자료형을 넘겨주면 된다.
template <class T1, class T2>
T1 mymin(T1 a, T2 b) {
	T1 min;
	min = a;
	if(a > b) {
		min = b;
	}
	return min;
}

template <class T>
void change(T *a, T *b) {
	T temp = *a;
	*a = *b;
	*b = temp;
}

template <class T>
void change(T &a, T &b) {
	T temp = a;
	a = b;
	b = temp;
}

void main() {
	
	int a = 2, b = 10;
	cout << "작은 값 : " << mymin(a, b) << endl;
	double c = 3.4, d = 2.5;
	cout << "작은 값 : " << mymin(c, d) << endl;
	char ch1 = 'a', ch2 = 'A';
	cout << "작은 값 : " << mymin(ch1, ch2) << endl;
//	template <class T>를 사용할 경우 mymin(a, d)는 a와 d의 자료형이 다르면 에러가
//	발생된다.
	cout << "작은 값 : " << mymin(d, a) << endl;

	change(&a, &b);
	cout << "a = " << a << ", b = " << b << endl;
	change(a, b);
	cout << "a = " << a << ", b = " << b << endl;

}