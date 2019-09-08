#include "config.h"

class Stack {
private:
	const int STACK_SIZE;
	int top;
	int *stack;
public:
	Stack(int n) : STACK_SIZE(n) {
		this->top = -1;
		this->stack = new int[STACK_SIZE];
	}
	~Stack() {
		delete[] stack;
	}

	bool isFull() {
		return top == STACK_SIZE - 1;
	}
	bool isEmpty() {
		return top == -1;
	}
	void viewStack() {
		if(isEmpty()) {
			cout << "������ ����ֽ��ϴ�." << endl;
		} else {
			cout << "���ÿ� ����� �� : ";
			for(int i=0 ; i<=top ; i++) {
				if(i > 0) {
					cout << ", ";
				}
				cout << stack[i];
			}
			cout << endl;
		}
	}
	void push() {
		if(isFull()) {
			cout << "������ �������ֽ��ϴ�." << endl;
			viewStack();
		} else {
			int value;
			cout << "push�� ������ : ";
			cin >> value;
			stack[++top] = value;
			viewStack();
		}
	}
	void pop() {
		if(isEmpty()) {
			cout << "������ ����ֽ��ϴ�." << endl;
		} else {
			cout << "POP Value : " << stack[top--] << endl;
			viewStack();
		}
	}
};

void main() {
	Stack stack(5);
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
				stack.push(); break;
			case 2:
				stack.pop(); break;
			case 3:
				stack.viewStack(); break;
//			case 4:
//				cout << "���̹���~~~~" << endl;
//				exit(0);		// ���α׷� ��������
		}
	}
	cout << "���̹���~~~~" << endl;
}