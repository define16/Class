package jv01;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data;
		char c;

		//data=78;
		data = Integer.parseInt(args[0]);
		
		switch(data/10)
		{
			case 10:
			case 9: c='A'; break;
			case 8: c='B'; break;
			case 7: c='C'; break;
			case 6: c='D'; break;
			default :
				c = 'F';
		}
		System.out.println("당신의 성적은 "  + c +"입니다.");
	}
}
