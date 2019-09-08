package Report2;

public class Ackermann 
{
	public int Calculation(int m, int n)
	{
		int c = 0;
		if(m == 0)
		{
			c =  n+1;
			return c;
		}
		else if(n == 0)
		{
			c =  Calculation(m-1, 1);
			return c;
		}
		else
		{
			c =  Calculation(m-1, Calculation(m,n-1));
			return c;
		}
	}

	public static void main(String []args)
	{
		Ackermann a = new Ackermann();
		System.out.println("(2,2)일 때의 함수값 : " + a.Calculation(2, 2));
		System.out.println("(3,3)일 때의 함수값 : " + a.Calculation(3, 3));
		System.out.println("(2,4)일 때의 함수값 : " + a.Calculation(2, 4));
	}

}
