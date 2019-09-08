#include <stdio.h>

void fun1() {
	int i = 11;
	printf("fun1()\n");
	while (i <= 10) {
		printf("%d\n", i);
		i--;
	}

	printf("fun1()  END\n");
}

void fun2() {
	int i = 11;

	printf("fun2()\n");
	do {
		printf("%d\n", i);
		i--;
	} while (i <= 10 && i > 0);

	printf("fun2()  END\n");
}

void fun3() {
	int i;
	for (i = 0; i <= 10; i = i+2) {
		printf("%d\n", i);
	}
}

void main() {
	//fun1();
	//fun2();
	fun3();
}