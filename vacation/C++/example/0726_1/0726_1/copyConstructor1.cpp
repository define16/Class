#include "config.h"

class Data {
private : 
// 클래스의 멤버 변수를 포인터로 선언하면 실 기억공간이 없으므로 반드시 생성자에서 
// 원하는 크기 만큼 동적 메모리를 할당 하고 초기화 시켜준다.
	char *name;		
	char *phone;		//포인터 선언, 실 기억공간이 없는 상태
	int age;
public :
		Data(char *name, char *phone, int age){
//			데이터가 메모리에 생성된 주소만 멤버에 기억되므로 아래 방식을 사용하지 않는다.
//			this->name = name;		데이터 메모리에 생성된 주소만 멤버에 기억된다.
//			this->phone = phone;
//			멤버 변수를 포인터로 선언한 경우 넘어오는 문자열의 크키를 strlen()함수를
//			사용해 얻어내고 얻어낸 크키 만큼 메모리를 할당한 후 strcpy()함수를 이용해서 
//			초기화 시켜준다.
//			strlen() : 괄호 안의 NULL문자를 제외한 나머지 문자열을 크기를 바이트 단위로 구한다.
//			strcpy(사본, 원본);
//			strcpy_s(사본, 문자열크기, 원본);

//			strcpy_s(사본, 원본); : 사본이 배열일 경우
//			strcpy_s(사본, 문자열크기, 원본); : 사본이 포인터일 경우
			 
			this->name = (char*)malloc(sizeof(char) * strlen(name) +1);  // C
			strcpy_s(this->name,strlen(name)+1, name); // +1을 꼭해주자!! 문자열이라서 뒤에 NULL이 붙기 때문이다.
			this->phone = new char[strlen(phone) +1];  // C++
			strcpy(this->phone, phone);
			this->age = age;
		}

~Data(){
	cout << "소멸합니다" << endl; 
		/*	free(name);
			delete[] phone;*/
		}

	Data(Data &D){		// 복사생성자
// 아래 내용은 기본 복사 생성자에 자동으로 코딩되는 내용이다.
// 원본 데이터의 주소가 사본 데이터의 주소로 넘겨져서 사본이 초기화된다.
// 원본과 사본은 같은 데이터의 주소를 기억하게 된다.
// 실제 값이 복사되는 것이 아니고 주소가 복사된다. 이를 얕은 복사라 한다.
		this->name = D.name;
		this->phone = D.phone;
		this->age = D.age;

	}

	void setName(char *name)
	{
		strcpy(this->name, name);
	}

	void toString(){
		cout << "이름 : " << name << ", 전화번호 : " << phone << ", 나이 : " << age << endl;	
	}

};

void main()
{
	class Data data1("홍길동","111-1111",10);
	cout << "data1 : "; data1.toString();
	class Data data2(data1);
	cout << "data2 : "; data2.toString();

// C++이 자동으로 만들어주는 기본 복사 생성자는 문자열을 포인터로 처리하는 경우 함수를
// 사용해서 값을 넣어주는 방식이 아니라 this 초기화를 통해서 원본의 주소를 넣어준다.
// 원본은 데이터가 변경되면 그 원본의 주소를 기억하고 있던 사본의 데이터가 같이 변경되는 
// 문제점이 발생된다.
	data1.setName("임꺽정");
	cout << "data1 : "; data1.toString();
// 기본 복사 생성자를 이용해 만든 data2클래스의 멤버 name은 원본인 data1의 name에 저장된
// 데이터의 주소를 기억하게 된다.
	cout << "data2 : "; data2.toString();

// 복사 생성자를 오버라이드 하지 않으면 data1이 메모리에서 소멸 될 때 data1에서 할당된
// 메모리가 소멸된다.
// 기본 복사 생성자를 사용해 만든 data2는 data1에서 할당된 동적 메모리의 주소를 그대로
// 넘겨 받았으므로 data1이 소멸될 때 data1에서 할당된 메모리가 소멸되면 data2가 소멸 될 때
// data2는 data1과 같은 주소를 알고 있으므로 소멸시킬 메모리가 없으므로 에러가 발생된다.
}



