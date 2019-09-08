#include "config.h"

void main() {

	int year, month, day;
	cout << "요일을 계산할 년, 월, 일 : ";
	cin >> year >> month >> day;

//	1년 1월 1일 부터 입력받은 년도의 전년도 12월 31일 까지 지나온 날짜의 합계를 구한다.
	int sum = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;

//	전년도 까지 지나온 날짜의 합계에 전달 까지 지나온 날짜를 더한다.
	for(int i=1 ; i<month ; i++) {				// 월
		switch(i) {
			case 2:
				sum += year%4 == 0 && year%100 != 0 || year%400 == 0 ? 29 : 28;
				break;
			case 4: case 6: case 9: case 11:
				sum += 30;
				break;
			default:
				sum += 31;
		}
	}

//	전달 까지 지나온 날짜의 합계에 일을 더한다.
	sum += day;

	switch(sum % 7) {
		case 0: cout << "일요일" << endl; break;
		case 1: cout << "월요일" << endl; break;
		case 2: cout << "화요일" << endl; break;
		case 3: cout << "수요일" << endl; break;
		case 4: cout << "목요일" << endl; break;
		case 5: cout << "금요일" << endl; break;
		case 6: cout << "토요일" << endl;
	}

}