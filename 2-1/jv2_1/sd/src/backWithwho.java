import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class backWithwho extends JFrame {
	
	JPanel imagepanel, cardPanel, panel, changepanel;
	JLabel imagelabel;
	JButton alonebt, friendbt, loverbt, familybt;
	
	public backWithwho()
	{
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		  
			imagepanel = new JPanel();
			imagepanel.setBounds(10,10,420, 170);
			

			imagelabel = new JLabel();
			ImageIcon logo = new ImageIcon("src/image/title2.png");
			imagelabel.setIcon(logo);
			imagelabel.setText(null);
			
			add(imagepanel);
			imagepanel.add(imagelabel);


		alonebt = new JButton("나만의 여행");
		alonebt.setBounds(60, 200, 160, 60);


		friendbt = new JButton("친구들과 여행");
		friendbt.setBounds(260, 200, 160, 60);


		loverbt = new JButton("연인과 여행");
		loverbt.setBounds(60, 300, 160, 60);


		familybt = new JButton("가족들과 여행");
		familybt.setBounds(260, 300, 160, 60);


		add(alonebt);
		add(friendbt);
		add(loverbt);
		add(familybt);
		
		alonebt.addActionListener(new ActionListener() {  
			   public void actionPerformed(ActionEvent e) {
			    // TODO Auto-generated method stub
				   setVisible(false);
				   AloneFrame af = new AloneFrame();
			   }
			  });
		
		friendbt.addActionListener(new ActionListener() {  
			   public void actionPerformed(ActionEvent e) {
			    // TODO Auto-generated method stub
				   setVisible(false);
				   FriendFrame ff = new FriendFrame();
			   }
			  });
		
		loverbt.addActionListener(new ActionListener() {  
			   public void actionPerformed(ActionEvent e) {
			    // TODO Auto-generated method stub
				   setVisible(false);
				   LoverFrame af = new LoverFrame();
			   }
			  });
		
		familybt.addActionListener(new ActionListener() {  
			   public void actionPerformed(ActionEvent e) {
			    // TODO Auto-generated method stub
				   setVisible(false);
				   FamilyFrame faf = new FamilyFrame();
			   }
			  });
	      setResizable(false);
		setVisible(true);
	}

	


}

