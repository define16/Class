package Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class LoverFrame extends JFrame implements ActionListener{

	JButton homebt3, backbt3, internetbt3;
    JTabbedPane lovertabbedPane;
    JPanel car,underground,train;
    
	public LoverFrame()
	{
		super("���ΰ� �Բ�");
		setSize(490,490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		homebt3 = new JButton("Ȩ����");
		homebt3.setBounds(162,0,160,30);
		homebt3.addActionListener(this);
		add(homebt3);
		
		backbt3 = new JButton("�ڷ�");
		backbt3.setBounds(2,0,160,30);
		backbt3.addActionListener(this);
		add(backbt3);
		
		internetbt3 = new JButton("��õ������");
		internetbt3.setBounds(322,0,160,30);
		internetbt3.addActionListener(this);
		add(internetbt3);
		
		lovertabbedPane = new JTabbedPane();
		lovertabbedPane.setBounds(0,30,485,432);
         populateTabbedPane();
         getContentPane().add(lovertabbedPane);
         
         car = new JPanel();
         underground = new JPanel();
         train = new JPanel();
         
         
		
		

         setResizable(false);
		setVisible(true);
		
	}
	
	   private void populateTabbedPane() {
		   lovertabbedPane.addTab("���̼�", null, new Namisum(), "���ΰ� �Բ�");     
		   lovertabbedPane.addTab("���̵尡��",null, new Jadegarden(), "���� ǳ��� �Բ�");          
		   lovertabbedPane.addTab("���̷���", null, new Leisure(), "���� �� ���� �߾���");   
	 
       }
	   
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			if(arg0.getSource() == homebt3)
			{
				setVisible(false);
				MainFrame mf = new MainFrame(); 
			}
			
			if(arg0.getSource() == backbt3)
			{	
				setVisible(false);
				backWithwho bww = new backWithwho(); 
			}
			
			if(arg0.getSource() == internetbt3)
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
