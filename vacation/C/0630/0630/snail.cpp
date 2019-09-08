#include "config.h"

void main() {

	int a[5][5] = {0, };
	int n = 0, s = 1, i = 0, j = -1, k = 5;

	while(true) {
		for(int p=1 ; p<=k ; p++) {
			j += s;
			a[i][j] = ++n;
		}
		if(--k == 0) {
			break;
		}
		for(int p=1 ; p<=k ; p++) {
			i += s;
			a[i][j] = ++n;
		}
		s *= -1;
	}

	for(i=0 ; i<5 ; i++) {
		for(j=0 ; j<5 ; j++) {
			cout << setw(2) << a[i][j] << " ";
		}
		cout << endl;
	}

}