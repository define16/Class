#include "config.h"

// 추상 클래스는 한 개 이상의 순수 가상 함수를 멤버로 가지고 있는 클래스로 상속을 시키기 위해서 만드는
// 불완전한 클래스이다. 따라서  추상클래스는 객체를 생성할 수 없다.
// 어차피 상속받은 자식 클래스에 오버라이드 시켜서 사용한다면 부모 클래스에서 기능을 정의

class Object {			// 추상 클래스
public :
// 순수 가상 함수 : 아무런 일도 하지 않는 {} 블록이 없는 함수로
// 상속 받는 자식 클래스에서 반드시 오버라이드 해서 사용해야한다.
//	virtual void draw(){  } : 아무런 일도 하지 않는 일반 가상함수
	virtual void draw() = 0;		// 순수 가상 함수 (자바의 추상메소드)
};

// 부모클래스가 추상 클래스(Object)인 Point 클래스는 부모클래스의 순수가상함수도 상속을 받는다.
// 따라서 상속받은 순수 가상 함수를 재정의 하지 않으면 Point 클래스는 추상클래스가 되므로 객체를 만들어서
// 사용할 수 없다.
class Point : public Object {
public : 
// 부모 클래스로 부터 상속받은 순수 가상 함수 draw()를 오버라이드 한다.
	void draw() {
		cout << "점을 찍는다. " << endl; 
	}

};
class Line : public Object {
public : 
	void draw() {
		cout << "선을 그린다. " << endl; 
	}
};

class Circle : public Object {
	public : 
	void draw() {
		cout << "원을 그린다. " << endl; 
	}
};

class Rect : public Object {
	public : 
	void draw() {
		cout << "사각형을 그린다. " << endl; 
	}
};

class Triangle : public Object {
	public : 
	void draw() {
		cout << "삼각형을 그린다. " << endl; 
	}
};
void main(){
//	 Object object;  // 추상 클래스의 객체를 만들려 했으므로 에러가 발생된다.
	//Point point;
	//point.draw();
	//Line line;
	//line.draw();
	//Circle circle;
	//circle.draw();

// 다형성이란 하나의 함수가 서로 다른 클래스에서 다양하게 사용되는 것을 말한다.'
// 다형성을 구현하려면 다형성을 구현할 함수를 멤버로 가지는 모든 클래스가 동일한 부모
// 클래스를 가져야 하고 부모 클래스와 자식 클래스에 동일한 함수가 있어야 한다.
// 부모클래스와 지식클래스에 동일한 함수가 있어야한다.
// 부모클래스의 함수를 자식 클래스에서 반드시 오버라이드 시켜 사용해야한다.
// 부모클래스의 포인터에 자식 클래스객체를 생성해 시작주소를 대입시켜 사용해야된다.

	Object *object[] = {new Point(), new Line(), new Circle(), new Rect(), new Triangle()};
	for(int i = 0; i<5; i++){
		object[i]->draw();
	}
}
