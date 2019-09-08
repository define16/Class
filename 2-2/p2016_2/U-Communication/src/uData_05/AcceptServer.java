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
		
		System.out.println("[SYSTEM] 서버가 종료 되었습니다.");
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
				System.out.println("[SYSTEM] 새로운 클라이언트의 접속을 기다립니다...");
				listener.Receive("[SYSTEM] 새로운 클라이언트의 접속을 기다립니다...");
				Socket socket = serverSocket.accept();
				
				System.out.println(socket.getInetAddress().getHostAddress());
				//
				
				do
				{
					ran = (int)(Math.random()*ServerList.SERVER_MAX);
					
					
				}while(!ServerList.serverList[ran].isIdle());
				
				System.out.println("[SYSTEM] 클라이언트(" + socket.getInetAddress().getHostAddress() +")가 접속하엿습니다.");
				//listener.Receive("[SYSTEM] 클라이언트(" + socket.getInetAddress().getHostAddress() +")가 접속하엿습니다.");
				listener.Receive("[ "+ran+" ]님이 접속하셨습니다..");
				
				ServerList.serverList[ran].setServer(ran,socket);
				
				// 추가 부분 addReceiveListener(this);
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
