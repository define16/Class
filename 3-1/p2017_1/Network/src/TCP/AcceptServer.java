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
			 System.out.println("[SYSTEM] ������ ���Ƚ��ϴ�.");
			 System.out.println("[SYSTEM] �������� IP : " + InetAddress.getLocalHost().getHostAddress() + " PORT : " + SERVER_PORT);
			 
		 }catch (IOException e) {
			// TODO: handle exception
			 System.err.println(getTime() + "�ش� ��Ʈ�� ������Դϴ�. ������ ������ ���α׷����� �������ּ���.");
			 return;
		 }
		 
		 try{
			 System.out.println("[SYSTEM] ������ ������ ��ٸ��ϴ�.");
			 serverSocket.setSoTimeout(5*1000);
			 client = serverSocket.accept();
			 in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			 out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
			 
			 System.out.println("[SYSTEM] Ŭ���̾�Ʈ " + client.getInetAddress().getHostAddress() + "�� �����Ͽ����ϴ�.");
			 
		 }catch (SocketTimeoutException e3){
			 System.out.println(getTime() + "������ �ð����� ���ӿ�û�� ��� ������ �ߴ��մϴ�.");
			 System.exit(0);
		 } catch (IOException e) {
			// TODO: handle exception
			 System.err.println(getTime() + "[SYSTEM] �����κ��� ������ �޴� �Ϳ� ���� ������ �߻��Ͽ����ϴ�.");
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
					 System.out.println("[SYSTEM] Ŭ���̾�Ʈ���� ������ ���������ϴ�.");
				 else
				 {
					 
					  	 System.out.println("[SYSTEM] Ŭ���̾�Ʈ���� �޼����� ��ҽ��ϴ�." + input);
					  	 
						 if(input.equals("myip"))
						 {
							 input = InetAddress.getLocalHost().getHostAddress();
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] Ŭ���̾�Ʈ���� �޼����� ���½��ϴ�." + input);
						 }
						 else if(input.equals("time"))
						 {
							 input = d.toString();
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] Ŭ���̾�Ʈ���� �޼����� ���½��ϴ�." + input);
						 }
						 else if(input.equals("quit"))
						 {
							 input = "[SYSTEM] ������ ����Ǿ����ϴ�.";
							 out.println(input);
							 out.flush();
							 break;
						 }
						 else
						 {
							 out.println(input);
							 out.flush();
							 System.out.println("[SYSTEM] Ŭ���̾�Ʈ���� �޼����� ���½��ϴ�." + input);
						 }
				}
			}
			 }catch (IOException e) {
				// TODO: handle exception
				 System.out.println(getTime() + "[SYSTEM] Ŭ���̾�Ʈ���� ������ ���������ϴ�.");
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
			System.out.println(getTime() + "[SYSTEM] ������ ����Ǿ����ϴ�.");
	
		
	
		}
	
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh::mm::ss]");
		return f.format(new Date());
	}
}
