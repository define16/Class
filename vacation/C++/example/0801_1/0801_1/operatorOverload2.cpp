#include "config.h"

class Matric {
private:
	int arr[4];
public:
	Matric(int a = 0, int b = 0, int c = 0, int d = 0) {
		arr[0] = a; arr[1] = b; arr[2] = c; arr[3] = d;
	}

	void toString() {
		for(int i=0 ; i<4 ; i++) {
			if(i > 0) {
				cout << ", ";
			}
			cout << arr[i];
		}
	}
	

//	Matric operator +(Matric m) {
//		Matric matric;
//		for(int i=0 ; i<4 ; i++) {
//			matric.arr[i] = arr[i] + m.arr[i];
//		}
//		return matric;
//	}

//	+=, -=, *=, /=, %=과 같은 대입 연산자는 인수 1개 짜리로는 제대로된 오버로딩이 힘들다.
//	Matric operator +=(Matric m) {
//		Matric matric;
//		for(int i=0 ; i<4 ; i++) {
//			matric.arr[i] = arr[i] + m.arr[i];
//			cout << arr[i] << ", " << m.arr[i] << ", " << matric.arr[i] << endl;
//		}
//		return matric;
//	}

// 연산 결과 참 또는 거짓이므로 리턴 타입은 bool로 한다.
//	bool operator ==(Matric m) {
//		배열의 각 요소를 비교해 같은 요소의 개수를 구한다.
//		int count = 0;
//		for(int i=0 ; i<4 ; i++) {
//			if(arr[i] == m.arr[i]) {
//				count++;
//			}
//		}
//		if(count == 4) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	friend Matric operator +(Matric, Matric);
	friend Matric operator +=(Matric &, Matric);
	friend bool operator ==(Matric m1, Matric m2);
};

Matric operator +(Matric m1, Matric m2) {
	Matric matric;
		for(int i=0 ; i<4 ; i++) {
			matric.arr[i] = m1.arr[i] + m2.arr[i];
		}
	return matric;
}

Matric operator +=(Matric &m1, Matric m2) {
		for(int i=0 ; i<4 ; i++) {
			m1.arr[i] = m1.arr[i] + m2.arr[i];
		}
	return m1;
}


// 꼭 클래스 이름으로 리턴 타입을 만들 필요가 없다. int, bool등으로 만들 수 있다.
bool operator ==(Matric m1, Matric m2) {
		int count = 0;
		for(int i=0 ; i<4 ; i++) {
			if(m1.arr[i] == m2.arr[i]) {
				count++;
			}
		}
		if(count == 4) {
			return true;
		} else {
			return false;
		}
	}


void main() {

	Matric a(1, 2, 3, 4);
	cout << "Matric a = {"; a.toString(); cout << "}" << endl;
	Matric b(4, 3, 2, 1);
	cout << "Matric b = {"; b.toString(); cout << "}" << endl;
	Matric c;
	cout << "Matric c = {"; c.toString(); cout << "}" << endl;

	c = a + b;
	cout << "Matric c = {"; c.toString(); cout << "}" << endl;

	a += b;
	cout << "Matric a = {"; a.toString(); cout << "}" << endl;

// if문 안에서도 작동 가능.
	if(a == b)
		cout << "같습니다." << endl;
	else 
		cout << "다릅니다." << endl;

	if(a == c)
		cout << "같습니다." << endl;
	else 
		cout << "다릅니다." << endl;


}