#include "config.h"

void main() {

	int n;
	cout << "정렬할 데이터 개수 : ";
	cin >> n;
	int *data = new int[n];

	cout << "정렬할 데이터 입력 : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

	for(int i=0 ; i<n-1 ; i++) {

//		정렬 작업을 시작하기 전에 flag 변수를 false로 초기화 한다.
		bool flag = false;

		for(int j=0 ; j<n-1-i; j++) {
			if(data[j] > data[j+1]) {
				swap(data[j], data[j+1]);

//				값교환이 실행되면 정렬 작업이 진행되는 상태이므로 flag를 true로 변경한다.
				flag = true;

			}
		}

//		flag의 값이 초기화한 false 그대로라면 값교환 작업이 한 번도 실행되지 않은 상태 즉, 정렬이 이미 완료된
//		상태이므로 반복을 탈출한다.
		if(!flag) {
			break;
		}

		cout << i + 1 << "회전 결과 : ";
		for(int j=0 ; j<n ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}

}