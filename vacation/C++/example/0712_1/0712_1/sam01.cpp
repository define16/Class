#include "config.h"


//�ý��۱���ü

void main()
{
	//srand((unsigned)time(NULL)); //�����Լ� �ʱ�ȭ
	//rand(); //�����Լ�

	cout <<"���" << endl; //������ �޼��� ����϶� ������.
	cout << "���н�Ÿ�� :" << time(NULL)<< endl;
	//time(NULL) : ���н�Ÿ��
	// 1970�� 1�� 1�Ϻ��� ���Լ��� ����Ǵ� �������� ������ �ð��� �ʴ����� ����Ѵ�.

	 //time_t timer; // time.h�� ����� �ý��۱���ü tm����ü������ �����Ѵ�.
	 //struct tm *t; // tm ����ü ������ ����
	 //timer = time(NULL); // ����ð��� �ʴ����� �� ����ü�� �����Ѵ�.
	 // �� ������ �ð��� ��,��,��,��,��,�� ������ �����ؼ� ����ü �ɹ��� �־��ش�.
	 //t = locatltime(&timer); 

	 time_t timer = time(NULL);
	  struct tm *t = localtime(&timer); 
	  //���� ���ٰ� ����

	  //c/cpp�� ��¥�� 1900���� �������� ó���ϱ⶧���� �⵵�� ���ö��� 
	  //1900�� ���� ���ö��� 1�� ��������ϰ� �ݴ�� �־��ٶ��� �⵵�� 1900�� ���� 1�� ���� �־�����Ѵ�.
	  cout << "���� �⵵ : " << t->tm_year + 1900 << endl;
	  cout << "���� �� : " << t->tm_mon + 1 << endl;
	  cout << "���� �� : " << t->tm_mday + 1900 << endl;
	  cout << "���� �ð� : " << t->tm_hour << endl;
	  cout << "���� �� : " << t->tm_min  << endl;
	  cout << "���� �� : " << t->tm_sec  << endl;
	  cout << "���� ���� : " << t->tm_wday << endl;
	  cout << "1�� 1�Ϻ��� ������ ��¥ : " << t->tm_yday  << endl;
	  cout << "����Ÿ�� �ǽ� ���� : " << t->tm_isdst  << endl;	

}
