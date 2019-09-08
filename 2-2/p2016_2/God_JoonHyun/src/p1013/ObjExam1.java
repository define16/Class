package p1013;

class ObjExam1 {
	String name;

	public void prtName(){
		System.out.println("이름 : " + name);
	}

	public static void main(String[] args) {

		ObjExam1 obj1 = new ObjExam1();

		obj1.name = "박준현";
		obj1.prtName();
	}
}
