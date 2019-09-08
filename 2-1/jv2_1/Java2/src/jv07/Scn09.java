package jv07;
import java.util.Scanner;

public class Scn09 {
	public static void main(String[] args) {
		Scanner i = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요:");
		String spi = i.nextLine();              // 입력 : 홍길동 40
		String[] spiResult = spi.split(" "); // 공백을 구분자로 한 라인을 나눈다.
	
		String strValue = spiResult[0];                // 홍길동
		int intValue = Integer.parseInt(spiResult[1]); // 40
		
		System.out.println(strValue + "-" + intValue);
		i.close();
	}
}

/*
[응용]
클래스명 : Scn099

문자열을 입력하세요:홍길동 40 100 89
[홍길동]님의 성적은 [40],[100],[89] 이고,
총점[   ] , 평균 [  ], 학점 [   ]입니다.
*/

/*
클래스명 : Scn0999
[문제설명]데이터의 입력과 처리 및 출력을 각각 분리(클래스의 멤버로 처리)

이름과 성적을 입력하세요: 홍길동 40 100 89
[홍길동]님의 성적은 [40],[100],[89] 이고,
총점[   ] , 평균 [  ], 학점 [   ]입니다.
*/