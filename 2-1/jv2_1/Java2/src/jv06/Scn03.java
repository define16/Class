package jv06;
import java.util.*;

public class Scn03 {
	public static void main(String[] args) 
	{
		int in=0;
		Scanner scan=new Scanner(System.in);
		
		System.out.print("������ �Է��ϼ���:");
		try{
			in = scan.nextInt();
			System.out.println("�Է¹��� ������ ��:" + in);
		}catch(InputMismatchException e)
		{
			System.out.println("������ �ƴմϴ�." + e);
		}
		finally {
			scan.close();
		}
	}
}
