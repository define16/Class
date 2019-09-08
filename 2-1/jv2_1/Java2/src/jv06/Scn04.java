package jv06;
import java.util.Scanner;

public class Scn04 {
	public static void main(String[] args) {
		final int STUDENT=5;
		int total=0;
		
		Scanner s = new Scanner(System.in);
		int[] scores = new int[STUDENT];
		
		System.out.println("5과목의 성적을 입력합니다.");
		for(int i=0; i<STUDENT; i++)
		{
			System.out.print("성적 입력:");
			scores[i] = s.nextInt();
		}
		for(int i=0; i<scores.length; i++)
			total += scores[i];
		
		System.out.println("평균 성적은" + total/STUDENT + "입니다.");
		s.close();
	}
}
