package p1013;

public class ObjExam2 {
	String name;
	int num;
	
	public ObjExam2()
	{
		name = "������";
		num = 20;
	}
	
	public ObjExam2(int num, String name)
	{
		this.name = name;
		this.num = num;
	}
	
	public void prt()
	{
		System.out.println("��ȣ : " + num);
		System.out.println("�̸� : " + name);
	}
	
	public static void main(String[] args) {
		
		ObjExam2 obj1 = new ObjExam2();
		ObjExam2 obj2 = new ObjExam2(50,"�Ѹ���");
		
		obj1.prt();
		obj2.prt();
	}
}
