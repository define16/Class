#include "config.h"

void main() {

	int superball[59];
	for(int i=0 ; i<59 ; i++) {
		superball[i] = i + 1;
	}
	srand((unsigned)time(NULL));
	for(int i=0 ; i<1000000 ; i++) {
		int r = rand() % 58 + 1;
//		int temp = superball[0];
//		superball[0] = superball[r];
//		superball[r] = temp;
		swap(superball[0], superball[r]);					// 두 기억장소의 값을 교환하는 함수
	}
	cout << "흰공 : ";
	int start = time(NULL);
	for(int i=0 ; i<5 ; i++) {
		if(i > 0) {
			cout << ", ";
		}
		cout << superball[i];
		while(true) {
			if((start + i + 1) == time(NULL)) {
				break;
			}
		}
	}
	cout << " 빨간공 : " << rand() % 35 + 1 << endl;

}