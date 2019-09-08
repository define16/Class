#include "config.h"


class Base {
public :
// 함수 선언시 virtual 예약어를 붙여서 선언하면 동적 바인딩을 실행한다.
// 정적 바인딩 : 컴파일 단계에서 함수의 주소가 결정된다.
// 동적 바인딩 : 컴파일 단계에서는 실행할 함수의 주소를 비워두고 프로그램이 실행되는
//							단계에서 실행할 준비를 한다.
	virtual void toString() {
		cout << "부모 클래스 Base의 toString() 함수 호출 " << endl;
	}
	
};


class Derived : public Base {
public : // Base 클래스로 부터 상속받은 toString() 함수를 오버라이드 한다.
	void toString() {
		cout << "자식 클래스 Derived의 toString() 함수 호출 " << endl;
	}


};


void main() {
// 부모 클래스의 객체(Base)와 포인터(pBase) 생성
		Base base, *pBase;
// 부모 클래스의 객체가 생성된 주소를 포인터에 저장
		pBase = &base;
		cout << "부모 클래스 객체가 생성된 주소 : " << pBase << endl;
// 부모 포인터에서 toString() 함수 실행
		pBase -> toString();
// 자식 클래스의 객체(Derived)와 포인터 (pDerived)생성
		Derived derived, *pDerived;
// 부모 클래스의 객체가 생성된 주소를 포인터에 저장
		pDerived = &derived;
		cout << "자식 클래스 객체가 생성된 주소 : " << pDerived << endl;
// 부모 포인터에서 toString() 함수 실행 => 자식 클래스의 함수가 실행된다.
		pDerived -> toString();

// 부모 클래스 포인터에 자식 클래스 포인터를 대입한다.
		pBase = pDerived;
		cout << "부모 클래스 포인터에 저장된 주소 : " << pBase << endl;
		pBase->toString();

		Base b[5];		//객체 배열
		b[0].toString();
}
