package jv08;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx1 {
	public static void main(String args[]) throws IOException{
		FileOutputStream out = new FileOutputStream("out.txt");
		String name = "Kim Eun Ju";
		
		try
		{
			for(int cnt=0; cnt<name.length();cnt++)
				out.write(name.charAt(cnt));
		}
		finally
		{
			if(out != null)
				out.close();
					
		}
		
	}
}
