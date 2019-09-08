#include "config.h"

//	여러 함수에서 사용할 기억 장소는 전역 변수로 만들어 준다.
//	스택의 크기를 정한다.
//	#define STACK_SIZE 5			// C언어에서 상수를 정의하는 방법
const int STACK_SIZE = 5;			// C++에서 상수를 정의하는 방법
int *stack = new int[STACK_SIZE];	// 스택의 크기만큼 메모리를 동적으로 할당한다.
int top = -1;						// 스택 포인터

bool isFull() {
	return top == STACK_SIZE - 1;
}

void viewStack() {
	cout << "스택에 저장된 값 : ";
	for(int i=0 ; i<=top ; i++) {
		if(i > 0) {
			cout << ", ";
		}
		cout << stack[i];
	}
	cout << endl;
}

void push() {						// 스택에 데이터를 입력하는 함수
//	스택이 가득차있는가 물어봐서 참이면 오버플로우를 발생시키고 거짓이면 스택에 데이터를 입력한다.
	if(isFull()) {
		cout << "스택이 가득차있습니다." << endl;
		viewStack();
	} else {
//		스택 포인터를 1증가시키고 스택에 데이터를 입력한다.
		int value;
		cout << "push할 데이터 : ";
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
			cout << "원하는 메뉴를 선택하세요 : ";
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
//				cout << "바이바이~~~~" << endl;
//				exit(0);		// 프로그램 강제종료
		}
	}
	cout << "바이바이~~~~" << endl;
}