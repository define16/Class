#include <iostream>
#include <string>
using namespace std;

void report6()
{
	string name[]={""};
	string name1;
	int max=0,i=0,cnt=0;
	
	cout << "3���� �̸��� ' , '�� �����Ͽ� �Է��ϼ���. : ";
	cin >> name1;
	for(int i=0;i<name1.length();i++)
		name[i]+=name[i];
	
	string *named = new string[name[i].length()];
		for(unsigned int j=0; j< named[j].length();j++)
		{
			if(named[i][j]==',')
			{
				cnt++;
				name[i][j]='\0';
			}
		cout<< cnt+1 << " : " << named[i]<<endl;
		if(named[i].length()>named[max].length())
			max=i;
	
		}
		
		
	
	cout<< "���� �� �̸��� : [ "<< named[max]<<" ] �Դϴ�."<<endl;

}