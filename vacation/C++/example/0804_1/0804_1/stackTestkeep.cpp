#include "config.h"

// 여러 함수에서 사용할 기억 장소는 전역변수로 만들어준다.
// 스택의 크기를 정한다
 const int STACK_SIZE = 5;
// 스택의 크기 만큼 메모리를 동적으로 할당한다.
int *stack = new int[STACK_SIZE]; // 스택의 크기 만큼 메모리를 동적으로 할당한다.
int top = -1;			// 스택포인터

bool isFull()
{
	return top == STACK_SIZE-1;
}

bool isEmpty()
{
	return top == -1;
}

// 스택 늘리기
//int *overStack(int *stack)
//{
//	int newStack[10];
//	int oldStack = *stack; 
//	newStack[10] = oldStack;
//	//stack = oldStack + newStack[10];
//	//stack = temp;
//	
//	return newStack;
//}



void outputStack()
{
	if(isEmpty())
		cout << "스택에 아무것도 없습니다." << endl;
	else
	{
		for(int i=0; i<=top;i++)
		{
			if(i > 0)
			cout << ", ";
			cout << stack[i];
		}
		cout << endl;
	}
}
void Push()		// 스택에 데이터를 입력하는 함수
// 스택이 가득차 있는가를 먼저 물어본다. 참이면 오버플로우 발생시키고 거짓이면 스택에 입력한다.
{
	if(isFull())
	{
		int n;
		cout << "스택이 가득차있습니다." << endl;
		outputStack();
	/*	cout << " 스택을 늘리시겠습니까?? 1번을 눌러주세요 ";
		cin >> n;
		switch(n){
			case 1 : 
				 overStack(stack); break;
			default : 
				break;
		}*/
		
	}
	else 
	{ // 스택포인터를 1증가시키고 스택에 데이터를 입력한다.
		int value;
		cout << "push할 데이터 : ";
		cin >> value;
		stack[++top] = value;
		cout << "스택에 저장된 값 : ";
		outputStack();
	}
}

void Pop(){
	if(isEmpty()){
		cout << "스택이 없습니다." << endl;
	}
	else {
		stack[--top];
		cout << "스택에 저장된 값 : ";
		outputStack();
	}
}


void main() {
	int menu =0;
	while(menu !=3){
		cout << "--------------------" << endl;
		cout << "1.Push 2.Pop 3.View 4.Quit" <<endl;
		cout << "--------------------" << endl;
		cin >> menu;
		
		switch(menu)
		{
		case 1: 
			Push();  break;
		case 2:  // pop함수 구현하기
			Pop();  break;
		case 3: 
			outputStack();  break;
		case 4: 
			cout << "Quit" << endl;  break;
		}
	}
}