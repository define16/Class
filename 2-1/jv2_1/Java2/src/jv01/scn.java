package jv01;
import java.util.Scanner;
public class scn {
	final static int STUDENT = 3;
	Scanner sc = new Scanner(System.in); //������ ����� �Ŷ� ����� ����
	
	public int[] getValues(int scores[])
	{
		for(int i = 0; i<STUDENT; i++)
		{
			System.out.print("�����Է� : ");
			scores[i] = sc.nextInt();
		}
		return scores;
		
	}
	public void getAverage(int scores[])
	{
		int avg = 0;
		
		avg = (scores[0]+scores[1]+scores[2])/STUDENT;
		System.out.println("��ռ����� " + avg +" �Դϴ�.");
	}

	public static void main(String []args)
	{
		int []scores = new int [STUDENT];
		scn s = new scn();
		
		s.getValues(scores);
		s.getAverage(scores);
		
	}
}
