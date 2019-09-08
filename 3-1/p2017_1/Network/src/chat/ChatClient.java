package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{

	private JButton sendbt = null;
	private JLabel sendlb = null;
	private JTextField txt = null;

	private JList list= null;
	private JScrollPane list_scroll= null;
	private DefaultListModel model= null;
	Socket sock = null;
	BufferedReader br = null;
	PrintWriter pw = null;

	
	public ChatClient(){}
	
	public ChatClient(String args) {
		super("ClientUI");
	
		try{
			
			setLayout(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			//setResizable(false);
			setBounds(100,100,465,500);
			
			sendlb = new JLabel("Send :");
			sendlb.setBounds(10,20,60,30);
			
			txt = new JTextField();
			txt.setBounds(70,20,200,30);
			
			
			sendbt = new JButton("전송");
			sendbt.setBounds(275,20,60,30);
			sendbt.addActionListener(this);
			
			list = new JList(new DefaultListModel());
			model = (DefaultListModel) list.getModel();
			
			list_scroll = new JScrollPane(list);
			list_scroll.setBounds(10, 60, 430, 390);
			
			add(sendlb);
			add(txt);
			add(sendbt);
			add(list_scroll);
			
			
			setVisible(true);
			
		
			
			sock = new Socket("127.0.0.1", 8008);
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			InputThread it = new InputThread(sock, br);
			
			pw.println(args);
			pw.flush();
			model.addElement("접속완료 ID : " + args);
			
			
			it.start();
		

	
		}catch (Exception ex) {
			// TODO: handle exception		

		}
		
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if(o == sendbt)
		{
				String msg = txt.getText();

				pw.println(msg);
				pw.flush();

				txt.setText("");
				if(msg.equals("/quit")){
					pw.close();
					System.exit(0);
				}
			}
		
		
		}
	

	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh::mm::ss]");
		return f.format(new Date());
	}

	public static void main(String[] args) {
		// TODO Auto-generatedmethod stub
		ChatClient client = new ChatClient(args[0]);
		
	}

	
	class InputThread extends Thread {
		private Socket sock = null;
		private BufferedReader br = null;
		long startTime = 0, endTime = 0;


		
		public InputThread(Socket sock, BufferedReader br){
			this.sock = sock;
			this.br = br;
		
		}
		
		public void run(){
			try{
			    String line = null;
			    sock.setSoTimeout(10*60*1000); //60*1000 1분
				while ((line = br.readLine()) != null) {
					model.addElement(line);

				}
				
			}catch (SocketTimeoutException e2){	// 클라이언트를 종료
				System.out.println("지정된 시간안에 메세지를 보내지 않아서 종료됩니다.");
				System.exit(0);
			}catch (Exception e) {
				// TODO: handle exception
	
		}
				finally{
				try{
					if(sock != null){
						sock.close();
					}
				}catch (Exception ex) {
					// TODO: handle exception
				}
			}
		}
	}
}
