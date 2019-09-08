import java.util.Scanner;

public class fifth {
	public static void main(String []args){
		
	
	 while(true)
     {
        String input = "";
        String temp = ""; 
        
        Scanner sc = new Scanner(System.in);
        System.out.print("6자리 정수입력: ");
        input  = sc.next();
        
        if(input.length() != 6)
        {
           System.out.println("6자리 다시입력!");
           continue;
        }
        
        if(input.equals("999999"))
        {
           System.out.println("종료");
           break;
        }
        
        for(int i=input.length()-1; i>=0; i--)
        {
           temp +=  input.charAt(i);
        }
        int result = Integer.parseInt(input) + Integer.parseInt(temp);
        System.out.println(input+"+"+temp+"="+result);
     }   
	}
}
	
