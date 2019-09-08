#include "config.h"
#include "calendar.h"

void main() {

//	cout << (isYoun(2016) ? "윤년" : "평년") << endl;
//	cout << lastDay(2016, 7) << endl;
//	cout << totalDay(2016, 7, 4) << endl;
//	cout << weekDay(2016, 7, 4) << endl;

	int year, month;
	cout << "달력을 출력할 년, 월을 입력하세요 : ";
	cin >> year >> month;

	cout << "============================" << endl;
//	cout << "         " << year << "년 " << month << "월" << endl;
	printf("         %d년 %d월\n", year, month);
	cout << "============================" << endl;
	cout << " 일  월  화  수  목  금  토 " << endl;
	cout << "============================" << endl;

//	1일이 출력될 요일을 맞추기 위해서 달력을 출력할 달 1일의 요일 만큼 반복하며 빈칸을 출력한다.
	for(int i=1 ; i<=weekDay(year, month, 1) ; i++) {
		cout << "    ";
	}

//	1일 부터 그 달의 마지막 날짜까지 반복하며 날짜를 출력한다.
	for(int i=1 ; i<=lastDay(year, month) ; i++) {
		cout << setw(3) << i << " ";
//		출력한 날짜(i)가 토요일이고 그 달의 마지막 날짜가 아니면 줄을 바꾼다.
		if(weekDay(year, month, i) == 6 && lastDay(year, month) != i) {
			cout << endl;
		}
	}
	cout << endl << "============================" << endl;

}