#include "config.h"
#include <time.h>							// C언어에서 time() 함수를 사용할 수 있게 해주는 헤더 파일
#include <stdlib.h>							// C언어에서 rand(), srand() 함수를 사용할 수 있게 해주는 헤더 파일

void main() {

//	rand() : 0 이상인 난수(무작위수)를 발생시킨다. 난수를 그냥 발생시키면 매번 같은 값이 나오므로 반드시 rand() 함수를
//	실행하기 전에 난수 초기화 작업을 해줘야 한다.
//	srand() : 괄호 안의 시간을 이용해 난수를 초기화 한다.
//	time(NULL) : 1970년 1월 1일 0시 부터 이 함수가 실행되는 순간까지 지나온 시간을 초 단위로 표시한다.
//	cout << time(NULL) << endl;

	srand((unsigned)time(NULL));						// 난수 초기화
//	for(int i=0 ; i<10 ; i++) {
//		int r1 = rand() % 6 + 1;
//		int r2 = rand() % 6 + 1;
//		cout << r1 << ", " << r2 << endl;
//	}
//	cout << "========================================" << endl;

	int count[6] = {0, };
	for(int i=0 ; i<10 ; i++) {
//		int r = rand() % 6 + 1;
//		cout << r << endl;
//		count[r-1]++;
		count[rand() % 6]++;
	}
	for(int i=0 ; i<6 ; i++) {
		cout << i + 1 << " : " << setw(2) << count[i] << endl;
	}

}