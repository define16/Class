package jv02;

public class ObjExam1 {

	String name;

	public void prtName(){
		System.out.println("¿Ã∏ß : " + name);
	}

	public static void main(String[] args){
		ObjExam1 obj1 = new ObjExam1();
		
 		obj1.name = "±Ë¿∫¡÷";
		obj1.prtName();
	}

}
