package p1006;
import java.util.Scanner;

public class Te3 {
	public static void main(String[] args) {

		char c;

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.print("�ҹ��ڳ� �빮�ڷ� �Է��ϼ���. : ");
		c = sc.next().charAt(0);


		if(c>='a' && c<='z')
			c -= 32;

		else if(c>='A' && c<='Z')
			c += 32;

		else
			System.out.println("�ҹ��ڿ� �빮�ڰ� �ƴմϴ�.");

		System.out.println("��ȯ�� ���ڴ� " + c + "�Դϴ�.");

	}
}
