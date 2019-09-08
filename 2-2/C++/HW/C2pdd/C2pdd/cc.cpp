#include <iostream>
#include <string>
using namespace std;

void report6()
{
	int input, minute, second, hour;
	const int SEC_PER_MINUTE=60;
	
	cout << "초단위의 시간을 입력하시요:(32억초이하) ";
	cin >> input;		// 초단위의 시간을 읽는다.
	
	hour = (input / SEC_PER_MINUTE) / SEC_PER_MINUTE;
	minute = (input / SEC_PER_MINUTE) % SEC_PER_MINUTE;	// 몇 분
	second = input % SEC_PER_MINUTE;	// 몇 초
	
	cout << input << "초는 " << hour << "시 " << minute << "분 " << second << "초 입니다." << endl;
	
}

void test1(void)
{
	double a,b,c;
	double sum = 0, avg=0;
	char d;

	cout << "점수를 쓰세요";
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

	cout << "점수의 합은 " << sum << "이고, ";
	printf("평균은 %0.1f 입니다.",avg);
	cout << "학점은 " << d << "입니다. " << endl;

}

void test2(void)
{
	double i[5];
	double temp;
	cout << "5개의 실수를 입력해주세요 : ";
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