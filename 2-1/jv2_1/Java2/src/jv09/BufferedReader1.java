package jv09;
import java.io.*;

public class BufferedReader1 {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader(args[0]);
		BufferedReader br = new BufferedReader(fr);
		
		String s;
		while((s=br.readLine()) != null)
			System.out.println(s);
		br.close();
	}
}
