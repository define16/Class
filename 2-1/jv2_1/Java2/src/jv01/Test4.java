package jv01;

public class Test4 {

	public static void main(String[] args) {
		// C:\>java Test3 ������ 78
		//������ �� ����� ������ C�����Դϴ�.
		
		int data;
		char c;

		//data=78;
		data = Integer.parseInt(args[1]);
		
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
		System.out.println(args[0] + "�� ����� ������ "  + c +"���� �Դϴ�.");
	}

}
