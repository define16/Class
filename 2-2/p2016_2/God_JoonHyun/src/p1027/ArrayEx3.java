package p1027;

public class ArrayEx3 {
	public static void main(String[] args) {

		String[] arr;
		//arr = new String[args.length];

		if(args.length > 0)
		{
			arr = args;
			for(int i=0; i<arr.length; i++)
				System.out.println("arr[" + i + "] : " + arr[i]);
		}
		else
			System.out.println("args�� ������ �����ϴ�.");
	}
}
