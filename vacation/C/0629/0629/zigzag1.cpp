#include "config.h"

void main() {

	int a[4][5] = {0, };
	int count = 0, start = 0, end = 4, sw = 1;

	for(int i=0 ; i<4 ; i++) {

		for(int j=start ; j!=end+sw ; j+=sw) {
			a[i][j] = ++count;
		}
		swap(start, end);
		sw *= -1;

	}

	for(int i=0 ; i<4 ; i++) {
		for(int j=0 ; j<5 ; j++) {
			cout << setw(2) << a[i][j] << " ";
		}
		cout << endl;
	}

}