package jv05;

public class P1 
{
	public static void main(String [] args)
	{
		int [] num = {56, 80, 100, 89, 45, 79, 34, 89, 90 ,75} ;
		int sum = 0, arg = 0;
		char c;
		
		int i = 0;
		while (i < num.length)
		{
			sum += num[i];
			
			 i++;
		}
		     arg  = sum/10;

		switch(arg/10)
		{
		case 10:
		case 9:
			c = 'A';
		break;
		case 8:
			c = 'B';
		break;
		case 7:
			c = 'C';
		break;
		case 6:
			c = 'D';
		break;
		default:
			c= 'F';
		break;
		}
		
		System.out.println("ȫ�浿���� ������ " + sum + "���̰� �����  "+ arg + "���̰� ������ " + c +" �Դϴ�");
	}
}


