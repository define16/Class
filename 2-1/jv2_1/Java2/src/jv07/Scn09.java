package jv07;
import java.util.Scanner;

public class Scn09 {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		
		System.out.print("���ڿ��� �Է��ϼ���:");
		String spi = i.nextLine();              // �Է� : ȫ�浿 40
		String[] spiResult = spi.split(" "); // ������ �����ڷ� �� ������ ������.
	
		String strValue = spiResult[0];                // ȫ�浿
		int intValue = Integer.parseInt(spiResult[1]); // 40
		
		System.out.println(strValue + "-" + intValue);
		i.close();
	}
}

/*
[����]
Ŭ������ : Scn099

���ڿ��� �Է��ϼ���:ȫ�浿 40 100 89
[ȫ�浿]���� ������ [40],[100],[89] �̰�,
����[   ] , ��� [  ], ���� [   ]�Դϴ�.
*/

/*
Ŭ������ : Scn0999
[��������]�������� �Է°� ó�� �� ����� ���� �и�(Ŭ������ ����� ó��)

�̸��� ������ �Է��ϼ���: ȫ�浿 40 100 89
[ȫ�浿]���� ������ [40],[100],[89] �̰�,
����[   ] , ��� [  ], ���� [   ]�Դϴ�.
*/