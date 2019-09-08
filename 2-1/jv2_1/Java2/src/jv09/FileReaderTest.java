package jv09;
import java.io.*;

public class FileReaderTest {
	public static void main(String[] args) throws IOException 	{
		FileReader in = null;
		FileWriter out = null;
		String s = "������ ������ �����Դϴ�.";

	    try{
			out = new FileWriter("data.txt");
			out.write(s); 
			out.append("\n�����Դϴ�.\r"); 		
			out.append("\n���� �������Դϴ�."); 
			out.append("\n���� ������ �Ͼ��ּ���."); 
			out.flush();
	
			in = new FileReader("data.txt");
			int c;
			while ((c = in.read()) != -1) {
				System.out.print((char)c);
			}
        }finally{
			if (in != null)
				in.close();
			if (out != null)
				out.close();
	     }
	}
}
