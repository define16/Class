#include "config.h"
#include <stdlib.h>
#include <time.h>

void main() {

//	time(NULL) : ���н� Ÿ��
//	1970�� 1�� 1�� ���� �� �Լ��� ����Ǵ� �������� ������ �ð��� �ʴ����� ����Ѵ�.
	cout << "���н� Ÿ�� : " << time(NULL) << endl;

//	time_t timer;				// time.h�� ����� �ý��� ����ü tm ����ü ������ �����Ѵ�.
//	struct tm *t;				// tm ����ü �����͸� �����Ѵ�.
//	timer = time(NULL);			// ���� �ð��� �ʴ����� �� ����ü�� �����Ѵ�.
//	�� ������ �ð��� ��, ��, ��, ��, ��, �� ������ ������ ����ü ����� �־��ش�.
//	t = localtime(&timer);
	time_t timer = time(NULL);
	struct tm *t = localtime(&timer);

//	C/CPP�� ��¥�� 1900���� �������� ó���ϱ� ������ �⵵�� ���� ���� 1900�� ���� ���� ����
//	1�� ������� �ϰ� �ݴ�� �־��� ���� �⵵�� 1900�� ���� 1�� ���� �־���� �Ѵ�.
	cout << "���� �⵵ : " << t->tm_year + 1900 << endl;
	cout << "���� �� : " << t->tm_mon + 1 << endl;
	cout << "���� �� : " << t->tm_mday << endl;
	cout << "���� �ð� : " << t->tm_hour << endl;
	cout << "���� �� : " << t->tm_min << endl;
	cout << "���� �� : " << t->tm_sec << endl;
//	tm_wday : ������ ���ڷ� ���´�. �Ͽ���(0), ������(1), ..., �����(6)
	cout << "���� ���� : " << t->tm_wday << endl;
	cout << "1�� 1�� ���� ������ ��¥ : " << t->tm_yday << endl;
	cout << "����Ÿ�� �ǽÿ��� : " << t->tm_isdst << endl;

}