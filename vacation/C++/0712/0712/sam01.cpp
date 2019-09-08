#include "config.h"
#include <stdlib.h>
#include <time.h>

void main() {

//	time(NULL) : 유닉스 타임
//	1970년 1월 1일 부터 이 함수가 실행되는 시점까지 지나온 시간을 초단위로 출력한다.
	cout << "유닉스 타임 : " << time(NULL) << endl;

//	time_t timer;				// time.h에 선언된 시스템 구조체 tm 구조체 변수를 선언한다.
//	struct tm *t;				// tm 구조체 포인터를 선언한다.
//	timer = time(NULL);			// 현재 시간을 초단위로 얻어서 구조체에 저장한다.
//	초 단위의 시간을 년, 월, 일, 시, 분, 초 단위로 구분해 구조체 멤버에 넣어준다.
//	t = localtime(&timer);
	time_t timer = time(NULL);
	struct tm *t = localtime(&timer);

//	C/CPP은 날짜를 1900년을 기준으로 처리하기 때문에 년도를 얻어올 때는 1900을 월을 얻어올 때는
//	1을 더해줘야 하고 반대로 넣어줄 때는 년도는 1900을 월을 1을 빼서 넣어줘야 한다.
	cout << "현재 년도 : " << t->tm_year + 1900 << endl;
	cout << "현재 월 : " << t->tm_mon + 1 << endl;
	cout << "현재 일 : " << t->tm_mday << endl;
	cout << "현재 시간 : " << t->tm_hour << endl;
	cout << "현재 분 : " << t->tm_min << endl;
	cout << "현재 초 : " << t->tm_sec << endl;
//	tm_wday : 요일을 숫자로 얻어온다. 일요일(0), 월요일(1), ..., 토요일(6)
	cout << "현재 요일 : " << t->tm_wday << endl;
	cout << "1월 1일 부터 지나온 날짜 : " << t->tm_yday << endl;
	cout << "서머타임 실시여부 : " << t->tm_isdst << endl;

}