#include "config.h"
#include "date.h"

// 날짜를 저장할 클래스
class Date
{
	private : 
		int year,month,date;
	public :
		Date(int year = getYear() , int month = getMonth(), int date = getDay())
		{
			this -> year = year;
			this -> month = month;
			this -> date = date;
		}

		void toString(){
			printf("%4d년 %2d월 %2d일\n", year, month, date);
//			cout << setw(4) << year << "년 " << setw(2) << month << "월 " << setw(2) << date << "일" <<endl; 
		}

};

// 시간을 저장할 클래스
class Time 
{
	private : 
		int hour, minute, second;
	public :
			Time(int hour = getHour() , int minute = getMin(), int second = getSec())
		{
			this -> hour = hour;
			this -> minute = minute;
			this -> second = second;
		}

		void toString(){
			printf("%2d시 %2d분 %2d초\n",hour, minute, second);
		}
};

// 날짜, 시간 클래스를 포함한 클래스

class Now{
	private :
//클래스 포함이란 클래스의 멤버로 다른 클래스가 오는 것을 말한다.
		class Date date;  // class는 생략가능.
		class Time time;
	public :
		Now()
		{

		}
		Now(Date date, Time time)
		{
			this->date = date;
			this->time = time;
		}

		void toString()
		{
			date.toString();
			time.toString();
		}
};


void main()
{
	class Date date1;
	date1.toString();
	class Date date2(2016,12,25);
	date2.toString();
	class Time time1;
	time1.toString();
	class Time time2(10,50,55);
	time2.toString();

	class Now now1;
	now1.toString();
	
	class Now now2(date2,time2);
	now2.toString();

	//과제 : 구현하기 
	class Now now3(2016,12,25,13,48,27)
	now3.toString();
}
