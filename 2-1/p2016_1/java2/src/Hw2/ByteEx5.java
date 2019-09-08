package Hw2;
import java.io.*;
public class ByteEx5
{
		public static void main(String[] args) throws IOException
		{
			InputStream in = new FileInputStream("org.bin");
			OutputStream out = new FileOutputStream("cpy.bin");
			
			int cb =4;
			int bData;
			
			while(true)
			{
				bData=in.read();
				if(bData == -1)
					break;
				
				out.write(bData);
				cb++;
			}
			
			in.close();
			out.close();
			System.out.println("복사된 바이트의 크기 : " + cb);
			
		}
}