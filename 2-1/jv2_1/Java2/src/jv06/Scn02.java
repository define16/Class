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
		System.out.println(start + "부터 " + end + "까지 데이터를 출력합니다.");
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
		
		System.out.print("초기값과 최종값을 입력하세요:");
		st = sc.nextInt();
		ed = sc.nextInt();
		
		Scn02 obj1 = new Scn02();
		Scn02 obj2 = new Scn02(st, ed);
	
 		obj1.prt();
		obj2.prt();
		
		sc.close();
	
	}

}
