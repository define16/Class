package p1027;

public class ArrayEx1 {
	public static void main(String[] args) {

		char[] ch;
		ch = new char[4];

		ch[0] = 'J';
		ch[1] = 'a';
		ch[2] = 'v';
		ch[3] = 'a';

		for(int i = 0; i < ch.length; i++)
			System.out.println("ch[" + i + "] : " + ch[i]);
	}
}
