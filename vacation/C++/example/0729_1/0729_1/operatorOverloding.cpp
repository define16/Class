#include "config.h"

class Point {
friend	Point operator +(Point , Point);

private : 
	int x,y;
public :
	Point(int x = 0, int y = 0)
	{
		this->x = x;
		this->y = y;
	}

	void toString(){
		cout << "x�� �� : " <<  x << " y�� �� : " << y << endl;
	}

	void add(int a){
		x +=a;
		y +=a;
	}

// ���� ��ü(this)�� ������ �� ���� Ŭ������ ��� �Լ��� ����� �ȴ�.
// �μ��� �Ѱ��� "+" ������ �����ε�, ������ �ߺ��Լ���� �Ѵ�.
// Case 1: 
	//Point operator + (int value){
	//	Point point;
	//	point .x = x + value;
	//	point.y = y + value;
	//	return point;
	//}

// Case 2: 
	void operator + (int value){
		x += value;
		y += value;
	}

//	point3 = point1 + point2;
	//Point operator +(Point p) {
	//	Point point;
	//	point.x = x + p.x;
	//	point.y = y + p.y;
	//	return point;
	//}

// ���� Ŭ���� Ÿ���� �μ��� 2��¥�� ������ �ؾ��� ��쿡�� �Ű� ������ �ʹ� ���ٴ�
// ������ �߻��ǹǷ� �ܺ��Լ��θ� ���Ǹ� �ؾ��Ѵ�.
//	Point operator +(Point p1, Point p2) { }
};

Point operator +(Point p1, Point p2) { 
	Point point;
	point.x = p1.x + p2.x;
	point.y = p1.y + p2.y;

	return point;
}


void main(){
	Point point1(10,20);
	point1.toString();			// x = 10, y = 20
	point1.add(10);
	point1.toString();
//	point1 = point1 +10;
	point1 +10;
	point1.toString();

	Point point2(20,10);
	Point point3;

	point3 = point1 + point2;
	point3.toString();
}
