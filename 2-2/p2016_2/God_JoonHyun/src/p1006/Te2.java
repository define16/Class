package p1006;

public class Te2 {
	public static void main(String[] args) {

		if(args.length > 0)
		{
			char c;

			c = args[0].charAt(0);

			if(c>='a' && c<='z')
				c -= 32;

			else if(c>='A' && c<='Z')
				c += 32;

			else
				System.out.println("�ҹ��ڿ� �빮�ڰ� �ƴմϴ�.");

			System.out.println("��ȯ�� ���ڴ� " + c + "�Դϴ�.");
		}
	}
}
