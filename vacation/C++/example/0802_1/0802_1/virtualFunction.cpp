#include "config.h"

class Base {
public:
//	함수 선언시 virtual 예약어를 붙여서 선언하면 동적 바인딩을 실행한다.
//	정적 바인딩 : 컴파일 단계에서 실행할 함수의 주소가 결정된다.
//	동적 바인딩 : 컴파일 단계에서는 실행할 함수의 주소를 비워두고 프로그램이 실행되는 단계에서
//	실행할 함수의 주소가 결정되는 방식이다.
	virtual void toString() {
		cout << "부모 클래스 Base의 toString() 함수 호출" << endl;
	}
};

class Derived : public Base {
public:
//	Base 클래스로 부터 상속받은 toString() 함수를 오버라이드 한다.
	void toString() {
		cout << "자식 클래스 Derived의 toString() 함수 호출" << endl;
	}
};

void main() {

//	부모 클래스의 객체(base)와 포인터(pBase) 생성
	Base base, *pBase;
//	부모 클래스의 객체가 생성된 주소를 포인터에 저장
	pBase = &base;
	cout << "부모 클래스 객체가 생성된 주소 : " << pBase << endl;
//	부모 포인터에서 toString() 함수 실행 ==> 부모 클래스의 함수가 실행된다.
	pBase->toString();

//	자식 클래스의 객체(derived)와 포인터(pDerived) 생성
	Derived derived, *pDerived;
//	부모 클래스의 객체가 생성된 주소를 포인터에 저장
	pDerived = &derived;
	cout << "자식 클래스 객체가 생성된 주소 : " << pDerived << endl;
//	부모 포인터에서 toString() 함수 실행 ==> 자식 클래스의 함수가 실행된다.
	pDerived->toString();

//	부모 클래스 포인터에 이미 생성되어있는 자식 클래스 포인터를 대입한다.
	pBase = pDerived;
	cout << "부모 클래스 포인터에 저장된 주소 : " << pBase << endl;
	pBase->toString();

//	부모 클래스 포인터에 자식 객체를 생성해서 주소를 대입한다.
	Base *pBase1 = new Derived();
	pBase1->toString();

//	부모가 자식을 제어할 수 있지만 자식이 부모를 제어할 수 없다.
//	자식 클래스 포인터에 이미 생성되어있는 부모 클래스 포인터를 대입한다.
//	pDerived = pBase;					// 에러 발생
//	자식 클래스 포인터에 부모 객체를 생성해서 주소를 대입한다.
//	Derived *pDerived1 = new Base();	// 에러 발생

}