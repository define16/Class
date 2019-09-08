package DaTa_02.com.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DaTa_02.com.datatype.Member;
import DaTa_02.com.function.Function;
import DaTa_02.com.function.Resolution;

public class RegisterUI extends JFrame implements ActionListener {
	
	private JTextField text_name = null, text_id = null;
	private JPasswordField text_passwd = null,text_passwd_2 = null;
	private JButton button_submit = null, button_cancel = null, button_confirm = null;
	
	private Function function = new Function();
	
	public RegisterUI()
	{
		super("Register");
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Resolution.x/2-150, Resolution.y/2-200,380,220);
		setResizable(false);
		
		JLabel label_name = new JLabel("이름 : ");
		JLabel label_id = new JLabel("ID : ");
		JLabel label_passwd = new JLabel("PASSWD : ");
		JLabel label_passwd_2 = new JLabel("Confirm PASSWD : ");
		
		label_name.setBounds(20,20,100,20);
		label_id.setBounds(20,50,100,20);
		label_passwd.setBounds(20,80,100,20);
		label_passwd_2.setBounds(20,110,120,20);

		text_name = new JTextField();
		text_id = new JTextField();
		text_passwd = new JPasswordField();
		text_passwd_2 = new JPasswordField();
		
		text_name.setBounds(150, 20, 100, 20);
		text_id.setBounds(150, 50, 100, 20);
		text_passwd.setBounds(150, 80, 100, 20);
		text_passwd_2.setBounds(150, 110, 100, 20);
		
		 button_confirm = new JButton("Confirml");
		 button_submit = new JButton("Submit");
		 button_cancel = new JButton("Cancel");
		
		button_confirm.setBounds(255,50,90,20);
		button_submit.setBounds(20,140,90,20);
		button_cancel.setBounds(160,140,90,20);

		button_confirm.addActionListener(this);
		button_submit.addActionListener(this);
		button_cancel.addActionListener(this);
		 
		add(label_id);
		add(label_name);
		add(label_passwd);
		add(label_passwd_2);
		add(text_id);
		add(text_name);
		add(text_passwd);
		add(text_passwd_2);
		add(button_confirm);
		add(button_submit);
		add(button_cancel);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
			
		if( o == button_confirm)
		{
			String id = text_id.getText();
			String passwd = text_passwd.getText();
			String passwd2 = text_passwd_2.getText();
			
			if(id.equals("") || passwd.equals("") || passwd2.equals(""))
				JOptionPane.showMessageDialog(null, "정보를 입력해주세요.");
			else if(function.Confirm(id,passwd,passwd2) == 2)
			{
				JOptionPane.showMessageDialog(null, "비밀번호가 서로 다릅니다.");
				text_passwd.setText(""); text_passwd_2.setText("");
			}
			else if(function.Confirm(id,passwd,passwd2) == 1){
				JOptionPane.showMessageDialog(null, "중복된 아이디가 있습니다.");
				text_id.setText("");
			}
			else
				JOptionPane.showMessageDialog(null, "계속 진행하고 싶으시면 Submit를 눌러주세요.");
		}
		else if(o == button_submit)
		{
			String name = text_name.getText();
			String id = text_id.getText();
			String passwd = text_passwd.getText();
			
			if(function.register(new Member(id,passwd,name)))
			{
				JOptionPane.showMessageDialog(null, "회원가입에 성공하였습니다.");
				setVisible(false);
			}
			else
				JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다.");
	
		}
		else if(o == button_cancel)
			setVisible(false);
		
	}


	

}
