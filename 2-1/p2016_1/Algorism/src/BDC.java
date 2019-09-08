import java.util.Scanner;
public class BDC {
	static int cnt;
	static int arr[];
	static int arrbin[];
	
	static void split(int a)
	{
		for (;;)
			if (a != 0)
			{
				a /= 10;
				cnt++;
			} 
			else
				break;
		
		arr = new int[cnt]; 
	}
	static void getArr(int a)
	{
		for (int i = cnt - 1; i >= 0; i--)
		{
			arr[i] = a % 10;
			a /= 10;
		}
			}
	
	static void Bin()
	{
		arrbin = new int[cnt * 4];
		int temp;
		
		for(int i = cnt; i > 0; i--)
		{
			temp = arr[i-1];
			for(int j = 1; j <= 4 ; j++)
			{
				if(temp != 0)
				{
					arrbin[(i*4)-j] = temp % 2;
					temp = temp / 2;
				}
				else 
					arrbin[(i*4)-j] = 0;
			}
		}
	}
	static void PrintBCD() 
	{
		System.out.print("BCD코드:: ");
		
		for (int i = 0; i <= cnt-1; i++)
		{
			for (int j = 0; j < 4; j++) 
				System.out.print(arrbin[(i*4)+j]);
			System.out.print(" ");
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		
		Scanner s = new Scanner(System.in);
		int input;
		System.out.print("10진수 정수를 입력해주세요  : ");
		
		input = s.nextInt();
		split(input);
		getArr(input);
		Bin();
		PrintBCD();
		s.close();
	}

}
