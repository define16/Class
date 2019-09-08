#include "config.h"

void main() {

	int data[] = {8, 3, 4, 9, 1};			// 정적 배열

	for(int i=0 ; i<4 ; i++) {				// 회전수, 선택 위치
		for(int j=i+1 ; j<5 ; j++)	{		// 선택 위치(i)와 비교 대상이 되는 위치

//			배열의 i번째 값과 j번째 값을 비교해 앞의 값이 크면 두 기억 장소의 값을 교환한다.(오름차순 정렬)
//			부등호를 반대로(<) 변경하면 내림차순으로 정렬된다.
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}

		}		// 회전 종료

		cout << i + 1 << "회전 결과 : ";
		for(int j=0 ; j<5 ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;

	}			// 정렬 종료

	//cout << "정렬 결과 : ";
	//for(int i=0 ; i<5 ; i++) {
	//	cout << data[i] << " ";
	//}
	//cout << endl;

}