package jv07;
import java.util.Scanner;

public class Scn08 {
    final static int STUDENT=3;
	
	public void getValues(int[] array)
	{
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<array.length;i++)
		{
			System.out.print("���� �Է� : ");
			array[i] = sc.nextInt();
		}
		sc.close();
	}
	
	public void getAverage(int[] array){
		int total = 0;
		
		for(int i=0; i<array.length;i++)
			total += array[i];
		System.out.println("��� ������ " + total/array.length + "�Դϴ�.");	
		
	}
	
	public static void main(String[] args) {
		Scn08 s = new Scn08();
		int[] scores = new int[STUDENT];
		
		s.getValues(scores);
		s.getAverage(scores);
	}
}
