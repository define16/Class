#include "config.h"

class Sungjuk
{	//일반적으로 멤버변수는 private을 멤버 함수는  public을 접근권한으로 설정한다.
private:		//한번 설정한 접근 권한은 다른 접근 권한을 설정하기 전까지 유지된다.
	int no;		//초기화가 불가능하다.
	char name[21];
	int cpp, java, python, total;
	double average;
	char hajum;
public:
// 멤보 변수를 초기화 하기 위해 생성자 함수(이하 생성자)를 만든다.
// 생성자를 만들지 않으면 C++컴파일러가 아무런 일도 하지 않는 기본 생성자를 만든다.
// 생성자 이름은 반드시 클래스의 이름과 같아야 하고, 클래스의 객체가 생성되는 순간 
// 자동으로 실행이 된다.
// 생성자는 return을 가지지 않으며 리턴타입(void)도 사용하지 않는다.

	//기본 생성자도 초기화를 시켜주어야한다.
	Sungjuk() : no(0), cpp(0), java(0), python(0)//생성자 옆에 ":"를 찍어서 초기화 리스트를 사용할 수 있다.
	{
//		no = 0;
		strcpy_s(name,"홍길동씨");  // 문자 배열은 초기화 리스트를 이용해서 초기화를 할 수가 없다
//		cpp = 0;
//		java = 0;
//		python = 0;
		hajum = 0;
		calc();


	}

	Sungjuk(int no,char name[21],int cpp, int java, int python){
		this->no = no; 
		strcpy_s(this ->name,name);  
		this->cpp = cpp;
		this->java = java;
		this->python = python;
		this->hajum = hajum;
		calc();
	}
	void calc()
	{
			total = cpp + java + python;
			average = (double)total / 3;

			switch((int)average/10){
			case 10: case 9: hajum = 'A'; break;
			case 8: hajum = 'B'; break;
			case 7: hajum = 'C'; break;
			case 6: hajum = 'D'; break;
			default : hajum = 'F';
			}
	}
	

	~Sungjuk()
	{
		cout << "객체가 소멸됩니다."<<endl;
	}

	//객체에 저장된 내용을 출력하는 함수
	void toString()
	{
		cout << name << "님의 평균은 " << average << "점이고 학점은 " << hajum << "입니다." << endl;
	}

	//생성자에서 총점, 평균, 학점을 계산하는 함수


};



void main()
{
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk(); 
	s1.toString(); //자주색 육면체는 함수이다.
	s2->toString();

	class Sungjuk s3(1,"홍길동", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2,"임꺽정",85,79,88);
	s3.toString();
	s4->toString();

	//delete는 따로 쓰기.
	delete s2; delete s4;
}