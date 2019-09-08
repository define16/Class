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
				System.out.println("소문자와 대문자가 아닙니다.");

			System.out.println("변환된 문자는 " + c + "입니다.");
		}
	}
}
