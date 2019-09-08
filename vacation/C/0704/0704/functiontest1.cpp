#include "config.h"
#include "func.h"

void main() {

	cout << "1~100의 합계 : " << total() << endl;
	int n;
	cout << "숫자를 입력하세요 : ";
	cin >> n;
	cout << "1~" << n << "의 합계 : " << total(n) << endl;
	cout << "실인수 n에 저장된 값 : " << n << endl;
	int m;
	cout << "숫자 2개를 입력하세요 : ";
	cin >> n >> m;
	cout << n << "~" << m << "의 합계 : " << total(n, m) << endl;

}
