#include "omp.h"
#include <stdio.h>
#include <time.h>

void ex1(){
	clock_t startTime = clock();	//�ð� ���� ����
	const long long N= 100000;
	int i, k=10;
	double A[N], B[N], C[N];
   
	for (i=0; i<N; i++)
	{
		A[i] = B[i] + k*C[i];
	}
	printf("Elpase Time : %d\n", clock() - startTime);//�ð� ���� ����
}

void ex2(){
	const long long N= 100000;
	int i, k=10;
	double A[N], B[N], C[N];
	clock_t startTime = clock();//�ð� ���� ����
   
	#pragma omp parallel for	//����ó������
	for (i=0; i<N; i++)
	{
		A[i] = B[i] + k*C[i];
	}// ����ó�� ��

	printf("Elpase Time : %d\n", clock() - startTime); //�ð� ���� ����
}

int main(){
	printf("start\n");
	//ex1();
	ex2();
	return 0;
}