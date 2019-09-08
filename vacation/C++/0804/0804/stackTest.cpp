#include "config.h"

//	���� �Լ����� ����� ��� ��Ҵ� ���� ������ ����� �ش�.
//	������ ũ�⸦ ���Ѵ�.
//	#define STACK_SIZE 5			// C���� ����� �����ϴ� ���
const int STACK_SIZE = 5;			// C++���� ����� �����ϴ� ���
int *stack = new int[STACK_SIZE];	// ������ ũ�⸸ŭ �޸𸮸� �������� �Ҵ��Ѵ�.
int top = -1;						// ���� ������

bool isFull() {
	return top == STACK_SIZE - 1;
}

void viewStack() {
	cout << "���ÿ� ����� �� : ";
	for(int i=0 ; i<=top ; i++) {
		if(i > 0) {
			cout << ", ";
		}
		cout << stack[i];
	}
	cout << endl;
}

void push() {						// ���ÿ� �����͸� �Է��ϴ� �Լ�
//	������ �������ִ°� ������� ���̸� �����÷ο츦 �߻���Ű�� �����̸� ���ÿ� �����͸� �Է��Ѵ�.
	if(isFull()) {
		cout << "������ �������ֽ��ϴ�." << endl;
		viewStack();
	} else {
//		���� �����͸� 1������Ű�� ���ÿ� �����͸� �Է��Ѵ�.
		int value;
		cout << "push�� ������ : ";
		cin >> value;
		stack[++top] = value;
		viewStack();
	}
}

void main() {

	int menu = 0;
	while(menu != 4) {
		do {
			cout << "-------------------------------" << endl;
			cout << " 1.push  2.pop  3.view  4.quit " << endl;
			cout << "-------------------------------" << endl;
			cout << "���ϴ� �޴��� �����ϼ��� : ";
			cin >> menu;
		} while(menu < 1 || menu > 4);

		switch(menu) {
			case 1:
				push(); break;
			case 2:
				cout << "POP" << endl; break;
			case 3:
				viewStack(); break;
//			case 4:
//				cout << "���̹���~~~~" << endl;
//				exit(0);		// ���α׷� ��������
		}
	}
	cout << "���̹���~~~~" << endl;
}