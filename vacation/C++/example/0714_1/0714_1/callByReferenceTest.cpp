#include "config.h"

//Call By Reference는 결과를 2가지 이상 얻기위해서 사용

//C언어에서 포인터를 이용하는 Call By Reference
//함수를 호출할때는 실인수로 데이터가 저장된 기억장소의 주소를 적어준다. 
//함수가 호출 당하면 실인수로 넘어오는 주소값을 포인터로 받아준다.
 void change(int *p1, int *p2)	//정수를 교환하는 함수
 {
	 int temp = *p1;
	 *p1 = *p2;
	 *p2 = temp;
 }

//함수 오버로딩 : 하나의 파일에 같은 이름의 함수가 여러개 나올수 있는다.
//C++컴파일러는 함수의 이름이 같으면 인수의 개수를 가지고 함수를 식별 만약 인수의 개수가 같다면 인수의 데이터 타입으로 식별.

  void change(double *p1, double *p2) //실수를 교환하는 함수
 {
	 double temp = *p1;
	 *p1 = *p2;
	 *p2 = temp;
 }


//C++에서 포인터를 이용하는 Call By Reference
//함수가 호출 당하면 실인수로 넘어오는 주소값을 참조형 변수로 받아준다.

 void change(int &p1, int &p2)	//정수를 교환하는 함수
 {
	 int temp = p1;
	 p1 = p2;
	 p2 = temp;
 }

   void change(double &p1, double &p2) //실수를 교환하는 함수
 {
	 double temp = p1;
	 p1 = p2;
	 p2 = temp;
 }

void main()
{
	int a = 3, b = 4;
	swap(a,b);	// C++만 해당.

	cout << "a = " << a<<", b = " << b << endl;
	printf("a = %d, b = %d",a,b);

//C의 call by reference는 실인수로 데이터가 저장된 주소를 적어준다.
	change(&a,&b);
	cout  << "a = " << a << ", b = " <<  b << endl;

//C++의 call by reference는 실인수로 데이터가 저장된 변수만 적어준다.
		change(a ,b);
		cout  << "a = " << a << ", b = " <<  b << endl;

	double c = 3.1, d = 4.9;

	swap(c,d);
	cout << "c = " << c<<", d = " << d << endl;

	change(&c,&d);
	cout << "c = " << c<<", d = " << d << endl;

}
