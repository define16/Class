#include "config.h"

void main() {

	int level;
	cout << "레벨을 입력하세요 : ";
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
//	무한 루프를 돌려서 맞출때까지 반복한다.
	int start = (unsigned)time(NULL);			// 게임 시작 시간
	while(true) {
		char user[10];
		cout << "USER : ";
		cin >> user;
		count++;
	
		int s = 0, b = 0;
//		레벨만큼 반복하며 스트라이크와 볼의 개수를 구한다.
		for(int i=0 ; i<level ; i++) {
//			ball 배열의 i번째와 user 배열의 i번째 값이 같으면 스트라이크
			if(ball[i] == user[i] - 48) {
				s++;
			}
//			ball 배열의 i번째와 user 배열에 포함되어 있고 i와 j가 같지 않으면 볼
			for(int j=0 ; user[j]!='\0' ; j++) {
				if(ball[i] == user[j] - 48 && i != j) {
					b++;
					break;
				}
			}
		}

//		스트라이크 개수와 레벨의 크기가 같으면 맞춘것이므로 무한 루프를 탈출시킨다.
		if(s == level) {
			break;
		}
		cout << s << " 스트라이크 " << b << " 볼" << endl;

	}

	int end = (unsigned)time(NULL);			// 게임 종료 시간
	cout << end - start << "초 걸려서 " << count << "번 만에 맞췄다." << endl;

}