package jv09;
import java.io.*;

public class BufferedWriter1 {
	public static void main(String[] args) throws Exception {
		String intxt="연습용입니다";
	
		FileWriter fw = new FileWriter(args[0]);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(intxt);
		bw.close();
	}

}
