package jv08;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileEx5 {
	 public static void main(String[] args) throws IOException {
	        FileReader inputStream = null;
	        FileWriter outputStream = null;

	        try {
	            inputStream = new FileReader("input2.txt");
	            outputStream = new FileWriter("output2.txt");

	            int c;
	            while ((c = inputStream.read()) != -1) {
	                outputStream.write(c);
	            }
	        } finally {
	            if (inputStream != null) 
	                inputStream.close();
	            
	            if (outputStream != null) 
	                outputStream.close();
	                
	            System.out.println("프로그램을 종료합니다.");
	            
	        }
	    }
}
