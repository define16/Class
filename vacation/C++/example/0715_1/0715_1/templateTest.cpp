#include "config.h"

//int mymin(int a, int b)
//{
//	return a < b ? a : b;
//}
//
//double mymin(double a, double b)
//{
//	return a < b ? a : b;
//}
//
//char mymin(char a, char b)
//{
//	return a < b ? a : b;
//}

template <class T>		//C++ 가능
T mymin(T a, T b)
{
	return a < b ? a : b;
}
// 위의 템플릿은 한 가지 문제점이 있다.
// 위의 템플릿은 실행하려면 템플릿을 호출할 때 두 인수의 데이터 타입이 반드시
// 같아야 에러가 발생하지 않는다.

// 템플릿으로 넘어오는 데이터의 이수의 타입이 다를 경우 아래와 같이 선언 한다.
// 위의 템플릿을 실행하려면 템플릿을 호출 할때 두 인수의 데이터 타입이 반드시 같아야
// 에러가 발생하지 않는다.
// 첫번째 인수는 T1, 두 번째 인수는 T2로 넘어온다. T1과 T2의 자료형이 다르면 값 손실이 일어날 수 있다.
template <class T1,class T2>		//C++ 가능
T1 mymin(T1 a, T2 b)
{
	return a < b ? a : b;
}

//템플릿을 하나만 쓰면 첫 번째 자료형만 받는다.
//함수로 넘어오는 자료형이 같을 경우 사용한다.
template <class T>
void change(T &a,T &b)
{
	T temp = a;
	a = b;
	b = temp;
}


void main()
{
	int a = 2, b = 10;
	cout << "작은 값 : " << mymin(a,b) << endl;
	double c = 3.4, d = 2.5;
	cout << "작은 값 : " << mymin(c,d) << endl;
//	mymin(a,d)는 a와 d의 자료형이 다르면 에러가 발생한다.
//	cout << "작은 값 : " << mymin(a,d) << endl;+

	change(a, b);
	cout << "a = " << a<<", b = " << b <<endl;

}
