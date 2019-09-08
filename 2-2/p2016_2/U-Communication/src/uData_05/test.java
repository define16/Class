package uData_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test 
{
	public static void main(String[] args)
	{
		BufferedReader in = null;
		Date date = new Date();
		SimpleDateFormat dform = null;
		
		try {
			dform = new SimpleDateFormat("hh:mm:ss");
			in = new BufferedReader(new InputStreamReader(System.in));
			String command =null;
			while( (command=in.readLine()) != null){
				if(command.equals("ip"))
					System.out.println(InetAddress.getLocalHost().getHostAddress());
				else if(command.equals("info"))
					System.out.println("user:"+System.getProperty("user.name") +
							  ", version:" + System.getProperty("java.version"));
				else if(command.equals("time"))
					System.out.println(dform.format(date));
				else
					System.out.println("없는 명령어입니다.");	
			}
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
}
