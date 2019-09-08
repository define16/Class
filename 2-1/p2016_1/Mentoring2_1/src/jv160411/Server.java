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
			//�ش� ��Ʈ�� ���� ���� �Ҵ�
			serverSock = new ServerSocket(PORT);
			System.out.println("[Notice] ������ ���Ƚ��ϴ�. ["+serverSock.getLocalPort()+"]");
			System.out.println("[Notice] Server IP : "
					+ serverSock.getInetAddress().getHostAddress());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("[Notice] �ش� ��Ʈ�� ������Դϴ�.");
			System.err.println(e.getMessage());
			return;
		}


		try {
			System.out.println("Client ������ ��ٸ��� ��...");
			//���� ��Ʈ�� ���� Ŭ���̾�Ʈ�� ���� �Ҵ�
			sock = serverSock.accept();
			System.out.println(sock.getInetAddress().getHostAddress()+"���� Client ����");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("[Notice] ������ ���� ���� �߻�");
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
				System.out.println("[Notice] Client�κ��� �޽��� ���� �����...");		
				System.out.println("[Notice] Client�κ��� �޽����� ���� �Ǿ����ϴ�.");
				System.out.println(data);
				System.out.println("[Notice] ���ŵ� �޽����� ���� �����ϴ�.");
				out.println(data);
				out.flush();
		
			}else
			{
				System.out.println("������ ���� �˴ϴ�.");
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
