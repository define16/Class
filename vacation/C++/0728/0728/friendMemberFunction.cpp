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
	cout << "������ " << year << "�� " << month << "�� " << day << "�� "
		<< t->hour << "�� " << t->minute << "�� " << t->second << "�� �Դϴ�." << endl;
}
void Date::today(Time &t) {
	cout << "������ " << year << "�� " << month << "�� " << day << "�� "
		<< t.hour << "�� " << t.minute << "�� " << t.second << "�� �Դϴ�." << endl;
}

void main() {

	Date date;
	Time time;
	date.today(&time);
	date.today(time);

}