#include "config.h"

void main() {

	int cpp, java, jsp;
	cout << "3���� ������ �Է��ϼ��� : ";
	cin >> cpp >> java >> jsp;
	int total = cpp + java + jsp;
	double average = (double)total / 3;

//	key�� ������ ����ϴ� ���� �Ǵ� ���� ����� ������ ���ĸ� �� �� �ִ�.
//	switch(key) {
//		case value:
//			key�� value ���� ��ġ�� ��� ������ ����;
//			...;
//			[break;]							// {} ����� Ż���Ѵ�.
//		...;
//		[default:
//			key�� ��ġ�ϴ� value ���� ���� ��� ������ ����;]
//	}

	switch((int)average / 10) {
		case 10:
			cout << "�ڡڡڡڡ� �����߾�� �ڡڡڡڡ�" << endl;
//			cout << "A" << endl; break;
		case 9:
			cout << "A" << endl; break;
		case 8:
			cout << "B" << endl; break;
		case 7:
			cout << "C" << endl; break;
		case 6:
			cout << "D" << endl; break;
		default:
			cout << "F" << endl;
	}

}