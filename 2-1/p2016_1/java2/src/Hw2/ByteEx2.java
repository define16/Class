package Hw2;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteEx2 {
    public static void main(String[] args) throws IOException{
    
    	BufferedInputStream in = new BufferedInputStream(new FileInputStream
    			("D:\\Java\\p1\\test.txt"));
    	BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream
    			("D:\\Java\\p1\\test.txt"));
    	 
    	int cb = 4;
    	 
    	while (in.available() > 0) {
    	    cb ++;
    	    out.write(in.read());
    	}
    	 
    	System.out.format("총 %,d바이트 복사었습니다.\n", cb);
    	 
    	out.flush();
    	in.close();
    	out.close();

    }
}
