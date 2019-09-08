package uData_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;


public class Receiver extends Thread{
	
	
	private boolean threadFlag = true;
	private int client_id = -1;
	private BufferedReader in = null;
	private ReceiveListener listener;
	//private String ma;
	public int getID() {
		// TODO Auto-generated method stub
		return client_id;
	}
	
	
	public Receiver(InputStream is, int client_id)
	{
		in = new BufferedReader(new InputStreamReader(is));
		this.client_id = client_id;
	}
	
	public void addReceiveListener(ReceiveListener listener)
	{
		this.listener = listener;
	}
	
	public void close()
	{
		try{
			if(in != null)
				in.close();
			in = null;
		}catch(IOException e)
		{
			
		}
		threadFlag = false;
		client_id = -1;
	}
	public void run()
	{
		
		while(threadFlag)
		{
			
			try{
				String msg = in.readLine();
				
				if(msg == null)
					break;
				else
				{
					System.out.println("[System] "+ client_id + "님으로 부터 온 메시지입니다."+msg);
					
					listener.Receive("[SYSTEM]"+client_id +"님으로 부터 온 메세지 입니다."+msg);
					for(int i=0 ; i<ServerList.serverList.length; i++)
					{
						ServerList.serverList[i].sendMessage(client_id+" 님의 말 : "+msg);
						
					}
				
				}
			}catch(IOException e)
			{
				break;
			}
		}
		
		System.out.println("[SYSTEM] "+ client_id + "님이 종료 하였습니다.");
		listener.Receive("[SYSTEM]"+client_id+"님이 종료 하셨습니다.");
		ServerList.serverList[client_id].closeServer();
		close();
	}
	

}
