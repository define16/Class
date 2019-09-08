#include "config.h"
#include "date_s.h"

class Time;
class Date {
private:
	int year, month, day;
public:
	Date(int year = getYear(), int month = getMonth(), int day = getDate()) {
		this->year = year;
		this->month = month;
		this->day = day;
	}
	void today(Time *);
	void today(Time &);
};

class Time {
	friend void Date::today(Time *);
	friend void Date::today(Time &);
private:
	int hour, minute, second;
public:
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond()) {
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
};


void Date::today(Time *t) {
	cout << "지금은 " << year << "년 " << month << "월 " << day << "일 "
		<< t->hour << "시 " << t->minute << "분 " << t->second << "초 입니다." << endl;
}
void Date::today(Time &t) {
	cout << "지금은 " << year << "년 " << month << "월 " << day << "일 "
		<< t.hour << "시 " << t.minute << "분 " << t.second << "초 입니다." << endl;
}

void main() {

	Date date;
	Time time;
	date.today(&time);
	date.today(time);

}