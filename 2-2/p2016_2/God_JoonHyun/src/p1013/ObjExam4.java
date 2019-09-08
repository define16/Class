package p1013;

class ObjExam4 {
	int start;
	int end;

	//1,100,5,7,cnt,sum
	
	public ObjExam4()
	{
		start = 1;
		end = 100;
	}
	public ObjExam4(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	public void prt()
	{
		int i = 0;
		System.out.println(start + "부터 " + end + "까지 데이터를 출력합니다.");
		
		while(start<=end)
		{
			System.out.printf("%3d", start);
			start++;
			i++;
			
			if(i%25==0)
				System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		ObjExam4 obj1 = new ObjExam4();
		ObjExam4 obj2 = new ObjExam4(5, 10);
		ObjExam4 obj3 = new ObjExam4(10, 50);
		
		obj1.prt();
		obj2.prt();
		obj3.prt();
	}
}
