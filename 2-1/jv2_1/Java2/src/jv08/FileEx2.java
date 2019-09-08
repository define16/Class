package jv08;

import java.io.*;

public class FileEx2 {
	public static void main(String args[]) throws IOException{
		FileOutputStream out = new FileOutputStream("out.txt");
		
		try
		{
			char c;
			System.out.print("이름을 입력하세요 : ");
					
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
