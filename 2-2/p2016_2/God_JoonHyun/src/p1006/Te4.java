package p1006;
import java.util.Scanner;

public class Te4 {
	public static void main(String[] args) {

		String name; //�̸�
		float[] num;
		float sum, avr; //��, ���

		num = new float[3];
		sum = 0; avr = 0;

		//Scanner ����
		Scanner sc = new Scanner(System.in);


		System.out.print("�̸��� �Է��ϼ���. : ");
		name = sc.nextLine(); //�̸� �Է�

		for(int i = 0; i<3; i++)
		{
			System.out.print(i+1 + "��° �Ǽ��� �Է��ϼ���. : ");
			num[i] = sc.nextFloat(); //�Ǽ� �Է�1, 2, 3
			sum += num[i];
		}

		avr = sum / 3;

		System.out.println("�̸� : " + name);
		System.out.printf("�� �Ǽ� ���� �� : %.2f", sum);
		System.out.println();
		System.out.printf("�� �Ǽ� ���� ��� : %.2f", avr);

	}
}

