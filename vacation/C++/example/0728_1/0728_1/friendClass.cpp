#include "config.h"
#include "date_s.h"

class Time;
class Date {	
// 클래스를 friend로 설정하면 friend로 설정된 클래스이 모든 멤버 함수가 현재 클래스의
// private 멤버 변수에 자유롭게 접근할 수 있다.
// 완전히 구현된 클래스만 friend클래스로 지정할 수 있음에 주의하자.
// Time 클래스의 모든 멤버 함수(today(Date *d),today(Date &d))가 Date클래스의
// private 멤버 변수에 접근이 가능하다.
friend	class Time;
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

private :
	int hour,minute,second;
public :
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond())
	{
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
	void today(Date *d) 
	{
		cout << "지금은 " << d->year << "년 " << d->month << "월 " << d->day << "일 " 
			<< hour << "시 " <<minute << "분 " << second << "초 입니다." << endl; 
	}
	void today(Date &d) 
	{
		cout << "지금은 " << d.year << "년 " << d.month << "월 " << d.day << "일 " 
			<< hour << "시 " <<minute << "분 " << second << "초 입니다." << endl; 
	}

};

void main(){
	Date date;
	Time time;
	time.today(&date);
	time.today(date);
	date.today(&time);
}
