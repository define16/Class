#include "config.h"
#include "date.h"

void main()
{
	cout <<"���н� Ÿ�� : " << unixTime() << endl;
	cout <<"���� �⵵ : " << getYear() << endl;
	cout <<"���� �� : " << getMonth() << endl;
	cout << "���� �� : " << getDay() << endl;
	  cout << "���� �ð� : " <<getHour()<< endl;
	  cout << "���� �� : " << getMin() << endl;
	  cout << "���� �� : " << getSec() << endl;
	  cout << "���� ���� : " << getWday() << endl;
	  cout << "1�� 1�Ϻ��� ������ ��¥ : " <<getYday()  << endl;
	  cout << "����Ÿ�� �ǽ� ���� : " << getIsdst()<< endl;	
}
