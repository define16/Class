package p0929;

public class ForEx4 {
	public static void main(String[] args) {

		int i;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;

		for(i = 1; i <= 100; i++)
		{
			if(i % 5 == 0)
			{
				System.out.printf("%3d",i);
				cnt++;
				sum += i;

				if(cnt%7==0)
					System.out.println();

			}
		}
		System.out.println();
		System.out.println("5의 배수의 개수 : " + cnt);
		System.out.println("5의 배수의 합   : " + sum);
	}
}
