package Hw2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class ByteEx4
{
	public static void main(String []args)
	{
		InputStream in = System.in;
		OutputStream out = System.out;
		
		int read = 0;
		System.out.print("데이터 입력 (exit 종료): ");
		byte [] buffer = new byte[1024];
		int index = 0;
		
		try
		{
			while( (read = in.read(buffer) ) != -1)
			{
				do
				{
					index++;
				}
				while(buffer[index] != 0);
				byte [] temp = new byte[index];
				
				for(int i = 0; i<temp.length;i++)
				{
					temp[i] = buffer[i];
				}
				out.write(temp,0,temp.length);
				out.flush();
				
				if(temp.equals("exit"))
				{
					System.out.println("종료 : ");
					break;
				}
				int det = 0;
				buffer = new byte[1024];
						
			}
			in.close();
			out.close();
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
