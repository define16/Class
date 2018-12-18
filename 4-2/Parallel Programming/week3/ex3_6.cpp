#include "omp.h"
#include <stdio.h>
#include <time.h>


void ex3(){
	double pi = 0.0;
	const int iterationCount = 200000000;

	clock_t startTime = clock();	//�ð� ���� ����

	for (int i = 0; i < iterationCount; i++)
	{
	   pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI ���ϱ�
	}

	printf("Elpase Time : %d\n", clock() - startTime); //�ð� ���� ����
	printf("pi = %.8f\n", pi);
}


void ex4(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//�ð� ���� ����

	#pragma omp parallel	//omp ��ü����
	{
		#pragma omp for	// for���� �۾��� �������� ������ ����
		for (int i = 0; i < iterationCount; i++)
		{
			pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI ���ϱ�
		} // for ����
	} //omp ����

	printf("Elpase Time : %d\n", clock() - startTime);	//�ð� ���� ����
	printf("pi = %.8f\n", pi);
}

void ex5(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//�ð� ���� ����

	#pragma omp parallel	//omp ��ü����
	{
		#pragma omp for // ����
		for (int i = 0; i < iterationCount; i++)
		{
			#pragma omp atomic	// Shared memory ������ �����Ϳ� ���� �ټ��� thread �� ���� ���� ������ ����
			pi += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0);	// PI ���ϱ�
		}
	}

	printf("Elpase Time : %d\n", clock() - startTime);	//�ð� ���� ����
	printf("pi = %.8f\n", pi);
}

void ex6(){
	double pi = 0.0;
	const int iterationCount = 200000000;
	clock_t startTime = clock();	//�ð� ���� ����

	#pragma omp parallel
	{
		double temp = 0.0;
		#pragma omp for	// for���� �۾��� �������� ������ ����
		for (int i = 0; i < iterationCount; i++)
		{
			temp += 4 * (i % 2 ? -1 : 1) / (2.0 * i + 1.0); // PI ���ϱ�
		}
		#pragma omp atomic	// Shared memory ������ �����Ϳ� ���� �ټ��� thread �� ���� ���� ������ ����
		pi += temp;

		}

		printf("Elpase Time : %d\n", clock() - startTime);	//�ð� ���� ����
		printf("pi = %.8f\n", pi);
}

void main(){
	//printf("start\n"); ex3();	
	//printf("start\n"); ex4();
	//printf("start\n"); ex5();
	printf("start\n"); ex6();
}
