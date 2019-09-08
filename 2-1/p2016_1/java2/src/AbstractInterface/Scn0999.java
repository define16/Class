package AbstractInterface;

import java.util.*;

class Polynomial
{
	protected int a, b, c; //a는 계수 b는 차수 
	public Polynomial()
	{
		this.a=a;this.b=b;this.c=c;
		
	}
	public Polynomial(int a, int b,int c)
	{
		a=b=c=0;
	}
	public void print()
	{
		System.out.println(a + "x" +"^"+b+"+"+c);
	}
	
}
class PolyAdd extends Polynomial
{
	protected int sum;
	public PolyAdd(int a,int b,int c,int sum)
	{
		super(a,b,c);
		this.sum=sum;
	}
	public void PolyAdd(int a,int b ,int c,int sum)
	{
		System.out.println(sum+"=" + a+"x"+"^"+b+"+"+c);
		if(b>2)
		{
			sum+=sum;
		}
	}
}
class PolyMult extends Polynomial
{
	protected int Multy;
	public PolyMult(int a, int b, int c,int Multy)
	{
		super(a,b,c);
		this.Multy=Multy;
	}
	public void PolyMult(int a, int b, int c, int Multy){
		System.out.println(Multy + "=");
	}
}
class PolynomialTest
{
	public static void main(String[] args)
	{
		 Scanner ad = new Scanner(System.in);
		 
	}
}