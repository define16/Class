import java.util.Scanner;

public class fifth {
	public static void main(String []args){
		
	
	 while(true)
     {
        String input = "";
        String temp = ""; 
        
        Scanner sc = new Scanner(System.in);
        System.out.print("6�ڸ� �����Է�: ");
        input  = sc.next();
        
        if(input.length() != 6)
        {
           System.out.println("6�ڸ� �ٽ��Է�!");
           continue;
        }
        
        if(input.equals("999999"))
        {
           System.out.println("����");
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
	
