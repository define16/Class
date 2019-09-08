package jv09;
import java.io.*;

public class FileReaderTest {
	public static void main(String[] args) throws IOException 	{
		FileReader in = null;
		FileWriter out = null;
		String s = "지금은 연습용 파일입니다.";

	    try{
			out = new FileWriter("data.txt");
			out.write(s); 
			out.append("\n정말입니다.\r"); 		
			out.append("\n나는 김은주입니다."); 
			out.append("\n나의 진심을 믿어주세요."); 
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
