//	�⵵�� �Ѱܹ޾� ����/����� �Ǵ��� ������ true(1), ����� false(0)�� �����ϴ� �Լ�
bool isYoun(int year) {
	return year%4 == 0 && year%100 != 0 || year%400 == 0;
}
//	��, ���� �Ѱܹ޾� �� ���� ������ ��¥�� �����ϴ� �Լ�
int lastDay(int year, int month) {
	int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	m[1] = isYoun(year) ? 29 : 28;
	return m[month - 1];
}
//	��, ��, ���� �Ѱܹ޾� 1�� 1�� 1�� ���� ������ ��¥�� ����� �����ϴ� �Լ�
int totalDay(int year, int month, int day) {
	int sum = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
	for(int i=1 ; i<month ; i++) {
		sum += lastDay(year, i);
	}
	return sum + day;
}
//	��, ��, ���� �Ѱܹ޾� ������ ���ڷ� �����ϴ� �Լ�, �Ͽ���(0), ������(1), ..., �����(6)
int weekDay(int year, int month, int day) {
	return totalDay(year, month, day) % 7;
}