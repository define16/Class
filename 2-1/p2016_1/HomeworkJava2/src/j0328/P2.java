package j0328;

public class P2 
{
	int [] num = {56, 80, 100, 89, 45, 79, 34, 89, 90 ,75} ;
	static int sum , arg ;
	char c;
	
	public int Sum()
	{
		int i = 0;
		while (i < num.length)
		{
			sum += num[i];
			 i++;
		}
		
		System.out.print("합계는 " + sum +" 점이고");
		return sum;
	}
	public int Arg()
	{
		arg = sum/10;
		System.out.print("평균은 " + arg +" 점이고 ");
		
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
		System.out.print("학점은 " + c +" 입니다.");
	}
	
	public static void main(String []arge)
	{
		System.out.print("홍킬동님의 ");
		
		P2 sum1 = new P2();
		P2 arg1 = new P2();
		P2 score1 = new P2();
		
		sum1.Sum();
		arg1.Arg();
		score1.Score();
	}
	
}
