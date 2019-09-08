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

	friend Matric operator +(Matric, Matric);
	friend Matric operator *(Matric m1, Matric m2);
};

Matric operator +(Matric m1, Matric m2) {
	Matric matric;
		for(int i=0 ; i<4 ; i++) {
			matric.arr[i] = m1.arr[i] + m2.arr[i];
		}
	return matric;
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



}