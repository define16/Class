package ef;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.*;

class ReportChange extends JFrame implements ActionListener {
	JButton b1 = new JButton("저장");
	JButton b2 = new JButton("취소");
	JTextField tf, tf1, tf2, tf3;
	JTextArea ta;
	
	private PrintWriter out, out2;
	private BufferedReader in, in2;
	private final String filename = "회원명단.txt";
	private final String filename2 = "임시파일.txt";
	private Report r;
	private Reportjoin rj;
	String data = "";
	String search[] = data.split("/");

	public ReportChange() {
		setTitle("회원가입");
		JLabel l1 = new JLabel("이름 : ");
		JLabel l2 = new JLabel("아이디 : ");
		JLabel l3 = new JLabel("패스워드 : ");
		JLabel l4 = new JLabel("주소 : ");
		JLabel l5 = new JLabel("추가사항 : ");
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		tf = new JTextField();
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		ta = new JTextArea(10, 15);
		b1.addActionListener(this);
		b2.addActionListener(this);
		tf.setEditable(false);
		tf1.setEditable(false);
		tf2.setEditable(false);

		p1.setLayout(new GridLayout(5, 2));

		p1.add(l1);
		p1.add(tf);
		p1.add(l2);
		p1.add(tf1);
		p1.add(l3);
		p1.add(tf2);
		p1.add(l4);
		p1.add(tf3);
		p2.add(l5);
		p2.add(ta);
		p3.add(b1);
		p3.add(b2);

		add("North", p1);
		add("Center", p2);
		add("South", p3);

		pack();
		setVisible(true);
	}

	public void init() {
		String data = "";
		try {
			in = new BufferedReader(new FileReader(filename));
			while ((data = in.readLine()) != null) {
				String search[] = data.split("/");
				if (search[1].equals(r.tf.getText()) && search[2].equals(r.tf1.getText())) {
					tf.setText(search[0]);
					tf1.setText(search[1]);
					tf2.setText(search[2]);
					tf3.setText(search[3]);
					ta.setText(search[4]);
				}
			}
		} catch (IOException e1) {
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String data = "";
		if (e.getSource() == b1) {
			fileDelete(filename2);
			try {
				out = new PrintWriter(new FileWriter(filename2, true));
				in = new BufferedReader(new FileReader(filename));
				while ((data = in.readLine()) != null) {
					String search[] = data.split("/");
					if(search[1].equals(r.tf.getText()) && search[2].equals(r.tf1.getText())) {
						out.println(tf.getText() + "/" + tf1.getText() + "/" + tf2.getText() + "/" + tf3.getText() + "/"
										+ ta.getText());
						out.flush();
					}
					else if(search[1]!= r.tf.getText() || search[2] != r.tf1.getText()){
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
			Report r = new Report();
			r.init();
			setVisible(false);

		}
		if (e.getSource() == b2) {
			setVisible(false);
			Report r = new Report();
			r.init();
		}
	}
	
	public static void fileDelete(String deleteFileName) {
		File i = new File(deleteFileName);
		i.delete();
	}
}
