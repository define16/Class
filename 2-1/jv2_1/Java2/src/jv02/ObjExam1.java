package jv02;

public class ObjExam1 {

	String name;

	public void prtName(){
		System.out.println("�̸� : " + name);
	}

	public static void main(String[] args){
		ObjExam1 obj1 = new ObjExam1();
		
 		obj1.name = "������";
		obj1.prtName();
	}

}
