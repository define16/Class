package jv08;
import java.io.*;

public class FileEx8 {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("num.txt");
		
		for(int i=1; i<=100; i++)
			fw.write(i+" ");
		
		fw.close();
	}
}
