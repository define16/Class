#include "config.h"
#include "sort.h"

void main() {

	int n,i;
	cout << "������ ������ ���� : ";
	cin >> n;
//	�Է¹��� �������� ������ŭ �޸𸮸� �������� �Ҵ��Ѵ�. ==> ���� �迭
//	int *data = (int *)malloc(sizeof(int)*n);		//C����� ���� �Ҵ�
	int *data = new int[n];		//C++�� ���� �Ҵ�
//	int data[] = new int [n]; //Java�� ���� �Ҵ� 
	
	input(data,n);

	selectionsort(data, n);

	output(data,n);

	//free(data); //C���� �����Ҵ�� �޸𸮸� ����
	delete[] data;//C++���� �����Ҵ�� �޸𸮸� ����
	}

