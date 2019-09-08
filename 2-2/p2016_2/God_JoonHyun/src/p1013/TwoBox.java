package p1013;

class Box {

	int width;
	int height;
	int depth;
	
	/*
	public Box(int width,int b, int c)
	{
		this.width = width;
		height = b;
		depth = c;
	}
	
	public Box(int width)
	{
		this.width = 40;
		
	}
	*/
}

public class TwoBox {
	public static void main(String[] args) {

		/*
		Box mybox1 = new Box(1);
		Box mybox2 = new Box(1,8,7);
		*/
		Box mybox1 = new Box();
		Box mybox2 = new Box();
		
		int vol1, vol2;

		mybox1.width = 20;
		mybox1.height = 40;
		mybox1.depth = 15;

		mybox2.width = 10;
		mybox2.height = 20;
		mybox2.depth = 30;

		vol1 = mybox1.width * mybox1.height * mybox1.depth;
		System.out.println("첫번째 박스의 부피는 " + vol1 + "입니다.");

		vol2 = mybox2.width * mybox2.height * mybox2.depth;
		System.out.println("첫번째 박스의 부피는 " + vol2 + "입니다.");
	}
}
