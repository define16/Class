#include "config.h"

//int total();	//함수를 main()함수 뒤에 선언할 경우 반드시; mian 앞에 함수의 원형을 적어주어야한다.
//int total(int);

// 함수의 디폴트 인수
// 디폴트 인수는 함수가 호출될 때 인수가 넘어오면 인수를 받아서 함수를 실행하고
// 인수가 넘어오지 않으면 디폴트로 지정된 인수를 가지고 함수를 실행한다. 
int total(int n = 100)
{
	int i, sum = 0;

	for(i=1;i<=n;i++)
		sum += i;

	return sum;
}

void main()
{
	cout << "1~100의 합계 : " << total() << endl;
	int n;
	cout << "합계를 계산할 수 입력 : ";
	cin >> n;
	cout << "1~" << n << "의 합계 : " << total(n) << endl;
}

//int total()
//{
//	int i, sum = 0;
//
//	for(i=1;i<=100;i++)
//		sum += i;
//	return sum;
//
//}
//
//int total(int n)
//{
//	int i, sum = 0;
//
//	for(i=1;i<=n;i++)
//		sum += i;
//
//	return sum;
//}
