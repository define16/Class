package p0927;

public class ForEx3 {
	public static void main(String[] args) {

		int i;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;

		// 1부터 100까지의 데이터 중에서 5의 배수의 데이터를 출력하고
		// 마지막에서 5의 배수의 개수를 출력하라...
		for(i = 1; i <= 100; i++)
		{
			if(i % 5 == 0)
			{
				System.out.print(i+" ");
				cnt++;
				sum+=i;

				if(cnt % 7 == 0)
					System.out.println();
			}
		}

		System.out.println();
		System.out.println("5의 배수의 개수 : " + cnt);
		System.out.println("5의 배수의 합 : " + sum);

	}
}
