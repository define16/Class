#include "config.h"
#include "date_s.h"

//	날짜를 저장할 클래스
class Date {
private:
	int year, month, date;
public:
	Date(int year = getYear(), int month = getMonth(), int date = getDate()) {
		this->year = year;
		this->month = month;
		this->date = date;
	}
	void toString() {
		printf("%4d년 %2d월 %2d일", year, month, date);
//		cout << setw(4) << year << "년 " << setw(2) << month << "월 " << setw(2) <<
//			date << "일" << endl;
	}
};

//	시간을 저장할 클래스
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
		printf("%02d:%02d:%02d", hour, minute, second);
	}
};

//	날짜, 시간 클래스를 포함한 클래스
class Now {
private:
//	클래스 포함이란 클래스의 멤버로 다른 클래스가 오는 것을 말한다.
	class Date date;
	class Time time;
public:
	Now() {

	}
	Now(Date date, Time time) {
		this->date = date;
		this->time = time;
	}

//	넘겨받은 인수로 객체를 생성해 초기화 시키는 생성자
//	Now(int year, int month, int date, int hour, int minute, int second) {
//		class Date d(year, month, date);
//		this->date = d;
//		class Time t(hour, minute, second);
//		this->time = t;
//	}

//	넘겨받은 인수를 초기화 리스트를 이용해 초기화 시키는 생성자
	Now(int year, int month, int date, int hour, int minute, int second) :
		date(year, month, date), time(hour, minute, second) {
		
	}

	void toString() {
		date.toString();
		cout << " ";
		time.toString();
		cout << endl;
	}
};

void main() {

	class Date date1;
	date1.toString(); cout << endl;
	class Date date2(2016, 12, 25);
	date2.toString(); cout << endl;
	class Time time1;
	time1.toString(); cout << endl;
	class Time time2(13, 48, 27);
	time2.toString(); cout << endl;
	class Now now1;
	now1.toString();
	class Now now2(date2, time2);
	now2.toString();
	class Now now3(2017, 8, 15, 13, 48, 27);
	now3.toString();

}