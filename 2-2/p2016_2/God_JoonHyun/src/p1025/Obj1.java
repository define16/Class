package p1025;

public class Obj1 {
	String name;
	int num;
	
	public Obj1() {
		name = "��翬";
		num = 20;
	}
	
	public Obj1(int num, String name){
		this.num = num;
		this.name = name;
	}
	
	public void prt(){
		System.out.println("��ȣ : " + num);
		System.out.println("�̸� : " + name);
	}
	
	public static void main(String[] args) {
		
		Obj1 ob1 = new Obj1();
		Obj1 ob2 = new Obj1(50, "�Ѹ���");
		
		ob1.prt();
		ob2.prt();
	}
}
