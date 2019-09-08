#include "config.h"
#include "date_s.h"

class Time;		// Time이 클래스임을 컴파일러에게 알려주는 전방 선언이다.
class Date {
//	friend를 설정하는 위치는 특별히 없고 읽기 쉬운 장소에서 설정하면 된다.
//	friend로 설정할 함수의 원형을 적고 앞에 friend만 붙여주면 된다.
//	friend로 설정하면 friend로 설정된 외부 함수는 자유롭게 현재 클래스의 private 멤버에
//	접근할 수 있다.
//	friend void today(Date, Time);
	friend void today(Date *, Time *);
	friend void today(Date &, Time &);

private:
	int year, month, day;
public:
//	int year, month, day;
	Date(int year = getYear(), int month = getMonth(), int day = getDate()) {
		this->year = year;
		this->month = month;
		this->day = day;
	}
};

class Time {
//	friend void today(Date, Time);
	friend void today(Date *, Time *);
	friend void today(Date &, Time &);
private:
	int hour, minute, second;
public:
//	int hour, minute, second;
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond()) {
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
};

/*
//	call by value 방식으로 구현된 외부 함수
void today(Date d, Time t) {
	cout << "지금은 " << d.year << "년 " << d.month << "월 " << d.day << "일 "
		<< t.hour << "시 " << t.minute << "분 " << t.second << "초 입니다." << endl;
}
*/
//	포인터를 사용하는 call by reference 방식으로 구현된 외부 함수
void today(Date *d, Time *t) {
	cout << "지금은 " << d->year << "년 " << d->month << "월 " << d->day << "일 "
		<< t->hour << "시 " << t->minute << "분 " << t->second << "초 입니다." << endl;
}

//	레퍼런스 변수를 사용하는 call by reference 방식으로 구현된 외부 함수
void today(Date &d, Time &t) {
	cout << "지금은 " << d.year << "년 " << d.month << "월 " << d.day << "일 "
		<< t.hour << "시 " << t.minute << "분 " << t.second << "초 입니다." << endl;
}

void main() {

	Date date;
	Time time;
// 	call by value 방식으로 구현된 외부 함수를 호출한다.
//	today(date, time);
// 	포인터를 사용하는 call by reference 방식으로 구현된 외부 함수를 호출한다.
	today(&date, &time);		// 주소를 던져주면 포인터로 받는다.
// 	레퍼런스 변수를 사용하는 call by reference 방식으로 구현된 외부 함수를 호출한다.
//	call by value 방식으로 구현된 외부 함수를 호출하는 방법과 겹치므로 call by value
//	방식으로 선언된 함수와 함께 사용할 수 없다.
	today(date, time);

}