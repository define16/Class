package jv06;
import java.util.Scanner;


public class Scn05 {
	public static void main(String[] args) {
		/*
		String[] str = {"JAVA","C Programming","C++"};
		for(String s:str)
			System.out.println(s);
			*/
		Scanner sc = new Scanner(System.in);
		String[] str=new String[3];
		int i;
		
		for(i=0; i<3; i++)
		{
			System.out.print(i + "��° �̸��� ����ϼ��� : " );
			str[i] = sc.nextLine();
		}
		
		i=0;
		for(String s:str)
		{
			System.out.print(i++ + "��° : ");
			System.out.println(s);
		}
		
		sc.close();
	}
}
