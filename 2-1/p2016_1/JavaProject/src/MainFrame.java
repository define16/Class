import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

 class MainFrame extends JFrame implements ActionListener
{
	JLabel imagelabel;
	JButton waybt,placebt,restaurantbt,explanationbt ;
	
	
	public MainFrame()
	{
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ȯ���մϴ�.");
		//setResizable(false);
		setVisible(true);
		
		imagelabel  = new JLabel();
		imagelabel.setBounds(60,30,330,160);
		ImageIcon logo = new ImageIcon("logo.jpg");
		imagelabel.setIcon(logo);
		add(imagelabel);
		
		
		
		waybt = new JButton("���ô� ��");
		waybt.setBounds(60,200,160,60);
		waybt.addActionListener(this);
		add(waybt);
		
		explanationbt = new JButton("��õ�� ����");
		explanationbt.setBounds(260,200,160,60);
		explanationbt.addActionListener(this);
		add(explanationbt);
		
		placebt = new JButton("�������");
		placebt.setBounds(60,300,160,60);
		placebt.addActionListener(this);
		add(placebt);
		
		restaurantbt = new JButton("����");
		restaurantbt.setBounds(260,300,160,60);
		restaurantbt.addActionListener(this);
		add(restaurantbt);
	
		
		
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == waybt) // ���ô±�
		{
			System.out.println("w��ư �ߵ�");
		}
		
		if(e.getSource() == explanationbt) // ��õ�� ����
		{
			System.out.println("e��ư �ߵ�");
		}
		
		
		if(e.getSource() == placebt) // �������
		{
			System.out.println("p��ư �ߵ�");
		}
		
		
		if(e.getSource() == restaurantbt) // �Ĵ�
		{
			System.out.println("r��ư �ߵ�");
		}
		
		
		
	}
	
	


}
