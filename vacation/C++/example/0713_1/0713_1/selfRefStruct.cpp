#include "config.h"

//�ڱ� ���� ����ü : ����� �ڽ��� Ÿ���� ������ �� �ִ� �����͸� ������ ����ü
struct node
{
	int data;		
	struct node *link;		// �ڽ��� Ÿ���� ������ �� �ִ� ����ü ������
};

void main()
{
	struct node item1,item2, item3;			//node ����ü ���� ����

	item1.data = 100;
	item2.data = 300;
	item3.data = 200;
	item1.link = item2.link = item3.link = NULL;		//��� �����͸� NULL�� �ʱ�ȭ

	item1.link = &item3;	 //100������ ó���� 200�� ����� �ּҸ� �־��ش�.
	item3.link = &item2;	//200������ ó���� 300�� ����� �ּҸ� �־��ش�.
	item2.link = &item1;	//������ ������ ó�� �� ó�� �����ͷ� �̵��Ѵ�. ������ �����.

	cout <<  "item1.data : " << item1.data << endl;
	printf("item1.data : %d/n", item1.data);
	cout << "item3.data : " << item1.link->data << endl;  // 	cout << "item3.data : " << (*item1.link).data << endl;
	cout << "item2.data : " << item1.link->link->data << endl;
}
