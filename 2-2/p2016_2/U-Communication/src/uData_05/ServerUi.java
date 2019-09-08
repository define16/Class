package uData_05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class ServerUi extends JFrame implements ActionListener, ReceiveListener {
	
	
	private JTextField text_input= null;
	private Receiver rv =null;
	private AcceptServer sv = null;
	 private JButton button_login = null;
	 private JButton button_register = null;
	 private AcceptServer sc = null;
	private JList jl=null ;
	
	private DefaultListModel md = null;
	private JScrollPane jsp = null , jsp2 = null;
	
	 public ServerUi(){
		 super("20125331_sv");
		 setLayout(null);
		 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		 setResizable(false);
		 setBounds(100,150,300,250);
		
		 
		 text_input = new JTextField();
		 text_input.setBounds(10,130,170,30);
		

		
		 button_login = new JButton("입력");
		 button_register = new JButton("실행");
		
		 
		 button_login.setBounds(180, 130, 100, 30);
		 button_register.setBounds(180, 180, 100, 30);
		 
		 button_login.addActionListener(this);
		 button_register.addActionListener(this);
		
		 
		 jl = new JList(new DefaultListModel());
		 md = (DefaultListModel)jl.getModel();
		 jsp = new JScrollPane(jl);
		 jsp.setBounds(10,10,280,100);
		 
		
		 
		 add(jsp);
		
		
		 add(text_input);
		
		 add(button_login);
		 add(button_register);
		 
		
		 setVisible(true);
		 
		 sv = new AcceptServer();
		 sv.addReceiveListener(this);
		 
	 }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
		 Object o = e.getSource();
		 if(o == button_login)
		 {
			 String str = text_input.getText();
			boolean a = str.matches(".*broad/.*");
			if(a)
			{
				for(int i=1; i<ServerList.SERVER_MAX;i++)
				{
					ServerList.serverList[i].sendMessage(str.split("/")[1]);
					
				}
					
			}
			text_input.setText(" ");
		 }
		 if(o == button_register)
		 {
			 
			 sv.startServer();
			
		 }
	}
	public void Receive(String msg)
	{
		md.addElement(msg);
		
	}

}
