#include "config.h"
#include "sort.h"

void main() {

	int n;
	cout << "정렬할 데이터 개수 : ";
	cin >> n;
//	입력받은 데이터의 개수만큼 메모리를 동적으로 할당한다. ==> 동적 배열
//	int *data = (int *)malloc(sizeof(int) * n);		// C언어의 동적 할당
	int *data = new int[n];			// C++의 동적 할당
//	int[] data = new int[n];		// 자바의 동적 할당

	input(data, n);
	selectionsort(data, n);
	output(data, n);
	
//	free(data);			// C언어에서 동적 할당된 메모리를 해제한다.
	delete[] data;		// C++에서 동적 할당된 메모리를 해제한다.

}