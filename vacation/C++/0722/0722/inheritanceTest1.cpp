#include "config.h"

class Parent {
protected:
//	char name[21];
	string name;
	bool gender;
public:
//	Parent(char name[21] = "����", bool gender = false) {
	Parent(string name = "����", bool gender = false) {
//		strcpy_s(this->name, name);
		this->name = name;
		this->gender = gender;
	}

//	char *getName() {
	string getName() {
		return name;
	}
//	void setName(char name[21]) {
	void setName(string name) {
//		strcpy_s(this->name, name);
		this->name = name;
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

class Child : public Parent {
private:
	int age;
	char nickName[21];
public:
//	�θ� Ŭ������ ���� ��ӹ��� ��� ������ ���� ������ protected�� ��� this �ʱ�ȭ��
//	�����ϴ�.
	Child(string name, bool gender, int age, char nickName[21]) {
//		strcpy_s(this->name, name);
		this->name = name;
		this->gender = gender;
		this->age = age;
		strcpy_s(this->nickName, nickName);
	}

	void toString() {
		cout << name << "(" << (gender ? "��" : "��") << ") - " << 
			age << ", " << nickName << endl;
	}
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