package jv02;

/*
[�Է�ȭ��]
	    C:\>java Test1 ȫ�浿 100 90


[��°��]

	     [ȫ�浿]�� ����� ������ [100][90]���̰�
	     ����[  ], ����[  ], ����[  ]�Դϴ�.
*/

public class Test1 {
	public static void main(String[] args) {
		
		int d1, d2;
		int data, sum;
		char c;

		d1 = Integer.parseInt(args[1]); //Ŀ�ǵ忡�� �Է��� �޴´�.
		d2 = Integer.parseInt(args[2]); 
		//run configurations���� arguments�� ���� ���� �Է�
		
		sum  = d1+d2;
		data = sum/(args.length-1);
		
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
		System.out.println("[" + args[0] + "] �� ����� ������ [" +d1 +"] [" + d2 +"] ���̰�");
		System.out.println("������[" +sum +"]," + "����� [" + data + "],����["+ c +"]�Դϴ�.");
	}

}
