package jv08;

import java.io.*;

public class FileEx2 {
	public static void main(String args[]) throws IOException{
		FileOutputStream out = new FileOutputStream("out.txt");
		
		try
		{
			char c;
			System.out.print("�̸��� �Է��ϼ��� : ");
					
			while((c=(char)System.in.read()) != '\r')
			{
				out.write(c);
			    System.out.print(c);
			}
				
		}
		finally
		{
			if(out != null)
				out.close();
					
		}
		
	}
}
