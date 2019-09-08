package jv06;
import java.util.Scanner;

public class Scn01 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int cnt;
		
		/*
		int input;
		String s = new String();
		char c;
		
		
		System.out.print("정수값을 입력하세요:");
		input = sc.nextInt();
		
		System.out.println("입력하신 데이터는 :" + input +"입니다.");
	
		
		System.out.print("문자열을 입력하세요:");
		s = sc.nextLine();
		System.out.println("입력하신 문자열은: " + s +"입니다.");
			
		System.out.print("문자를 입력하세요:");
		c = sc.next().charAt(1);
		System.out.println("입력하신 문자열은: " + c +"입니다.");
		
		*/
	
		System.out.print("입력할 정수의 개수를 입력하세요:");
		cnt =sc.nextInt();
		
		if(cnt==0)
		{
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}
			
		int[] su=new int[cnt];
		
		for(int i=0; i<cnt; i++)
		{
			System.out.print(i + "번째 숫자를 입력하세요:");
			su[i] = sc.nextInt();
		}
		
		for(int i=0; i<cnt; i++)
			System.out.println(i + "번째 숫자는 : " + su[i]);
		
		sc.close();
	}
}
