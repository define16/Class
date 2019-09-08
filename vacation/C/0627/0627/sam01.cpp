#include "config.h"

void main() {

	int n;
	cout << "배열의 크기 : ";
	cin >> n;

//	C언어의 메모리 동적 할당
//	배열의자료형 *배열명 = (배열의자료형 *)malloc(sizeof(배열의자료형) * 배열의크기);
//	sizeof(자료형) : 괄호 안의 자료형의 크기를 바이트 단위로 출력한다.
//	cout << sizeof(int) << endl;
	int *a = (int *)malloc(sizeof(int) * n);
//	배열의 자료형이 char일 경우 배열의 크기 뒤에 NULL 문자가 저장될 크기 1을 더해줘야 한다.
//	char *a = (char *)malloc(sizeof(char) * n + 1);

//	C++의 메모리 동적 할당
//	배열의자료형 *배열명 = new 배열의자료형[배열의크기];
	int *a = new int[n];
//	배열의 자료형이 char일 경우 배열의 크기 뒤에 NULL 문자가 저장될 크기 1을 더해줘야 한다.
//	char *a = new char[n + 1];

//	프로그램이 종료될 때 동적 할당된 메모리 영역을 해제하지 않으면 메모리 누수 현상이 발생되므로 해제해야 한다.
//	C언어의 메모리 동적 할당 해제
	free(a);
//	C++의 메모리 동적 할당 해제
	delete[] a;

}