package jv06;
import java.util.Scanner;

public class Scn04 {
	public static void main(String[] args) {
		final int STUDENT=5;
		int total=0;
		
		Scanner s = new Scanner(System.in);
		int[] scores = new int[STUDENT];
		
		System.out.println("5������ ������ �Է��մϴ�.");
		for(int i=0; i<STUDENT; i++)
		{
			System.out.print("���� �Է�:");
			scores[i] = s.nextInt();
		}
		for(int i=0; i<scores.length; i++)
			total += scores[i];
		
		System.out.println("��� ������" + total/STUDENT + "�Դϴ�.");
		s.close();
	}
}
