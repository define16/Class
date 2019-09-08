
public class Hw1
{
	static int bin;
	static byte ex;
	
	
	public byte Complement()
	{
		byte a,b;
		 a =  (byte) (0b100000000-bin);
		 b = (byte) ((0b11111111 ^ bin )+ 1);
	
		System.out.println("(1) 2보수를  구하기  위한 연산(논리, 산술)");
		System.out.println("산술 ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
		System.out.println("논리 ");
		System.out.println("10진수 : " + b); //10진수로 변환
		System.out.print("2진수 : ");
		String s3 = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
		System.out.println(s3); //2진수로 변환
		System.out.print("16진수 : ");
		String s4 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s4);//16진수로 변환
		
		ex=b;
		
		
	return b;
	}
	
	public void Clear()
	{
		byte a;
		a = (byte) (bin & 0b11110000);
		
		System.out.println("(2)하위 4비트를  0000으로  clear ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
		
	}
	public void Mask()
	{
		byte a;
		a = (byte) (bin & 0b00001111);
		System.out.println("(3)하위 4비트만 추출 ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	}
	
	public void Intsert()
	{
		byte a;
		a = (byte)((bin & 0b00001111)|0b10100000);
		System.out.println("(4)상위 4비트는 1010으로  삽입 ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
	
	public void Shift1()
	{
		byte a;
		a = (byte)(bin >> 3) ;
		System.out.println("(5)우측으로 3번 산술 쉬프트 ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
	
	public void Shift2() //(6)(1) 2의 보수한 결과를 좌측으로  2번 산술 쉬프트
	{
		byte a;
		a = (byte)(ex << 2);
		System.out.println("(6)(1)의2의 보수한 결과를 좌측으로  2번 산술 쉬프트 ");
		System.out.println("10진수 : " + a); //10진수로 변환
		System.out.print("2진수 : ");
		String s1 = String.format("%8s", Integer.toBinaryString(a & 0xFF)).replace(' ', '0');
		System.out.println(s1); //2진수로 변환
		System.out.print("16진수 : ");
		String s2 = String.format(Integer.toHexString(a & 0xFF));
		System.out.println(s2);
	} 	
		
	public static void main(String []arge)
	{
	      byte a = 0x41;
	      String b = String.format("%08d", Integer.parseInt(Integer.toString(a, 2)));
	      System.out.print("2진수 데이터형 : ");
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
	
		com.Complement();//2보수를  구하기  위한 연산(논리, 산술)
		clear.Clear();//2보수를  구하기  위한 연산(논리, 산술)
		mask.Mask();//(3)하위 4비트만 추출 
		intsert.Intsert();//(4)상위 4비트는 1010으로  삽입
		shift1.Shift1();//(5)우측으로 3번 산술 쉬프트
		shift2.Shift2();//(6)(1) 2의 보수한 결과를 좌측으로  2번 산술 쉬프트
	
			
	}
}