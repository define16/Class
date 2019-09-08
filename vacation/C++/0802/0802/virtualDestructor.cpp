#include "config.h"

class A {
public:
	A() {
		cout << "A 클래스의 생성자 실행, 동적 메모리 할당" << endl;
	}
	virtual ~A() {		// 가상 소멸자
		cout << "A 클래스의 소멸자 실행, 동적 메모리 해제" << endl;
	}
};

class B : public A {
public:
//	자식 클래스의 생성자가 실행되면 부모 클래스의 기본 생성자가 자동으로 실행된다.
	B() {
		cout << "B 클래스의 생성자 실행, 동적 메모리 할당" << endl;
	}
	~B() {
		cout << "B 클래스의 소멸자 실행, 동적 메모리 해제" << endl;
	}
};

void main() {

//	A a;
//	B b;
	A *a = new B();
	delete a; 

//	부모 클래스(A)의 포인터에 자식 클래스(B)의 객체를 만들어 시작 주소를 대입했을 경우
//	A 클래스의 소멸자를 일반 소멸자로 만들어 사용하면 A 클래스의 객체가 소멸될 때
//	A 클래스의 소멸자만 실행되고 B 클래스의 소멸자가 실행되지 않는다.
//	따라서, B 클래스의 객체가 생성될 때 할당된 동적 메모리가 해제되지 않기 때문에 메모
//	리 누수 현상이 발생된다.
//	이를 해결하기 위해 A 클래스의 소멸자를 virtual을 붙여서 가상 소멸자로 만들어 주면
//	소멸자도 동적 바인딩을 하게되고 B 클래스의 소멸자가 정상적으로 실행되서 메모리 누수
//	현상이 발생되지 않는다.

}