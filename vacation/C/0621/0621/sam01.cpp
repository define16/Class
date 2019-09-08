#include "config.h"

//	유클리드 호제법을 이용한 최대공약수, 최소공배수 구하기
//	① 숫자 2개를 입력받아 큰 수와 작은 수를 판별한다.
//	② 큰수를 작은수로 나눈 나머지가 0이면 작은수가 최대공약수고 입력받은 2개의 숫자를 곱한 값을 최대공약수로 나누면
//	최소공배수가 된다.
//	③ 큰수를 작은수로 나눈 나머지가 0이 아니면 큰수에 작은수를 넣고 작은수에는 나머지를 넣고 ② 작업 부터 반복한다.
void main() {

	int a, b;
	cout << "숫자 2개를 입력하세요 : ";
	cin >> a >> b;

	int big, small;
	if(a > b) {
		big = a; small = b;
	} else {
		big = b, small = a;
	}
//	big = a > b ? a : b;
//	small = a < b ? a : b;
//	cout << "큰수 : " << big << ", 작은수 : " << small << endl;

	while(true) {

		int r = big % small;
		if(r == 0) {				// 무한 Loop 탈출 조건
			break;
		}
		big = small;
		small = r;

	}

	cout << "최대공약수 : " << small << ", 최소공배수 : " << a * b / small << endl;

}