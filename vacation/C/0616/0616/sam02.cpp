#include "config.h"

void main() {

	int year, month, day;
	cout << "������ ����� ��, ��, �� : ";
	cin >> year >> month >> day;

//	1�� 1�� 1�� ���� �Է¹��� �⵵�� ���⵵ 12�� 31�� ���� ������ ��¥�� �հ踦 ���Ѵ�.
	int sum = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;

//	���⵵ ���� ������ ��¥�� �հ迡 ���� ���� ������ ��¥�� ���Ѵ�.

	int m[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	m[1] = year%4 == 0 && year%100 != 0 || year%400 == 0 ? 29 : 28;

	for(int i=1 ; i<month ; i++) {				// ��
//		switch(i) {
//			case 2:
//				sum += year%4 == 0 && year%100 != 0 || year%400 == 0 ? 29 : 28;
//				break;
//			case 4: case 6: case 9: case 11:
//				sum += 30;
//				break;
//			default:
//				sum += 31;
//		}
		sum += m[i-1];
	}

//	���� ���� ������ ��¥�� �հ迡 ���� ���Ѵ�.
	sum += day;

//	switch(sum % 7) {
//		case 0: cout << "�Ͽ���" << endl; break;
//		case 1: cout << "������" << endl; break;
//		case 2: cout << "ȭ����" << endl; break;
//		case 3: cout << "������" << endl; break;
//		case 4: cout << "�����" << endl; break;
//		case 5: cout << "�ݿ���" << endl; break;
//		case 6: cout << "�����" << endl;
//	}

//	���� �迭�� �̸� �տ� "*"�� ���̸� ���ڿ� �迭�� �ȴ�.
	char *weekday[] = {"��","��","ȭ","��","��","��","��"};
	cout << weekday[sum % 7] << "����" << endl;

}