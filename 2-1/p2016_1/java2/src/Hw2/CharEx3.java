package Hw2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class CharEx3 {
	public static void main(String []args) throws IOException
	{
		FileReader in = new FileReader("./text2.txt");
		FileWriter out = new FileWriter("./text2.txt");

		OutputStream os = System.out;

		String txt = "Hi? abcdefg\r\nhihi~";
		out.write(txt);
		out.flush();
		out.close();
		byte temp[] = new byte[txt.length()];
		int index = 0;
		
		int data = 0;
		while ((data = in.read()) != -1) 
		{
			temp[index++] = (byte)data;
		}
		String result = new String(temp);
		System.out.println(result);

		in.close();
		os.close();
	}

}
