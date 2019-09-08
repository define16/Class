package jv08;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileEx3 {
	public static void main(String args[]) throws IOException{
		FileOutputStream out = new FileOutputStream("out2.txt");
		Scanner s = new Scanner(System.in); 
		
		try
		{
			System.out.print("�̸��� �Է��ϼ���: ");
			String name = s.nextLine();
			
			for(int cnt=0; cnt<name.length();cnt++)
				out.write(name.charAt(cnt));
		}
		finally
		{
			if( s != null )
				s.close();
			
			if( out != null )
				out.close();
			
			System.out.println("���α׷��� �����մϴ�.");
			
		}
	}
}
