#include "config.h"

class Data {
private:
//	Ŭ������ ��� ������ �����ͷ� �����ϸ� �� ��� ������ �����Ƿ� �ݵ�� �����ڿ���
//	���ϴ� ũ�� ��ŭ �޸𸮸� �Ҵ��ϰ� �ʱ�ȭ �����ش�.
	char *name;				// ������ ����, �� ��� ������ ���� ����
	char *phone;
	int age;
public:
	Data(char *name, char *phone, int age) {
//		�����Ͱ� �޸𸮿� ������ �ּҸ� ����� ���ǹǷ� �Ʒ� ����� ������� �ʴ´�.
//		this->name = name;
//		this->phone = phone;

//		��� ������ �����ͷ� ������ ��� �Ѿ���� ���ڿ��� ũ�⸦ strlen() �Լ��� �����
//		���� �� ũ�� + 1 ��ŭ �޸𸮸� �Ҵ��� �� strcpy_s() �Լ��� �̿��ؼ� �ʱ�ȭ
//		�����ش�.
//		strlen() : ��ȣ ���� NULL ���ڸ� ������ ���ڿ��� ũ�⸦ ����Ʈ ������ ���Ѵ�.
//		strcpy_s(�纻, ����) : �纻�� �迭�� ���
//		strcpy_s(�纻, ���ڿ�ũ��, ����) : �纻�� �������� ���

		this->name = (char*)malloc(sizeof(char) * strlen(name) + 1);	//	C
		strcpy_s(this->name, strlen(name) + 1, name);
		this->phone = new char[strlen(phone) + 1];						// C++
		strcpy_s(this->phone, strlen(phone) + 1, phone);
		this->age = age;
	}

	~Data() {
//		cout << "�Ҹ��ڰ� ����˴ϴ�." << endl;
		free(name);
		delete[] phone;
	}

	void toString() {
		cout << "�̸� : " << name << ", ��ȭ��ȣ : " << phone << ", ���� :" << 
			age << endl;
	}
	void setName(char *name) {
		strcpy_s(this->name, strlen(name) + 1, name);
	}

	Data(Data &D) {							// ���� ������
//		�Ʒ� ������ �⺻ ���� �����ڿ� �ڵ����� �ڵ��Ǵ� �����̴�.
//		���� �������� �ּҰ� �纻 �������� �ּҷ� �Ѱ����� �纻�� �ʱ�ȭ �ȴ�.
//		������ �纻�� ���� �������� �ּҸ� ����ϰ� �ȴ�.
//		���� ���� ����Ǵ� ���� �ƴϰ� �ּҰ� ����ȴ�. �̸� ���� ����� �Ѵ�.
		this->name = D.name;
		this->phone = D.phone;
		this->age = D.age;
	}

};

void main() {

	class Data data1("ȫ�浿", "111-1111", 20);
	cout << "data1 : "; data1.toString();
	class Data data2(data1);				// ���� �����ڰ� ����ȴ�.
	cout << "data2 : "; data2.toString();

//	C++�� �ڵ����� ������ִ� �⺻ ���� �����ڴ� ���ڿ��� �����ͷ� ó���ϴ� ��� �Լ���
//	����ؼ� ���� �־��ִ� ����� �ƴ϶� this �ʱ�ȭ�� ���ؼ� ������ �ּҸ� �־��ش�.
//	������ �����Ͱ� ����Ǹ� �� ������ �ּҸ� ����ϰ� �ִ� �纻�� �����Ͱ� ���� ����Ǵ�
//	�������� �߻��ȴ�.
	data1.setName("�Ӳ���");
	cout << "data1 : "; data1.toString();
//	�⺻ ���� �����ڸ� �̿��� ���� data2�� ��� name�� ������ data1�� name�� ����� ��������
//	�ּҸ� ����ϰ� �ȴ�.
	cout << "data2 : "; data2.toString();

//	���� �����ڸ� �������̵� ���� ������ data1�� �޸𸮿��� �Ҹ�� �� data1���� �Ҵ��
//	�޸𸮰� �Ҹ�ȴ�.
//	�⺻ ���� �����ڸ� ����� ���� data2�� data1���� �Ҵ�� ���� �޸��� �ּҸ� �״�� 
//	�Ѱ� �޾����Ƿ� data1�� �Ҹ�� �� data1���� �Ҵ�� �޸𸮰� �Ҹ�Ǹ� data2�� �Ҹ��
//	�� data2�� data1�� ���� �ּҸ� �˰� �����Ƿ� �Ҹ��ų �޸𸮰� �����Ƿ� ������ �߻��ȴ�.

}