package jv160411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private int PORT = 6006;
	private Socket sock;
	private ServerSocket serverSock;
	private BufferedReader in = null;
	private PrintWriter out = null;

	public void runServer()
	{
		try {
			//해당 포트로 서버 소켓 할당
			serverSock = new ServerSocket(PORT);
			System.out.println("[Notice] 서버가 열렸습니다. ["+serverSock.getLocalPort()+"]");
			System.out.println("[Notice] Server IP : "
					+ serverSock.getInetAddress().getHostAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("[Notice] 해당 포트가 사용중입니다.");
			System.err.println(e.getMessage());
			return;
		}


		try {
			System.out.println("Client 접속을 기다리는 중...");
			//서버 포트로 들어온 클라이언트에 소켓 할당
			sock = serverSock.accept();
			System.out.println(sock.getInetAddress().getHostAddress()+"에서 Client 접속");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("[Notice] 서버로 부터 문제 발생");
			System.err.println(e.getMessage());	
			try {
				if(sock!=null)
					sock.close();
				if(in !=null)
					in.close();
				if(out != null)
					out.close();
				if(serverSock != null)
					serverSock.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return;
		}


		try {
			while(true){
			String data = in.readLine();
			if(data !=null){
				System.out.println("[Notice] Client로부터 메시지 수신 대기중...");		
				System.out.println("[Notice] Client로부터 메시지가 수신 되었습니다.");
				System.out.println(data);
				System.out.println("[Notice] 수신된 메시지를 돌려 보냅니다.");
				out.println(data);
				out.flush();
		
			}else
			{
				System.out.println("접속이 종료 됩니다.");
			}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				if(sock!=null)
					sock.close();
				if(in !=null)
					in.close();
				if(out != null)
					out.close();
				if(serverSock != null)
					serverSock.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.err.println(e.getMessage());
			return;		
		}finally
		{
			try {
				in.close();
				out.close();
				sock.close();
				serverSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
