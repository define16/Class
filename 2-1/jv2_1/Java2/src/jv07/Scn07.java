package jv07;

public class Scn07 {
	public static void main(String[] args) 
	{
		int[][] array={{10,20},{50,60,70},{90,100,100,120}};
		
		printArray(array);
	}
	
	public static void printArray(int[][] array)
	{
		for(int r=0;r<array.length;r++)
		{
			for(int c=0; c<array[r].length;c++)
				System.out.println("["+ r + "][" + c + "] : " + array[r][c]);
			System.out.println();
		}
	}
}
