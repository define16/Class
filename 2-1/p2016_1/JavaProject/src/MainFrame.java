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
		setTitle("환영합니다.");
		//setResizable(false);
		setVisible(true);
		
		imagelabel  = new JLabel();
		imagelabel.setBounds(60,30,330,160);
		ImageIcon logo = new ImageIcon("logo.jpg");
		imagelabel.setIcon(logo);
		add(imagelabel);
		
		
		
		waybt = new JButton("오시는 길");
		waybt.setBounds(60,200,160,60);
		waybt.addActionListener(this);
		add(waybt);
		
		explanationbt = new JButton("춘천의 역사");
		explanationbt.setBounds(260,200,160,60);
		explanationbt.addActionListener(this);
		add(explanationbt);
		
		placebt = new JButton("관광명소");
		placebt.setBounds(60,300,160,60);
		placebt.addActionListener(this);
		add(placebt);
		
		restaurantbt = new JButton("맛집");
		restaurantbt.setBounds(260,300,160,60);
		restaurantbt.addActionListener(this);
		add(restaurantbt);
	
		
		
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == waybt) // 오시는길
		{
			System.out.println("w버튼 잘됨");
		}
		
		if(e.getSource() == explanationbt) // 춘천의 역사
		{
			System.out.println("e버튼 잘됨");
		}
		
		
		if(e.getSource() == placebt) // 관광명소
		{
			System.out.println("p버튼 잘됨");
		}
		
		
		if(e.getSource() == restaurantbt) // 식당
		{
			System.out.println("r버튼 잘됨");
		}
		
		
		
	}
	
	


}
