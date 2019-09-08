#include "config.h"

class Point {
private:
	int x, y;
public:
	Point(int x = 0, int y = 0) {
		this->x = x;
		this->y = y;
	}
	void toString() {
		cout << "x = " << x << ", y = " << y << endl;
	}
	void add(int value) {
		x += value;
		y += value;
	}

//	���� ��ü(this)�� ������ �� ���� Ŭ������ ��� �Լ��� ����� �ȴ�.
//	�μ��� 1���� "+" ������ �����ε�, ������ �ߺ� �Լ� ��� �θ��⵵ �Ѵ�.

//	Point operator +(int value) {
//		Point point;
//		point.x = x + value;
//		point.y = y + value;
//		return point;
//	}

	void operator +(int value) {
		x += value;
		y += value;
	}

//	Point operator +(Point p) {
//		Point point;
//		point.x = x + p.x;
//		point.y = y + p.y;
//		return point;
//	}

//	���� Ŭ���� Ÿ���� �μ��� 2��¥�� ������ �ؾ� �� ��쿡�� �Ű� ������ �ʹ� ���ٴ�
//	������ �߻��ǹǷ� �ܺ� �Լ��� ���Ǹ� �ϰ� friend�� �����ϸ� �ȴ�.
//	Point operator +(Point p1, Point p2) { }		// ������ �߻��ȴ�.

	friend Point operator +(Point, Point);

};

Point operator +(Point p1, Point p2) {
	Point point;
	point.x = p1.x + p2.x;
	point.y = p1.y + p2.y;
	return point;
}

void main() {

	Point point1(10, 20);
	point1.toString();				// x = 10, y = 20
//	point1.add(10);
//	point1 = point1 + 10;
	point1 + 10;
	point1.toString();				// x = 20, y = 30

	Point point2(20, 10);
	Point point3;

	point3 = point1 + point2;
	point3.toString();				// x = 40, y = 40

}