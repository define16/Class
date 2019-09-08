#include "config.h"

class Memo {
private : 
	char *name;
	char *phone;
	int age;
public :
	Memo(char *name = "무명씨", char *phone = "없음", int age = 0){
//		멤버를 포인터로 선언했으면 넘어온 문자열의 크기 만큼 메모리를 동적할당하고 초기화한다.
//		메모리를 동적으로 할당하고 할당된 메모리의 시작 주소를 포인터에 넣어준다.
//		생성자에서 동적 할당된 메모리는 소멸자에서 해제해야한다.
		this->name=(char*)malloc(sizeof(char)*strlen(name)+1);
		strcpy_s(this->name,strlen(name)+1,name);
		this->phone = new char[strlen(phone)+1];
		strcpy_s(this->phone,strlen(phone)+1,phone);
		this->age = age; 
	}
// 복사 생성자를 오버라이드 하지 않으면 C++컴파일러가 기본 복사 생성자를 만든다.
// 복사 생성자는 포인터를 그냥 this 초기화를 해버린다.
// 복사 생성자는 현재의 데이터 타입의 참조형 변수를 인수로 가지는 생성자이다.

// C++가 자동으로 만들어주는 복사 생성자
// 단점 : 1.원본과 사본이 같이 바뀐다. 2.동적메모리를 해체할 경우 오류가 발생한다.
//	Memo(Memo &M) {
//// this초기화를 하면 포인터에 저장된 주소만 넘어간다.
//// 결과적으로 새로 생성되는 객체의 포인터에 저장되는 주소와 인수로 넘어온
//// 객체의 포인터에 저장된 주소가 같다.
////  이와 같이 주소만 넘겨주는 방식을 얕은 복사라 하고 얕은 복사를 하게 되면
//// 원본과 사본이 같은 데이터를 공유해 사용한게 된다.
//		this->name = M.name;
//		this->phone = M.phone;
//		this->age = M.age;
//	}

	Memo(Memo &M){
// 복사 생성자를 오버라이드해서 복사 생성자로 생성되는 객체도 메모리를 동적으로
// 할당해 실 기억 공간을 만들어 주고 값을 넘겨주면 원본과 사본이 서로 다른
// 메모리를 사용하므로 원본이 변경되도 사본이 변경되지 않는다.
// 이와 같이 실 기억 공간을 만들어 주소가 아닌 값을 넘겨주는 방식을 깊은 복사라 부른다.
		this->name = (char*)malloc(sizeof(char)*strlen(M.name)+ 1);
		strcpy_s(this->name,strlen(M.name)+ 1,M.name);
		this->phone = new char[strlen(M.phone)+ 1]; // C++용 동적메모리 할당.
		strcpy_s(this->phone,strlen(M.phone)+ 1,M.phone);
		this -> age = M.age;
	}


	~Memo() {
// 소멸자에서 생성자에서 할당한 동적 메모리를 할당할 경우 memo2가 생성될 때 할당된 동적 메모리가 해제된 후
// memo3에서 할당된 동적 메모리를 해제하려 하니까 해제할 메모리가 존재하지 않으므로 에러가 발생한다.
		cout << "소멸자가 실행됩니다." << endl;
		free(name);
		delete[]phone;		//여러개는 []를 붙이고 하나는 붙이지 않는다.
	}

	void setName(char *name) {
// 생성자에서 동적 할당으로 메모리를 확보했으므로 여기서는 하면 안된다.
		strcpy_s(this->name,strlen(name)+1,name);
	}
	void toString() {
		cout << "이름 : " << name << ", 전화번호 : " << phone << ", 나이 : " << age << endl;
	}
};

void main(){

	Memo memo1;
	cout << "memo1 : "; memo1.toString();
	Memo memo2("홍길동", "111-1111",20);
	cout << "memo2 : "; memo2.toString();
	Memo memo3(memo2);
	cout << "memo3 : "; memo3.toString();
//	setter를 이용해 memo2의 name을 변경한다.
//	memo2의 name과 memo3의 name이 같은 메모리를 사용하고 있으므로
//	memo2의 name이 변경될 경우 
	memo2.setName("임꺽정");
	cout << "memo2 : "; memo2.toString();
	cout << "memo3 : "; memo3.toString();

// 복사 생성자를 이용할 경우에는 포인터를 이용한 방법은 좋은 방법이 아니다.
	Memo *memo4 = new Memo();
	cout << "memo4 : ";memo4 ->toString();
	Memo *memo5 = new Memo("장길산", "222-2222",20);
	cout << "memo5 : ";memo5 ->toString();
	Memo *memo6(memo5);
	cout << "memo6 : ";memo6 ->toString();

// 클래스의 객체를 변수로 선언하면서 동적 할당된 객체의 내용을 복사 생성자의
// 인수로 넘겨야 할 경우 동적 할당된 객체가 참조하는 내용을 넘겨줘야 한다.
	Memo memo7(*memo5);
	cout << "memo7 : ";memo7.toString();
	delete memo4;		//new가 소멸 되지 않음
	delete memo5;	
//	delete memo6;	
}