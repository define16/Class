package jv06;
import java.util.*;

public class Scn03 {
	public static void main(String[] args) 
	{
		int in=0;
		Scanner scan=new Scanner(System.in);
		
		System.out.print("정수를 입력하세요:");
		try{
			in = scan.nextInt();
			System.out.println("입력받은 정수의 값:" + in);
		}catch(InputMismatchException e)
		{
			System.out.println("정수가 아닙니다." + e);
		}
		finally {
			scan.close();
		}
	}
}
