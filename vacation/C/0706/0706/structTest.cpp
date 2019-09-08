#include "config.h"

//	구조체(struct), 복합 자료형, 사용자 정의 자료형
//	실제 작업에 사용되는 자료형은 1가지 자료형으로만 구성되지 않고 여러 자료형이 섞여서 구성된다.
//	기본 자료형을 묶어서 실제 작업에 필요한 새로운 자료형을 프로그래머가 만들어 사용할 수 있는데 이를 구조체라 한다.
//	구조체에는 데이터를 기억하는 멤버 변수만 존재한다. 구조체에 데이터를 처리할 수 있는 함수를 추가한 것을 클래스라
//	부른다.

//	struct 구조체이름 {
//		구조체 멤버 변수 선언;				// 멤버 변수 선언과 동시에 "="을 사용해 초기화 할 수 없다.
//		...;
//	};										// ";" 빼먹으면 에러가 발생된다.

struct Sungjuk {							// 구조체 선언, 설계도
	int no;
	char name[11];
	int java;
	int jsp;
	int spring;
	int total;
	double average;
	int rank;
};

void main() {

//	구조체 변수 선언
//	struct 구조체이름 변수명;				// 구조체 변수 선언
//	struct 구조체이름 변수명 = {초기치};	// 구조체 변수 선언후 초기화 한다.
//	struct 구조체이름 배열명[첨자];			// 구조체 배열 선언
//	struct 구조체이름 *포인터명;			// 구조체 포인터 선언

	struct Sungjuk s1;

//	구조체 멤버에 접근하는 방법
//	구조체변수명.멤버명
//	구조체배열명[첨자].멤버명
//	구조체포인터->멤버명

	s1.java = 100;
	s1.jsp = 100;
	s1.spring = 100;
	s1.total = s1.java + s1.jsp + s1.spring;
	s1.average = (double)s1.total / 3;

	struct Sungjuk *p1;
	p1 = &s1;

	cout << s1.average << endl;
	cout << p1->average << endl;

}