#include "config.h"

void main() {

	int n;
	cout << "������ ������ ���� : ";
	cin >> n;
	int *data = new int[n];

	cout << "������ ������ �Է� : ";
	for(int i=0 ; i<n ; i++) {
		cin >> data[i];
	}

	for(int i=0 ; i<n-1 ; i++) {

//		���� �۾��� �����ϱ� ���� flag ������ false�� �ʱ�ȭ �Ѵ�.
		bool flag = false;

		for(int j=0 ; j<n-1-i; j++) {
			if(data[j] > data[j+1]) {
				swap(data[j], data[j+1]);

//				����ȯ�� ����Ǹ� ���� �۾��� ����Ǵ� �����̹Ƿ� flag�� true�� �����Ѵ�.
				flag = true;

			}
		}

//		flag�� ���� �ʱ�ȭ�� false �״�ζ�� ����ȯ �۾��� �� ���� ������� ���� ���� ��, ������ �̹� �Ϸ��
//		�����̹Ƿ� �ݺ��� Ż���Ѵ�.
		if(!flag) {
			break;
		}

		cout << i + 1 << "ȸ�� ��� : ";
		for(int j=0 ; j<n ; j++) {
			cout << data[j] << " ";
		}
		cout << endl;
	}

}