#include "config.h"

// 상수 : 프로그램내에서 변하지 않는 숫자나 문자를 의미한다.
// 변수에 상수를 저장시키고 한번 값이 할당 되면 ./그 변수 값을 변경할 수 없게 만들어 사용한다.
// C언어에서 상수를 정의하는 방법
// 값을 할당할때 "="을 사용하지 않고 ";"을 찍지 않는다.
#define PI1  3.1415926535897932384
//C++에서 상수를 정의하는법
const double PI2 = 3.1415926535897932384;

class ConstTest
{
	private:
		double r;
	public:	
//	 클래스 선언시 정적 정수형 상수를 제외한 나머지는 클래스 내부에서 "="로 초기화를
//		시킬수 없다.
		const static int MAX = 100;			//요 경우에만 "="으로 초기화가 가능하다.
//		const double PI3 = 3.1415926535897932384;  //"="으로 초기화를 시킬 수 없으므로 에러가 발생된다.
// 상수는 반드시 초기화를 시켜야한다.
// 상수는 위의 경우를 빼곤 초기화리스트를 이용해서 초기화 시켜야한다.

		const double PI3;
		ConstTest(double r) : PI3(3.1415926535897932384)
		{
			this->r = r;
		}
		double girth()
		{
			return  2 * PI3 * r;
		}
		double area()
		{
			return  pow(r,2)* PI3;
		}

};

void main()
{
	double r;
	cout << "원의 반지름을 입력하세요 : ";
	cin >> r;
	cout << "원의 둘레1 : " << 2 * 3.1415926535897932384 * r << endl;
	cout << "원의 둘레2 : " << 2 * PI1 * r << endl;	
	cout << "원의 넓이1 : " << 3.1415926535897932384 * pow(r,2) << endl;		//pow()거듭제곱구하는 함수
	cout << "원의 넓이2 : " << PI2 * pow(r,2) << endl;

	class ConstTest c1(r);
	cout << "원의 둘레3 : " << c1.PI3 << endl;
	cout << "원의 넓이3 : " << c1.PI3 << endl;

	cout << "원의 둘레4 : " << c1.girth() << endl;
	cout << "원의 넓이4 : " << c1.area() << endl;
	

}
