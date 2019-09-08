#include "config.h"

class Base {
public:
//	�Լ� ����� virtual ���� �ٿ��� �����ϸ� ���� ���ε��� �����Ѵ�.
//	���� ���ε� : ������ �ܰ迡�� ������ �Լ��� �ּҰ� �����ȴ�.
//	���� ���ε� : ������ �ܰ迡���� ������ �Լ��� �ּҸ� ����ΰ� ���α׷��� ����Ǵ� �ܰ迡��
//	������ �Լ��� �ּҰ� �����Ǵ� ����̴�.
	virtual void toString() {
		cout << "�θ� Ŭ���� Base�� toString() �Լ� ȣ��" << endl;
	}
};

class Derived : public Base {
public:
//	Base Ŭ������ ���� ��ӹ��� toString() �Լ��� �������̵� �Ѵ�.
	void toString() {
		cout << "�ڽ� Ŭ���� Derived�� toString() �Լ� ȣ��" << endl;
	}
};

void main() {

//	�θ� Ŭ������ ��ü(base)�� ������(pBase) ����
	Base base, *pBase;
//	�θ� Ŭ������ ��ü�� ������ �ּҸ� �����Ϳ� ����
	pBase = &base;
	cout << "�θ� Ŭ���� ��ü�� ������ �ּ� : " << pBase << endl;
//	�θ� �����Ϳ��� toString() �Լ� ���� ==> �θ� Ŭ������ �Լ��� ����ȴ�.
	pBase->toString();

//	�ڽ� Ŭ������ ��ü(derived)�� ������(pDerived) ����
	Derived derived, *pDerived;
//	�θ� Ŭ������ ��ü�� ������ �ּҸ� �����Ϳ� ����
	pDerived = &derived;
	cout << "�ڽ� Ŭ���� ��ü�� ������ �ּ� : " << pDerived << endl;
//	�θ� �����Ϳ��� toString() �Լ� ���� ==> �ڽ� Ŭ������ �Լ��� ����ȴ�.
	pDerived->toString();

//	�θ� Ŭ���� �����Ϳ� �̹� �����Ǿ��ִ� �ڽ� Ŭ���� �����͸� �����Ѵ�.
	pBase = pDerived;
	cout << "�θ� Ŭ���� �����Ϳ� ����� �ּ� : " << pBase << endl;
	pBase->toString();

//	�θ� Ŭ���� �����Ϳ� �ڽ� ��ü�� �����ؼ� �ּҸ� �����Ѵ�.
	Base *pBase1 = new Derived();
	pBase1->toString();

//	�θ� �ڽ��� ������ �� ������ �ڽ��� �θ� ������ �� ����.
//	�ڽ� Ŭ���� �����Ϳ� �̹� �����Ǿ��ִ� �θ� Ŭ���� �����͸� �����Ѵ�.
//	pDerived = pBase;					// ���� �߻�
//	�ڽ� Ŭ���� �����Ϳ� �θ� ��ü�� �����ؼ� �ּҸ� �����Ѵ�.
//	Derived *pDerived1 = new Base();	// ���� �߻�

}