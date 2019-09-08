package DaTa_03.com.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
//127.0.0.1 ,자기 ip주소를 받아오는 것
	
 private static final int Accept_port = 6637;
 private static final String Accept_ip = "192.168.0.4";
 
 private BufferedReader receive = null;
 private PrintWriter trans = null;
 private BufferedReader in = null;

	

 public void startClient()
 {
  Socket socket = null;
  
  try{
  
   System.out.println("[IP : " + Accept_ip + ",PORT : "+Accept_port + "]로 점속중...");
   socket = new Socket(Accept_ip, Accept_port);
   System.out.println("서버에 접속 하셨습니다.");
   receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   trans = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
  }catch(IOException e)
  {
   System.err.println("[ERR] 서버 접속 실패");
   return;
  }

  try{
	  while(true){			
	   System.out.print("To." + Accept_ip+" :	");
	   in = new BufferedReader(new InputStreamReader(System.in));
	   String line = in.readLine();
	 
	   trans.println(line);
	   trans.flush();
	  
	   line = receive.readLine();
	   
	
	   
	   System.out.println("From."+Accept_ip+" : "+line);
	   
	   
	  }
  }catch(IOException e)
  {
	  System.err.println("[ERR] 서버 끊김");
  }

  try{
   if(receive !=null)
    receive.close();
   if(trans !=null)
    trans.close();
   if(socket !=null)
    socket.close();
  }catch(IOException e)
  {
   
  }
 }
} 

