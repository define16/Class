#include "config.h"

void main() {

	int a[4][5] = {0, };
	int count = 0;

	for(int i=0 ; i<4 ; i++) {

		if(i % 2 == 0) {			// 짝수행인가?
//			열(j)을 0 부터 시작해서 5 보다 작을때 까지 1씩 증가시킨다.
			for(int j=0 ; j<5 ; j++) {
				a[i][j] = ++count;
			}
		} else {
//			열(j)을 4 부터 시작해서 -1 보다 클때 까지 1씩 감소시킨다.
			for(int j=4 ; j>-1 ; j--) {
				a[i][j] = ++count;
			}
		}

	}

	for(int i=0 ; i<4 ; i++) {
		for(int j=0 ; j<5 ; j++) {
			cout << setw(2) << a[i][j] << " ";
		}
		cout << endl;
	}

}