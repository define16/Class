package p1025;

class Box
{
	long idNum;
	static long boxID = 0; //클래스 변수 선언

	public Box()
	{
		idNum = boxID++; // 생성자가 수핼될 때마다 클래스 변수의 값을 증가
	}
}
public class StaticDemo {
	public static void main(String[] args) {

		Box mybox1 = new Box();
		Box mybox2 = new Box();
		Box mybox3 = new Box();
		Box mybox4 = new Box();

		System.out.println("mybox1의 id 번호 : " + mybox1.idNum);
		System.out.println("mybox2의 id 번호 : " + mybox2.idNum);
		System.out.println("mybox3의 id 번호 : " + mybox3.idNum);
		System.out.println("mybox4의 id 번호 : " + mybox4.idNum);
		System.out.println("전체 박스의 개수는 " + Box.boxID + "입니다.");
	}
}
