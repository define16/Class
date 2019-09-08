package Data_05;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ServerUI extends JFrame implements ActionListener, ReceiveListener{
	private JTextField text1 = null;
	private JList list = null;
	private JButton button_send = null, button_run = null;
	private JScrollPane list_scroll = null;
	private DefaultListModel model = null;
	private AcceepServer acceepserver = null;
	private Client client = null; 
	private Server server = null;
	private Receiver receiver = null;


	public ServerUI()
	{
		super("Chat");
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(290,160, 400, 300);
		setResizable(false);
		
		list = new JList(new DefaultListModel());
		model = (DefaultListModel) list.getModel();
		
		list_scroll = new JScrollPane(list);
		list_scroll.setBounds(20, 20, 345, 100);
		
		text1 = new JTextField();
		text1.setBounds(20, 140, 250, 40);

		button_send = new JButton("�Է�");
		button_run = new JButton("����");
		
		button_send.setBounds(285,140,80,40);
		button_run.setBounds(285,200,80,40);
		
		button_send.addActionListener(this);
		button_run.addActionListener(this);

		add(list_scroll);
		add(text1);

		add(button_send);
		add(button_run);
		
		setVisible(true);
		
		acceepserver = new AcceepServer();
		acceepserver.addReceiveListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if( o == button_send)
		{	
		}
		else if(o == button_run)
		{
			acceepserver.startServer();
		}
	
	}

	@Override //����Ʈ���� �޼����� �����.
	public void Receive(String msg) {
		model.addElement(msg);
	}



}


