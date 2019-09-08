package jv01;
import java.util.Scanner;
public class scn {
	final static int STUDENT = 3;
	Scanner sc = new Scanner(System.in); //생성자 만드는 거랑 비슷한 포맷
	
	public int[] getValues(int scores[])
	{
		for(int i = 0; i<STUDENT; i++)
		{
			System.out.print("성적입력 : ");
			scores[i] = sc.nextInt();
		}
		return scores;
		
	}
	public void getAverage(int scores[])
	{
		int avg = 0;
		
		avg = (scores[0]+scores[1]+scores[2])/STUDENT;
		System.out.println("평균성적은 " + avg +" 입니다.");
	}

	public static void main(String []args)
	{
		int []scores = new int [STUDENT];
		scn s = new scn();
		
		s.getValues(scores);
		s.getAverage(scores);
		
	}
}
