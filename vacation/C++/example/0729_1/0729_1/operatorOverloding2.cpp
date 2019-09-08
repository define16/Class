#include "config.h"

class Matric {
friend Matric operator + (Matric , Matric );
friend Matric operator * (Matric , Matric );
private:
	int arr[4];
public :
	Matric(int a = 0, int b = 0, int c = 0, int d = 0) {
		arr[0] = a; arr[1] = b; arr[2] = c; arr[3] = d;
	}

	void toString() {
		for(int i=0 ; i<4;i++) {
			if(i>0){
				cout << ", ";
			}
			cout << arr[i];
		}
	}

};
Matric operator + (Matric m1, Matric m2){
	Matric m3;
	for(int i = 0; i<4;i++)
		m3.arr[i] = m1.arr[i] + m2.arr[i];
	return m3;
}

		
Matric operator * (Matric m1, Matric m2){
	Matric m3;
	for(int i = 0; i<4;i++)
		m3.arr[i] = m1.arr[i] * m2.arr[i];
	return m3;
}

void main() {
	Matric a(1,2,3,4);
	cout << "Matric a = {"; a.toString(); cout << "}" << endl;
	Matric b(4,3,2,1);
	cout << "Matric b = {"; b.toString(); cout << "}" << endl;
	Matric c;

	c = a + b;
	cout << "Matric c = {"; c.toString(); cout << "}" << endl;

	Matric d;
	d = a * b;
	cout << "Matric d = {"; d.toString(); cout << "}" << endl;
	
}