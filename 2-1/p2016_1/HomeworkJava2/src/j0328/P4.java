package j0328;

abstract class AbsData
{
	int [] num;
	int sum , arg ;
	char c;
	public void setScore(int s[]){
		
	};
	public int Sum(){
		return 0;
	};
	

}
	
class P41 extends AbsData
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
}

public class P4 extends P41
{
	public static void main(String []arge)
	{
		int []score = {56, 80, 100, 89, 45, 79, 34, 89, 90 ,75};
		System.out.print("홍킬동님의 ");
		
		P3 obj1 = new P3();
		obj1.setScore(score);
		obj1.Sum();
		
		obj1.Arg();
		obj1.Score();
		
		
	
	}

}
