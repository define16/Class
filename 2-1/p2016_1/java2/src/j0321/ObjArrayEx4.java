package j0321;

public class ObjArrayEx4 {
	public static void main(String[] args){
		String[] arr;
		int score=0;
		char unit;
		
		if(args.length > 0) 
		{
			arr = args;

			System.out.print(arr[0] + "�� ");
			for(int i = 1 ; i < arr.length ; i++)
				score += Integer.parseInt(arr[i]);

			System.out.print("����� ������ " + score + "�̰�, ");
			
			score = score/(arr.length-1);
			if(score >= 90 && score <= 100)
				unit = 'A';
			else if( score >=80 && score <=89)
				unit = 'B';
			else if(score >= 70 && score <= 79)
				unit = 'C';
			else if(score >= 60 && score <=69)
				unit = 'D';
			else
				unit = 'F';
			
			
			System.out.println("������ " + unit + "�Դϴ�");
		
		}
		else
			System.out.println("args�� ������ �����ϴ�.");
	}
}
