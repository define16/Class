package ef;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Reportjoin extends JFrame implements ActionListener {
	JButton b1 = new JButton("����");
	JButton b2 = new JButton("���");
	JTextField tf, tf1, tf2, tf3;
	JTextArea ta;
	private PrintWriter out;
	private final String filename = "ȸ�����.txt";
	private Report r;

	public Reportjoin() {
		setTitle("ȸ������");
		JLabel l1 = new JLabel("�̸� : ");
		JLabel l2 = new JLabel("���̵� : ");
		JLabel l3 = new JLabel("�н����� : ");
		JLabel l4 = new JLabel("�ּ� : ");
		JLabel l5 = new JLabel("�߰����� : ");
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
	
	public void visible(boolean flag) {
		setVisible(flag);
	}

	public void init()
	{
		tf.setText("");
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		ta.setText("");
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b1) {
			try {
				out = new PrintWriter(new FileWriter(filename, true));
				out.println(tf.getText() + "/" + tf1.getText() + "/" + tf2.getText() + "/" + tf3.getText() + "/"
						+ ta.getText());
				out.flush();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "ȸ�������� �����մϴ�.");
			visible(false);
			Report r = new Report();
		}

		if (e.getSource() == b2) {
			visible(false);
		}
	}
}
