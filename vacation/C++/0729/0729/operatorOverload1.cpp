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

//	현재 객체(this)와 연산을 할 경우는 클래스의 멤버 함수로 만들면 된다.
//	인수가 1개인 "+" 연산자 오버로딩, 연산자 중복 함수 라고 부르기도 한다.

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

//	같은 클래스 타입인 인수가 2개짜리 연산을 해야 할 경우에는 매개 변수가 너무 많다는
//	에러가 발생되므로 외부 함수로 정의를 하고 friend로 설정하면 된다.
//	Point operator +(Point p1, Point p2) { }		// 에러가 발생된다.

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