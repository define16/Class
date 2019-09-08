package jv02;

public class ObjExam2 {
	String name;
	int num;


	public ObjExam2() {
		name = "고사연";
		num = 20;
	}

	public ObjExam2(int num, String name){
		this.num = num;
		this.name = name;
	}

	public void prt(){
		System.out.println("     번호 : " + num);
		System.out.println("     이름 : " + name);
	}

	public static void main(String[] args){
		ObjExam2 obj1 = new ObjExam2();
		ObjExam2 obj2 = new ObjExam2(50,"한림자");
		
 		obj1.prt();
		obj2.prt();
	}
}
