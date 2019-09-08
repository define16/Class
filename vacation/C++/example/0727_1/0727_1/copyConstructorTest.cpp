#include "config.h"

class Memo {
private : 
	char *name;
	char *phone;
	int age;
public :
	Memo(char *name = "����", char *phone = "����", int age = 0){
//		����� �����ͷ� ���������� �Ѿ�� ���ڿ��� ũ�� ��ŭ �޸𸮸� �����Ҵ��ϰ� �ʱ�ȭ�Ѵ�.
//		�޸𸮸� �������� �Ҵ��ϰ� �Ҵ�� �޸��� ���� �ּҸ� �����Ϳ� �־��ش�.
//		�����ڿ��� ���� �Ҵ�� �޸𸮴� �Ҹ��ڿ��� �����ؾ��Ѵ�.
		this->name=(char*)malloc(sizeof(char)*strlen(name)+1);
		strcpy_s(this->name,strlen(name)+1,name);
		this->phone = new char[strlen(phone)+1];
		strcpy_s(this->phone,strlen(phone)+1,phone);
		this->age = age; 
	}
// ���� �����ڸ� �������̵� ���� ������ C++�����Ϸ��� �⺻ ���� �����ڸ� �����.
// ���� �����ڴ� �����͸� �׳� this �ʱ�ȭ�� �ع�����.
// ���� �����ڴ� ������ ������ Ÿ���� ������ ������ �μ��� ������ �������̴�.

// C++�� �ڵ����� ������ִ� ���� ������
// ���� : 1.������ �纻�� ���� �ٲ��. 2.�����޸𸮸� ��ü�� ��� ������ �߻��Ѵ�.
//	Memo(Memo &M) {
//// this�ʱ�ȭ�� �ϸ� �����Ϳ� ����� �ּҸ� �Ѿ��.
//// ��������� ���� �����Ǵ� ��ü�� �����Ϳ� ����Ǵ� �ּҿ� �μ��� �Ѿ��
//// ��ü�� �����Ϳ� ����� �ּҰ� ����.
////  �̿� ���� �ּҸ� �Ѱ��ִ� ����� ���� ����� �ϰ� ���� ���縦 �ϰ� �Ǹ�
//// ������ �纻�� ���� �����͸� ������ ����Ѱ� �ȴ�.
//		this->name = M.name;
//		this->phone = M.phone;
//		this->age = M.age;
//	}

	Memo(Memo &M){
// ���� �����ڸ� �������̵��ؼ� ���� �����ڷ� �����Ǵ� ��ü�� �޸𸮸� ��������
// �Ҵ��� �� ��� ������ ����� �ְ� ���� �Ѱ��ָ� ������ �纻�� ���� �ٸ�
// �޸𸮸� ����ϹǷ� ������ ����ǵ� �纻�� ������� �ʴ´�.
// �̿� ���� �� ��� ������ ����� �ּҰ� �ƴ� ���� �Ѱ��ִ� ����� ���� ����� �θ���.
		this->name = (char*)malloc(sizeof(char)*strlen(M.name)+ 1);
		strcpy_s(this->name,strlen(M.name)+ 1,M.name);
		this->phone = new char[strlen(M.phone)+ 1]; // C++�� �����޸� �Ҵ�.
		strcpy_s(this->phone,strlen(M.phone)+ 1,M.phone);
		this -> age = M.age;
	}


	~Memo() {
// �Ҹ��ڿ��� �����ڿ��� �Ҵ��� ���� �޸𸮸� �Ҵ��� ��� memo2�� ������ �� �Ҵ�� ���� �޸𸮰� ������ ��
// memo3���� �Ҵ�� ���� �޸𸮸� �����Ϸ� �ϴϱ� ������ �޸𸮰� �������� �����Ƿ� ������ �߻��Ѵ�.
		cout << "�Ҹ��ڰ� ����˴ϴ�." << endl;
		free(name);
		delete[]phone;		//�������� []�� ���̰� �ϳ��� ������ �ʴ´�.
	}

	void setName(char *name) {
// �����ڿ��� ���� �Ҵ����� �޸𸮸� Ȯ�������Ƿ� ���⼭�� �ϸ� �ȵȴ�.
		strcpy_s(this->name,strlen(name)+1,name);
	}
	void toString() {
		cout << "�̸� : " << name << ", ��ȭ��ȣ : " << phone << ", ���� : " << age << endl;
	}
};

void main(){

	Memo memo1;
	cout << "memo1 : "; memo1.toString();
	Memo memo2("ȫ�浿", "111-1111",20);
	cout << "memo2 : "; memo2.toString();
	Memo memo3(memo2);
	cout << "memo3 : "; memo3.toString();
//	setter�� �̿��� memo2�� name�� �����Ѵ�.
//	memo2�� name�� memo3�� name�� ���� �޸𸮸� ����ϰ� �����Ƿ�
//	memo2�� name�� ����� ��� 
	memo2.setName("�Ӳ���");
	cout << "memo2 : "; memo2.toString();
	cout << "memo3 : "; memo3.toString();

// ���� �����ڸ� �̿��� ��쿡�� �����͸� �̿��� ����� ���� ����� �ƴϴ�.
	Memo *memo4 = new Memo();
	cout << "memo4 : ";memo4 ->toString();
	Memo *memo5 = new Memo("����", "222-2222",20);
	cout << "memo5 : ";memo5 ->toString();
	Memo *memo6(memo5);
	cout << "memo6 : ";memo6 ->toString();

// Ŭ������ ��ü�� ������ �����ϸ鼭 ���� �Ҵ�� ��ü�� ������ ���� ��������
// �μ��� �Ѱܾ� �� ��� ���� �Ҵ�� ��ü�� �����ϴ� ������ �Ѱ���� �Ѵ�.
	Memo memo7(*memo5);
	cout << "memo7 : ";memo7.toString();
	delete memo4;		//new�� �Ҹ� ���� ����
	delete memo5;	
//	delete memo6;	
}