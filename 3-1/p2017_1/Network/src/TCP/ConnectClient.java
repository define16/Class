package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectClient {
	private static final String SERVER_ADDR = "127.0.0.1";
	private static final int SERVER_PORT = 8008;
	
	private BufferedReader in = null;
	private BufferedReader in2 = null;
	private PrintWriter out = null;
	
	public ConnectClient()
	{
	}
	
	public void startClient()
	{
		Socket client = null;
		
		in2 = new BufferedReader(new InputStreamReader(System.in));
	
		try{
			client = new Socket(SERVER_ADDR,SERVER_PORT);
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		}catch (IOException e) {
			// TODO: handle exception
			 System.err.println("[SYSTEM] 서버와 연결에 실패하였습니다.");
			 return;
		}
	
			try{
				String msg = null;
				while(true)
				{
					 msg = in2.readLine();
					
					
					out.println(msg);
					out.flush();
				
					msg = in.readLine();
				
					System.out.println(msg);
				}
			}catch (IOException e) {
				// TODO: handle exception
			}
			try
			{
				 if(in != null)
					 in.close();
				 if(out != null)
					 out.close();
				 if(client != null)
					 client.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
		
	}
}
