package p1006;
import java.util.Scanner;

public class Te3 {
	public static void main(String[] args) {

		char c;

		Scanner sc;
		sc = new Scanner(System.in);

		System.out.print("소문자나 대문자로 입력하세요. : ");
		c = sc.next().charAt(0);


		if(c>='a' && c<='z')
			c -= 32;

		else if(c>='A' && c<='Z')
			c += 32;

		else
			System.out.println("소문자와 대문자가 아닙니다.");

		System.out.println("변환된 문자는 " + c + "입니다.");

	}
}
