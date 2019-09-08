package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FriendFrame extends JFrame implements ActionListener{

	JButton homebt2, backbt2, internetbt2;
    JTabbedPane friendtabbedPane;


	public FriendFrame()
	{
		super("친구와 함께");
		setSize(490,490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		homebt2 = new JButton("홈으로");
		homebt2.setBounds(162,0,160,30);
		homebt2.addActionListener(this);
		add(homebt2);
		
		backbt2 = new JButton("뒤로");
		backbt2.setBounds(2,0,160,30);
		backbt2.addActionListener(this);
		add(backbt2);
		
		internetbt2 = new JButton("춘천관광넷");
		internetbt2.setBounds(322,0,160,30);
		internetbt2.addActionListener(this);
		add(internetbt2);
		
		friendtabbedPane = new JTabbedPane();
		friendtabbedPane.setBounds(0,30,485,432);
         populateTabbedPane();
         getContentPane().add(friendtabbedPane);
  

         setResizable(false);
		setVisible(true);
		
	}
	
	   private void populateTabbedPane() {
		   friendtabbedPane.addTab("강촌 레저",null,new Leisure(),"잊을 수 없는 추억을"); 
		   friendtabbedPane.addTab("강촌랜드",null, new AmusementPark(), "친구들과 함께");          
		   friendtabbedPane.addTab("구곡폭포", null, new Waterfall(), "자연과 하나");   
       }
	   
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getSource() == homebt2)
			{
				setVisible(false);
				MainFrame mf = new MainFrame(); 
			}
			
			if(arg0.getSource() == backbt2)
			{	
				setVisible(false);
				backWithwho bww = new backWithwho(); 
			}
			
			if(arg0.getSource() == internetbt2)
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

