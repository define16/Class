#include "config.h"

class Sungjuk
{	//�Ϲ������� ��������� private�� ��� �Լ���  public�� ���ٱ������� �����Ѵ�.
private:		//�ѹ� ������ ���� ������ �ٸ� ���� ������ �����ϱ� ������ �����ȴ�.
	int no;		//�ʱ�ȭ�� �Ұ����ϴ�.
	char name[21];
	int cpp, java, python, total;
	double average;
	char hajum;
public:
// �⺸ ������ �ʱ�ȭ �ϱ� ���� ������ �Լ�(���� ������)�� �����.
// �����ڸ� ������ ������ C++�����Ϸ��� �ƹ��� �ϵ� ���� �ʴ� �⺻ �����ڸ� �����.
// ������ �̸��� �ݵ�� Ŭ������ �̸��� ���ƾ� �ϰ�, Ŭ������ ��ü�� �����Ǵ� ���� 
// �ڵ����� ������ �ȴ�.
// �����ڴ� return�� ������ ������ ����Ÿ��(void)�� ������� �ʴ´�.

	//�⺻ �����ڵ� �ʱ�ȭ�� �����־���Ѵ�.
	Sungjuk() : no(0), cpp(0), java(0), python(0)//������ ���� ":"�� �� �ʱ�ȭ ����Ʈ�� ����� �� �ִ�.
	{
//		no = 0;
		strcpy_s(name,"ȫ�浿��");  // ���� �迭�� �ʱ�ȭ ����Ʈ�� �̿��ؼ� �ʱ�ȭ�� �� ���� ����
//		cpp = 0;
//		java = 0;
//		python = 0;
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
	}
	void calc()
	{
			total = cpp + java + python;
			average = (double)total / 3;

			switch((int)average/10){
			case 10: case 9: hajum = 'A'; break;
			case 8: hajum = 'B'; break;
			case 7: hajum = 'C'; break;
			case 6: hajum = 'D'; break;
			default : hajum = 'F';
			}
	}
	

	~Sungjuk()
	{
		cout << "��ü�� �Ҹ�˴ϴ�."<<endl;
	}

	//��ü�� ����� ������ ����ϴ� �Լ�
	void toString()
	{
		cout << name << "���� ����� " << average << "���̰� ������ " << hajum << "�Դϴ�." << endl;
	}

	//�����ڿ��� ����, ���, ������ ����ϴ� �Լ�


};



void main()
{
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk(); 
	s1.toString(); //���ֻ� ����ü�� �Լ��̴�.
	s2->toString();

	class Sungjuk s3(1,"ȫ�浿", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2,"�Ӳ���",85,79,88);
	s3.toString();
	s4->toString();

	//delete�� ���� ����.
	delete s2; delete s4;
}