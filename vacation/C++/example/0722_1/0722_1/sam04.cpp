#include "config.h"
#include "date.h"

// ��¥�� ������ Ŭ����
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
			printf("%4d�� %2d�� %2d��\n", year, month, date);
//			cout << setw(4) << year << "�� " << setw(2) << month << "�� " << setw(2) << date << "��" <<endl; 
		}

};

// �ð��� ������ Ŭ����
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
			printf("%2d�� %2d�� %2d��\n",hour, minute, second);
		}
};

// ��¥, �ð� Ŭ������ ������ Ŭ����

class Now{
	private :
//Ŭ���� �����̶� Ŭ������ ����� �ٸ� Ŭ������ ���� ���� ���Ѵ�.
		class Date date;  // class�� ��������.
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

	//���� : �����ϱ� 
	class Now now3(2016,12,25,13,48,27)
	now3.toString();
}
