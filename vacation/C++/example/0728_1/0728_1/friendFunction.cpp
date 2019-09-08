#include "config.h"
#include "date_s.h"

// ������ ����Լ�, Ŭ������ ������ ���Ƽ� ����, ������ �Լ��� �� ����ص���!!
class Time;
class Date {		//Time�� Ŭ�������� �����Ϸ����� �˷��ִ� ���� �����̴�.
// friend�� �����ϴ� ��ġ�� Ư���� ���� �б� ���� ��ҿ��� �����ϸ� �ȴ�.
// friend�� ������ �Լ��� ������ ���� �տ� friend�� �ٿ��ָ� �ȴ�.
// friend�� �����ϸ� friend�� ������ �ܺ� �Լ��� �����Ӱ� ���� Ŭ������ private ����� ������ �� �ִ�.
//friend void today(Date, Time);
friend	void today(Date *d, Time *t);
friend	void today(Date &d, Time &t);

private :
	 int year, month, day;
public :
	Date(int year = getYear(), int month = getMonth(), int day = getDate()){
		this->year = year;
		this->month = month;
		this->day = day;
	}
};

class Time {
//friend void today(Date,Time);
friend	void today(Date *d, Time *t);
friend	void today(Date &d, Time &t);
private :
	int hour,minute,second;
public :
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond())
	{
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}


	
};

//Call By Value ������� ������ �ܺ��Լ�
//void today(Date d, Time t) {
//		cout << "������ " << d.year << "�� " << d.month << "�� " << d.day << "�� " <<
//		t.hour << "�� " << t.minute << "�� " << t.second << "�� �Դϴ�." << endl;
//	}

//Call By Referenced ������� ������ �ܺ��Լ�
void today(Date *d, Time *t)
{
		cout << "������ " << d->year << "�� " << d->month << "�� " << d->day << "�� " 
			<< t->hour << "�� " << t->minute << "�� " << t->second << "�� �Դϴ�." << endl;
}
void today(Date &d, Time &t)
{
		cout << "������ " << d.year << "�� " << d.month << "�� " << d.day << "�� " <<
		t.hour << "�� " << t.minute << "�� " << t.second << "�� �Դϴ�." << endl;
}
void main(){
	Date date;
	Time time;
// Call By Value������� ������ �ܺ��Լ��� ȣ���Ѵ�.
//	today(date, time);
// Call By Referenced������� ������ �ܺ��Լ��� ȣ���Ѵ�.
	today(&date, &time);		// �ּҸ� �����ָ� �����ͷ� �޴´�.

}
