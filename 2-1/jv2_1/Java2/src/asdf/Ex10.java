package asdf;

public class Ex10 {
	int start, end;
	
	public Ex10()
	{
		start = 1;
		end = 100;
	}
	public Ex10(int start, int end)
	{
		this.start = start;
		this.end = end;
		
	}
	public void prt()
	{
		System.out.println(start + "부터 " + end + "까지의 데이터를 출력합니다.");
		for (int i = start;i<=end;i++)
			System.out.print(i + " ");
		System.out.println();
		
	
		String a = "basdf";
		if(a == "basdf" )
		{
			System.out.print(a);
		}
	}
	
	
	public static void main(String []args)
	{
		Ex10 obj1 = new Ex10();
		Ex10 obj2 = new Ex10(5,10);
		Ex10 obj3 = new Ex10(10,50);
		
		obj1.prt();
		obj2.prt();
		obj3.prt();
		
		
	}

}
