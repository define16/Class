package jv02;

public class ObjExam3 {
	int num;


	public ObjExam3() {
		num = 2;
	}

	public ObjExam3(int num){
		this.num = num;
	}

	public void prt(){
		System.out.println(num + "´Ü");
		for(int i=1; i<=9; i++)
			System.out.println(num + "*" + i + "=" + (num*i));
	}

	public static void main(String[] args){
		ObjExam3 obj1 = new ObjExam3();
		ObjExam3 obj2 = new ObjExam3(4);
		ObjExam3 obj3 = new ObjExam3(7);

 		obj1.prt();
		obj2.prt();
		obj3.prt();;
	}
}
