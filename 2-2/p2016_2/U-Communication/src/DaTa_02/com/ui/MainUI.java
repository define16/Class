package DaTa_02.com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DaTa_02.asdf;
import DaTa_02.com.datatype.Member;
import DaTa_02.com.function.Function;
import DaTa_02.com.function.Resolution;

public class MainUI extends JFrame implements ActionListener{
	private JTextField text_id = null;
	private JPasswordField text_passwd = null;
	private JButton button_login = null, button_register = null, button_print = null;
	
	private Function function = new Function();
	
	public MainUI()
	{
		super("Data_02");
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Resolution.x/2-150, Resolution.y/2-200,290,160);
		setResizable(false);
		
		JLabel label_id = new JLabel("ID : ");
		JLabel label_passwd = new JLabel("PASSWD : ");
		
		label_id.setBounds(20,20,100,20);
		label_passwd.setBounds(20,50,100,20);
		
		text_id = new JTextField();
		text_passwd = new JPasswordField();
		
		text_id.setBounds(150, 20, 100, 20);
		text_passwd.setBounds(150, 50, 100, 20);
		
		button_login = new JButton("Login");
		button_register = new JButton("Register");
		button_print = new  JButton("Print");
		
		button_login.setBounds(20,90,70,20);
		button_register.setBounds(168,90,90,20);
		button_print.setBounds(94,90,70,20);
		
		button_login.addActionListener(this);
		button_register.addActionListener(this);
		button_print.addActionListener(this);
			
		add(label_id);
		add(label_passwd);
		add(text_id);
		add(text_passwd);
		add(button_login);
		add(button_register);
		add(button_print);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		
		if( o == button_login)
		{
			String id = text_id.getText();
			String passwd = text_passwd.getText();
			
			if(function.login(new Member(id,passwd),true))
				JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다.");
			else
				JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다.");
		}
		
		else if(o == button_register)
		{
			 RegisterUI register_ui = new RegisterUI();
			setVisible(false);
		}
		else if(o == button_print)
		{
			MemberListUI memberlistui = new MemberListUI();
			setVisible(false);
		}
	
	}	
}


