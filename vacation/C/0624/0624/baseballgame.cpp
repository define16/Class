#include "config.h"

void main() {

	int level;
	cout << "������ �Է��ϼ��� : ";
	cin >> level;

	srand((unsigned)time(NULL));
	int ball[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	for(int i=0 ; i<1000000 ; i++) {
		int r = rand() % 9 + 1;
		swap(ball[0], ball[r]);
	}
	//cout << "CPU : ";
	//for(int i=0 ; i<level ; i++) {
	//	cout << ball[i];
	//}
	//cout << endl;

	int count = 0;
//	���� ������ ������ ���⶧���� �ݺ��Ѵ�.
	int start = (unsigned)time(NULL);			// ���� ���� �ð�
	while(true) {
		char user[10];
		cout << "USER : ";
		cin >> user;
		count++;
	
		int s = 0, b = 0;
//		������ŭ �ݺ��ϸ� ��Ʈ����ũ�� ���� ������ ���Ѵ�.
		for(int i=0 ; i<level ; i++) {
//			ball �迭�� i��°�� user �迭�� i��° ���� ������ ��Ʈ����ũ
			if(ball[i] == user[i] - 48) {
				s++;
			}
//			ball �迭�� i��°�� user �迭�� ���ԵǾ� �ְ� i�� j�� ���� ������ ��
			for(int j=0 ; user[j]!='\0' ; j++) {
				if(ball[i] == user[j] - 48 && i != j) {
					b++;
					break;
				}
			}
		}

//		��Ʈ����ũ ������ ������ ũ�Ⱑ ������ ������̹Ƿ� ���� ������ Ż���Ų��.
		if(s == level) {
			break;
		}
		cout << s << " ��Ʈ����ũ " << b << " ��" << endl;

	}

	int end = (unsigned)time(NULL);			// ���� ���� �ð�
	cout << end - start << "�� �ɷ��� " << count << "�� ���� �����." << endl;

}