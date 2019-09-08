package uData_05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.TreeSet;


public class AcceptServer extends Thread {
	
	private ServerSocket serverSocket = null;
	private static final int SERVER_PORT = 9613;
	private String msg;
	private String ma;
	private boolean serverFlag = true;
	int ran = -1;
	private ReceiveListener listener;
	public void closeServer()
	{
		serverFlag = false;
		
		try 
		{
			serverSocket.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("[SYSTEM] ������ ���� �Ǿ����ϴ�.");
		System.exit(0);
	}
	
	
	public boolean startServer()
	{
		try{
			
			serverSocket = new ServerSocket(SERVER_PORT);
		}catch(IOException e)
		{
			return false;
		}
		super.start();
		return true;
	}
	
	public void run()
	{
		while(serverFlag)
		{
			try {
				System.out.println("[SYSTEM] ���ο� Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...");
				listener.Receive("[SYSTEM] ���ο� Ŭ���̾�Ʈ�� ������ ��ٸ��ϴ�...");
				Socket socket = serverSocket.accept();
				
				System.out.println(socket.getInetAddress().getHostAddress());
				//
				
				do
				{
					ran = (int)(Math.random()*ServerList.SERVER_MAX);
					
					
				}while(!ServerList.serverList[ran].isIdle());
				
				System.out.println("[SYSTEM] Ŭ���̾�Ʈ(" + socket.getInetAddress().getHostAddress() +")�� �����Ͽ����ϴ�.");
				//listener.Receive("[SYSTEM] Ŭ���̾�Ʈ(" + socket.getInetAddress().getHostAddress() +")�� �����Ͽ����ϴ�.");
				listener.Receive("[ "+ran+" ]���� �����ϼ̽��ϴ�..");
				
				ServerList.serverList[ran].setServer(ran,socket);
				
				// �߰� �κ� addReceiveListener(this);
				ServerList.serverList[ran].addReceiveListener(listener);
				ServerList.serverList[ran].startServer();
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				break;
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				e.printStackTrace();
			}
			
		}
	}
   
	public void start()
	{
		throw new RuntimeException("Don't call the start()");
	}
	
	public void addReceiveListener(ReceiveListener listener)
	{
		this.listener = listener;
	}
	
	
	
}
