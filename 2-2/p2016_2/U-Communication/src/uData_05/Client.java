package uData_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread
{
	private static final int ACCEPT_PORT = 9613;
	private static final String ACCEPT_IP = "127.0.0.1"; //203.253.255.99
	private Server sv= null;
	private BufferedReader receive = null;
	private PrintWriter trans = null;
	private BufferedReader in = null;
	private String msg;

	private ReceiveListener listener;
	private boolean tg;
	public void run()
	{
		if(!tg)
		{
			Socket socket = null;
			
			// ������ ����
			try
			{
				System.out.println("[IP:" + ACCEPT_IP + ",PORT:" + ACCEPT_PORT + "]�� ������..." );
				listener.Receive("[IP:" + ACCEPT_IP + ",PORT:" + ACCEPT_PORT + "]�� ������...");
				socket = new Socket(ACCEPT_IP, ACCEPT_PORT);
				System.out.println("������ �����Ͽ����ϴ�.");
				listener.Receive("������ �����Ͽ����ϴ�.");
				receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				trans = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			
			}catch(IOException e){
				// ���� ���� ���� - ip�� port�� �߸��Ǿ��� ���
				System.err.println("[ERR]���� ���� ����");
				return ;
			}
			
			 //������ ���� �޽����� �Է¹޴� ���ÿ� �������� ���� �޽����� ����
			try
			{
				
					while(true)
					{
						// ������ ���� �޽����� �޴� ���� ��ٸ���.
						msg = receive.readLine();
						// ���� �޽����� ����Ѵ�.
					
						System.out.println(msg);
						listener.Receive(msg);
						
					}
					
				
			}catch(IOException e){
				System.err.println("[ERR]���� ����");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
			// ���������� ������ ���� �� ����
			try {
				if( receive != null)
					receive.close();
				if(trans != null)
					trans.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				
			}
		}
	}
	
	
	
	public void sendMessage(String msg)
	{
		trans.println(msg);
		trans.flush();
			
	}
	public void addReceiveListener(ReceiveListener listener) {
		this.listener = listener;
	}
	
}
