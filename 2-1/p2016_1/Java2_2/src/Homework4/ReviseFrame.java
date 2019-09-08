package Homework4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
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

import ef.Report;

public class ReviseFrame extends JFrame implements ActionListener{
	private PrintWriter out;
	private BufferedReader in;
	private final String filename = "회원명단.txt";
	private final String filename2 = "임시파일.txt";

	
	JPanel panel_3,panel1_3,panel2_3,panel3_3,panel4_3,panel5_3,panel6_3;
	JLabel Namelabel3,IDlabel_3,PWlabel_3,ADRESSlabel3,NOTElabel3;
	JTextField Nametext3,IDtext_3,PWtext_3,ADRESStext3;
	JTextArea NOTEtext3;
	JButton Revisebutton2,Cancelbutton2;
	
	
	public ReviseFrame()
	{
		setSize(370,370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("정보수정");
		
		panel_3  = new JPanel();
		panel1_3  = new JPanel();
		panel1_3 .setPreferredSize(new Dimension(350, 30));
		panel1_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel2_3  = new JPanel();
		panel2_3 .setPreferredSize(new Dimension(350, 30));
		panel2_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel3_3  = new JPanel();
		panel3_3 .setPreferredSize(new Dimension(350, 30));
		panel3_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel4_3  = new JPanel();
		panel4_3 .setPreferredSize(new Dimension(350, 30));
		panel4_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel5_3  = new JPanel();
		panel5_3 .setPreferredSize(new Dimension(350, 100));
		panel5_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel6_3  = new JPanel();
		panel6_3 .setPreferredSize(new Dimension(163, 30));
		panel6_3.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Namelabel3 = new JLabel("이름");
		Namelabel3.setPreferredSize(new Dimension(90, 23));
		Nametext3 = new JTextField(15);
		Nametext3.setEnabled(false);
		
		IDlabel_3 = new JLabel("아이디");
		IDlabel_3.setPreferredSize(new Dimension(90, 23));
		IDtext_3 = new JTextField(15);
		IDtext_3.setEnabled(false);
		
		PWlabel_3 = new JLabel("패스워드");
		PWlabel_3.setPreferredSize(new Dimension(90, 23));
		PWtext_3 = new JTextField(15);
		PWtext_3.setEnabled(false);
		
		ADRESSlabel3 = new JLabel("주소");
		ADRESSlabel3.setPreferredSize(new Dimension(90, 23));
		ADRESStext3 = new JTextField(15);
		ADRESStext3.setEnabled(true);
		
		NOTElabel3 = new JLabel("<html>추가사항<br><br><br><br><br>");
		NOTElabel3.setPreferredSize(new Dimension(90, 80));
		NOTEtext3 = new JTextArea(5,15);
		NOTEtext3.setEnabled(true);
	
		Cancelbutton2 = new JButton("취소");
		Cancelbutton2.setPreferredSize(new Dimension(75, 23));
		Cancelbutton2.addActionListener(this);
		

		Revisebutton2 = new JButton("수정");
		Revisebutton2.setPreferredSize(new Dimension(75, 23));
		Revisebutton2.addActionListener(this);
		
		
		panel1_3.add(Namelabel3);
		panel1_3.add(Nametext3);
		panel2_3.add(IDlabel_3);
		panel2_3.add(IDtext_3);
		panel3_3.add(PWlabel_3);
		panel3_3.add(PWtext_3);
		panel4_3.add(ADRESSlabel3);
		panel4_3.add(ADRESStext3);
		panel5_3.add(NOTElabel3);
		panel5_3.add(NOTEtext3);
		panel6_3.add(Revisebutton2);
		panel6_3.add(Cancelbutton2);
	
	
		panel_3.add(panel1_3);
		panel_3.add(panel2_3);
		panel_3.add(panel3_3);
		panel_3.add(panel4_3);
		panel_3.add(panel5_3);
		panel_3.add(panel6_3);
		
		add(panel_3);
		setVisible(true);
	}

	public void init() {
		String data = "";
	
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((data = in.readLine()) != null) {
				String search[] = data.split("/");
				if(search[1].equals(LoginFrame.IDtext.getText()) && search[2].equals(LoginFrame.PWtext.getText())) { //여기가 잘못
					Nametext3.setText(search[0]);
					IDtext_3.setText(search[1]);
					PWtext_3.setText(search[2]);
					ADRESStext3.setText(search[3]);
					NOTEtext3.setText(search[4]);
				}
			}
			in.close();	
		}catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	public void fileCopy(String infilename, String outfilename) {
		try {
			int data = 0;
			FileInputStream fis = new FileInputStream(infilename);
			FileOutputStream fos = new FileOutputStream(outfilename);
			while ((data = fis.read()) != -1) {
				fos.write(data);
			}
			fis.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == Revisebutton2)
		{
			String data = "";
			fileDelete(filename2);
			try {
				out = new PrintWriter(new FileWriter(filename2, true));
				in = new BufferedReader(new FileReader(filename));
				while ((data = in.readLine()) != null) {
					String search[] = data.split("/");
					if(search[1].equals(LoginFrame.IDtext.getText()) && search[2].equals(LoginFrame.PWtext.getText())) {
						out.println(Nametext3.getText() + "/" + IDtext_3.getText() + "/" + PWtext_3.getText() + "/" + ADRESStext3.getText() + "/"
										+ NOTEtext3.getText());
						out.flush();
					}
					else if(search[1]!= LoginFrame.IDtext.getText() || search[2] != LoginFrame.PWtext.getText()){
						out.println(search[0] + "/" + search[1] + "/" + search[2] + "/" + search[3] + "/"
								+ search[4]);
						out.flush();
						
					}
				}
				out.close();
				fileDelete(filename);
				fileCopy(filename2, filename);
				fileDelete(filename2);

			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
			setVisible(false);
			JOptionPane.showMessageDialog(null, "다시 로그인해주세요.");
			LoginFrame lf = new LoginFrame();

			
		
		}
		
		if(e.getSource() == Cancelbutton2)
		{
			LoginSuccess ls = new LoginSuccess();
			setVisible(false);
		}
		
	}
	
	public static void fileDelete(String deleteFileName) {
		File f = new File(deleteFileName);
		f.delete();
	}

}
