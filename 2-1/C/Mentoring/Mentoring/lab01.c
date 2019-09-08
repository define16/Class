#include <stdio.h>

float sum(int r) {
	const float PI = 3.14;
	float result = 2 * PI * r;

	return result;
}

void p() {
	printf("p");
}

void a(int b, int c) {
	int bc = b + c;
}

char sc() {
	return 'c';
}

void main() {
	const int MAX = 10;
	int x = 0;

	float result = sum(2);
	printf("%f", result);

	printf("adb\n");
	p();


	return 0;
}