#include "config.h"
#include "date_s.h"

class Date {
private:
	int year, month, day;
public:
	Date(int year = getYear(), int month = getMonth(), int day = getDate()) {
		this->year = year;
		this->month = month;
		this->day = day;
	}
	void toString() {
		printf("%4d�� %2d�� %2d��", year, month, day);
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
	void toString() {
		printf("%2d:%2d:%2d", hour, minute, second);
	}
};

//	Date Ŭ������ Time Ŭ������ ��ӹ޾� Now Ŭ������ �����.
//	2�� �̻��� Ŭ������ ��ӹ޴� ���� ���� ����̶� �Ѵ�.
//	������ ���̾Ƹ�� �������� ���� �ڹٳ� C#�� ���� ����� ������� �ʴ´�.
class Now : public Date, public Time {
public:
	Now() {

	}
//	�θ� Ŭ������ setter �Լ��� �غ���� �ʾҰ� ��ӹ��� ����� ���� ������ private��
//	�����Ǿ� �����Ƿ� �θ� Ŭ������ �����ڸ� ȣ���ؼ� ����� �ʱ�ȭ ������� �Ѵ�.
	Now(int year, int month, int day, int hour, int minute, int second) : 
		Date(year, month, day), Time(hour, minute, second) {

	}
	void viewNow() {
//	Date Ŭ������ toString() �Լ��� Time Ŭ������ toString() �Լ��� ��ӹ޾Ҵ�.
//	���� �ٸ� Ŭ������ ���� �̸��� ������ �Լ��� ��ӹ޾����Ƿ� Now Ŭ�������� toString()
//	�Լ��� �����ϰ�	�Ǹ� � Ŭ�������� ��ӹ��� �Լ��� �����ؾ� �ϴ��� �����Ϸ��� ������
//	�� �� �����Ƿ� �Լ��� ��ȣ�ϴٴ� ���� �޽����� ��µȴ�.
//	�� ������ �ذ��ϴ� ����� ��� Ŭ������ ���� ��ӹ��� �Լ������� ����� �ָ� �ȴ�.
//	�Լ� �̸� �տ� ����� �Լ��� ���Ե� Ŭ���� �̸��� ���� "::"�� ����ش�.
		Date::toString();
		cout << " ";
		Time::toString();
		cout << endl;
	}
};

void main() {

	class Now now1;
	now1.viewNow();
	class Now now2(2016, 12, 25, 19, 30, 15);
	now2.viewNow();

}