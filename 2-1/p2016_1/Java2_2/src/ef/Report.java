package ef;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class Report extends JFrame implements ActionListener {

	private JButton bu = new JButton("회원가입");
	private JButton login = new JButton("로그인");
	static JTextField tf = new JTextField();
	static JTextField tf1 = new JTextField();
	private BufferedReader in;
	private final String filename = "회원명단.txt";
	

	public Report() {
		setTitle("로그인 화면");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel l1 = new JLabel("아이디 :", JLabel.CENTER);
		JLabel l2 = new JLabel("패스워드 :", JLabel.CENTER);
		JLabel icon = new JLabel(new ImageIcon("C:\\Users\\JangDH\\Desktop\\gun.jpg"));
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JLabel ta = new JLabel("안녕하세요.");
		JLabel ta1 = new JLabel("본 프로그램은 ID를 입력하셔야만");
		JLabel ta2 = new JLabel("사용이 가능합니다.");
		JLabel ta3 = new JLabel(" ");
		JLabel ta4 = new JLabel("ID입력 후 로그인 버튼을 클릭하세요.");
		bu.addActionListener(this);

		p.setLayout(new GridLayout(2, 3));
		p.add(l1);
		p.add(tf);
		p.add(login);
		login.addActionListener(this);
		p.add(l2);
		p.add(tf1);
		p.add(bu);

		p1.add(icon);

		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.add(ta);
		p2.add(ta1);
		p2.add(ta2);
		p2.add(ta3);
		p2.add(ta4);

		add("South", p);
		add("West", p1);
		add("East", p2);

		pack();
		setVisible(true);
	}

	public void visible(boolean flag) {
		setVisible(flag);
	}
	
	public void init()
	{
		tf.setText("");
		tf1.setText("");
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == login) {
			String data = "";
			boolean flag = true;
			try {
				in = new BufferedReader(new FileReader(filename));
				while ((data = in.readLine()) != null) {
					String search[] = data.split("/");
					if (search[1].equals(tf.getText()) && search[2].equals(tf1.getText())) {
						visible(false);
						ReportM rm = new ReportM();
						rm.init();
						break;
					}
				}
				if (data == null) {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치하지 않습니다.");
				} 
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (ae.getSource() == bu)
		{
			visible(false);
			Reportjoin rj = new Reportjoin();
		}
	}
	public static void main(String[] args) {
		Report mf = new Report();
	}
}
