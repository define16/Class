#include "omp.h"
#include <stdio.h>
#include <time.h>


void ex3(){
	double pi = 0.0;
	const int iterationCount = 200000000;

	clock_t startTime = clock();	//시간 측정 시작

	for (int i = 0; i < iterationCount; i++)
	{
	   pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI 구하기
	}

	printf("Elpase Time : %d\n", clock() - startTime); //시간 측정 종료
	printf("pi = %.8f\n", pi);
}


void ex4(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//시간 측정 시작

	#pragma omp parallel	//omp 객체생성
	{
		#pragma omp for	// for문의 작업을 쓰레드의 개수로 분할
		for (int i = 0; i < iterationCount; i++)
		{
			pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI 구하기
		} // for 종료
	} //omp 종료

	printf("Elpase Time : %d\n", clock() - startTime);	//시간 측정 종료
	printf("pi = %.8f\n", pi);
}

void ex5(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//시간 측정 시작

	#pragma omp parallel	//omp 객체생성
	{
		#pragma omp for // 병렬
		for (int i = 0; i < iterationCount; i++)
		{
			#pragma omp atomic	// Shared memory 영역의 데이터에 대한 다수의 thread 의 동시 접근 방지을 방지
			pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI 구하기
		}
	}

	printf("Elpase Time : %d\n", clock() - startTime);	//시간 측정 종료
	printf("pi = %.8f\n", pi);
}

void ex6(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//시간 측정 시작

	#pragma omp parallel
	{
		double temp = 0.0;
		#pragma omp for	// for문의 작업을 쓰레드의 개수로 분할
		for (int i = 0; i < iterationCount; i++)
		{
			temp += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0); // PI 구하기
		}
		#pragma omp atomic	// Shared memory 영역의 데이터에 대한 다수의 thread 의 동시 접근 방지을 방지
		pi += temp;

		}

		printf("Elpase Time : %d\n", clock() - startTime);	//시간 측정 종료
		printf("pi = %.8f\n", pi);
}

void main(){
	//printf("start\n"); ex3();	
	//printf("start\n"); ex4();
	//printf("start\n"); ex5();
	printf("start\n"); ex6();
}
