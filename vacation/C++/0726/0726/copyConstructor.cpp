#include "config.h"

class Data {
private:
	char name[21];			// 배열, 정적 할당(실 기억공간을 가지고 있다.)
	int age;
public:
//	Data(char name[21], int age) {
	Data(char *name, int age) {
		strcpy_s(this->name, name);
		this->age = age;
	}

//	복사 생성자
//	자기 자신의 클래스와 타입이 같은 객체를 레퍼런스(참조형) 인수로 받는 생성자를 말한다.
//	C++ 컴파일러는 복사 생성자를 정의하지 않으면 자동으로 만들어준다.
	Data(Data &D) {
//		cout << "복사 생성자가 실행됩니다." << endl;
		strcpy_s(this->name, D.name);
		this->age = D.age;
	}

	void toString() {
		cout << name << "님 " << age << "살 이네요" << endl;
	}
};

void main() {

	class Data data1("홍길동", 10);
	data1.toString();
	class Data data2 = data1;		// 기본 복사 생성자가 실행된다.
	data2.toString();
	class Data data3(data1);		// 기본 복사 생성자가 실행된다.
	data3.toString();

}