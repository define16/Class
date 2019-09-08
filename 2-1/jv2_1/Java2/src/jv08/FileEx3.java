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
			System.out.print("이름을 입력하세요: ");
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
			
			System.out.println("프로그램을 종료합니다.");
			
		}
	}
}
