#include "config.h"

//	완전수는 자기 자신을 제외한 양의 약수의 합이 자신과 같은 수
void main() {

	int n;
	cout << "완전수를 판별할 숫자를 입력하세요 : ";
	cin >> n;

	int sum = 0;
//	자기 자신을 제외하고 어떤 수를 나눠 떨어뜨릴 수 있는 가장 큰수는 자기 자신의 절반을 넘어가지 않는다.
	for(int i=1 ; i<=n/2 ; i++) {
		if(n % i == 0) {				// i가 n의 약수인가?
			sum += i;
		}
	}

	if(n == sum) {
		cout << n << "은 완전수 입니다." << endl;
	} else {
		cout << n << "은 완전수가 아닙니다." << endl;
	}

}