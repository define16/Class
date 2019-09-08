package jv07;

import java.util.Scanner;


public class Scn099 {

	public static void main(String []args)
	{
		Scanner i = new Scanner(System.in);
		int sum = 0,avg=0;
		char c = ' ';
		System.out.print("문자열을 입력하세요 : ");
		
		String spi = i.nextLine();
		String[] spiResult = spi.split(" ");
		
		String strValue = spiResult[0];
		int intValue = Integer.parseInt(spiResult[1]);
		int intValue1 = Integer.parseInt(spiResult[2]);
		int intValue2 = Integer.parseInt(spiResult[3]);
		
		for(int k = 1;k<=spiResult.length;k++)
		{
			sum = intValue + intValue1 + intValue2 ;
			avg = sum/3;
			switch(avg/10)
			{
				case 10:
				case 9:
					c = 'A';
					break;
				case 8:
					c = 'B';
					break;
				case 7:
					c = 'C';
					break;
				case 6:
					c = 'D';
					break;
				default:
						c = 'F';
					
			}
		}
		
		System.out.println("[" + strValue + "]" + "님의 점수은 ["  + intValue + "],[" + intValue1 + "],[" + intValue2 + "]이고,");
		
		
		System.out.println("총점["+sum+"]이고 " + "평균은[" + avg + "]이고" + "학점은[" + c + "]입니다.");
		
		
	}

	
}