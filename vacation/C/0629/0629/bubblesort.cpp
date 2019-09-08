#include "config.h"

void main() {

	int data[] = {8, 3, 4, 9, 1};

	for(int i=0 ; i<4 ; i++) {						// 회전수, 선택 정렬과 똑같다.
		for(int j=0 ; j<4-i; j++) {					// 비교

//			cout << "i = " << i << ", j = " << j << endl;
			if(data[j] > data[j+1]) {
				swap(data[j], data[j+1]);
			}

		}		// 회전 종료
		cout << i + 1 << "회전 결과 : ";
		for(int j=0 ; j<5 ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}			// 정렬 종료

}