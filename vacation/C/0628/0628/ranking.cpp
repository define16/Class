#include "config.h"

void main() {

	int n;
	cout << "석차를 계산할 데이터 개수 : ";
	cin >> n;
//	입력받은 데이터의 개수만큼 동적 배열을 만든다.
	int *data = (int *)malloc(sizeof(int) * n);			// 점수를 기억할 배열
	int *rank = new int[n];								// 석차를 기억할 배열
//	석차를 계산할 점수를 입력받는다.
	cout << "석차를 계산할 데이터 입력 : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
		rank[i] = 1;									// 석차를 기억할 기억장소의 초기치는 무조건 1로 지정한다.
	}

//	선택정렬 알고리즘 반복원리를 사용해 반복하며 내림차순 석차(큰게 1등)를 계산한다.
	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++) {

//			부등호 방향을 반대로 변경하면 오름차순 석차(작은게 1등)을 계산할 수 있다.
			if(data[i] > data[j]) {
//				i번째 점수가 크면 j번째 석차를 1증가시킨다.
				rank[j]++;
			} else if(data[i] < data[j]) {
//				j번째 점수가 크면 i번째 석차를 1증가시킨다.
				rank[i]++;
			}

		}
	}

	for(int i=0 ; i<n ; i++) {
		cout << setw(3) << data[i] << "점은 " << rank[i] << "등 입니다." << endl;
	}

	free(data);
	delete[] rank;

}