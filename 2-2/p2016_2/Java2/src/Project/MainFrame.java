package Project;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	
	JPanel imagepanel,imagepanel2,mainpanel;
	JLabel imagelabel,imagelabel2;
	JButton nextframebt,controlbt;
	static WithWho ww; 
	
	public MainFrame()
	{
		setSize(500,500);
		setTitle("ȯ���մϴ�!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(200,100);
		imagepanel = new JPanel();
		imagepanel.setBounds(5,10,460,220);
		imagelabel = new JLabel();  // �λ縻 �̹���
		ImageIcon logo = new ImageIcon("src/image/title.png"); 
		imagelabel.setIcon(logo);
		imagelabel.setText(null);
		add(imagepanel);
		imagepanel.add(imagelabel);
		imagepanel2 = new JPanel();
		imagepanel2.setBounds(20,215,200,180);
		imagelabel2 = new JLabel(); // ȣ����ĳ���� �̹���
		ImageIcon logo2 = new ImageIcon("src/image/logo2.jpg");
		imagelabel2.setIcon(logo2);
		imagelabel2.setText(null);
		add(imagepanel2);
		imagepanel2.add(imagelabel2);
		controlbt = new JButton("����������");
		controlbt.setBounds(22,400,100,40);
		controlbt.addActionListener(this); // �������������� ���� ��ư
		add(controlbt);
		nextframebt = new JButton("��������");
		nextframebt.setBounds(245,322,160,60);
		nextframebt.addActionListener(this); //�������� ����ϴ� ��ư
		add(nextframebt);
	    setResizable(false);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == controlbt){
			setVisible(false);
			Control ct = new Control();
		}if(e.getSource() == nextframebt){
			setVisible(false);
			ww = new WithWho();
		}
	}
}
