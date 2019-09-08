#include "config.h"

class Data {
private:
	char name[21];			// �迭, ���� �Ҵ�(�� �������� ������ �ִ�.)
	int age;
public:
//	Data(char name[21], int age) {
	Data(char *name, int age) {
		strcpy_s(this->name, name);
		this->age = age;
	}

//	���� ������
//	�ڱ� �ڽ��� Ŭ������ Ÿ���� ���� ��ü�� ���۷���(������) �μ��� �޴� �����ڸ� ���Ѵ�.
//	C++ �����Ϸ��� ���� �����ڸ� �������� ������ �ڵ����� ������ش�.
	Data(Data &D) {
//		cout << "���� �����ڰ� ����˴ϴ�." << endl;
		strcpy_s(this->name, D.name);
		this->age = D.age;
	}

	void toString() {
		cout << name << "�� " << age << "�� �̳׿�" << endl;
	}
};

void main() {

	class Data data1("ȫ�浿", 10);
	data1.toString();
	class Data data2 = data1;		// �⺻ ���� �����ڰ� ����ȴ�.
	data2.toString();
	class Data data3(data1);		// �⺻ ���� �����ڰ� ����ȴ�.
	data3.toString();

}