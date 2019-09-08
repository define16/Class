package p1025;

class Box2
{
	long idNum;
	static long boxID = 100;

	static long getcurrentID()
	{
		return boxID++;
	}
}
public class StaticMethodDemo {
	public static void main(String[] args) {

		Box2 mybox1 = new Box2();
		mybox1.idNum = Box2.getcurrentID();

		Box2 mybox2 = new Box2();
		mybox2.idNum = mybox2.getcurrentID();

		System.out.println("mybox1의 id 번호 : " + mybox1.idNum);
		System.out.println("mybox2의 id 번호 : " + mybox2.idNum);
		System.out.println("다음 박스의 번호는 " + Box2.boxID + "번 입니다.");
	}
}
