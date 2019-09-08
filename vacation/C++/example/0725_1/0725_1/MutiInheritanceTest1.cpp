#include "config.h"
#include "date_s.h"

class Date {
private : 
	int year, month, day;
public :
	Date(int year = getYear(), int month = getMonth(), int day = getDate())
	{
		this->year = year;
		this->month = month;
		this->day = day;
	}
	void toString()
	{
		cout << year << "��, " << month << "��, " << day << "��"<<endl;
	}


};

class Time {
private : 
	int hour, minute, second;
public :
	Time(int hour = getHour(), int minute = getMinute(), int second = getSecond())
	{
		this->hour = hour;
		this->minute = minute;
		this->second = second;
	}
	void toString()
	{
		cout << hour << "��, " << minute << "��, " << second << "��"<<endl;
	}
};

// DateŬ������ TimeŬ������ ��ӹ޾� NowŬ������ �����.
// 2�� �̻��� Ŭ������ ��� �޴� ���� ���� ����̶� �Ѵ�.
// ������ ���̾Ƹ�� �������� ���� �ڹٳ� C#�� ���� ����� ������� �ʴ´�.
class Now : public Date, public Time{
public :
// �θ� Ŭ������ setter�Լ��� �غ���� �ʾҰ� ��ӹ��� ����� ���� ������ private�� ���� �Ǿ� �����Ƿ� �θ�Ŭ������
// �����ڸ� ȣ���ؼ� ����� �ʱ�ȭ ��������Ѵ�.
		Now(int year = getYear(), int month = getMonth(), int day = getDate(),int hour = getHour(), int minute = getMinute(), int second = getSecond()) : 
		Date(year , month , day), Time(hour , minute, second)
		{
			
		}

	void viewNow() 
	{
// DateŬ������ toString()�Լ��� TimeŬ������ toString()�Լ��� ��� �޾Ҵ�.
// ���� �ٸ� Ŭ������ ���� �̸��� ������ �Լ��� ��ӹ޾����Ƿ� NowŬ�������� toString()
// �Լ��� �����ϰ� �Ǹ� � Ŭ�������� ��ӹ��� �Լ��� �����ؾ� �ϴ��� �����Ϸ��� ������
// �� �� �����Ƿ� �Լ��� ��ȣ�ϴٴ� ���� �޽����� ��µȴ�.
//					toString();
// �� ������ �ذ��� ����� ��� Ŭ������ ���� ��ӹ��� �Լ������� ����� �ָ� �ȴ�.
// �Լ��� �̸��տ�  ����� �Լ��� ���Ե� Ŭ���� �̸��� ���� "::"�� ����ش�.
				Date::toString();
				Time::toString();


	}


};

void main()
{
		class Now now1;
		now1.viewNow();
		class Now now2(2016,12,25,19,30,15);
		now2.viewNow();
}
