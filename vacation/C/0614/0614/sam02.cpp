#include "config.h"

void main() {

	int cpp, java, jsp;
	cout << "3���� ������ �Է��ϼ��� : ";
//	scanf("%d %d %d", &cpp, &java, &jsp);
	cin >> cpp >> java >> jsp;
	int total = cpp + java + jsp;
	double average = (double)total / 3;

	if(average >= 90) {
		cout << "A" << endl;
	} else if(average >= 80) {
		cout << "B" << endl;
	} else if(average >= 70) {
		cout << "C" << endl;
	} else if(average >= 60) {
		cout << "D" << endl;
	} else {
		cout << "F" << endl;
	}

}