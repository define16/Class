package p0927;

public class ForEx3 {
	public static void main(String[] args) {

		int i;
		int cnt;
		int sum;

		cnt = 0;
		sum = 0;

		// 1���� 100������ ������ �߿��� 5�� ����� �����͸� ����ϰ�
		// ���������� 5�� ����� ������ ����϶�...
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
		System.out.println("5�� ����� ���� : " + cnt);
		System.out.println("5�� ����� �� : " + sum);

	}
}
