package uData_05;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ClientUi extends JFrame implements ActionListener, ReceiveListener{
	
	private JTextField text1 = null;
	private JList cl ;
	private JList ul;
	private JButton transport = null;
	private JScrollPane chat_list;
	private JScrollPane user_list ;
	private DefaultListModel md;
	private DefaultListModel md2 ;
	private Client client = null;
	private AcceptServer scv = null;
	private Receiver rci;
	private ReceiveListener listener;
	private Server rv = null;
	private Socket client_socket = null;
	private JLabel U_i = null;
	private JLabel c_i = null;
	private BufferedReader in = null;
	private Socket cs = null;
	public ClientUi()
	{
		super("20125331_cl");
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(290,160, 370, 270);
		//setResizable(false);
		
		U_i = new JLabel("<채팅 내용>");
		U_i.setBounds(10,10, 100 ,20);
		
		cl = new JList(new DefaultListModel());
		md = (DefaultListModel) cl.getModel();
		
		
		
		chat_list = new JScrollPane(cl);
		chat_list.setBounds(20, 30, 200, 150);
		
		c_i = new JLabel("<User_List>");
		c_i.setBounds(230, 10,100, 10);
		
		ul = new JList(new DefaultListModel());
		md2 = (DefaultListModel) ul.getModel();
		
		user_list = new JScrollPane(ul);
		user_list.setBounds(230, 30, 100, 150);
		
		text1 = new JTextField();
		text1.setBounds(20, 190, 180, 40);

		transport = new JButton("입력");
		transport.setBounds(220 ,190,100,20);	
		transport.addActionListener(this);

		add(U_i);
		add(c_i);
		add(chat_list);
		add(text1);
		add(user_list);
		add(transport);
		
		
		
		setVisible(true);
		
		client = new Client();
		client.addReceiveListener(this);
		client.run();
		
		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		//boolean clear = false;
		if( o == transport)
		{	
			String str = text1.getText();
			client.sendMessage(str);
			
			boolean f = str.matches(".*broad/.*");
			
			if(f)
			{
				for(int i = 1; i<ServerList.SERVER_MAX;i++)
				{
					ServerList.serverList[i].sendMessage(str.split("/")[1]);
					break;
				}
			}
			 text1.setText("");
		}
		
	
	}
	

	@Override
	public void Receive(String msg) {
		// TODO Auto-generated method stub
		
		boolean a = msg.matches(".*user/.*");
		if(a == true)
		{
			//md2.removeAllElements();
			for(int i=1; i<msg.split("/").length;i++)
			
				md2.addElement(msg.split("/")[i]);
			
		}
		else
			md.addElement(msg);
		
		
	}
	



}
