#include "config.h"

class Sungjuk {
private:
	int no;
	char name[21];
	int cpp, java, python, total;
	double average;
	char hakjum;
public:
//	생성자 옆에 ":"를 찍어서 초기화 리스트를 사용할 수 있다.
//	초기화 리스트를 이용해 생성자에서 멤버를 초기화 시킬 수 있다.
//	문자 배열은 초기화 리스트를 이용해 멤버를 초기화 시킬 수 없다.
	Sungjuk() : no(0), /*name("무명씨"),*/cpp(10), java(10), python(10) {
//		no = 0;
		strcpy_s(this->name, "무명씨");
//		cpp = 0;
//		java = 0;
//		python = 0;
		calc();
	}
	Sungjuk(int no, char name[21], int cpp, int java, int python) {
		this->no = no;
		strcpy_s(this->name, name);
		this->cpp = cpp;
		this->java = java;
		this->python = python;
		calc();
	}
//	생성자에서 총점, 평균, 학점을 계산하는 함수
	void calc() {
		total = cpp + java + python;
		average = (double)total / 3;
		switch((int)average / 10) {
			case 10: case 9: hakjum = 'A'; break;
			case 8: hakjum = 'B'; break;
			case 7: hakjum = 'C'; break;
			case 6: hakjum = 'D'; break;
			default: hakjum = 'F';
		}
	}

//	소멸자(파괴자) 함수(이하 소멸자)
//	소멸자의 이름은 클래스 이름 앞에 "~"를 붙이면 된다.
//	소멸자는 객체가 소멸되는 순간 자동으로 실행되며 생성자에서 동적으로 메모리를 할당한 경우
//	할당된 동적 메모리를 해제하려는 목적으로 주로 사용된다.
	~Sungjuk() {
//		cout << "객체가 소멸됩니다." << endl;
	}

//	객체에 저장된 내용을 출력하는 함수
	void toString() {
		cout << name << "님의 평균은 " << average << "점 이고 학점은 " << hakjum << " 입니다." << endl;
//		printf("%s님의 평균은 %6.2f점 이고 학점은 %c입니다.\n", name, average, hakjum);
	}

};

void main() {

	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk();
	s1.toString();
	s2->toString();

	class Sungjuk s3(1, "홍길동", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2, "임꺽정", 85, 79, 88);
	s3.toString();
	s4->toString();

	delete s2;
	delete s4;

}