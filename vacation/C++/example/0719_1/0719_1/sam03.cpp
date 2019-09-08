#include "config.h"

class Sungjuk
{	
	private:		
		int no;	
		char name[21];
		int cpp, java, python, total;
		double average;
		char hajum;

	public:
		/*Sungjuk()
		{
			no = 0;
			strcpy_s(name,"ȫ�浿��"); 
			cpp = 0;
			java = 0;
			python = 0;
			hajum = 0;
			calc();
		}

		Sungjuk(int no,char name[21],int cpp, int java, int python){
			this->no = no; 
			strcpy_s(this ->name,name);  
			this->cpp = cpp;
			this->java = java;
			this->python = python;
			this->hajum = hajum;
			calc();
		}*/


//����Ʈ�μ��� �̿��� �⺻ �����ڰ� ����Ǹ� �⺻������ �ʱ�ȭ ��Ű�� ���� �Ѱܹ��� 
//�����ڰ� ����Ǹ� �Ѱ� ���� ������ ����� �ʱ�ȭ ��Ű�� ������
//����Ʈ�μ��� �����Ϸ��� ��� �μ��� �����ؾ� �Ѵ�.
		Sungjuk(int no  = 0, char name[21] = "����", int cpp  = 0, int java  = 0, int python  = 0){
			this->no = no; 
			strcpy_s(this ->name,name);  
			this->cpp = cpp;
			this->java = java;
			this->python = python;
			this->hajum = hajum;
			calc();
		}



		~Sungjuk()
		{
			cout << "��ü�� �Ҹ�˴ϴ�."<<endl;
		}

//Ŭ������ ��� �Լ��� Ŭ���� �ܺο��� ������ �� �ִ�.
//Ŭ���� ���ο��� �ܺο��� ������ �Լ��� ������ �����ְ� Ŭ���� �ܺο��� �Լ��� ������ �� �ݵ��
//�Ҽ� Ŭ���� "::"�� ����� �˷��ָ� �ȴ�.
		void toString();	 //void Sungjuk :: toString() 
		void calc();		//	void Sungjuk :: calc()
};
	void Sungjuk :: toString() 
	{
		cout << name << "���� ����� " << average << "���̰� ������ " << hajum << "�Դϴ�." << endl;
	}

	void Sungjuk :: calc()
	{
		total = cpp + java + python;
		average = (double)total / 3;

		switch((int)average/10)
		{
		case 10: case 9: hajum = 'A'; break;
		case 8: hajum = 'B'; break;
		case 7: hajum = 'C'; break;
		case 6: hajum = 'D'; break;
		default : hajum = 'F';
			}
	}

void main()
{
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk(); 
	s1.toString(); 
	s2->toString();

	class Sungjuk s3(1,"ȫ�浿", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2,"�Ӳ���",85,79,88);
	s3.toString();
	s4->toString();

// ��ü���� ����� private ���� ������ �ʹ� �����ϰ� ����ǹǷ� private�������� ������ ����� ������
// �����ϵ��� ����(getter & setter�Լ�, friend ����)�� �д�.

// getter �Լ� : get���� �����ϰ� ��� �̸��� ������ �Լ��� private ����� ���� ���� �� ����Ѵ�.
// getter�� �Լ��� ���� Ÿ���� ����� �ڷ����̰� �μ��� ���� �ʴ´�.
//	 int getJava()
//	 {
//		 return java;
//	 }
//	 setter �Լ� : set���� �����ϰ� ��� �̸��� ������ �Լ��� private ����� ���� ������ �� ����Ѵ�.
// setter�� �Լ��� ���� Ÿ���� void�̰� �μ��� ����� ������ �����͸� �޴´�.
//	 void setJava(int java)
//	 {
//	 	 this->java = java;
//	 }

//	s3.java = 97;


	delete s2; delete s4;
}