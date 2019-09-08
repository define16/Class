package jv06;

public class Scn06 {
	
	public int[] getData()
	{
		int[] data = {10, 20, 30, 40, 50};
		return data;
	}

	public void printData(int[] array){
		System.out.println("기본 For문");
		for (int i = 0; i < array.length; i++)
			//System.out.println(array[i]);
			System.out.format("%3d", array[i]);

		System.out.println();
		
		System.out.println("향상된 For문");
		for (int i : array)
			//System.out.println(i);
			System.out.format("%3d", i);
	}
	
	public static void main(String[] args) {
		Scn06 arr = new Scn06();
		int[] array;
	
		array = arr.getData();
		arr.printData(array);
	}
}
