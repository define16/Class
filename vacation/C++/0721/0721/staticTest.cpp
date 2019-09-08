#include "config.h"

class Memo {
private:
//	정적 멤버 변수는 클래스 외부에서 초기화를 시켜야 한다.
//	정적 멤버 변수는 현재 클래스로 생성되는 모든 객체에서 공유해서 사용된다.
//	static이 붙지 않는 멤버 변수는 인스턴스 멤버 변수라 부르며 현재 클래스로 생성되는
//	각각의 객체에서 독립된 기억 공간을 가진다.
	static int count;		// 정적 멤버 변수
	int no;					// 자동증가
	char name[21];
	char memo[101];
public:
	/*
	Memo() {
		no = ++count;
		strcpy(name, "무명씨");
		strcpy(memo, "없음");
	}
	Memo(int no, char name[21], char memo[101]) {
		no = ++count;
		strcpy(this->name, name);
		strcpy(this->memo, memo);
	}
	*/
	Memo(char name[21] = "무명씨", char memo[101] = "없음") {
		no = ++count;
		strcpy_s(this->name, name);
		strcpy_s(this->memo, memo);
	}
	void toString() {
//		printf("%d. %s님이 남긴말 : %s\n", no, name, memo);
		cout << no << ". " << name << "님이 남긴말 : " << memo << endl;
	}
};

//	Memo 클래스에서 선언된 정적 변수 count의 초기화
int Memo::count = 0;

void main() {

	class Memo memo1;
	memo1.toString();
	class Memo memo2("홍길동", "까꿍~~~");
	memo2.toString();
	class Memo memo3("임꺽정", "어흥~~~");
	memo3.toString();

//	memo1.count = 100;
//	cout << memo3.count << endl;

	class Memo memo4("성춘향", "꺄아~~~");
	memo4.toString();

}