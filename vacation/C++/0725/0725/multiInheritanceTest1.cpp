#include "config.h"
#include "date_s.h"

class Date {
private:
	int year, month, day;
public:
	Date(int year = getYear(), int month = getMonth(), int day = getDate()) {
		this->year = year;
		this->month = month;
		this->day = day;
	}
	void toString() {
		printf("%4d년 %2d월 %2d일", year, month, day);
	}
};

class Time {
private:
	int hour, minute, second;
public:
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond()) {
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
	void toString() {
		printf("%2d:%2d:%2d", hour, minute, second);
	}
};

//	Date 클래스와 Time 클래스를 상속받아 Now 클래스를 만든다.
//	2개 이상의 클래스를 상속받는 것을 다중 상속이라 한다.
//	죽음의 다이아몬드 현상으로 인해 자바나 C#은 다중 상속을 허용하지 않는다.
class Now : public Date, public Time {
public:
	Now() {

	}
//	부모 클래스에 setter 함수가 준비되지 않았고 상속받은 멤버의 접근 권한이 private로
//	설정되어 있으므로 부모 클래스의 생성자를 호출해서 멤버를 초기화 시켜줘야 한다.
	Now(int year, int month, int day, int hour, int minute, int second) : 
		Date(year, month, day), Time(hour, minute, second) {

	}
	void viewNow() {
//	Date 클래스의 toString() 함수와 Time 클래스의 toString() 함수를 상속받았다.
//	서로 다른 클래스의 같은 이름을 가지는 함수를 상속받았으므로 Now 클래스에서 toString()
//	함수를 실행하게	되면 어떤 클래스에서 상속받은 함수를 실행해야 하는지 컴파일러가 결정을
//	할 수 없으므로 함수가 모호하다는 에러 메시지가 출력된다.
//	이 에러를 해결하는 방법은 어느 클래스로 부터 상속받은 함수인지를 명시해 주면 된다.
//	함수 이름 앞에 상속은 함수가 포함된 클래스 이름을 적고 "::"를 찍어준다.
		Date::toString();
		cout << " ";
		Time::toString();
		cout << endl;
	}
};

void main() {

	class Now now1;
	now1.viewNow();
	class Now now2(2016, 12, 25, 19, 30, 15);
	now2.viewNow();

}