#include "config.h"
#include "SelectionSort.h"

class Stack{
private :
	const int STACK_SIZE;
	int *stack; 
	int top ;			
public :
	Stack(int n) : STACK_SIZE(n) {
		this->top = -1;
		this->stack = new int[STACK_SIZE];
	}
	~Stack(){
		delete[] stack;
	}
bool isFull()
{
	return top == STACK_SIZE-1;
}

bool isEmpty(){
	return top == -1;
}


void outputStack()
{
	for(int i=0; i<=top;i++)
	{
		if(i > 0)
		cout << ", ";
		cout << stack[i];
	}
	cout << endl;
}
void Push()		
{
	if(isFull())
	{
		cout << "스택이 가득차있습니다." << endl;
		outputStack();
		
	}
	else 
	{
		int value;
		cout << "push할 데이터 : ";
		cin >> value;
		stack[++top] = value;
		cout << "스택에 저장된 값 : ";
		outputStack();
	}
}

void Pop(){
	if( isEmpty())
	{
		cout << "스택이 없습니다." << endl;
	}
	else {
		stack[--top];
		cout << "스택에 저장된 값 : ";
		outputStack();
	}
}

};

void main() {
	Stack stack(5);
	int menu =0;
	while(menu !=3){
		cout << "-------------------------------" << endl;
		cout << "1.push 2.pop 3.view 4.quit" <<endl;
		cout << "-------------------------------" << endl;
		cin >> menu;
		
		switch(menu)
		{
		case 1: 
			stack.Push();  break;
		case 2: 
			stack.Pop();  break;
		case 3: 
			stack.outputStack();  break;
		case 4: 
			cout << "Quit" << endl;  exit(0) ;
		}
	}
}