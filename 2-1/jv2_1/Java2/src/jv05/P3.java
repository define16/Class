package jv05;


class Data
{
	int [] num;
	int sum , arg ;
	char c;

}
	
class P31 extends Data
{
	public void setScore(int s[])
	{
		num = s;
	}
	
	public int Sum()
	{
		int i = 0;
		while (i < num.length)
		{
			sum += num[i];
			 i++;
		}
		
		System.out.print("�հ�� " + sum +" ���̰�");
		return sum;
	}
	public int Arg()
	{
		arg = sum/10;
		System.out.print("����� " + arg +" ���̰� ");
		
		return arg;
	}
	
	public void Score()
	{
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
		System.out.print("������ " + c +" �Դϴ�.");
	}
}

public class P3 extends P31
{
	public static void main(String []arge)
	{
		int []score = {56, 80, 100, 89, 45, 79, 34, 89, 90 ,75};
		System.out.print("ȫų������ ");
		
		P3 obj1 = new P3();
		obj1.setScore(score);
		obj1.Sum();
		
		obj1.Arg();
		obj1.Score();
		
		
	
	}

}
