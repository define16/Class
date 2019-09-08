package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FamilyFrame extends JFrame implements ActionListener{

	JButton homebt4, backbt4, internetbt4;
    JTabbedPane familytabbedPane;

	public FamilyFrame()
	{
		super("가족과 함께");
		setSize(490,490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		homebt4 = new JButton("홈으로");
		homebt4.setBounds(162,0,160,30);
		homebt4.addActionListener(this);
		add(homebt4);
		
		backbt4 = new JButton("뒤로");
		backbt4.setBounds(2,0,160,30);
		backbt4.addActionListener(this);
		add(backbt4);
		
		internetbt4 = new JButton("춘천관광넷");
		internetbt4.setBounds(322,0,160,30);
		internetbt4.addActionListener(this);
		add(internetbt4);
		
		familytabbedPane = new JTabbedPane();
		familytabbedPane.setBounds(0,30,485,432);
         populateTabbedPane();
         getContentPane().add(familytabbedPane);

		
         setResizable(false);
		
		setVisible(true);
		
	}
	
	   private void populateTabbedPane() {
		   familytabbedPane.addTab("제이드가든",null, new Jadegarden(), "예쁜 풍경과 함께");   
		   familytabbedPane.addTab("남이섬", null, new Namisum(), "가족과 함께");
		   familytabbedPane.addTab("구곡폭포", null,new Waterfall(),"자연과 하나"); 
		   familytabbedPane.addTab("애니메이션 박물관", null, new AnimationMuseum(), "동심의 세계로");      
	 
       }
	   
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getSource() == homebt4)
			{
				setVisible(false);
				MainFrame mf = new MainFrame(); 
			}
			
			if(arg0.getSource() == backbt4)
			{	
				setVisible(false);
				backWithwho bww = new backWithwho(); 
			}
			
			if(arg0.getSource() == internetbt4)
			{
				
				 String temp = "";
				   try {
					temp = URLEncoder.encode(temp, "utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   String Url = "http://tour.chuncheon.go.kr/open_content/page/main.asp";
				   Hyper.openUrl(Url);
				// 탭을 이동
			}

		}

}
