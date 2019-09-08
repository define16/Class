package jv01;

public class Test7 {

	public static void main(String[] args) {
		int i;
		int sum=0, cnt=0;

		i=1;
		while(i <= 100){
			if(i%5 == 0)
			{
				System.out.print(i + " ");
				cnt++;
				if(cnt%7 == 0)
					System.out.println();
				sum += i;
			}
			i++;
		}
		System.out.print("\n5의 배수의 개수는 " + cnt + "이고, ");
		System.out.println( "합은 " + sum + "입니다.");

	}

}
