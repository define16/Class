
public class Hw1
{
	static int bin;
	static byte ex;
	
	
	public byte Complement()
	{
		byte a,b;
		 a =  (byte) (0b100000000-bin);
		 b = (byte) ((0b11111111 ^ bin )+ 1);
	
		System.out.println("(1) 2������  ���ϱ�  ���� ����(��, ���)");
		System.out.println("��� ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
		System.out.println("�� ");
		System.out.println("10���� : " + b); //10������ ��ȯ
		System.out.print("2���� : ");
		String s3 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
		System.out.println(s3); //2������ ��ȯ
		System.out.print("16���� : ");
		String s4 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s4);//16������ ��ȯ
		
		ex=b;
		
		
	return b;
	}
	
	public void Clear()
	{
		byte a;
		a = (byte) (bin & 0b11110000);
		
		System.out.println("(2)���� 4��Ʈ��  0000����  clear ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
		
	}
	public void Mask()
	{
		byte a;
		a = (byte) (bin & 0b00001111);
		System.out.println("(3)���� 4��Ʈ�� ���� ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	}
	
	public void Intsert()
	{
		byte a;
		a = (byte)((bin & 0b00001111)|0b10100000);
		System.out.println("(4)���� 4��Ʈ�� 1010����  ���� ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
	
	public void Shift1()
	{
		byte a;
		a = (byte)(bin >> 3) ;
		System.out.println("(5)�������� 3�� ��� ����Ʈ ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
	
	public void Shift2() //(6)(1) 2�� ������ ����� ��������  2�� ��� ����Ʈ
	{
		byte a;
		a = (byte)(ex << 2);
		System.out.println("(6)(1)��2�� ������ ����� ��������  2�� ��� ����Ʈ ");
		System.out.println("10���� : " + a); //10������ ��ȯ
		System.out.print("2���� : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2������ ��ȯ
		System.out.print("16���� : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
		
	public static void main(String []arge)
	{
	      byte a = 0x41;
	      String b = String.format("%08d", Integer.parseInt(Integer.toString(a, 2)));
	      System.out.print("2���� �������� : ");
	      bin = Integer.parseInt(b, 10);
	      for(int i=0;i<b.length();i++)
	            System.out.print(b.charAt(i));
	      System.out.println();

	
		Hw1 com = new Hw1();
		Hw1 clear = new Hw1();
		Hw1 mask = new Hw1();
		Hw1 intsert = new Hw1();
		Hw1 shift1 = new Hw1();
		Hw1 shift2 = new Hw1();
	
		com.Complement();//2������  ���ϱ�  ���� ����(��, ���)
		clear.Clear();//2������  ���ϱ�  ���� ����(��, ���)
		mask.Mask();//(3)���� 4��Ʈ�� ���� 
		intsert.Intsert();//(4)���� 4��Ʈ�� 1010����  ����
		shift1.Shift1();//(5)�������� 3�� ��� ����Ʈ
		shift2.Shift2();//(6)(1) 2�� ������ ����� ��������  2�� ��� ����Ʈ
	
			
	}
}