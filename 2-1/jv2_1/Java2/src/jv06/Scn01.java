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
		
		
		System.out.print("�������� �Է��ϼ���:");
		input = sc.nextInt();
		
		System.out.println("�Է��Ͻ� �����ʹ� :" + input +"�Դϴ�.");
	
		
		System.out.print("���ڿ��� �Է��ϼ���:");
		s = sc.nextLine();
		System.out.println("�Է��Ͻ� ���ڿ���: " + s +"�Դϴ�.");
			
		System.out.print("���ڸ� �Է��ϼ���:");
		c = sc.next().charAt(1);
		System.out.println("�Է��Ͻ� ���ڿ���: " + c +"�Դϴ�.");
		
		*/
	
		System.out.print("�Է��� ������ ������ �Է��ϼ���:");
		cnt =sc.nextInt();
		
		if(cnt==0)
		{
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}
			
		int[] su=new int[cnt];
		
		for(int i=0; i<cnt; i++)
		{
			System.out.print(i + "��° ���ڸ� �Է��ϼ���:");
			su[i] = sc.nextInt();
		}
		
		for(int i=0; i<cnt; i++)
			System.out.println(i + "��° ���ڴ� : " + su[i]);
		
		sc.close();
	}
}
