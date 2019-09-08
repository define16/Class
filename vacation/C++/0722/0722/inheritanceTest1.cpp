#include "config.h"

class Parent {
protected:
//	char name[21];
	string name;
	bool gender;
public:
//	Parent(char name[21] = "무명씨", bool gender = false) {
	Parent(string name = "무명씨", bool gender = false) {
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
		cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}

};

class Child : public Parent {
private:
	int age;
	char nickName[21];
public:
//	부모 클래스로 부터 상속받은 멤버 변수의 접근 권한이 protected일 경우 this 초기화가
//	가능하다.
	Child(string name, bool gender, int age, char nickName[21]) {
//		strcpy_s(this->name, name);
		this->name = name;
		this->gender = gender;
		this->age = age;
		strcpy_s(this->nickName, nickName);
	}

	void toString() {
		cout << name << "(" << (gender ? "남" : "여") << ") - " << 
			age << ", " << nickName << endl;
	}
};

void main() {

	class Parent parent1;
	parent1.toString();
	class Parent parent2("홍길동", true);
	parent2.toString();

	parent2.setName("임꺽정");
	parent2.toString();
	cout << parent2.getName() << endl;

	class Child child1("성춘향", false, 16, "이쁘니");
	child1.toString();

}