#include "config.h"

void main() {

	int n;
	cout << "정렬할 데이터 개수 : ";
	cin >> n;
//	입력받은 데이터의 개수만큼 메모리를 동적으로 할당한다. ==> 동적 배열
	int *data = new int[n];

	cout << "정렬할 데이터 입력 : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++)	{
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}
		}
		cout << i + 1 << "회전 결과 : ";
		for(int j=0 ; j<n ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}

}