package jv160411;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	private String serverIP = "127.0.0.1";
	private int serverPort = 6006;
	
	private Socket sock = null;
	
	private BufferedReader input = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	
	public void runClient()
	{
		input = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.println("[Notice] 서버에 접속 요청을 보냅니다.");
			sock = new Socket(serverIP,serverPort);
			System.out.println("[Notice] 서버에 접속 성공!");
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream());
		}
		catch(IOException e)
		{
			System.err.println("서버에 접속하는데 오류가 생겼습니다.");
			System.err.println(e.getMessage());
			return;
		}
		
		try {
			while(true){
			System.out.print("서버로 보낼 메시지를 입력하세요 >> ");
			String data = input.readLine();
			if(data != null)
			{
				out.println(data);
				out.flush();
				System.out.println("메시지 전송 성공!");
			}
			String indata = in.readLine();
			System.out.println("서버로부터 데이터를 수신하였습니다.");
			System.out.println(indata);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
			if(sock != null)
				
					sock.close();
				
			if(in != null)
				in.close();
			if(out != null)
				out.close();
			if(input != null)
				input.close();
			
				}
			catch (IOException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
	}
	
}
