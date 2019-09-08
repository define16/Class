#include "config.h"

class Sungjuk
{	
	private:		
		int no;	
		char name[21];
		int cpp, java, python, total;
		double average;
		char hajum;

	public:
		/*Sungjuk()
		{
			no = 0;
			strcpy_s(name,"홍길동씨"); 
			cpp = 0;
			java = 0;
			python = 0;
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
		}*/


//디폴트인수를 이용해 기본 생성자가 실행되면 기본값으로 초기화 시키고 값을 넘겨받은 
//생성자가 실행되면 넘겨 받은 값으로 멤버를 초기화 시키는 생성자
//디폴트인수는 지정하려면 모든 인수에 지정해야 한다.
		Sungjuk(int no  = 0, char name[21] = "무명씨", int cpp  = 0, int java  = 0, int python  = 0){
			this->no = no; 
			strcpy_s(this ->name,name);  
			this->cpp = cpp;
			this->java = java;
			this->python = python;
			this->hajum = hajum;
			calc();
		}



		~Sungjuk()
		{
			cout << "객체가 소멸됩니다."<<endl;
		}

//클래스의 멤버 함수를 클래스 외부에서 정의할 수 있다.
//클래스 내부에는 외부에서 정의할 함수의 원형을 적어주고 클래스 외부에서 함수를 정의할 때 반드시
//소속 클래스 "::"를 사용해 알려주면 된다.
		void toString();	 //void Sungjuk :: toString() 
		void calc();		//	void Sungjuk :: calc()
};
	void Sungjuk :: toString() 
	{
		cout << name << "님의 평균은 " << average << "점이고 학점은 " << hajum << "입니다." << endl;
	}

	void Sungjuk :: calc()
	{
		total = cpp + java + python;
		average = (double)total / 3;

		switch((int)average/10)
		{
		case 10: case 9: hajum = 'A'; break;
		case 8: hajum = 'B'; break;
		case 7: hajum = 'C'; break;
		case 6: hajum = 'D'; break;
		default : hajum = 'F';
			}
	}

void main()
{
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk(); 
	s1.toString(); 
	s2->toString();

	class Sungjuk s3(1,"홍길동", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2,"임꺽정",85,79,88);
	s3.toString();
	s4->toString();

// 객체지향 언어의 private 접근 권한이 너무 엄격하게 적용되므로 private권한으로 설정된 멤버에 접근이
// 가능하도록 예외(getter & setter함수, friend 설정)를 둔다.

// getter 함수 : get으로 시작하고 멤버 이름이 나오는 함수로 private 멤버의 값을 얻어올 때 사용한다.
// getter는 함수의 리턴 타입은 멤버의 자료형이고 인수는 받지 않는다.
//	 int getJava()
//	 {
//		 return java;
//	 }
//	 setter 함수 : set으로 시작하고 멤버 이름이 나오는 함수로 private 멤버의 값을 수정할 때 사용한다.
// setter는 함수의 리턴 타입은 void이고 인수로 멤버에 저정할 데이터를 받는다.
//	 void setJava(int java)
//	 {
//	 	 this->java = java;
//	 }

//	s3.java = 97;


	delete s2; delete s4;
}