package p1004;

public class ForEx5 {
	public static void main(String[] args) {

		int sum, i, j;
		char c;
		double data;
		int[] a;
		sum = 0;

		i = args.length;
		a=new int[i-1];

		for(j=1; j<i; j++)
		{
			a[j-1] = Integer.parseInt(args[j]);
			sum += a[j-1];
		}		



		data = (double)sum/(i-1);

		if(data >= 90 && data <= 100)
			c = 'A';
		else if(data >= 80 && data < 90)
			c = 'B';
		else if(data >= 70 && data < 80)
			c = 'C';
		else if(data >= 60 && data < 70)
			c = 'D';
		else
			c = 'F';


		System.out.print(args[0] + "님 당신의 성적은 ");
		for(j = 0; j<i-2; j++)
			System.out.print("[" + a[j] + "], ");

		System.out.println("[" + a[i-2] + "]이고 ");
		System.out.print("입력하신 데이터의 합은 " + sum);
		System.out.format(", 평균은 %.2f, ",data);
		System.out.println("학점은 " + c + "입니다.");
	}

}
