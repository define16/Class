package jv02;

/*
[입력화면]
	    C:\>java Test1 홍길동 100 90


[출력결과]

	     [홍길동]님 당신의 점수는 [100][90]점이고
	     합은[  ], 총점[  ], 학점[  ]입니다.
*/

public class Test1 {
	public static void main(String[] args) {
		
		int d1, d2;
		int data, sum;
		char c;

		d1 = Integer.parseInt(args[1]); //커맨드에서 입력을 받는다.
		d2 = Integer.parseInt(args[2]); 
		//run configurations에서 arguments에 가서 값을 입력
		
		sum  = d1+d2;
		data = sum/(args.length-1);
		
		switch(data/10)
		{
			case 10:
			case 9: c='A'; break;
			case 8: c='B'; break;
			case 7: c='C'; break;
			case 6: c='D'; break;
			default :
				c = 'F';
		}
		System.out.println("[" + args[0] + "] 님 당신의 점수는 [" +d1 +"] [" + d2 +"] 점이고");
		System.out.println("총점은[" +sum +"]," + "평균은 [" + data + "],학점["+ c +"]입니다.");
	}

}
