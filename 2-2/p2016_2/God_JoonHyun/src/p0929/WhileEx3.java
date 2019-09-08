package p0929;

public class WhileEx3 {
	public static void main(String[] args) {

		int i, z, m;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;

		i = Integer.parseInt(args[0]);
		m = Integer.parseInt(args[1]);
		z = Integer.parseInt(args[2]);

		while(i <= m)
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
