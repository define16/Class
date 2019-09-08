package uData_05;

import java.io.IOException;
import java.net.Socket;





public class Server {
	
	private static final int ACCEPT_PORT = 9613;
	private int client_id = -1; // <- get 메소드 생성하기
	private Socket client_socket = null;
	private Receiver receiver = null;
	private Transmitter transmitter = null;
	private AcceptServer as;
	private ReceiveListener listener;
	private String ma;
	public int getID()
	{
		return client_id;
	}
	
	
	public boolean isIdle()
	{
		return (client_socket == null);
	}
	public void setServer() {
		// TODO Auto-generated method stub
		this.client_id = client_id;
		this.client_socket = client_socket;
	}
	public void setServer(int client_id, Socket client_socket)
	{
		this.client_id = client_id;
		this.client_socket = client_socket;
	}
	public void startServer()
	{
		
		if(client_id == -1 || isIdle())
		{
			return;
		}
		
		try
		{
			transmitter = new Transmitter(client_socket.getOutputStream());
			receiver = new Receiver(client_socket.getInputStream(),client_id);
			receiver.addReceiveListener(listener);
			receiver.start();
			
			for(int i=0; i<ServerList.SERVER_MAX;i++)
			{
				
				ma = String.format("user/%s",client_id);
				ServerList.serverList[i].sendMessage(ma);
			}
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addReceiveListener(ReceiveListener listener)
	{
		this.listener = listener;
	}
	
	public void closeServer()
	{
		client_id= -1;
		client_socket = null;
	}
	public void sendMessage(String msg)
	{
		if(transmitter != null)
			transmitter.sendMessage(msg);
	}


	


	
}
