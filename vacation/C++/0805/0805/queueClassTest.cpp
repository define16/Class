#include "config.h"

class Queue {
private:
	const int QUEUE_SIZE;
	int rear, front;
	int *queue;
public:
	Queue(int n) : QUEUE_SIZE(n) {
		this->rear = -1;
		this->front = -1;
		this->queue = new int[QUEUE_SIZE];
	}
	~Queue() {
		delete[] queue;
	}

	bool isFull() {
		return rear == QUEUE_SIZE - 1;
	}
	bool isEmpty() {
		return rear == -1 || rear == front;
	}
	void viewQueue() {
		if(isEmpty()) {
			cout << "큐가 비어있습니다." << endl;
		} else {
			cout << "큐에 저장된 값 : ";
			for(int i=front+1 ; i<=rear ; i++) {
				if(i > front+1) {
					cout << ", ";
				}
				cout << queue[i];
			}
			cout << endl;
		}
	}
	void input() {
		if(isFull()) {
			cout << "큐가 가득차있습니다." << endl;
			viewQueue();
		} else {
			int value;
			cout << "input할 데이터 : ";
			cin >> value;
			queue[++rear] = value;
			viewQueue();
		}
	}
	void output() {
		if(isEmpty()) {
			cout << "큐가 비어있습니다." << endl;
		} else {
			cout << "OUTPUT Value : " << queue[++front] << endl;
			viewQueue();
		}
	}
};

void main() {
	Queue queue(5);
	int menu = 0;
	while(menu != 4) {
		do {
			cout << "-----------------------------------" << endl;
			cout << " 1.input  2.output  3.view  4.quit " << endl;
			cout << "-----------------------------------" << endl;
			cout << "원하는 메뉴를 선택하세요 : ";
			cin >> menu;
		} while(menu < 1 || menu > 4);

		switch(menu) {
			case 1:
				queue.input(); break;
			case 2:
				queue.output(); break;
			case 3:
				queue.viewQueue(); break;
		}
	}
	cout << "바이바이~~~~" << endl;
}