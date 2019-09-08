#include "config.h"
class Memo{
	private : 
// 정적 멤버변수는 클래스 외부에서 초기화를 시켜야한다.
// 정적 멤버변수는 현재 클래스로 생성되는 모든 객체에서 공유해서 사용된다.
// static이 붙지 않는 멤버변수는 인스턴스 멤버 변수라 부르며 현재 클래스로 생성되는
// 각각의 객체에서 독립된 기억 공간을 가진다.
		static int count;	//정적 멤버변수
		int no;		//자동증가
		char name[21];
		char memo[101];
	public : 
		Memo(char name[21] = "무명씨" , char memo[101] = "없음")
		{
			no = ++count;
			strcpy_s(this->name,name); 
			strcpy_s(this->memo,memo); 	
		}

		void toString(char name[21] = "무명씨" , char memo[101] = "없음"){
			cout << no << ", " << name << "님이 남긴말 : " << memo << endl;
		}
};
// Memo클래스에서 선언된 정적 변수 count의 초기화
int Memo :: count = 0;

void main(){
	class Memo memo1;
	memo1.toString();
	class Memo memo2;
	memo2.toString("홍길동","ㅁㅇㄹ");
	class Memo memo3;
	memo3.toString("임꺽정","ㅁㄷㄹ");
}