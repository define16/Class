package jv08;
import java.io.*;

public class FileEx7 {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("alph.txt");
		
		for(int i='A'; i<='Z'; i++)
			fw.write(i);
		
		fw.close();
	}
}
