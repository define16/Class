package jv02;

public class ObjExam2 {
	String name;
	int num;


	public ObjExam2() {
		name = "��翬";
		num = 20;
	}

	public ObjExam2(int num, String name){
		this.num = num;
		this.name = name;
	}

	public void prt(){
		System.out.println("     ��ȣ : " + num);
		System.out.println("     �̸� : " + name);
	}

	public static void main(String[] args){
		ObjExam2 obj1 = new ObjExam2();
		ObjExam2 obj2 = new ObjExam2(50,"�Ѹ���");
		
 		obj1.prt();
		obj2.prt();
	}
}
