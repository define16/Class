//	년도를 넘겨받아 윤년/평년을 판단해 윤년은 true(1), 평년은 false(0)를 리턴하는 함수
bool isYoun(int year) {
	return year%4 == 0 && year%100 != 0 || year%400 == 0;
}
//	년, 월을 넘겨받아 그 달의 마지막 날짜를 리턴하는 함수
int lastDay(int year, int month) {
	int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	m[1] = isYoun(year) ? 29 : 28;
	return m[month - 1];
}
//	년, 월, 일을 넘겨받아 1년 1월 1일 부터 지나온 날짜를 계산해 리턴하는 함수
int totalDay(int year, int month, int day) {
	int sum = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
	for(int i=1 ; i<month ; i++) {
		sum += lastDay(year, i);
	}
	return sum + day;
}
//	년, 월, 일을 넘겨받아 요일을 숫자로 리턴하는 함수, 일요일(0), 월요일(1), ..., 토요일(6)
int weekDay(int year, int month, int day) {
	return totalDay(year, month, day) % 7;
}