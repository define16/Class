package jv01;

class Box {
	 long idNum;
	static long boxID = 25;
	
	public void box(){
		idNum = boxID++;
		
	}
}
 
	
		
	
public class sf {
	public static void main(String []args)
	{
		Box mybox1 = new Box();
		Box mybox2 = new Box();
		Box mybox3 = new Box();
		Box mybox4 = new Box();
		
		System.out.println("box1�� id��ȣ : "+ mybox1.idNum);
		System.out.println("box2�� id��ȣ : "+ mybox2.idNum);
		System.out.println("box3�� id��ȣ : "+ mybox3.idNum);
		System.out.println("box4�� id��ȣ : "+ mybox4.idNum);
		System.out.println("��ü ������ : "+ Box.boxID+" �Դϴ�.");
		
	}
}
