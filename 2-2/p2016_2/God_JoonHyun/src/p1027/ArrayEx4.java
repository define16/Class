package p1027;

public class ArrayEx4 {
	public static void main(String[] args) {

		String[] arr;
		int score = 0;

		if(args.length > 0)
		{
			arr = args;

			System.out.print("입력하신 데이터는 ");
			for(int i = 0; i<arr.length; i++)
			{
				score += Integer.parseInt(arr[i]);
				System.out.print("[" + arr[i] + "] ");
			}
			System.out.println("이고, 총합은 " + score + "입니다.");
		}
		else
			System.out.println("args의 내용이 없습니다.");
	}
}
