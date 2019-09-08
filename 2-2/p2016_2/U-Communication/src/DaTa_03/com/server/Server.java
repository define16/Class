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
			System.out.println("[IP : " + InetAddress.getLocalHost().getHostAddress() + ", PORT : " + ACCEPT_PORT + "] 서버시작");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[ERR]포트가 사용중입니다.");
			return;
		}
		
		try {
			System.out.println("접속 대기중...");
			client = server.accept();
			System.out.println("[IP : "+client.getInetAddress().getHostAddress() +"]님이 접속");
			
			 receive = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 trans = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("[ERR]클라이언트 접속 실패");			
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
					System.out.println("없는 명령어입니다.");
			
				System.out.println("To." + client.getInetAddress().getHostAddress() + " : " + line);
				
				
				
				trans.println(line); // 연결
				trans.flush();
				
			
				
				
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("[ERR]클라이언트 끊김");
		}		
		
		try {
			System.out.println("[IP : " + InetAddress.getLocalHost().getHostAddress() + ", PORT : " + ACCEPT_PORT + "]서버종료" );
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
