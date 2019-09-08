package jv08;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx4 {
	public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("input.txt");
            out = new FileOutputStream("output.txt");

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
