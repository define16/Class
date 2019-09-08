package p1006;

public class Te1 {
	public static void main(String[] args) {

		if(args.length > 0)
		{
			char c;
			String msg = null;

			c = args[0].charAt(0);

			if(c>='0' && c<='9')
				msg = "숫자입니다.";

			else if(c>='a' && c<='z')
				msg = "소문자입니다.";

			else if(c>='A' && c<='Z')
				msg = "대문자입니다.";

			else
				msg = "숫자와 문자가 아닙니다.";

			System.out.println(msg);
		}
	}
}
