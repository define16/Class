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
		case 1: 	System.out.println("합은 : " + total); 		break;
		case 2: 	System.out.println("데이터의 개수는 : " + num); 	break;
		case 3:
		  	st=first;
			while(st <= en)
			{
				if(st % b == 0)
					System.out.print(st + " ");
				st++;
			}
			System.out.println();
			System.out.println("데이터의 합은 :" + total);
			System.out.println("데이터의 개수는 :" + num);
		}
	}
}

public class Inte5{
	public static void main(String[] args) {
	
		Oper subOb = new Oper();
		
		subOb.setdata(1, 100, 5); //1~100까지 5의 배수입력
		
		subOb.sum(); //합계산
		subOb.print(0); //데이터출력
		System.out.println("=============");
		subOb.print(1); // 합출력
		System.out.println("=============");
		subOb.print(2);// 개수
		System.out.println("=============");
		subOb.print(3);//몽땅
	}
}
