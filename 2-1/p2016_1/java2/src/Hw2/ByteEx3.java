package Hw2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//DataInputStream/DataOutputStream


public class ByteEx3
{
    public static void main(String[] args) throws IOException
    {
    	File file = new File("D:\\Java\\p1\\test.dat");
    	 
    	
    	DataOutputStream d = new DataOutputStream(new FileOutputStream(file));
    	d.writeBoolean(true);
    	d.write(7);
    	d.writeByte((byte) 7);
    	d.writeInt(12405);
    	d.writeDouble(210.523);
    	d.writeUTF("Hello");
    	 
    	d.flush();
    	d.close();
    	 
    
    	DataInputStream d2 = new DataInputStream(new FileInputStream(file));
    	System.out.println(d2.readBoolean());
    	System.out.println(d2.read());
    	System.out.println(d2.readByte());
    	System.out.println(d2.readInt());
    	System.out.println(d2.readDouble());
    	System.out.println(d2.readUTF());
    	d2.close();
    }
}