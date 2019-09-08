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
		super("ģ���� �Բ�");
		setSize(490,490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		homebt2 = new JButton("Ȩ����");
		homebt2.setBounds(162,0,160,30);
		homebt2.addActionListener(this);
		add(homebt2);
		
		backbt2 = new JButton("�ڷ�");
		backbt2.setBounds(2,0,160,30);
		backbt2.addActionListener(this);
		add(backbt2);
		
		internetbt2 = new JButton("��õ������");
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
		   friendtabbedPane.addTab("���� ����",null,new Leisure(),"���� �� ���� �߾���"); 
		   friendtabbedPane.addTab("���̷���",null, new AmusementPark(), "ģ����� �Բ�");          
		   friendtabbedPane.addTab("��������", null, new Waterfall(), "�ڿ��� �ϳ�");   
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
				// ���� �̵�
			}

		}
		
		
		
}

