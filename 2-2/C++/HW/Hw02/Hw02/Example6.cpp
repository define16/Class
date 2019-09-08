#include <iostream>
#include <string>
using namespace std;

void report6()
{
	string name[]={""};
	string name1;
	int max=0,i=0,cnt=0;
	
	cout << "3명의 이름을 ' , '로 구분하여 입력하세요. : ";
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
		
		
	
	cout<< "가장 긴 이름은 : [ "<< named[max]<<" ] 입니다."<<endl;

}