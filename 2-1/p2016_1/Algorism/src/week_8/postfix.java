package week_8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
public class postfix {
	public static String chanPostfix(String input) // 수식을 후위식으로 변환
	{
		ArrayStack s = new ArrayStack(); // 배열로 된 스택 객체 생성
		String postfix = new String(); // 중위식을 후위식으로 변환해서 문자열 postfix에 저장

		for (int i = 0; i < input.length(); i++) // 0부터 입력받은 문자열의 크기를 반복
		{
			char c = input.charAt(i); // 입력받은 문자열의 i번째 문자를 변수 c에 저장
			if (c == 'q') // 입력값이 q이면 프로그램 종료
			{
				System.out.println("프로그램을 종료 합니다.");
				System.exit(-1);
			} else if (c >= '0' && c <= '9') // 문자 c가 숫자면 postfix에 숫자 추가
			{
				// 빈칸 1을 채우시오: 문자 c가 숫자면 postfix에 숫자 추가
			} else if (c == ' ') // c가 공백이면 postfix 변화 없음
			{
				postfix = postfix;
			} else if (c == '(') // 문자 c가 '('이면 스택에 push
			{
				s.push(c); // '('를 스택에 삽입
				s.print(); // 스택에 있는 원소 출력
			} else if (c == ')') // 문자 c가 ')'일 때
			{
				char d = ((Character) (s.pop())); // 스택에서 top를 pop함
				s.print();

				while (d != '(') // 스택에 '('이 나올때까지 반복
				{
					// 연산자를 postfix에 더함
					// 스택에서 '('이 나오기 전까지 pop함
					// 빈칸 2를 채우시오
				}
			}
			// c가 연산자일 때
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%'
					|| c == '^') {
				while (true) {
					if (s.empty()) // 스택이 비어있다면 while문을 빠져나옴
						break;

					char d = (Character) s.pop(); // 스택에서 pop을 한 후 d에 저장
					int inStack = PIS(d); // 스택에 있는 연산자를 스택에서의 우선순위에
											// 맞춰 정수형 변수 inStack에 저장
					int newStack = PIS(c); // 스택에 삽입될 연산자를 스택에서의 우선순위에
											// 맞춰 정수형 변수 newStack에 저장

					if (inStack >= newStack) // 스택 톱 연산자의 우선순위 >= 저장하려는 연산자의
												// 우선순위 이면
						postfix = postfix + d; // 스택에 있는 연산자를 postfix에 추가
					else if (inStack == 5 || newStack == 5)
						System.out.println("연산자를 잘못 입력하셨습니다.");
					else // 저장하려는 연산자의 우선순위가 스택 톱 연산자의 우선순위보다 작으면
					{
						s.push(d); // 스택에 push
						break; // while문 빠져나옴
					}
				}
				s.push(c); // 스택에 새로운 연산자를 push
				s.print();
			} else // 문자를 잘못 입력한 경우
			{
				System.err.println("잘못된 문자를 입력하셨습니다 : " + c);
				System.exit(-1);
			}
		}
		while (!s.empty()) // 스택이 비어있지 않다면
		{
			postfix = postfix + ((Character) (s.pop())); // 스택에 있는 문자들을 pop한 후
															// postfix에 추가
			s.print();
		}
		return postfix;
	}

	private static int PIS(char a) // 스택에서의 우선 순위
	{
		if (a == '^')
			return 3;

		if (a == '*' || a == '/')
			return 2;

		if (a == '+' || a == '-')
			return 1;

		if (a == '(')
			return 0;

		else
			return 5;
	}

	public static int evalPostfix(String postfix) {
		ArrayStack s = new ArrayStack(); // 스택 객체 생성

		int n, valL, valR;
		char c;
		for (int i = 0; i < postfix.length(); ++i) // 문자열을 순회
		{
			c = (postfix.charAt(i)); // 문자열에서 한글자씩 캐릭터로 전환(토큰)
			if (Character.getType(c) == 9) // 후위식에서 토큰이 숫자일 경우 스택에 푸시
			{
				n = char2int(c);
				s.push(n);
			} else // 토큰이 숫자가 아닐 경우(부호) 해당 부호로 두번 팝해서 계산 후 다시 스택에 쌓기
			{
				valR = (Integer) s.pop();
				valL = (Integer) s.pop();
				s.push(signclassificationCalc(valL, valR, c));
			}
		}
		return (Integer) s.pop();
	}

	public static int char2int(char c) {
		/* 빈칸 3을 채우시오 */;
	//} // char형을 int형으로 변환
		/*
	public static int signclassificationCalc(int valL, int valR, char operator) {
		switch (operator) {
		case '+':
			return valL + valR;
		case '-':
			return valL - valR;
		case '^':
			return (int) Math.pow(valL, valR);
		case '*': // "*" 구현하는 부분
			
			 * 빈칸 4을 채우시오 : "*"를 구현하시오
			 */

		//default: // "/" 구현하는 부분
			/*
			 * 빈칸 5을 채우시오 : "/"를 구현하시오
			 *//*
		}
	}

	private static InputStreamReader isReader;
	private static BufferedReader bufReader;

	public static void main(String[] args) throws IOException {
		String str = new String();
		String input = new String();
		int result = 0;

		while (true) {
			System.out.println("스택을 이용한 후위식 프로그램 입니다.");
			System.out
					.print("식을 입력하세요\n입력 예: (5+2), 5 * (2 + 5)\n종료 하시려면 q를 입력하세요\n입력 : ");

			isReader = new InputStreamReader(System.in);
			bufReader = new BufferedReader(isReader);

			input = bufReader.readLine(); // 수식을 입력받음
			str = chanPostfix(input); // 입력받은 수식(중위식)을 chanPostfix 메소드의
										// 매개변수로 전달한 후 리턴값(후위식)을 str에 저장
			System.out.println("후위식 : " + str); // 후위식 출력

			result = evalPostfix(str); // 후위식을 evalPostfix 메소드를 통해 결과값을 result에
										// 저장
			System.out.println("후위식 결과 : " + result); // 결과값 출력

			System.out.println("");
		}
	}
}
*/