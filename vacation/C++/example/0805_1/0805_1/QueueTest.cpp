#include "config.h"

class Queue{
private : 
	int rear,front;
	int *queue;
	const int QUEUE_SIZE;
public :
	Queue(int n) : QUEUE_SIZE(n){
		this->rear = -1;
		this->front = -1;
		this->queue = new int[QUEUE_SIZE];
	}
	~Queue(){
		delete[] queue;
	}

	bool isFull()
	{
		return rear == QUEUE_SIZE-1;
	}
	
	bool isEmpty()
	{
		return rear == front || rear == -1 ;
	}
	void Insert()
	{
		if(isFull())
		cout << "ť�� �������ֽ��ϴ�. " << endl;
		else {
			int value;
			cout << "���ڸ� �Է��ϼ��� : ";
			cin >> value;
			queue[++rear] = value;
			outputStack();
		}
	}

	void Delete(){
		if(isEmpty())
		cout << "ť�� ����ֽ��ϴ�. " << endl;
		else {
			queue[++front] ;
			cout << "���� ������ : "  << queue[front] << endl;
			outputStack();
		}

	}
	void outputStack()
	{
		if(isEmpty())
			cout << "ť�� ����ֽ��ϴ�. " << endl;
		else{
			for(int i=front+1; i<=rear;i++)
			{
				if(i > front+1)
				cout << ", ";
				cout << queue[i];
			}
			cout << endl;
		}
	}
};

void main(){
	Queue queue(5);
	int menu =0;
	while(menu !=3){
		cout << "-------------------------------" << endl;
		cout << "1.Insert 2.Delete 3.view 4.quit" <<endl;
		cout << "-------------------------------" << endl;
		cin >> menu;
		
		switch(menu)
		{
		case 1: 
			queue.Insert();  break;
		case 2: 
			queue.Delete();  break;
		case 3: 
			queue.outputStack();  break;
		case 4: 
			cout << "Quit" << endl;  exit(0) ;
		}
	}
}

