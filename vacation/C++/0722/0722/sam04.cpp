#include "config.h"
#include "date_s.h"

//	��¥�� ������ Ŭ����
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
		printf("%4d�� %2d�� %2d��", year, month, date);
//		cout << setw(4) << year << "�� " << setw(2) << month << "�� " << setw(2) <<
//			date << "��" << endl;
	}
};

//	�ð��� ������ Ŭ����
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

//	��¥, �ð� Ŭ������ ������ Ŭ����
class Now {
private:
//	Ŭ���� �����̶� Ŭ������ ����� �ٸ� Ŭ������ ���� ���� ���Ѵ�.
	class Date date;
	class Time time;
public:
	Now() {

	}
	Now(Date date, Time time) {
		this->date = date;
		this->time = time;
	}

//	�Ѱܹ��� �μ��� ��ü�� ������ �ʱ�ȭ ��Ű�� ������
//	Now(int year, int month, int date, int hour, int minute, int second) {
//		class Date d(year, month, date);
//		this->date = d;
//		class Time t(hour, minute, second);
//		this->time = t;
//	}

//	�Ѱܹ��� �μ��� �ʱ�ȭ ����Ʈ�� �̿��� �ʱ�ȭ ��Ű�� ������
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