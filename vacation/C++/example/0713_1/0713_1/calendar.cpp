#include "config.h"
#include "calendar.h"
#include "date.h"

void main() {

	int year = getYear();
	int month = getMonth();

	cout << "============================" << endl;
	printf("         %d�� %d��\n", year, month);
	cout << "============================" << endl;
	cout << " ��  ��  ȭ  ��  ��  ��  �� " << endl;
	cout << "============================" << endl;
	for(int i=1 ; i<=weekDay(year, month, 1) ; i++) {
		cout << "    ";
	}
	for(int i=1 ; i<=lastDay(year, month) ; i++) {
		cout << setw(3) << i << " ";
		if(weekDay(year, month, i) == 6 && lastDay(year, month) != i) {
			cout << endl;
		}
	}
	cout << endl << "============================" << endl;

}