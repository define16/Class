package p0927;

public class ExIf5 {
	public static void main(String[] args) {

		int sum, data1, data2, data3;
		char c;
		double data;

		// ���� �Լ��� �Ű������� ���� �μ����� 3�� �Է��� ��
		// �� ���� �հ� ���, ������ ����ϼ���.

		data1 = Integer.parseInt(args[0]);
		data2 = Integer.parseInt(args[1]);
		data3 = Integer.parseInt(args[2]);

		sum = data1 + data2 + data3;
		data = sum / 3;
		//data = 78;
		data = (double)sum/3;

		if(data >= 90 && data <= 100)
			c = 'A';
		else if(data >= 80 && data <= 89)
			c = 'B';
		else if(data >= 70 && data <= 79)
			c = 'C';
		else if(data >= 60 && data <= 69)
			c = 'D';
		else
			c = 'F';


		System.out.println("�� ���� �� : " + sum + "�� �Դϴ�.");
		System.out.format("����� %.2f, ",data);
		System.out.println("����� ������ " + c + "�Դϴ�.");
	}
}
