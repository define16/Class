#include <iostream>
#include <string>
using namespace std;

//void fun1()
//{
//	int cnt = 0;
//
//	for(int i=1;i<=100;i++)
//	{
//		cout << i << " ";
//		if(i%10==0)
//			cout << endl;
//	}
//
//}
//
//void fun2(){
//
//	for(int i=1;i<=9;i++)
//	{
//		for(int j=1;j<=9;j++)
//		{
//			if((i*j) < 10)
//				cout << i << "*" <<j << "=" << i*j << "  ";
//			else
//				cout << i << "*" <<j << "=" << i*j << " ";
//		}
//		cout << endl;
//	}
//}
//
//
//
//void fun3()
//{
//	double in[5];
//	double temp;
//	cout << "5���� �Ҽ����� ���� �Ǽ��� �Է��ϼ��� : ";
//	for(int i=0;i<5;i++)
//		cin >> in[i];
//
//	for(int i=0;i<4;i++)
//	{
//		for(int j=i+1;j<5;j++)
//		{
//			if(in[i] < in[j])
//			{
//				temp = in[i];
//				in[i] = in[j];
//				in[j] = temp;
//			}
//		}
//	}
//	cout << "���ĵ� ����" << endl;
//
//	for(int i=0;i<5;i++)
//		cout << in[i] << endl;
//}
//
void fun4()
{
	stirng s;
	int i=0,cnt=0;

	cout << "���ڸ� �Է����ּ��� : ";
	cin >> s;

	while(!s.empty())
	{
		if(s.find('\n') )
			break;
		else{
			if(s.find('a') || s.find('A'))
				cnt++;
			i++;
			}
	}
	cout << "a �Ǵ� A�� ������ : " << cnt << " �Դϴ�." << endl;
}

//void fun5()
//{
//	char c[100];
//	int i=0;
//	cout << "���ڿ� �Է�>> ";
//	cin >> c;
//
//	while(c[i] != '\0')
//	{
//		for(int j=0;j<=i;j++)
//		{
//			cout << c[j];
//		}
//		i++;
//		cout << endl;
//	}
//}



int self_length(char c[100][100])
{
	int cnt = 0, i = 0 , j=0;

	while(c[i])
	{
		while(c[j++] != '\0')
			cnt++;
		i++;

	}
	return cnt;
}


void fun6()
{
	int cnt=0, num=1, index=0,index_s1=0, cnt2=0, int_temp = 0, temp2=0;;
	char s[100] = " ", temp[100] = " ";
	int index_s1_temp[100];
	char s1[100][100];

	cout << "3���� �̸��� ','�� �����Ͽ� �Է��ϼ���: ";
	cin >> s;

	while(s[index])
	{
		index++;
	}
		cout << index <<endl;
	for(int i=0;i<=index;i++)
	{
		if(s[i] == ',')
		{
			cnt++;
			index_s1 = 0;
			continue;
		}
		else
		{
			s1[cnt][index_s1++] = s[i];
			index_s1_temp[cnt2] = index_s1;

			for(int i=0;i<cnt2;i++)
			{
				for(int j=i+1;j<=cnt2;j++)
				{
					if(index_s1_temp[i] < temp[j])
						temp[temp2++] = s1[cnt][index_s1++];
				}
			}

			for(int i=0;i<=cnt2-1;i++)
			{
				for(int j=i+1;j<=cnt2;j++)
				{
					if(index_s1_temp[i] < index_s1_temp[j])
					{
						int_temp = index_s1_temp[j];
						index_s1_temp[j] = index_s1_temp[i];
						index_s1_temp[i] = int_temp;
					}
				}
			}
		}
	}

	cout << "index_s1 : " << index_s1_temp[0] << endl;
	for(int i=0;i<=cnt;i++)
	{
		for(int j=0;j<=index_s1_temp[0];j++)
			cout << s1[i][j];
		cout << endl;
	}
	for(int i=0;i<=index_s1_temp[0];i++)
	{
		cout << temp[i] << endl;
	}
	/*for(int index=0;index<=cnt;index++)
	{
		cout << num++ << ": " ;
		for(int k=0;k<index_s1;k++)
			cout << s1[index][k] << endl;
	}*/


	//for(int i=0;i<=cnt-1;i++)
	//{
	//	for(int j=i+1;j<=cnt;j++)
	//	{
	//		if(self_length(s1[i])) < self_length(s1[j]))
	//		{
	//			temp[i] = s1[j];
	//			s1[i] = s1[j];
	//			s1[j] = temp[i];
	//		}
	//	}
	//}



	//cout<< "���� �� �̸��� [" << s1[0] << "]�Դϴ�" << endl;
	
}
