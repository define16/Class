package jv08;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx6 {
	 public static void main(String[] args) throws IOException {

	        FileReader in = null;
	        FileWriter out = null;

	        try {
	            in = new FileReader(args[0]);
	            out= new FileWriter(args[1]);

	            int c;
	            while ((c = in.read()) != -1) {
	                out.write(c);
	            }
	        } finally {
	            if (in != null) 
	                in.close();
	        
	            if (out != null) 
	                out.close();
	           
	            System.out.println("프로그램을 종료합니다.");
	        }
	    }
}
