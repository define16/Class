#include "config.h"

class A {
public:
	void func1() {
		cout << "A" << endl;
	}
};

//	A 클래스를 상속받아 B 클래스를 만든다.
class B : virtual public A {
public:
//	A 클래스로 부터 상속받은 func1() 함수를 가지고 있다.
	void func2() {
		cout << "B" << endl;
	}
};

//	A 클래스를 상속받아 C 클래스를 만든다.
class C : virtual public A {
public:
//	A 클래스로 부터 상속받은 func1() 함수를 가지고 있다.
	void func2() {
		cout << "C" << endl;
	}
};

//	B 클래스와 C 클래스를 상속받아 D 클래스를 만든다.
//	B 클래스와 C 클래스 모두 A 클래스를 상속받아 만들어진 클래스이므로 D 클래스는 
//	결과적으로 A 클래스를 2번 상속받는 현상이 발생된다.
class D : public B, public C {
public:
//	B 클래스로 부터 상속받은 func1(), func2() 함수를 가지고 있다.
//	C 클래스로 부터 상속받은 func1(), func2() 함수를 가지고 있다.
	void func3() {
//		다중 상속은 같은 클래스를 2번 이상 상속받게 될 수 있으므로 같은 클래스가 2번
//		이상 상속되면 부모 클래스가 모호하다는 에러가 발생된다.
//		이런 현상을 죽음의 다이아몬드 현상이라 부르며 이 현상을 해결하는 방법은 
//		중복 상속될 것으로 예상되는 클래스를 상속받을 때 virtual 예약어를 사용해서
//		가상 상속이 되게하면 같은 클래스가 2번 이상 상속되지 않는다.
		A::func1();
//		B 클래스와 C 클래스로 부터 같은 이름의 함수를 상속받았으므로 구분하려면
//		같은 이름의 함수 앞에 "소속클래스::"를 적는다.
		B::func2();
		C::func2();
	}
};

void main() {

	class D d;
	d.func3();

}