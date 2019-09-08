package Hw2;

import java.io.PrintWriter;

public class CharEx5 {
	public static void main(String []args)
	{
		
		System.out.println("이게 마지막 입니다. 교수님"); 		 
	
		PrintWriter pw = new PrintWriter(System.out);
		pw.write("Good bye");
		pw.flush();
		pw.close();
	

	}

}
