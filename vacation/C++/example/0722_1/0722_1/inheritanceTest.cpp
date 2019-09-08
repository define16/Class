#include "config.h"


class Parent{
	protected :
//		char name[21];
		string name;
		bool gender;
	public :
		Parent(char name[21] = "무명씨", bool gender = false)
		{
			this->name = name;
			this->gender = gender;
		}
		string getName()
		{
			return name;
		}

		void setName(string name)
		{
			this->name = name;
		}

		 bool isgender()	
		 {
			 return gender;
		 }

		 void setGender(bool gender)
		 {
			 	this->gender = gender;
		 }

		void toString()
		{
			cout << name << "(" << (gender ? "남" : "여") << ")" << endl;
		}	 
};

class Child : public Parent {

	private : 
		int age;
		char nickName[21];
	public :

		Child(char name[21], bool gender, int age, char nickName[21] )
//	 부모 클래스로 부터 상속받은 private 멤버의 setter함수가 준비되어 있다면 부모 클래스의
// 생성자를 호출하지 않고 setter 함수로 초기화 시킬 수 있다.

// 부모 클래스로부터 상속받은 멤버 변수의 접근 권한이 protected일 경우 this 초기화가 가능하다.
		{
			this->name = name;
			this->gender = gender;
			this->age = age;
			strcpy_s(this->nickName,nickName);
		}


		void toString() 
		{
			cout << name << "(" <<( gender ? "남" : "여") << ") - " <<  age << ", "<< nickName<< endl;
// 부모 클래스로 부터 상속받은 함수에 기능을 추가해서 재정의를 해야 할 경우에는
// 부모 클래스로 부터 상속받은 함수를 재정의 하지 말고 부모 클래스의 함수를 실행하고
// 자식 클래스에서 추가되는 기능만 넣어주면 된다.
			Parent::toString();		//부모(Parent) 클래스의 toString() 함수를 실행한다.
			cout << " - " << age << ", " << nickName << endl;		//자식 클래스에서 기능 추가
		}	 


};
void main()
{
	class Parent parent1;
	parent1.toString();
	class Parent parent2("홍길동", true);
	parent2.toString();

	parent2.setName("임꺽정");
	parent2.toString();

	cout << parent2.getName() << endl;

	class Child child1("성춘향", false,16,"이쁜이");
	child1.toString();
}
