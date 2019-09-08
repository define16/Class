package p0922;

public class IfEx4 
{
	public static void main(String[] args) 
	{
		int data;
		char c;

		data = 78;

		if (data>=100 && data<=90)
			c = 'A';
		else if (data>=80 && data<=89)
			c = 'B';
		else if (data>=70 && data<=79)
			c = 'C';
		else if (data>=60 && data<=69)
			c = 'D';
		else
			c = 'F';

		System.out.println("당신의 학점은 " + c + "입니다.");
	}
}
