#include "config.h"
#include <math.h>								// ���п� ���õ� �Լ��� ����Ϸ� �� ��� ���̴� ��� ����

void main() {

	int n;
	cout << "ǥ�������� ����� ������ ���� : ";
	cin >> n;
	int *data = new int[n];
	cout << "ǥ�������� ����� ������ �Է� : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

//	�Է¹��� �����͸� �����Ѵ�.
	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++) {
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}
		}
	}

//	������ �ִ밪�� �ּҰ��� ������ �������� �հ�� ����� ����Ѵ�.
	int sum = 0;
	for(int i=1 ; i<n-1 ; i++) {				// ���� ����� ó��, ������ ���� �����ϰ� �ݺ��Ѵ�.
		sum += data[i];
	}
	double average = (double)sum / (n - 2);		// �ִ밪, �ּҰ��� �����ؾ� �ϹǷ� n - 2�� ������.

//	�ִ밪�� �ּҰ��� ������ �� ����(����)���� �������� �� ������ ������ �հ踦 ���Ѵ�.
	double total = 0.0;
	for(int i=1 ; i<n-1 ; i++) {
//		total += (data[i] - average) * (data[i] - average);
//		double temp = data[i] - average;
//		total += temp * temp;
//		pow(x, y) : x�� y���� ����Ѵ�. x�� ������ �Ǽ��� �� �� �ְ� y�� ���ڸ� ������ �ȴ�.
		total += pow(data[i] - average, 2);
	}

//	�л��� ����Ѵ�.
	double var = total / (n - 2);
//	ǥ�������� ����Ѵ�.
	double dev = sqrt(var);

	cout << "�Է¹��� ������ ǥ�������� " << dev << "�Դϴ�." << endl;

}