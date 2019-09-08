#include "config.h"

class Memo {
private:
//	���� ��� ������ Ŭ���� �ܺο��� �ʱ�ȭ�� ���Ѿ� �Ѵ�.
//	���� ��� ������ ���� Ŭ������ �����Ǵ� ��� ��ü���� �����ؼ� ���ȴ�.
//	static�� ���� �ʴ� ��� ������ �ν��Ͻ� ��� ������ �θ��� ���� Ŭ������ �����Ǵ�
//	������ ��ü���� ������ ��� ������ ������.
	static int count;		// ���� ��� ����
	int no;					// �ڵ�����
	char name[21];
	char memo[101];
public:
	/*
	Memo() {
		no = ++count;
		strcpy(name, "����");
		strcpy(memo, "����");
	}
	Memo(int no, char name[21], char memo[101]) {
		no = ++count;
		strcpy(this->name, name);
		strcpy(this->memo, memo);
	}
	*/
	Memo(char name[21] = "����", char memo[101] = "����") {
		no = ++count;
		strcpy_s(this->name, name);
		strcpy_s(this->memo, memo);
	}
	void toString() {
//		printf("%d. %s���� ���主 : %s\n", no, name, memo);
		cout << no << ". " << name << "���� ���主 : " << memo << endl;
	}
};

//	Memo Ŭ�������� ����� ���� ���� count�� �ʱ�ȭ
int Memo::count = 0;

void main() {

	class Memo memo1;
	memo1.toString();
	class Memo memo2("ȫ�浿", "���~~~");
	memo2.toString();
	class Memo memo3("�Ӳ���", "����~~~");
	memo3.toString();

//	memo1.count = 100;
//	cout << memo3.count << endl;

	class Memo memo4("������", "����~~~");
	memo4.toString();

}