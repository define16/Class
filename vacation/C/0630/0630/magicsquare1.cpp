#include "config.h"

void main() {

	int n;
	while(true) {
		cout << "배열의 차수를 홀수로 입력하세요 : ";
		cin >> n;
		if(n % 2 == 1) {
			break;
		}
		cout << "홀수로 입력하라니까는 콱~~~~~~" << endl;
	}

//	C언어의 배열 동적 할당
//	int *a = (int *)malloc(sizeof(int) * n);			// 1차원 동적할당
//	int **a = (int **)malloc(sizeof(int *) * n);		// 행 동적할당
//	for(int i=0 ; i<n ; i++) {							// 행의 개수만큼 반복하며 열을 동적으로 할당한다.
//		a[i] = (int *)malloc(sizeof(int) * n);			// 열 동적할당
//	}

//	C++의 배열 동적 할당
//	int *a = new int[n];								// 1차원 동적할당
	int **a = new int*[n];								// 행 동적할당
	for(int i=0 ; i<n ; i++) {							// 행의 개수만큼 반복하며 열을 동적으로 할당한다.
		a[i] = new int[n];								// 열 동적할당
	}
//	int[][] a = new int[n][n];							// 자바의 2차원 동적할당
//	int[,] a = new int[n, n];							// C#의 2차원 동적할당

	int i = 0, j = (n - 1) / 2;							// 최초로 1이 나올 위치를 정한다.

	for(int k=1 ; k<=pow((double)n, 2) ; k++) {			// pow() 함수의 첫 번째 인수는 반드시 실수가 나와야 한다.
		a[i][j] = k;
		if(k % n == 0) {
			i++;
		} else {
			if(--i == -1) {
				i = n - 1;
			}
			if(++j == n) {
				j = 0;
			}
		}
	}

	for(i=0 ; i<n ; i++) {
		for(j=0 ; j<n ; j++) {
			cout << setw(3) << a[i][j] << " ";
		}
		cout << endl;
	}

	
//	C언어에서 2차원 동적할당된 메모리 해제하는 방법
//	for(int i=0 ; i<n ; i++) {			// 행의 개수만큼 반복하며 열의 동적 할당을 해제한다.
//		free(a[i]);						// 열 동적할당 해제
//	}
//	free(a);							// 행 동적할당 해제

//	C++에서 2차원 동적할당된 메모리 해제하는 방법
	for(int i=0 ; i<n ; i++) {			// 행의 개수만큼 반복하며 열의 동적 할당을 해제한다.
		delete[] a[i];					// 열 동적할당 해제
	}
	delete[] a;							// 행 동적할당 해제

}