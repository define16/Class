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
		
		System.out.println("box1의 id번호 : "+ mybox1.idNum);
		System.out.println("box2의 id번호 : "+ mybox2.idNum);
		System.out.println("box3의 id번호 : "+ mybox3.idNum);
		System.out.println("box4의 id번호 : "+ mybox4.idNum);
		System.out.println("전체 개수는 : "+ Box.boxID+" 입니다.");
		
	}
}
