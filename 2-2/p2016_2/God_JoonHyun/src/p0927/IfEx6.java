package p0927;

public class IfEx6 {
	public static void main(String[] args) {

		String data = args[0];
		String res;

		// String ��ü ������ ���� ���� equals()�޼��带 ����Ѵ�.
		if(data.equals("����"))
			res = "�޴�.";
		else if(data.equals("����"))
			res = "�ÿ��ϴ�.";
		else if(data.equals("����"))
			res = "���ִ�.";
		else
			res = "��Ÿ";

		System.out.println(res);
	}
}