#include "config.h"

void main() {

	int n;
	cout << "������ ������ ���� : ";
	cin >> n;
//	�Է¹��� �������� ������ŭ �޸𸮸� �������� �Ҵ��Ѵ�. ==> ���� �迭
	int *data = new int[n];

	cout << "������ ������ �Է� : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

	for(int i=0 ; i<n-1 ; i++) {
		for(int j=i+1 ; j<n ; j++)	{
			if(data[i] > data[j]) {
				swap(data[i], data[j]);
			}
		}
		cout << i + 1 << "ȸ�� ��� : ";
		for(int j=0 ; j<n ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}

}