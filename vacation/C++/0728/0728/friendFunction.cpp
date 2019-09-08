#include "config.h"
#include "date_s.h"

class Time;		// Time�� Ŭ�������� �����Ϸ����� �˷��ִ� ���� �����̴�.
class Date {
//	friend�� �����ϴ� ��ġ�� Ư���� ���� �б� ���� ��ҿ��� �����ϸ� �ȴ�.
//	friend�� ������ �Լ��� ������ ���� �տ� friend�� �ٿ��ָ� �ȴ�.
//	friend�� �����ϸ� friend�� ������ �ܺ� �Լ��� �����Ӱ� ���� Ŭ������ private �����
//	������ �� �ִ�.
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
//	call by value ������� ������ �ܺ� �Լ�
void today(Date d, Time t) {
	cout << "������ " << d.year << "�� " << d.month << "�� " << d.day << "�� "
		<< t.hour << "�� " << t.minute << "�� " << t.second << "�� �Դϴ�." << endl;
}
*/
//	�����͸� ����ϴ� call by reference ������� ������ �ܺ� �Լ�
void today(Date *d, Time *t) {
	cout << "������ " << d->year << "�� " << d->month << "�� " << d->day << "�� "
		<< t->hour << "�� " << t->minute << "�� " << t->second << "�� �Դϴ�." << endl;
}

//	���۷��� ������ ����ϴ� call by reference ������� ������ �ܺ� �Լ�
void today(Date &d, Time &t) {
	cout << "������ " << d.year << "�� " << d.month << "�� " << d.day << "�� "
		<< t.hour << "�� " << t.minute << "�� " << t.second << "�� �Դϴ�." << endl;
}

void main() {

	Date date;
	Time time;
// 	call by value ������� ������ �ܺ� �Լ��� ȣ���Ѵ�.
//	today(date, time);
// 	�����͸� ����ϴ� call by reference ������� ������ �ܺ� �Լ��� ȣ���Ѵ�.
	today(&date, &time);		// �ּҸ� �����ָ� �����ͷ� �޴´�.
// 	���۷��� ������ ����ϴ� call by reference ������� ������ �ܺ� �Լ��� ȣ���Ѵ�.
//	call by value ������� ������ �ܺ� �Լ��� ȣ���ϴ� ����� ��ġ�Ƿ� call by value
//	������� ����� �Լ��� �Բ� ����� �� ����.
	today(date, time);

}