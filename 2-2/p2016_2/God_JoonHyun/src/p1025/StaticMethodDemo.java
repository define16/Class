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

		System.out.println("mybox1�� id ��ȣ : " + mybox1.idNum);
		System.out.println("mybox2�� id ��ȣ : " + mybox2.idNum);
		System.out.println("���� �ڽ��� ��ȣ�� " + Box2.boxID + "�� �Դϴ�.");
	}
}
