package chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket server = null;
	
		Socket sock = null;
		
		try {
			server = new ServerSocket(8008);
			System.out.println("������ ��ٸ��ϴ�.");
			HashMap hm = new HashMap();
		
			server.setSoTimeout(60*1000); //60*1000 1��
			
			while(true)
			{	
				
					sock = server.accept();
					server.setSoTimeout(0); // Ŭ���̾�Ʈ�� ���� �����ϸ� 0�� �־ ���Ѵ���Ŵ
					Chatthread thread = new Chatthread(sock,hm);
					thread.start();
					
			
			}
		}catch (SocketTimeoutException e2){	// Ŭ���̾�Ʈ���� ���ӿ�û�� ������ 
			
			 System.out.println(getTime() + "������ �ð����� ���ӿ�û�� ��� ������ �ߴ��մϴ�.");

			 System.exit(0);	
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh::mm::ss]");
		return f.format(new Date());
	}


}


class Chatthread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br = null;
	private HashMap hm;
	private boolean initFlag = false;
	
	
	
	
	public Chatthread(Socket sock, HashMap hm) {
		this.sock = sock;
		this.hm = hm;
		
		try {
		
	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = br.readLine();
			

			
			broadcast(id + "���� �����߽��ϴ�.");
			System.out.println("������ ������� ���̵�� " + id + " �Դϴ�.");
			
			synchronized(hm) {
				hm.put(this.id, pw);
				System.out.println("���� ���������� ���� " + hm.size() + " �Դϴ�.");
			}
			
			initFlag = true;

		}catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex);
		}
	}


	public void sendmsg(String msg){
		int start = msg.indexOf(" ") +1;
		int end = msg.indexOf(" ", start);
		
		if(end != -1){
			String to = msg.substring(start, end);
			String msg2 = msg.substring(end +1);
			Object obj = hm.get(to);
			if(obj != null){
				PrintWriter pw = (PrintWriter)obj;
				pw.println(id + "���� ������ �ӼӸ��� �����̽��ϴ�. :" + msg2);
				pw.flush();
			}
		}
	}
	public void run() {
		try{
			String line = null;
			
			while((line = br.readLine())!=null){
				if(line.equals("/quit"))
					break;
				if(line.indexOf("/to") == 0)
					sendmsg(line);
				else{
					broadcast(id + " : " + line);
				}
			}

		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally{
			synchronized(hm){
				hm.remove(id);
				System.out.println("���� ���������� ���� " + hm.size() + "�Դϴ�.");
			}
			broadcast(id + " ���� ���� �����߽��ϴ�.");
			
			try{
				if(sock != null)
					sock.close();
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
	}
	
	public void broadcast(String msg){
		synchronized(hm){
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}
	



}
