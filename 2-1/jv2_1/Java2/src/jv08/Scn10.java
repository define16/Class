package jv08;
import java.util.Scanner;

public class Scn10 {
	public static void main(String args[]){
        Scanner key = new Scanner(System.in);
        System.out.println("논리값을 입력하세요");
        boolean result1 = key.nextBoolean();        
        
        if(result1 == true){
            System.out.println("정수 두 개를 입력하세요");
            int result2 = key.nextInt();
            int result3 = key.nextInt();
            System.out.println("정수 덧셈 결과 : " + (result2 + result3) );	
        }
        else {
            System.out.println("한글 문자열 두 개를 입력하세요");
            String result4 = key.next();
            String result5 = key.next();  
            System.out.println
            ("문자열 결합 결과 : " + result4 + result5);		  		 
        }
        key.close();
	}
}
