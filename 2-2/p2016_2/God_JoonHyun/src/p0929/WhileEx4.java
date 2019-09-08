package p0929;

public class WhileEx4 {
	public static void main(String[] args) {

		int i, z;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;
		i = 1;
		z = Integer.parseInt(args[0]);

		switch(z)
		{
		case 1:
			while(i <= 100)
			{
				if(i % 2 != 0)
				{
					System.out.printf("%3d",i);
					cnt++;
					sum += i;

					if(cnt%7==0)
						System.out.println();

				}
				i++;
			}
			break;



		default :
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
		}
		System.out.println();
		System.out.println("배수의 개수 : " + cnt);
		System.out.println("배수의 합   : " + sum);
	}
}
