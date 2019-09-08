#include "config.h"
#include "calendar.h"

void main() {

//	cout << (isYoun(2016) ? "����" : "���") << endl;
//	cout << lastDay(2016, 7) << endl;
//	cout << totalDay(2016, 7, 4) << endl;
//	cout << weekDay(2016, 7, 4) << endl;

	int year, month;
	cout << "�޷��� ����� ��, ���� �Է��ϼ��� : ";
	cin >> year >> month;

	cout << "============================" << endl;
//	cout << "         " << year << "�� " << month << "��" << endl;
	printf("         %d�� %d��\n", year, month);
	cout << "============================" << endl;
	cout << " ��  ��  ȭ  ��  ��  ��  �� " << endl;
	cout << "============================" << endl;

//	1���� ��µ� ������ ���߱� ���ؼ� �޷��� ����� �� 1���� ���� ��ŭ �ݺ��ϸ� ��ĭ�� ����Ѵ�.
	for(int i=1 ; i<=weekDay(year, month, 1) ; i++) {
		cout << "    ";
	}

//	1�� ���� �� ���� ������ ��¥���� �ݺ��ϸ� ��¥�� ����Ѵ�.
	for(int i=1 ; i<=lastDay(year, month) ; i++) {
		cout << setw(3) << i << " ";
//		����� ��¥(i)�� ������̰� �� ���� ������ ��¥�� �ƴϸ� ���� �ٲ۴�.
		if(weekDay(year, month, i) == 6 && lastDay(year, month) != i) {
			cout << endl;
		}
	}
	cout << endl << "============================" << endl;

}