#include <iostream>
#include <string>
using namespace std;

void report6()
{
	int input, minute, second, hour;
	const int SEC_PER_MINUTE=60;
	
	cout << "�ʴ����� �ð��� �Է��Ͻÿ�:(32��������) ";
	cin >> input;		// �ʴ����� �ð��� �д´�.
	
	hour = (input / SEC_PER_MINUTE) / SEC_PER_MINUTE;
	minute = (input / SEC_PER_MINUTE) % SEC_PER_MINUTE;	// �� ��
	second = input % SEC_PER_MINUTE;	// �� ��
	
	cout << input << "�ʴ� " << hour << "�� " << minute << "�� " << second << "�� �Դϴ�." << endl;
	
}

void test1(void)
{
	double a,b,c;
	double sum = 0, avg=0;
	char d;

	cout << "������ ������";
	cin >> a >> b >> c;

	sum = a+b+c;
	avg = sum/3;
	
	if(avg <= 100 && avg >=90)
		d = 'A';

	else if(avg <= 89 && avg >=80)
		d = 'B';
	else if(avg <= 79 && avg >=70)
		d = 'C';
	else if(avg <= 69 && avg >=60)
		d = 'D';
	else
		d = 'F';

	cout << "������ ���� " << sum << "�̰�, ";
	printf("����� %0.1f �Դϴ�.",avg);
	cout << "������ " << d << "�Դϴ�. " << endl;

}

void test2(void)
{
	double i[5];
	double temp;
	cout << "5���� �Ǽ��� �Է����ּ��� : ";
	for(int j = 0;j<5;j++)
		cin >> i[j];

	for(int j=0;j<4;j++)
	{
		for(int k=j+1;k<5;k++)
		{
			if(i[j]<i[k])
			{
				temp = i[j];
				i[j] = i[k];
				i[k] = temp;
			}
		}
	}

	for(int j = 0;j<5;j++)
		cout << i[j] << " ";

	cout << endl;
}