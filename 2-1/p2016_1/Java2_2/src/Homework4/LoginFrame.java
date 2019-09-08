package Homework4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;



class LoginFrame extends JFrame implements ActionListener 
{
	private BufferedReader in;
	private final String filename = "회원명단.txt";
	public static String search[];
	
	JPanel panel,panel1, panel2, panel3;
	JLabel piclabel,IDlabel,PWlabel,Textlabel;
	JButton loginbutton,registerbutton;
	static JTextField IDtext,PWtext;
	
	
	public LoginFrame()
	{
		
		setSize(420,320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("로그인 화면");
		
		
		panel  = new JPanel();
		panel1  = new JPanel();
		panel1.setPreferredSize(new Dimension(390,163));
		//panel1.setPreferredSize(new Dimension(600, 225));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(390, 30));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(390, 30));
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		piclabel = new JLabel();
		ImageIcon pic = new ImageIcon("pic.jpg");
		piclabel.setIcon(pic);
		
		
		Textlabel = new JLabel();
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setPreferredSize(new Dimension(193, 153));
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>안녕하세요. <br>"
				+ "본 프로그램은 ID를 입력하셔야만 사용이 가능합니다.<br>"
				+ "ID입력후 로그인 버튼을 클릭하세요.<br><br><br><br>");
		 
		IDlabel = new JLabel("아이디 : ");
		IDlabel.setPreferredSize(new Dimension(90, 23));
		IDtext = new JTextField(15);
		
		PWlabel = new JLabel("패스워드 : ");
		PWlabel.setPreferredSize(new Dimension(90, 23));
		PWtext = new JTextField(15);
		
		loginbutton = new JButton("로그인");
		loginbutton.setPreferredSize(new Dimension(90, 23));
		loginbutton.addActionListener(this);
		
		registerbutton = new JButton("회원가입");
		registerbutton.setPreferredSize(new Dimension(90, 23));
		registerbutton.addActionListener(this);
		
		panel1.add(piclabel);
		panel1.add(Textlabel);
		panel2.add(IDlabel);
		panel2.add(IDtext);
		panel2.add(loginbutton);
		panel3.add(PWlabel);
		panel3.add(PWtext);
		panel3.add(registerbutton);
		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		add(panel);
		setVisible(true);
		
		
	}

	
	@Override //버튼 눌렀을때 작용
	public void actionPerformed(ActionEvent e) 
	{
	
		if(e.getSource() == loginbutton)
		{
			String data = "";
			
			boolean flag = true;
			try {
				in = new BufferedReader(new FileReader(filename));
				while((data=in.readLine())!=null)
				{
					String search[] = data.split("/"); 
					if(search[1].equals(IDtext.getText()) && search[2].equals(PWtext.getText()))
						{
							JOptionPane.showMessageDialog(null, "로그인 성공.");
							LoginSuccess ls = new LoginSuccess();
							ls.init();
							flag = false;
							setVisible(false);
							break;
					}
				}
				in.close();	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		
			if(flag)
			{
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 들렸습니다.");
			IDtext.setText("");
			PWtext.setText("");
			}
			
			
		}
		
		if(e.getSource() == registerbutton)
		{
			RegisterFrame rf = new RegisterFrame();
			setVisible(false);
		}
		
	}
}

