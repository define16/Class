package p1006;

public class Te1 {
	public static void main(String[] args) {

		if(args.length > 0)
		{
			char c;
			String msg = null;

			c = args[0].charAt(0);

			if(c>='0' && c<='9')
				msg = "�����Դϴ�.";

			else if(c>='a' && c<='z')
				msg = "�ҹ����Դϴ�.";

			else if(c>='A' && c<='Z')
				msg = "�빮���Դϴ�.";

			else
				msg = "���ڿ� ���ڰ� �ƴմϴ�.";

			System.out.println(msg);
		}
	}
}
