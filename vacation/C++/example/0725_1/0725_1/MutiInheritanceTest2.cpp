#include "config.h"
// 사용하지 않는 것이 좋습니다.
class A{
private : 
	int a;
public :
	void funcA()
	{
		cout << "A" << endl;
	}
};

// A클래스를 상속받아 B클래스를 만든다.
class B : virtual public A{
public :
// A클래스로 부터 상속받은 func1()함수를 가지고 있다.
	void func2()
	{
		cout << "B" << endl;
	}
};
// A클래스를 상속받아 C클래스를 만든다.
class C : virtual public A{
public :
// A클래스로 부터 상속받은 func1()함수를 가지고 있다.
	void func2()
	{
		cout << "C" << endl;
	}
};

// B클래스와 C클래스를 상속받아 D클래스를 만든다.
// B클래스와 C클래스 모두 A클래스를 상속받아 만들어진 클래스이므로 D클래스는
// 결과적으로 A클래스를 2번 상속받은 현상이 발생된다.
class D : public B, public C {
public : 
// B클래스로 부터 상속받은 func1(),func2()함수를 가지고 있다.
// C클래스로 부터 상속받은 func1(),func2()함수를 가지고 있다.
	void func3(){
// 다중 상속은 같은 클래스를 2번 이상 상속받게 될 수 있으므로 같은 클래스가 2번이상 
// 상속되면 부모 클래스가 모호하다는 에러가 발생된다.
// 이런 현상을 죽음의 다이아몬드 현상이라고 부르며 (A::fun1()) 이 현상을 해결하는 방법은
// 중복 상속될 것으로 예상되는 클래스 상속받을 때 virtual예약어를 사용해
// 가상 상속이 되게하면 같은 클래스가 2번 이상 상속
		A::funcA();
// B클래스와 C클래스로 부터 같은 이름의 함수를 상속 받았으므로 구분하려면
// 같은 이름의 함수 앞에 "소속클래스::"를 적는다.
		B::func2();
		C::func2();
	}

};


void main()
{


}