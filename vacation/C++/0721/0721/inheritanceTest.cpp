#include "config.h"

//	부모(상위, 슈퍼, 기반) 클래스
class Parent {
private:
	char name[21];
	bool gender;
public:
	/*
	Parent() {
		strcpy(name, "무명씨");
		gender = false;
	}
	Parent(char name[21], bool gender) {
		strcpy(this->name, name);
		this->gender = gender;
	}
	*/
	Parent(char name[21] = "무명씨", bool gender = false) {
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
		cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}

};

//	자식(하위, 서브, 파생) 클래스
//	상속의 형식
//	class 자식클래스이름 : 상속권한지정자 부모클래스이름

//	상속 권한 지정자
//	private : 부모 클래스 멤버의 접근 권한에 상관없이 모두 private으로 상속된다.
//	protected : 부모 클래스 멤버의 접근 권한이 private은 private로 나머지는 protected로
//              상속된다.
//	public : 부모 클래스 멤버의 접근 권한 그대로 상속된다.


//	Parent 클래스를 상속받아 Child 클래스를 만든다.
class Child : public Parent {
//	Parent 클래스를 상속받았으므로 Parent 클래스이 모든 멤버 변수와 함수를 정의하지 않아도
//	정의한 것 처럼 private 빼고 사용할 수 있다.
private:
	int age;
	char nickName[21];
public:
//	자식 클래스의 생성자는 자식 클래스의 멤버 변수를 초기화 시킬 값만 받으면 안되고 부모
//	클래스로 부터 상속받은 멤버 변수를 초기화 시킬 값도 받아줘야 한다.
//	부모 클래스로 부터 상속받은 멤버 변수의 접근 권한이 private일 경우 this 초기화를 할 수
//	없고 부모 클래스의 생성자를 실행해서 초기화 시켜야 한다.
	Child(char name[21], bool gender, int age, char nickName[21]) : Parent(name, gender) {
		this->age = age;
		strcpy_s(this->nickName, nickName);
	}

//	Parent 클래스로 부터 상속받은 toString() 함수는 이름과 성별만 출력할 수 있으므로 자식
//	클래스의 멤버 값을 출력할 수 없다.
//	부모 클래스로 부터 상속받은 함수가 마음에 들지 않으면 자식 클래스에서 다시 만들어서
//	사용하면 되는데 이를 함수의 override라 부른다.
	void toString() {
		cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
	}
//	성춘향(여) - 16, 이쁘니
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