package jv03;

public class MethodEx {
	public int sum(int a, int b){ //¸â¹ö¸Þ¼­µå
		return a+b;
	}
	public static void main(String[] args){
		MethodEx me = new MethodEx();
		int res = me.sum(1000, -10);
		System.out.println("res="+res);
	}
}
