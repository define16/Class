package p0929;

public class WhileEx2 {
	public static void main(String[] args) {

		int i, z;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;
		i = 1;
		z = Integer.parseInt(args[0]);

		while(i <= 100)
		{
			if(i % z == 0)
			{
				System.out.printf("%3d",i);
				cnt++;
				sum += i;

				if(cnt%7==0)
					System.out.println();

			}
			i++;
		}
		System.out.println();
		System.out.println("5의 배수의 개수 : " + cnt);
		System.out.println("5의 배수의 합   : " + sum);
	}

}
