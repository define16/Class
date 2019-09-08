#include "config.h"

void main() {

	int dec, n, bin[8] = {0, }, i = 7;
	cout << "10진수와 변환할 진법 : ";
	cin >> dec >> n;

	while(true) {
		int mok = dec / n;
		bin[i--] = dec % n;
		if(mok == 0) {
			break;
		}
		dec = mok;
	}

//	char hex[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	for(int i=0 ; i<8 ; i++) {
//		cout << hex[bin[i]] << " ";
		if(bin[i] < 10) {
			cout << bin[i] << " ";
		} else {
			cout << (char)(bin[i] + 55) << " ";
		}
	}
	cout << endl;

}