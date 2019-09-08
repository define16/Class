package Hw2;

//FileIntputsstream/OutputSteam

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteEx1
{
	public static void main(String[] args) throws  IOException
	{
		File f = new File("./text.txt");
	if (! f.exists())
		{
		    f.createNewFile();
		}
		 
 
		FileOutputStream f1 = new FileOutputStream("D:\\Java\\p1\\test3.txt", true);
	
		f1.write(97);  f1.write(102); f1.write(105); f1.write(112);
		f1.write(98); f1.write(108); f1.write(99); f1.write(108);
		f1.close();
		 
		
		FileInputStream f2 = new FileInputStream("D:\\Java\\p1\\test3.txt");
		 
		int data = 0; 
		while ((data = f2.read()) != -1)
		{
		    System.out.print((char) data); 
		}
		f2.close();

	}
}