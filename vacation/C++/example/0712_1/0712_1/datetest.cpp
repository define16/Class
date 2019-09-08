#include "config.h"
#include "date.h"

void main()
{
	cout <<"유닉스 타임 : " << unixTime() << endl;
	cout <<"현재 년도 : " << getYear() << endl;
	cout <<"현재 월 : " << getMonth() << endl;
	cout << "현재 일 : " << getDay() << endl;
	  cout << "현재 시간 : " <<getHour()<< endl;
	  cout << "현재 분 : " << getMin() << endl;
	  cout << "현재 초 : " << getSec() << endl;
	  cout << "현재 요일 : " << getWday() << endl;
	  cout << "1월 1일부터 지나온 날짜 : " <<getYday()  << endl;
	  cout << "서머타임 실시 여부 : " << getIsdst()<< endl;	
}
