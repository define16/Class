#include "config.h"

class Sungjuk {
//	�Ϲ������� ��� ������ private�� ��� �Լ��� public�� ���� �������� �����Ѵ�.
private:	// �� �� ������ ���� ������ �ٸ� ���� ������ �����ϱ� ������ �����ȴ�.
	int no;
	char name[21];
	int cpp, java, python, total;
	double average;
	char hakjum;
public:
//	��� ������ �ʱ�ȭ �ϱ� ���� ������ �Լ�(���� ������)�� �����.
//	�����ڸ� ������ ������ C++ �����Ϸ��� �ƹ��� �ϵ� ���� �ʴ� �⺻ �����ڸ� �����.
//	������ �̸��� �ݵ�� Ŭ������ �̸��� ���ƾ� �ϰ� Ŭ������ ��ü�� �����Ǵ� ���� �ڵ�����
//	����ȴ�.
//	�����ڴ� return�� ������ ������ ���� Ÿ�Ե� ������ �ʴ´�.

	Sungjuk() {		// �⺻ ������
		cout << "�⺻ �����ڰ� ����˴ϴ�." << endl;
	}

//	����� �ʱ�ȭ ��Ű�� ������
	Sungjuk(int no, char name[21], int cpp, int java, int python) {
//		���� {} ��Ͽ� ��� ������ ���� ������ ���� �̸��� ���� ��� ���� ������ �켱����
//		�ο��ȴ�. ��, ���� �̸��� ������ ���� ������ �νĵȴ�.
//		this : �ڱ� �ڽ��� Ŭ������ �ǹ��ϴ� ������
		this->no = no;
//		this->name = name;				// ���ڿ� �ʱ�ȭ�� "="�� ����� �� ����.
		strcpy_s(this->name, name);		// ���ڿ� �ʱ�ȭ�� �䷸�� �ؾ��Ѵ�.
		this->cpp = cpp;
		this->java = java;
		this->python = python;
		total = cpp + java + python;
		average = (double)total / 3;
		switch((int)average / 10) {
			case 10: case 9:
				hakjum = 'A'; break;
			case 8:
				hakjum = 'B'; break;
			case 7:
				hakjum = 'C'; break;
			case 6:
				hakjum = 'D'; break;
			default:		// ��Ÿ ��� ���̽�
				hakjum = 'F';
		}
	}
};

void main() {

//	�Ʒ��� 2���� ��� ��� �⺻ �����ڸ� �̿��� ��ü�� �����ȴ�.
	class Sungjuk s1;
	class Sungjuk *s2 = new Sungjuk();

//	���� �迭�� "="���� ���� ���� �� �ִ� ���� �迭�� ������ ���� �����ϴ�.
	char name[21] = "ȫ�浿";
	cout << name << endl;
//	name = "�Ӳ���";	// �迭 ���� �� "="���� ���� �־����Ƿ� ������ �߻��ȴ�.
//	strcpy_s(�迭��, �迭�� ������ ���ڿ�);
	strcpy_s(name, "�Ӳ���");
	cout << name << endl;

	delete s2;

}