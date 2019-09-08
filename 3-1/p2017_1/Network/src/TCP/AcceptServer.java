package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AcceptServer {
	private static final int SERVER_PORT = 8008;
	
	private BufferedReader in = null;
	private PrintWriter out = null;
	
	public AcceptServer()
	{}
	
	public void startServer()
	{
		 ServerSocket serverSocket = null;
		 Socket client = null;
		 
		 try{
			 serverSocket = new ServerSocket(SERVER_PORT);
			 System.out.println("[SYSTEM] 서버가 열렸습니다.");
			 System.out.println("[SYSTEM] 서버졍뵤 IP : " + InetAddress.getLocalHost().getHostAddress() + " PORT : " + SERVER_PORT);
			 
		 }catch (IOException e) {
			// TODO: handle exception
			 System.err.println(getTime() + "해당 포트가 사용중입니다. 이전에 실행한 프로그램들을 종료해주세요.");
			 return;
		 }
		 
		 try{
			 System.out.println("[SYSTEM] 서버의 접속을 기다립니다.");
			 serverSocket.setSoTimeout(5*1000);
			 client = serverSocket.accept();
			 in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			 
			 System.out.println("[SYSTEM] 클라이언트 " + client.getInetAddress().getHostAddress() + "가 접속하였습니다.");
			 
		 }catch (SocketTimeoutException e3){
			 System.out.println(getTime() + "지정된 시간동안 접속요청이 없어서 서버를 중단합니다.");
			 System.exit(0);
		 } catch (IOException e) {
			// TODO: handle exception
			 System.err.println(getTime() + "[SYSTEM] 서버로부터 접속을 받는 것에 대해 문제가 발생하였습니다.");
			 try{
				 if(in != null)
					 in.close();
				 if(out != null)
					 out.close();
				 if(client != null)
					 client.close();
				 if(serverSocket != null)
					 serverSocket.close();
			 }catch (IOException e2) {
				// TODO: handle exception
			
			 }
			 return;
		 }
		
			 try{
				 String input = null;
				while(true){
				  input = in.readLine();
				  Date d = new Date(); 
			      
				 if(input == null)
					 System.out.println("[SYSTEM] 클라이언트와의 접속이 끊어졌습니다.");
				 else
				 {
					 
					  	 System.out.println("[SYSTEM] 클라이언트와의 메세지를 방았습니다." + input);
					  	 
						 if(input.equals("myip"))
						 {
							 input = InetAddress.getLocalHost().getHostAddress();
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] 클라이언트와의 메세지를 보냈습니다." + input);
						 }
						 else if(input.equals("time"))
						 {
							 input = d.toString();
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] 클라이언트와의 메세지를 보냈습니다." + input);
						 }
						 else if(input.equals("quit"))
						 {
							 input = "[SYSTEM] 서버가 종료되었습니다.";
							 out.println(input);
							 out.flush();
							 break;
						 }
						 else
						 {
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] 클라이언트와의 메세지를 보냈습니다." + input);
						 }
				}
			}
			 }catch (IOException e) {
				// TODO: handle exception
				 System.out.println(getTime() + "[SYSTEM] 클라이언트와의 접속이 끊어졌습니다.");
			}
			 
			try{
				 if(in != null)
					 in.close();
				 if(out != null)
					 out.close();
				 if(client != null)
					 client.close();
				 if(serverSocket != null)
					 serverSocket.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
			System.out.println(getTime() + "[SYSTEM] 서버가 종료되었습니다.");
	
		
	
		}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh::mm::ss]");
		return f.format(new Date());
	}
}
