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
	Sungjuk()
	{
		cout << "�⺻ �����ڰ� ����˴ϴ�." << endl;
	}
// ����� �ʱ�ȭ ��Ű�� ������
		Sungjuk(int no,char name[21],int cpp, int java, int python, int total, double average,char hajum){
// ���� {} ��Ͽ� ��� ������ ���� ������ ���� �̸��� ���� ��� ���� ������ �켱���� �ο��ȴ�. ��, ���� �̸��� ������ ���� ������ �νĵȴ�.
// this : �ڱ� �ڽ��� Ŭ������ �ǹ��ϴ� ������
			this->no = no; //���⼭ this�� �������̹Ƿ� ->�� ����Ѵ�. 
		//	this->name = name; // ����� �� ����.
			strcpy_s(this ->name,name);  //���ڿ� �ʱ�ȭ ���
			this->cpp = cpp;
			this->java = java;
			this->python = python;
			this->hajum = hajum;
			total = cpp + java + python;
			average = (double)total / 3;

			switch((int)average/10){
			case 10:
			case 9:
				hajum = 'A';
				break;
			case 8:
				hajum = 'B';
				break;
			case 7:
				hajum = 'C';
				break;
			case 6:
				hajum = 'D';
				break;
			default : 
				hajum = 'F';
			}

		}
};

void main()
{
// �Ʒ��� 2���� ��� ��� �⺻ �����ڸ� �̿��� ��ü�� �����ȴ�.
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk(); //�޸� ������ �����. �׷��� delete s2�� �־� ����Ѵ�.

//���ڹ迭�� "="���� ���� ���� �� �ִ� ���� �迭�� ���� �� ���� �����ϴ�.
//	char name[21] = "ȫ�浿";
//	name = "�Ӳ���";	//����.
	char name[21] = "ȫ�浿";
//strcpy_s/strcpy(�迭��, �迭�� ������ ���ڿ�);
	strcpy(name, "�Ӳ���");	//���ڿ� �޴� �Լ�.
	cout << name << endl;

	delete s2;
}