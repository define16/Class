package jv03;

public class ObjArrayEx3 {
	public static void main(String[] args){
		String[] arr;
		int score=0;
	
		
		if(args.length > 0) //Ŀ�ǵ忡 �ִ� ������ ��.
		{
			arr = args;

			System.out.print("�Է��Ͻ� �����ʹ� ");
			for(int i = 0 ; i < arr.length ; i++)
			{
				System.out.print("[" + arr[i] +"] ");
				score += Integer.parseInt(arr[i]);
			}
			System.out.println("�̰�, ������  " + score + "�Դϴ�. ");
			
		}
		else
			System.out.println("args�� ������ �����ϴ�.");
	}
}
