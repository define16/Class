#include "config.h"


//시스템구조체

void main()
{
	//srand((unsigned)time(NULL)); //랜덤함수 초기화
	//rand(); //랜덤함수

	cout <<"출력" << endl; //간단한 메세지 출력일때 유용함.
	cout << "유닉스타임 :" << time(NULL)<< endl;
	//time(NULL) : 유닉스타임
	// 1970년 1월 1일부터 이함수가 실행되는 시점까지 지나온 시간을 초단위로 출력한다.

	 //time_t timer; // time.h에 선언된 시스템구조체 tm구조체변수를 선언한다.
	 //struct tm *t; // tm 구조체 포인터 선언
	 //timer = time(NULL); // 현재시간을 초단위로 얻어서 구조체에 저장한다.
	 // 초 단위의 시간을 년,월,일,시,분,초 단위로 구분해서 구조체 맴버에 넣어준다.
	 //t = locatltime(&timer); 

	 time_t timer = time(NULL);
	  struct tm *t = localtime(&timer); 
	  //위에 네줄과 같음

	  //c/cpp은 날짜를 1900년을 기준으로 처리하기때문에 년도를 얻어올때는 
	  //1900을 월을 얻어올때는 1을 더해줘야하고 반대로 넣어줄때는 년도를 1900을 월을 1을 빼서 넣어줘야한다.
	  cout << "현재 년도 : " << t->tm_year + 1900 << endl;
	  cout << "현재 월 : " << t->tm_mon + 1 << endl;
	  cout << "현재 일 : " << t->tm_mday + 1900 << endl;
	  cout << "현재 시간 : " << t->tm_hour << endl;
	  cout << "현재 분 : " << t->tm_min  << endl;
	  cout << "현재 초 : " << t->tm_sec  << endl;
	  cout << "현재 요일 : " << t->tm_wday << endl;
	  cout << "1월 1일부터 지나온 날짜 : " << t->tm_yday  << endl;
	  cout << "서머타임 실시 여부 : " << t->tm_isdst  << endl;	

}
