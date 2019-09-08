package DaTa_03.com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {
	private static final int ACCEPT_PORT = 6637;
	
	private BufferedReader receive = null;
	private PrintWriter trans = null;
	
	private Date date = new Date();
	private SimpleDateFormat dform = null;

	public Server(){
	
	}
	
	public void startServer()
	{
		ServerSocket server = null;
		Socket client = null;
		
		try {
			server = new ServerSocket(ACCEPT_PORT);
			System.out.println("[IP : " + InetAddress.getLocalHost().getHostAddress() + ", PORT : " + ACCEPT_PORT + "] ��������");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[ERR]��Ʈ�� ������Դϴ�.");
			return;
		}
		
		try {
			System.out.println("���� �����...");
			client = server.accept();
			System.out.println("[IP : "+client.getInetAddress().getHostAddress() +"]���� ����");
			
			 receive = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 trans = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[ERR]Ŭ���̾�Ʈ ���� ����");			
		}
		
		try {
			while(true){
				

				String line = receive.readLine();
				
				dform = new SimpleDateFormat("hh:mm:ss");
				System.out.println("From." + client.getInetAddress().getHostAddress() + " : " + line);
				
				if(line.equals("ip"))
					line = InetAddress.getLocalHost().getHostAddress();
				else if(line.equals("info"))
					line = "user : " + System.getProperty("user.name") + ", version :	" + System.getProperty("java.version");
				else if(line.equals("time"))
					line =  dform.format(date);
				else
					System.out.println("���� ��ɾ��Դϴ�.");
			
				System.out.println("To." + client.getInetAddress().getHostAddress() + " : " + line);
				
				
				
				trans.println(line); // ����
				trans.flush();
				
			
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERR]Ŭ���̾�Ʈ ����");
		}		
		
		try {
			System.out.println("[IP : " + InetAddress.getLocalHost().getHostAddress() + ", PORT : " + ACCEPT_PORT + "]��������" );
			if(receive != null)
				receive.close();
			if(trans != null)
				trans.close();
			if(client != null)
				client.close();
			if(server != null)
				server.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		}
	
}
