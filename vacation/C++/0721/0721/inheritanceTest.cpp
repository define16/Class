#include "config.h"

//	�θ�(����, ����, ���) Ŭ����
class Parent {
private:
	char name[21];
	bool gender;
public:
	/*
	Parent() {
		strcpy(name, "����");
		gender = false;
	}
	Parent(char name[21], bool gender) {
		strcpy(this->name, name);
		this->gender = gender;
	}
	*/
	Parent(char name[21] = "����", bool gender = false) {
		strcpy_s(this->name, name);
		this->gender = gender;
	}

	char *getName() {
		return name;
	}
	void setName(char name[21]) {
		strcpy_s(this->name, name);
	}
	bool isGender() {
		return gender;
	}
	void setGender(bool gender) {
		this->gender = gender;
	}

	void toString() {
		cout << name << "(" << (gender ? "��" : "��") << ")" << endl;
	}

};

//	�ڽ�(����, ����, �Ļ�) Ŭ����
//	����� ����
//	class �ڽ�Ŭ�����̸� : ��ӱ��������� �θ�Ŭ�����̸�

//	��� ���� ������
//	private : �θ� Ŭ���� ����� ���� ���ѿ� ������� ��� private���� ��ӵȴ�.
//	protected : �θ� Ŭ���� ����� ���� ������ private�� private�� �������� protected��
//              ��ӵȴ�.
//	public : �θ� Ŭ���� ����� ���� ���� �״�� ��ӵȴ�.


//	Parent Ŭ������ ��ӹ޾� Child Ŭ������ �����.
class Child : public Parent {
//	Parent Ŭ������ ��ӹ޾����Ƿ� Parent Ŭ������ ��� ��� ������ �Լ��� �������� �ʾƵ�
//	������ �� ó�� private ���� ����� �� �ִ�.
private:
	int age;
	char nickName[21];
public:
//	�ڽ� Ŭ������ �����ڴ� �ڽ� Ŭ������ ��� ������ �ʱ�ȭ ��ų ���� ������ �ȵǰ� �θ�
//	Ŭ������ ���� ��ӹ��� ��� ������ �ʱ�ȭ ��ų ���� �޾���� �Ѵ�.
//	�θ� Ŭ������ ���� ��ӹ��� ��� ������ ���� ������ private�� ��� this �ʱ�ȭ�� �� ��
//	���� �θ� Ŭ������ �����ڸ� �����ؼ� �ʱ�ȭ ���Ѿ� �Ѵ�.
	Child(char name[21], bool gender, int age, char nickName[21]) : Parent(name, gender) {
		this->age = age;
		strcpy_s(this->nickName, nickName);
	}

//	Parent Ŭ������ ���� ��ӹ��� toString() �Լ��� �̸��� ������ ����� �� �����Ƿ� �ڽ�
//	Ŭ������ ��� ���� ����� �� ����.
//	�θ� Ŭ������ ���� ��ӹ��� �Լ��� ������ ���� ������ �ڽ� Ŭ�������� �ٽ� ����
//	����ϸ� �Ǵµ� �̸� �Լ��� override�� �θ���.
	void toString() {
		cout << name << "(" << (gender ? "��" : "��") << ")" << endl;
	}
//	������(��) - 16, �̻ڴ�
};


void main() {

	class Parent parent1;
	parent1.toString();
	class Parent parent2("ȫ�浿", true);
	parent2.toString();

	parent2.setName("�Ӳ���");
	parent2.toString();
	cout << parent2.getName() << endl;

	class Child child1("������", false, 16, "�̻ڴ�");
	child1.toString();

}