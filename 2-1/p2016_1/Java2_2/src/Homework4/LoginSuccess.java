package Homework4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginSuccess extends JFrame implements ActionListener{
	
	private BufferedReader in;
	private final String filename = "회원명단.txt";


	
	JPanel panel_2,panel1_2,panel2_2,panel3_2,panel4_2,panel5_2,panel6_2;
	JLabel Namelabel2,IDlabel_2,PWlabel_2,ADRESSlabel2,NOTElabel2;
	JTextField Nametext2,IDtext_2,PWtext_2,ADRESStext2;
	JTextArea NOTEtext2;
	JButton Revisebutton,loginbutton2;
	
	
	
	
	public LoginSuccess()
	{
		setSize(370,370);
		setTitle("정보확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel_2  = new JPanel();
		panel1_2  = new JPanel();
		panel1_2 .setPreferredSize(new Dimension(350, 30));
		panel1_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_2  = new JPanel();
		panel2_2 .setPreferredSize(new Dimension(350, 30));
		panel2_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3_2  = new JPanel();
		panel3_2 .setPreferredSize(new Dimension(350, 30));
		panel3_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4_2  = new JPanel();
		panel4_2 .setPreferredSize(new Dimension(350, 30));
		panel4_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5_2  = new JPanel();
		panel5_2 .setPreferredSize(new Dimension(350, 100));
		panel5_2.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6_2  = new JPanel();
		panel6_2 .setPreferredSize(new Dimension(163, 30));
		panel6_2.setLayout(new FlowLayout(FlowLayout.LEFT));

		Namelabel2 = new JLabel("이름");
		Namelabel2.setPreferredSize(new Dimension(90, 23));
		Nametext2 = new JTextField(15);
		Nametext2.setEnabled(false);
		
		IDlabel_2 = new JLabel("아이디");
		IDlabel_2.setPreferredSize(new Dimension(90, 23));
		IDtext_2 = new JTextField(15);
		IDtext_2.setEnabled(false);
		
		PWlabel_2 = new JLabel("패스워드");
		PWlabel_2.setPreferredSize(new Dimension(90, 23));
		PWtext_2 = new JTextField(15);
		PWtext_2.setEnabled(false);
		
		ADRESSlabel2 = new JLabel("주소");
		ADRESSlabel2.setPreferredSize(new Dimension(90, 23));
		ADRESStext2 = new JTextField(15);
		ADRESStext2.setEnabled(false);
		
		NOTElabel2 = new JLabel("<html>추가사항<br><br><br><br><br>");
		NOTElabel2.setPreferredSize(new Dimension(90, 80));
		NOTEtext2 = new JTextArea(5,15);
		NOTEtext2.setEnabled(false);
		
		loginbutton2 = new JButton("확인");
		loginbutton2.setPreferredSize(new Dimension(75, 23));
		loginbutton2.addActionListener(this);
		
		Revisebutton = new JButton("수정");
		Revisebutton.setPreferredSize(new Dimension(75, 23));
		Revisebutton.addActionListener(this);
	
		
		
		panel1_2.add(Namelabel2);
		panel1_2.add(Nametext2);
		panel2_2.add(IDlabel_2);
		panel2_2.add(IDtext_2);
		panel3_2.add(PWlabel_2);
		panel3_2.add(PWtext_2);
		panel4_2.add(ADRESSlabel2);
		panel4_2.add(ADRESStext2);
		panel5_2.add(NOTElabel2);
		panel5_2.add(NOTEtext2);
		panel6_2.add(loginbutton2);
		panel6_2.add(Revisebutton);
		
		
		panel_2.add(panel1_2);
		panel_2.add(panel2_2);
		panel_2.add(panel3_2);
		panel_2.add(panel4_2);
		panel_2.add(panel5_2);
		panel_2.add(panel6_2);
		
		add(panel_2);
		setVisible(true);
	}
	
	public void init() {
		String data = "";
	
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((data = in.readLine()) != null) {
				String search[] = data.split("/");
				if(search[1].equals(LoginFrame.IDtext.getText()) && search[2].equals(LoginFrame.PWtext.getText())) { //여기가 잘못
					Nametext2.setText(search[0]);
					IDtext_2.setText(search[1]);
					PWtext_2.setText(search[2]);
					ADRESStext2.setText(search[3]);
					NOTEtext2.setText(search[4]);
				}
			}
			in.close();	
		}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == loginbutton2)
		{
			FaceFrame ff = new FaceFrame();
			setVisible(false);
		}
		
		if(e.getSource() == Revisebutton)
		{
			ReviseFrame rf = new ReviseFrame();
			rf.init();
			setVisible(false);
		}
		
		
	}

}
