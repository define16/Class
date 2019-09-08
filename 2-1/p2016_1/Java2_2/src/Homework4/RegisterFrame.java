package Homework4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;




class RegisterFrame extends JFrame implements ActionListener{
	private PrintWriter out;

	private final String filename = "회원명단.txt";
	private File file;

	
	JPanel panel_1,panel1_1,panel2_1,panel3_1,panel4_1,panel5_1,panel6_1;
	JLabel Namelabel,IDlabel_1,PWlabel_1,ADRESSlabel,NOTElabel;
	JTextField Nametext,IDtext_1,PWtext_1,ADRESStext;
	JTextArea NOTEtext;
	JButton Savebutton,Cancelbutton;
	
	public RegisterFrame()
	{
		setSize(370,370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("회원가입");
		
		panel_1  = new JPanel();
		panel1_1  = new JPanel();
		panel1_1 .setPreferredSize(new Dimension(350, 30));
		panel1_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_1  = new JPanel();
		panel2_1 .setPreferredSize(new Dimension(350, 30));
		panel2_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3_1  = new JPanel();
		panel3_1 .setPreferredSize(new Dimension(350, 30));
		panel3_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4_1  = new JPanel();
		panel4_1 .setPreferredSize(new Dimension(350, 30));
		panel4_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5_1  = new JPanel();
		panel5_1 .setPreferredSize(new Dimension(350, 100));
		panel5_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6_1  = new JPanel();
		panel6_1 .setPreferredSize(new Dimension(163, 30));
		panel6_1.setLayout(new FlowLayout(FlowLayout.LEFT));

		Namelabel = new JLabel("이름");
		Namelabel.setPreferredSize(new Dimension(90, 23));
		Nametext = new JTextField(15);
		
		IDlabel_1 = new JLabel("아이디");
		IDlabel_1.setPreferredSize(new Dimension(90, 23));
		IDtext_1 = new JTextField(15);
		
		PWlabel_1 = new JLabel("패스워드");
		PWlabel_1.setPreferredSize(new Dimension(90, 23));
		PWtext_1 = new JTextField(15);
		
		ADRESSlabel = new JLabel("주소");
		ADRESSlabel.setPreferredSize(new Dimension(90, 23));
		ADRESStext = new JTextField(15);
		
		NOTElabel = new JLabel("<html>추가사항<br><br><br><br><br>");
		NOTElabel.setPreferredSize(new Dimension(90, 80));
		NOTEtext = new JTextArea(5,15);
		
		Savebutton = new JButton("저장");
		Savebutton.setPreferredSize(new Dimension(75, 23));
		Savebutton.addActionListener(this);
		
		Cancelbutton = new JButton("취소");
		Cancelbutton.setPreferredSize(new Dimension(75, 23));
		Cancelbutton.addActionListener(this);
		
		
		panel1_1.add(Namelabel);
		panel1_1.add(Nametext);
		panel2_1.add(IDlabel_1);
		panel2_1.add(IDtext_1);
		panel3_1.add(PWlabel_1);
		panel3_1.add(PWtext_1);
		panel4_1.add(ADRESSlabel);
		panel4_1.add(ADRESStext);
		panel5_1.add(NOTElabel);
		panel5_1.add(NOTEtext);
		panel6_1.add(Savebutton);
		panel6_1.add(Cancelbutton);
		
		
		panel_1.add(panel1_1);
		panel_1.add(panel2_1);
		panel_1.add(panel3_1);
		panel_1.add(panel4_1);
		panel_1.add(panel5_1);
		panel_1.add(panel6_1);
		
		add(panel_1);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == Savebutton)
		{
			try {
				this.out = new PrintWriter(new FileWriter(filename, true));
				out.println(Nametext.getText()+"/"+IDtext_1.getText()+"/"+PWtext_1.getText()
				+"/"+ADRESStext.getText()+"/"+NOTEtext.getText());
				JOptionPane.showMessageDialog(null, " 회원가입 하신걸 축하드립니다.");
				out.flush();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			LoginFrame lf = new LoginFrame();
			setVisible(false);
		
		}
		
		if(e.getSource() == Cancelbutton)
		{
			LoginFrame lf = new LoginFrame();
			setVisible(false);
		}
		
	}
}
