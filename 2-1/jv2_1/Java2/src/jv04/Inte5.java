package jv04;

class DataSet{
	int st;
	int en;
	int b;
	
	
	void setdata(int x, int y, int z){
		st = x;
		en = y;
		b = z;
	}
}

class Oper extends DataSet{
	
	int total, num, first;
		
	void sum(){
		first = st;
		while(st <= en){
			if(st% b == 0){
				total += st;
				num++;
			}
			st++;
		}
	}
	
	void print(int a){
		st = first;
					
		switch(a){
		case 0:		
			while(st <= en)
			{
				if(st % b == 0)
			 		System.out.print(st + " ");
					
				st++;
			}
			System.out.println();
			break;
		case 1: 	System.out.println("���� : " + total); 		break;
		case 2: 	System.out.println("�������� ������ : " + num); 	break;
		case 3:
		  	st=first;
			while(st <= en)
			{
				if(st % b == 0)
					System.out.print(st + " ");
				st++;
			}
			System.out.println();
			System.out.println("�������� ���� :" + total);
			System.out.println("�������� ������ :" + num);
		}
	}
}

public class Inte5{
	public static void main(String[] args) {
	
		Oper subOb = new Oper();
		
		subOb.setdata(1, 100, 5); //1~100���� 5�� ����Է�
		
		subOb.sum(); //�հ��
		subOb.print(0); //���������
		System.out.println("=============");
		subOb.print(1); // �����
		System.out.println("=============");
		subOb.print(2);// ����
		System.out.println("=============");
		subOb.print(3);//����
	}
}
