#include "config.h"


class Base {
public :
// �Լ� ����� virtual ���� �ٿ��� �����ϸ� ���� ���ε��� �����Ѵ�.
// ���� ���ε� : ������ �ܰ迡�� �Լ��� �ּҰ� �����ȴ�.
// ���� ���ε� : ������ �ܰ迡���� ������ �Լ��� �ּҸ� ����ΰ� ���α׷��� ����Ǵ�
//							�ܰ迡�� ������ �غ� �Ѵ�.
	virtual void toString() {
		cout << "�θ� Ŭ���� Base�� toString() �Լ� ȣ�� " << endl;
	}
	
};


class Derived : public Base {
public : // Base Ŭ������ ���� ��ӹ��� toString() �Լ��� �������̵� �Ѵ�.
	void toString() {
		cout << "�ڽ� Ŭ���� Derived�� toString() �Լ� ȣ�� " << endl;
	}


};


void main() {
// �θ� Ŭ������ ��ü(Base)�� ������(pBase) ����
		Base base, *pBase;
// �θ� Ŭ������ ��ü�� ������ �ּҸ� �����Ϳ� ����
		pBase = &base;
		cout << "�θ� Ŭ���� ��ü�� ������ �ּ� : " << pBase << endl;
// �θ� �����Ϳ��� toString() �Լ� ����
		pBase -> toString();
// �ڽ� Ŭ������ ��ü(Derived)�� ������ (pDerived)����
		Derived derived, *pDerived;
// �θ� Ŭ������ ��ü�� ������ �ּҸ� �����Ϳ� ����
		pDerived = &derived;
		cout << "�ڽ� Ŭ���� ��ü�� ������ �ּ� : " << pDerived << endl;
// �θ� �����Ϳ��� toString() �Լ� ���� => �ڽ� Ŭ������ �Լ��� ����ȴ�.
		pDerived -> toString();

// �θ� Ŭ���� �����Ϳ� �ڽ� Ŭ���� �����͸� �����Ѵ�.
		pBase = pDerived;
		cout << "�θ� Ŭ���� �����Ϳ� ����� �ּ� : " << pBase << endl;
		pBase->toString();

		Base b[5];		//��ü �迭
		b[0].toString();
}
