package jv06;
import java.util.Scanner;

public class Scn02 {
	int start;
	int end;

	public Scn02() {
		start = 1;
		end = 100;
	}

	public Scn02(int start, int end){
		this.start = start;
		this.end = end;
	}

	public void prt(){
		System.out.println(start + "���� " + end + "���� �����͸� ����մϴ�.");
		while(start <= end )
		{ 
			System.out.print(start + "  ");
			start++;
		}
		System.out.println("\n");
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int st, ed;
		
		System.out.print("�ʱⰪ�� �������� �Է��ϼ���:");
		st = sc.nextInt();
		ed = sc.nextInt();
		
		Scn02 obj1 = new Scn02();
		Scn02 obj2 = new Scn02(st, ed);
	
 		obj1.prt();
		obj2.prt();
		
		sc.close();
	
	}

}
