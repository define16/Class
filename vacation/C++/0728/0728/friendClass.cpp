#include "config.h"
#include "date_s.h"

class Date {
//	Ŭ������ friend�� �����ϸ� friend�� ������ Ŭ������ ��� ��� �Լ��� ���� Ŭ������
//	private ��� ������ �����Ӱ� ������ �� �ִ�.
//	������ ������ Ŭ������ friend Ŭ������ ������ �� ������ ��������
//	Time Ŭ������ ��� ��� �Լ�(today(Date *d), today(Date &d))�� Date Ŭ������ 
//	private ��� ������ ������ �����ϴ�.
	friend class Time;
private:
	int year, month, day;
public:
	Date(int year = getYear(), int month = getMonth(), int day = getDate()) {
		this->year = year;
		this->month = month;
		this->day = day;
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
//	Time Ŭ������ ��� �Լ��̹Ƿ� Time Ŭ������ private ��� ������ ������ �� �ִ�.
	void today(Date *d) {
		cout << "������ " << d->year << "�� " << d->month << "�� " << d->day << "�� "
		<< hour << "�� " << minute << "�� " << second << "�� �Դϴ�." << endl;
	}
	void today(Date &d) {
		cout << "������ " << d.year << "�� " << d.month << "�� " << d.day << "�� "
		<< hour << "�� " << minute << "�� " << second << "�� �Դϴ�." << endl;
	}
};

void main() {

	Date date;
	Time time;
	time.today(&date);
	time.today(date);

}