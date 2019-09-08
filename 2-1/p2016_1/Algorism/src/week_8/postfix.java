package week_8;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
public class postfix {
	public static String chanPostfix(String input) // ������ ���������� ��ȯ
	{
		ArrayStack s = new ArrayStack(); // �迭�� �� ���� ��ü ����
		String postfix = new String(); // �������� ���������� ��ȯ�ؼ� ���ڿ� postfix�� ����

		for (int i = 0; i < input.length(); i++) // 0���� �Է¹��� ���ڿ��� ũ�⸦ �ݺ�
		{
			char c = input.charAt(i); // �Է¹��� ���ڿ��� i��° ���ڸ� ���� c�� ����
			if (c == 'q') // �Է°��� q�̸� ���α׷� ����
			{
				System.out.println("���α׷��� ���� �մϴ�.");
				System.exit(-1);
			} else if (c >= '0' && c <= '9') // ���� c�� ���ڸ� postfix�� ���� �߰�
			{
				// ��ĭ 1�� ä��ÿ�: ���� c�� ���ڸ� postfix�� ���� �߰�
			} else if (c == ' ') // c�� �����̸� postfix ��ȭ ����
			{
				postfix = postfix;
			} else if (c == '(') // ���� c�� '('�̸� ���ÿ� push
			{
				s.push(c); // '('�� ���ÿ� ����
				s.print(); // ���ÿ� �ִ� ���� ���
			} else if (c == ')') // ���� c�� ')'�� ��
			{
				char d = ((Character) (s.pop())); // ���ÿ��� top�� pop��
				s.print();

				while (d != '(') // ���ÿ� '('�� ���ö����� �ݺ�
				{
					// �����ڸ� postfix�� ����
					// ���ÿ��� '('�� ������ ������ pop��
					// ��ĭ 2�� ä��ÿ�
				}
			}
			// c�� �������� ��
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '%'
					|| c == '^') {
				while (true) {
					if (s.empty()) // ������ ����ִٸ� while���� ��������
						break;

					char d = (Character) s.pop(); // ���ÿ��� pop�� �� �� d�� ����
					int inStack = PIS(d); // ���ÿ� �ִ� �����ڸ� ���ÿ����� �켱������
											// ���� ������ ���� inStack�� ����
					int newStack = PIS(c); // ���ÿ� ���Ե� �����ڸ� ���ÿ����� �켱������
											// ���� ������ ���� newStack�� ����

					if (inStack >= newStack) // ���� �� �������� �켱���� >= �����Ϸ��� ��������
												// �켱���� �̸�
						postfix = postfix + d; // ���ÿ� �ִ� �����ڸ� postfix�� �߰�
					else if (inStack == 5 || newStack == 5)
						System.out.println("�����ڸ� �߸� �Է��ϼ̽��ϴ�.");
					else // �����Ϸ��� �������� �켱������ ���� �� �������� �켱�������� ������
					{
						s.push(d); // ���ÿ� push
						break; // while�� ��������
					}
				}
				s.push(c); // ���ÿ� ���ο� �����ڸ� push
				s.print();
			} else // ���ڸ� �߸� �Է��� ���
			{
				System.err.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ� : " + c);
				System.exit(-1);
			}
		}
		while (!s.empty()) // ������ ������� �ʴٸ�
		{
			postfix = postfix + ((Character) (s.pop())); // ���ÿ� �ִ� ���ڵ��� pop�� ��
															// postfix�� �߰�
			s.print();
		}
		return postfix;
	}

	private static int PIS(char a) // ���ÿ����� �켱 ����
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
		ArrayStack s = new ArrayStack(); // ���� ��ü ����

		int n, valL, valR;
		char c;
		for (int i = 0; i < postfix.length(); ++i) // ���ڿ��� ��ȸ
		{
			c = (postfix.charAt(i)); // ���ڿ����� �ѱ��ھ� ĳ���ͷ� ��ȯ(��ū)
			if (Character.getType(c) == 9) // �����Ŀ��� ��ū�� ������ ��� ���ÿ� Ǫ��
			{
				n = char2int(c);
				s.push(n);
			} else // ��ū�� ���ڰ� �ƴ� ���(��ȣ) �ش� ��ȣ�� �ι� ���ؼ� ��� �� �ٽ� ���ÿ� �ױ�
			{
				valR = (Integer) s.pop();
				valL = (Integer) s.pop();
				s.push(signclassificationCalc(valL, valR, c));
			}
		}
		return (Integer) s.pop();
	}

	public static int char2int(char c) {
		/* ��ĭ 3�� ä��ÿ� */;
	//} // char���� int������ ��ȯ
		/*
	public static int signclassificationCalc(int valL, int valR, char operator) {
		switch (operator) {
		case '+':
			return valL + valR;
		case '-':
			return valL - valR;
		case '^':
			return (int) Math.pow(valL, valR);
		case '*': // "*" �����ϴ� �κ�
			
			 * ��ĭ 4�� ä��ÿ� : "*"�� �����Ͻÿ�
			 */

		//default: // "/" �����ϴ� �κ�
			/*
			 * ��ĭ 5�� ä��ÿ� : "/"�� �����Ͻÿ�
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
			System.out.println("������ �̿��� ������ ���α׷� �Դϴ�.");
			System.out
					.print("���� �Է��ϼ���\n�Է� ��: (5+2), 5 * (2 + 5)\n���� �Ͻ÷��� q�� �Է��ϼ���\n�Է� : ");

			isReader = new InputStreamReader(System.in);
			bufReader = new BufferedReader(isReader);

			input = bufReader.readLine(); // ������ �Է¹���
			str = chanPostfix(input); // �Է¹��� ����(������)�� chanPostfix �޼ҵ���
										// �Ű������� ������ �� ���ϰ�(������)�� str�� ����
			System.out.println("������ : " + str); // ������ ���

			result = evalPostfix(str); // �������� evalPostfix �޼ҵ带 ���� ������� result��
										// ����
			System.out.println("������ ��� : " + result); // ����� ���

			System.out.println("");
		}
	}
}
*/