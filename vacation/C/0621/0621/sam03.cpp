#include "config.h"

//	4~10000 사이의 완전수와 완전수의 개수를 출력하는 정보처리기사 알고리즘

void main() {

	int count = 0;

	for(int n=4 ; n<=10000 ; n++) {

		int sum = 0;
		for(int i=1 ; i<=n/2 ; i++) {

			if(n % i == 0) {
				sum += i;
			}

		}
		if(n == sum) {
			cout << ++count << "번째 완전수 : " << setw(4) << n << endl;
		}

	}

	cout << "완전수의 개수 : " << count << "개" << endl;

}