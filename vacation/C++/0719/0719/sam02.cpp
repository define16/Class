#include "config.h"

class Sungjuk {
private:
	int no;
	char name[21];
	int cpp, java, python, total;
	double average;
	char hakjum;
public:
//	������ ���� ":"�� �� �ʱ�ȭ ����Ʈ�� ����� �� �ִ�.
//	�ʱ�ȭ ����Ʈ�� �̿��� �����ڿ��� ����� �ʱ�ȭ ��ų �� �ִ�.
//	���� �迭�� �ʱ�ȭ ����Ʈ�� �̿��� ����� �ʱ�ȭ ��ų �� ����.
	Sungjuk() : no(0), /*name("����"),*/cpp(10), java(10), python(10) {
//		no = 0;
		strcpy_s(this->name, "����");
//		cpp = 0;
//		java = 0;
//		python = 0;
		calc();
	}
	Sungjuk(int no, char name[21], int cpp, int java, int python) {
		this->no = no;
		strcpy_s(this->name, name);
		this->cpp = cpp;
		this->java = java;
		this->python = python;
		calc();
	}
//	�����ڿ��� ����, ���, ������ ����ϴ� �Լ�
	void calc() {
		total = cpp + java + python;
		average = (double)total / 3;
		switch((int)average / 10) {
			case 10: case 9: hakjum = 'A'; break;
			case 8: hakjum = 'B'; break;
			case 7: hakjum = 'C'; break;
			case 6: hakjum = 'D'; break;
			default: hakjum = 'F';
		}
	}

//	�Ҹ���(�ı���) �Լ�(���� �Ҹ���)
//	�Ҹ����� �̸��� Ŭ���� �̸� �տ� "~"�� ���̸� �ȴ�.
//	�Ҹ��ڴ� ��ü�� �Ҹ�Ǵ� ���� �ڵ����� ����Ǹ� �����ڿ��� �������� �޸𸮸� �Ҵ��� ���
//	�Ҵ�� ���� �޸𸮸� �����Ϸ��� �������� �ַ� ���ȴ�.
	~Sungjuk() {
//		cout << "��ü�� �Ҹ�˴ϴ�." << endl;
	}

//	��ü�� ����� ������ ����ϴ� �Լ�
	void toString() {
		cout << name << "���� ����� " << average << "�� �̰� ������ " << hakjum << " �Դϴ�." << endl;
//		printf("%s���� ����� %6.2f�� �̰� ������ %c�Դϴ�.\n", name, average, hakjum);
	}

};

void main() {

	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk();
	s1.toString();
	s2->toString();

	class Sungjuk s3(1, "ȫ�浿", 100, 100, 100);
	class Sungjuk *s4 = new Sungjuk(2, "�Ӳ���", 85, 79, 88);
	s3.toString();
	s4->toString();

	delete s2;
	delete s4;

}