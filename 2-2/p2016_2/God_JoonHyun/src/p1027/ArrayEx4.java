package p1027;

public class ArrayEx4 {
	public static void main(String[] args) {

		String[] arr;
		int score = 0;

		if(args.length > 0)
		{
			arr = args;

			System.out.print("�Է��Ͻ� �����ʹ� ");
			for(int i = 0; i<arr.length; i++)
			{
				score += Integer.parseInt(arr[i]);
				System.out.print("[" + arr[i] + "] ");
			}
			System.out.println("�̰�, ������ " + score + "�Դϴ�.");
		}
		else
			System.out.println("args�� ������ �����ϴ�.");
	}
}
