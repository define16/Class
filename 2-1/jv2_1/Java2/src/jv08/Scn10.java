package jv08;
import java.util.Scanner;

public class Scn10 {
	public static void main(String args[]){
        Scanner key = new Scanner(System.in);
        System.out.println("������ �Է��ϼ���");
        boolean result1 = key.nextBoolean();        
        
        if(result1 == true){
            System.out.println("���� �� ���� �Է��ϼ���");
            int result2 = key.nextInt();
            int result3 = key.nextInt();
            System.out.println("���� ���� ��� : " + (result2 + result3) );	
        }
        else {
            System.out.println("�ѱ� ���ڿ� �� ���� �Է��ϼ���");
            String result4 = key.next();
            String result5 = key.next();  
            System.out.println
            ("���ڿ� ���� ��� : " + result4 + result5);		  		 
        }
        key.close();
	}
}
