#include <stdio.h>

void main() {
	int score = 0;
	char c = 'p';
	for (int i = 0; i > 0; i++) {
		printf("점수를 입력해주세요 : ");
		scanf_s("%d", &score);

		if (score >= 90 && score <= 100) {
			c = 'A';
		}
		else if (score >= 80 && score < 90) {
			c = 'B';
		}
		else if (score >= 70 && score < 80) {
			c = 'C';
		}
		else if (score >= 60 && score < 70) {
			c = 'D';
		}
		else if (score < 60 && score > 0) {
			c = 'F';
		}
		else {
			c = 'X';
		}


		printf("당신의 등급은 : %c", c);
	}

}