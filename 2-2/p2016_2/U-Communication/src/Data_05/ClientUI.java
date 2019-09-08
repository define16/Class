package Data_05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ClientUI extends JFrame implements ActionListener, ReceiveListener{
	
	private JTextField text1 = null;
	private JList chatlist ,userlist= null;
	private JButton button_send = null, button_run = null;
	private JScrollPane chatlist_scroll, userlist_scroll = null;
	private DefaultListModel model, model2 = null;
	private AcceepServer acceepserver = null;
	private Server server = null;
	private Receiver receiver = null;
	private BufferedReader receive = null;
	private PrintWriter trans = null;
	private BufferedReader in = null;
	private Client client = null;
	private Transmitter transmitter = null;

	public ClientUI()
	{
		super("Client");
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(290,160, 460, 270);
		setResizable(false);
		
		chatlist = new JList(new DefaultListModel());
		model = (DefaultListModel) chatlist.getModel();
		
		chatlist_scroll = new JScrollPane(chatlist);
		chatlist_scroll.setBounds(20, 20, 300, 150);
		

		userlist = new JList(new DefaultListModel());
		model2 = (DefaultListModel) userlist.getModel();
		
		userlist_scroll = new JScrollPane(userlist);
		userlist_scroll.setBounds(328, 20, 100, 190);
		
		text1 = new JTextField();
		text1.setBounds(20, 180, 205, 30);

		button_send = new JButton("ют╥б");
		button_send.setBounds(240,180,80,30);	
		button_send.addActionListener(this);


		add(chatlist_scroll);
		add(text1);
		add(userlist_scroll);
		add(button_send);

		setVisible(true);

		client = new Client();
		client.addReceiveListener(this);
		
		
		client.start();
		

	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		//boolean clear = false;
		if( o == button_send)
		{	
			String str = text1.getText();
			client.sendMessage(str);
	
			 text1.setText("");
			 

		}
	}
	

	@Override
	public void Receive(String msg) {
		// TODO Auto-generated method stub
		boolean a = msg.matches(".*broad/.*");
		if(a){
			for(int i = 1; i<msg.split("/").length;i++)
			{
				//ServerList.serverList[i].sendMessage(users.split("/")[1]);
			//	System.out.println(user.split("/")[i]);
				model2.addElement(msg.split("/")[i]);
			}
		}
		else{
				model.addElement(msg);
				System.out.println(msg);
		}
	}




}
