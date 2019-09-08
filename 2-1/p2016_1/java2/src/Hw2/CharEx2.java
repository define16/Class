package Hw2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharEx2 {
	public static void main(String []args) throws IOException
	{

	FileWriter out = new FileWriter("D:\\Java\\p1\\test1.txt", true); 

	 
	String txt = "abcdefg \r\nABCDEFG \r\n가나다라마바사";
	out.write(txt);
	out.close();
	 

	FileReader in = new FileReader("D:\\Java\\p1\\test1.txt");
	int data = 0;
	while((data = in.read()) != -1) { 
	    System.out.print((char) data);
	}
	in.close();
	}
}
