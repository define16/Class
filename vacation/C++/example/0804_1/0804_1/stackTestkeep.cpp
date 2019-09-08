#include "config.h"

// ���� �Լ����� ����� ��� ��Ҵ� ���������� ������ش�.
// ������ ũ�⸦ ���Ѵ�
 const int STACK_SIZE = 5;
// ������ ũ�� ��ŭ �޸𸮸� �������� �Ҵ��Ѵ�.
int *stack = new int[STACK_SIZE]; // ������ ũ�� ��ŭ �޸𸮸� �������� �Ҵ��Ѵ�.
int top = -1;			// ����������

bool isFull()
{
	return top == STACK_SIZE-1;
}

bool isEmpty()
{
	return top == -1;
}

// ���� �ø���
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
		cout << "���ÿ� �ƹ��͵� �����ϴ�." << endl;
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
void Push()		// ���ÿ� �����͸� �Է��ϴ� �Լ�
// ������ ������ �ִ°��� ���� �����. ���̸� �����÷ο� �߻���Ű�� �����̸� ���ÿ� �Է��Ѵ�.
{
	if(isFull())
	{
		int n;
		cout << "������ �������ֽ��ϴ�." << endl;
		outputStack();
	/*	cout << " ������ �ø��ðڽ��ϱ�?? 1���� �����ּ��� ";
		cin >> n;
		switch(n){
			case 1 : 
				 overStack(stack); break;
			default : 
				break;
		}*/
		
	}
	else 
	{ // ���������͸� 1������Ű�� ���ÿ� �����͸� �Է��Ѵ�.
		int value;
		cout << "push�� ������ : ";
		cin >> value;
		stack[++top] = value;
		cout << "���ÿ� ����� �� : ";
		outputStack();
	}
}

void Pop(){
	if(isEmpty()){
		cout << "������ �����ϴ�." << endl;
	}
	else {
		stack[--top];
		cout << "���ÿ� ����� �� : ";
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
		case 2:  // pop�Լ� �����ϱ�
			Pop();  break;
		case 3: 
			outputStack();  break;
		case 4: 
			cout << "Quit" << endl;  break;
		}
	}
}