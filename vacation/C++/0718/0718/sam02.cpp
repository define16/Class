#include "config.h"

class Sungjuk {
//	일반적으로 멤버 변수는 private을 멤버 함수는 public을 접근 권한으로 설정한다.
private:	// 한 번 설정한 접근 권한은 다른 접근 권한을 설정하기 전까지 유지된다.
	int no;
	char name[21];
	int cpp, java, python, total;
	double average;
	char hakjum;
public:
//	멤버 변수를 초기화 하기 위해 생성자 함수(이하 생성자)를 만든다.
//	생성자를 만들지 않으면 C++ 컴파일러가 아무런 일도 하지 않는 기본 생성자를 만든다.
//	생성자 이름은 반드시 클래스의 이름과 같아야 하고 클래스의 객체가 생성되는 순간 자동으로
//	실행된다.
//	생성자는 return을 가지지 않으며 리턴 타입도 가지지 않는다.

	Sungjuk() {		// 기본 생성자
		cout << "기본 생성자가 실행됩니다." << endl;
	}

//	멤버를 초기화 시키는 생성자
	Sungjuk(int no, char name[21], int cpp, int java, int python) {
//		같은 {} 블록에 멤버 변수와 지역 변수가 같은 이름을 가질 경우 지역 변수에 우선권이
//		부여된다. 즉, 변수 이름만 적으면 지역 변수로 인식된다.
//		this : 자기 자신의 클래스를 의미하는 포인터
		this->no = no;
//		this->name = name;				// 문자열 초기화는 "="을 사용할 수 없다.
		strcpy_s(this->name, name);		// 문자열 초기화는 요렇게 해야한다.
		this->cpp = cpp;
		this->java = java;
		this->python = python;
		total = cpp + java + python;
		average = (double)total / 3;
		switch((int)average / 10) {
			case 10: case 9:
				hakjum = 'A'; break;
			case 8:
				hakjum = 'B'; break;
			case 7:
				hakjum = 'C'; break;
			case 6:
				hakjum = 'D'; break;
			default:		// 기타 등등 케이스
				hakjum = 'F';
		}
	}
};

void main() {

//	아래의 2가지 방법 모두 기본 생성자를 이용해 객체가 생성된다.
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk();

//	문자 배열에 "="으로 값을 넣을 수 있는 경우는 배열을 선언할 때만 가능하다.
	char name[21] = "홍길동";
	cout << name << endl;
//	name = "임꺽정";	// 배열 선언 후 "="으로 값을 넣었으므로 에러가 발생된다.
//	strcpy_s(배열명, 배열에 저장할 문자열);
	strcpy_s(name, "임꺽정");
	cout << name << endl;

	delete s2;

}