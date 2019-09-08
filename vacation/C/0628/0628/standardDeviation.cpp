#include "config.h"
#include <math.h>								// 수학에 관련된 함수를 사용하려 할 경우 붙이는 헤더 파일

void main() {

	int n;
	cout << "표준편차를 계산할 데이터 개수 : ";
	cin >> n;
	int *data = new int[n];
	cout << "표준편차를 계산할 데이터 입력 : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

//	입력받은 데이터를 정렬한다.
	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++) {
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}
		}
	}

//	점수의 최대값과 최소값을 제외한 나머지의 합계와 평균을 계산한다.
	int sum = 0;
	for(int i=1 ; i<n-1 ; i++) {				// 정렬 결과의 처음, 마지막 값을 제외하고 반복한다.
		sum += data[i];
	}
	double average = (double)sum / (n - 2);		// 최대값, 최소값을 제외해야 하므로 n - 2로 나눈다.

//	최대값과 최소값을 제외한 각 변량(점수)에서 산술평균을 뺀 편차의 제곱의 합계를 구한다.
	double total = 0.0;
	for(int i=1 ; i<n-1 ; i++) {
//		total += (data[i] - average) * (data[i] - average);
//		double temp = data[i] - average;
//		total += temp * temp;
//		pow(x, y) : x의 y승을 계산한다. x는 무조건 실수만 올 수 있고 y는 숫자만 나오면 된다.
		total += pow(data[i] - average, 2);
	}

//	분산을 계산한다.
	double var = total / (n - 2);
//	표준편차를 계산한다.
	double dev = sqrt(var);

	cout << "입력받은 점수의 표준편차는 " << dev << "입니다." << endl;

}