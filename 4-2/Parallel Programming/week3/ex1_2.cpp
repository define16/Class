#include "omp.h"
#include <stdio.h>
#include <time.h>

void ex1(){
	clock_t startTime = clock();	//시간 측정 시작
	const long long N= 100000;
	int i, k=10;
	double A[N], B[N], C[N];
   
	for (i=0; i<N; i++)
	{
		A[i] = B[i] + k*C[i];
	}
	printf("Elpase Time : %d\n", clock() - startTime);//시간 측정 종료
}

void ex2(){
	const long long N= 100000;
	int i, k=10;
	double A[N], B[N], C[N];
	clock_t startTime = clock();//시간 측정 시작
   
	#pragma omp parallel for	//병렬처리시작
	for (i=0; i<N; i++)
	{
		A[i] = B[i] + k*C[i];
	}// 병렬처리 끝

	printf("Elpase Time : %d\n", clock() - startTime); //시간 측정 종료
}

int main(){
	printf("start\n");
	//ex1();
	ex2();
	return 0;
}