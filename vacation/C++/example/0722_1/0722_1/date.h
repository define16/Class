//리턴타입 함수이름 ([인수,..]) { - 함수의 머리 
//   함수가 실행할 문장;  - 함수의 몸체
//    .... ;
//   [return 값;]
//   } return이 생략되면 리턴 타입에 void라고 적는다.
// 함수가 호출되면 프로그램은 호출된 함수롤 분기해서 함수를 실행한다.
// return을 만나거나 "}"를 만나면 함수가 호출된 곳으로 되돌아간다.

int unixTime()
{
	return (unsigned)time(NULL);
}

//리턴되는 값이 주소(포인터,배열명,문자열)일 경우 함수명 앞에 "*"을 붙여준다.
tm *getUnixTime()
{
	time_t timer = (unsigned)time(NULL);
	 struct tm *t = localtime(&timer); 
// struct tm t;
// localtime(&t ,&timer);

	 return t;
}

//현재 날짜에서 년도만 리턴하는 함수
int getYear()
{
	  return getUnixTime()->tm_year + 1900;
}

int getMonth()
{
	 return getUnixTime()->tm_mon + 1;
}

int getDay()
{
	 return getUnixTime()->tm_mday;
}

int getHour()
{
	 return getUnixTime()->tm_hour;
}

int getMin()
{
	 return getUnixTime()->tm_min;
}

int getSec()
{
	 return getUnixTime()->tm_sec;
}

char *getWday()
{
	//리턴할 요일이 저장된 문자열 배열을 만들어준다.
	char *week[] = {"일","월","화","수","목","금","토"};
	 return week[getUnixTime()->tm_wday];
}

int getYday()
{
	 return getUnixTime()->tm_yday;
}

int getIsdst()
{
	 return getUnixTime()->tm_isdst;
}