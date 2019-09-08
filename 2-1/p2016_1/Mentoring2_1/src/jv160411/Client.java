package jv160411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private String serverIP = "127.0.0.1";
	private int serverPort = 6006;
	
	private Socket sock = null;
	
	private BufferedReader input = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	
	public void runClient()
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("[Notice] ������ ���� ��û�� �����ϴ�.");
			sock = new Socket(serverIP,serverPort);
			System.out.println("[Notice] ������ ���� ����!");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream());
		}
		catch(IOException e)
		{
			System.err.println("������ �����ϴµ� ������ ������ϴ�.");
			System.err.println(e.getMessage());
			return;
		}
		
		try {
			while(true){
			System.out.print("������ ���� �޽����� �Է��ϼ��� >> ");
			String data = input.readLine();
			if(data != null)
			{
				out.println(data);
				out.flush();
				System.out.println("�޽��� ���� ����!");
			}
			String indata = in.readLine();
			System.out.println("�����κ��� �����͸� �����Ͽ����ϴ�.");
			System.out.println(indata);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
			if(sock != null)
				
					sock.close();
				
			if(in != null)
				in.close();
			if(out != null)
				out.close();
			if(input != null)
				input.close();
			
				}
			catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}
	
}
