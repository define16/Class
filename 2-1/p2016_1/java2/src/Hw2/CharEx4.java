package Hw2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharEx4 {
	public static void main(String []args) throws IOException
	{
	
		BufferedWriter out = new BufferedWriter(new FileWriter("./text4.txt", false));
		out.write("Java2 ����");
		out.flush();        
		out.close();
		 
		// �б�
		BufferedReader in = new BufferedReader(new FileReader("./text4.txt"));
		String data;
		while((data = in.readLine()) != null) {
		    System.out.println(data);
		}
		in.close();
	}

}
