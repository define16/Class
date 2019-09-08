#include "config.h"

//	자기 참조 구조체 : 멤버로 자신의 타입을 참조할 수 있는 포인터를 가지는 구조체
struct node {
	int data;
//	자신의 타입을 참조할 수 있는 구조체 포인터, 다음에 처리할 데이터의 주소를 기억한다.
	struct node *link;
};

void main() {

	struct node item1, item2, item3;		// node 구조체 변수 선언

	item1.data = 100;
	item2.data = 300;
	item3.data = 200;
	item1.link = item2.link = item3.link = NULL;		// 모든 포인터를 NULL로 초기화 한다.

	item1.link = &item3;		// 100 다음에 처리할 200이 저장된 주소를 넣어준다.
	item3.link = &item2;		// 200 다음에 처리할 300이 저장된 주소를 넣어준다.
	item2.link = &item1;		// 마지막 데이터 처리 후 처음 데이터로 이동한다. 순환이 생긴다.

	cout << "item1.data : " << item1.data << endl;
	printf("item1.data : %d\n", item1.data);
	cout << "item3.data : " << item1.link->data << endl;
	cout << "item3.data : " << (*item1.link).data << endl;
	cout << "item2.data : " << item1.link->link->data << endl;
	cout << "item2.data : " << (*(*item1.link).link).data << endl;
	cout << "item1.data : " << item1.link->link->link->data << endl;

}