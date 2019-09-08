#include "config.h"

void main() {

//	for가 끝나기 전에 새로운 for가 나오는 것을 다중 반복이라 하고 바깥쪽 반복에 쓰이는 변수와 안쪽 반복에 쓰이는 변수의
//	이름이 겹치지 않도록 주의한다.
//	바깥쪽 반복문의 변수 값이 1번 변경될 때 안쪽 반복문은 완전히 한 번 실행된다.
//	for(int i=0 ; i<3 ; i++) {
//		for(int j=0 ; j<5 ; j++) {
//			cout << "i = " << i << ", j = " << j << endl;
//		}
//		cout << endl;
//	}

//	*
//	**
//	***
//	****
//	*****
	for(int i=0 ; i<5 ; i++) {					// 행
		for(int j=0 ; j<i+1 ; j++) {
//			cout << "i = " << i << ", j = " << j << endl;
			cout << "*";
		}
		cout << endl;							// 별 한 줄을 출력하고 줄을 바꿔준다.
	}
	cout << "==============================" << endl;

//	*****
//	****
//	***
//	**
//	*
	for(int i=0 ; i<5 ; i++) {
		for(int j=0 ; j<5-i ; j++) {
//			cout << "i = " << i << ", j = " << j << endl;
			cout << "*";
		}
		cout << endl;
	}
	cout << "==============================" << endl;

//	    *
//	   **
//	  ***
//	 ****
//	*****
	for(int i=0 ; i<5 ; i++) {
//		"*"을 출력하기 전에 빈칸(" ")을 출력하는 반복
		for(int j=0 ; j<4-i ; j++) {
			cout << " ";
		}
		for(int j=0 ; j<i+1 ; j++) {
			cout << "*";
		}
		cout << endl;
	}
	cout << "==============================" << endl;

//	*****
//	 ****
//	  ***
//	   **
//	    *
	for(int i=0 ; i<5 ; i++) {
		for(int j=0 ; j<i ; j++) {
			cout << " ";
		}
		for(int j=0 ; j<5-i ; j++) {
			cout << "*";
		}
		cout << endl;
	}
	cout << "==============================" << endl;

//	*       *
//	**     **
//	***   ***
//	**** ****
//	*********
	for(int i=0 ; i<5 ; i++) {
		for(int j=0 ; j<i+1 ; j++) {
			cout << "*";
		}
		for(int j=0 ; j<7-i*2 ; j++) {
			cout << " ";
		}
		for(int j=0 ; j<i+1 ; j++) {
			if(j == 4) {
				break;
			}
			cout << "*";
		}
		cout << endl;
	}
}