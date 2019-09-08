package jv02;

public class ObjExam4 {
	int start;
	int end;

	public ObjExam4() {
		start = 1;
		end = 100;
	}

	public ObjExam4(int start, int end){
		this.start = start;
		this.end = end;
	}

	public void prt(){
		System.out.println(start + "부터 " + end + "까지 데이터를 출력합니다.");
		while(start <= end )
		{ 
			System.out.print(start + "  ");
			start++;
		}
		System.out.println("\n");
	}

	public static void main(String[] args){
		ObjExam4 obj1 = new ObjExam4();
		ObjExam4 obj2 = new ObjExam4(5, 10);
		ObjExam4 obj3 = new ObjExam4(10, 50);

 		obj1.prt();
		obj2.prt();
		obj3.prt();;
	}

}
