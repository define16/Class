import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


class Damdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public Damdetail(){
		super("소양강 댐 주변 관광지");
		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶팔각정");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,190,200);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>개방시간<br> 동절기(12~2월) - 10~16시 <br> 하절기(3~11월) - 10~17시<br> "
				+ "우리나라 최대의 다목적댐인 <br>소양강댐 정상을 걸어서 팔각정 <br>전망대까지 왕복 할 수 있습니다.");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dam2.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(205,35,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		titlelabel2 = new JLabel(" ▶청평사");
		titlelabel2.setBounds(10,235,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,270,460,70);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html> 광종때이 승건이 창건하고 백암선원이라 이름을 지었지만 문종 때 이후 청평사로 "
				+ "이름이 바뀌였다. 현재 청평사는 현재 보물 제164호인 청평사 회전문과 극락보전등이 있다.");
		add(Textlabel2);

		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/dam3.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(10,330,310,200);
		imagelabel2.setText(null);
		add(imagelabel2);

		nextbt = new JButton("처음으로");
		nextbt.setBounds(350, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(350, 450, 100, 30);
		backbt.addActionListener(this);
		add(backbt);
		
	    setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == nextbt)
		{
			setVisible(false);  // 전 프레임으로 되돌아 가는 버튼입니다.
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
			Damway dw = new Damway(); //현지교통편 프레임으로 가는 버튼입니다.
		}
		
	}
}

class Damway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;
	
	public Damway(){
		super("소양강 댐으로 가는법");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶시내버스");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,20);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>11번,12번,150번 버스<br>");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,55,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,80,460,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. 강촌삼거리→의암터널→춘천역→화천방면 5번 국도→제2소양교→"
				+ "양구방면 우회전→우두산삼거리(충렬탑)→오음리.양구방면 우회전→율문3리→"
				+ "소양강댐 입구 주차장(춘천역-12km-소양댐)<br><br> 2. 강촌삼거리→의암대교→의암터널→"
				+ "팔미리 I.C→우회전→계속 직진 -동면 감정리 로타리→좌회전→200m→우회전→"
				+ "소양강댐 밑 세월교→소양강댐 입구 주차장<br><br>"
				+ "3. 춘천IC→거두지구→금대울사거리→만천JC→천전삼거리→한주그랜빌아파트→소양호<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,275,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dammap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,285,310,200);
		imagelabel.setText(null);
		add(imagelabel);  
		
		nextbt = new JButton("다음");
		nextbt.setBounds(350, 330, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(350, 400, 100, 30);
		backbt.addActionListener(this);
		add(backbt);
		
	      setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextbt)
		{
			setVisible(false);
			Damdetail dd = new Damdetail(); // 소양강 댐 주변
		}
		if(e.getSource() == backbt)
		{
			setVisible(false); // 전 프레임으로 되돌아 가는 버튼입니다.
		}
	}
	
}


public class Dam extends JPanel implements ActionListener{
	//세 번째 프레임에 나오는 패널입니다.
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt1,waypagebt1;
	
	
	public Dam()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(13,15,450,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder); 
		Textlabel.setText("<html>국내 최대 규모를 자랑하는 다목적댐으로, "
				+ "그 위용만큼이나 주변경관이 아름다워 나들이 장소로 각광받고 있습니다. "
				+ "선착장에서 배를 타고 들어가면 오봉산에 위치한 고려시대 사찰인 청평사를 방문할수 있습니다.<br>");
		add(Textlabel);
		// 소양강 댐에 대한 설명입니다.
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dam.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(80,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt1 = new JButton("자세히");
		detailpagebt1.setBounds(280,350,100,30);
		detailpagebt1.addActionListener(this);
		add(detailpagebt1); // 소양강 댐 근처의 관광명소를 알려주는 버튼입니다.
		
		waypagebt1 = new JButton("현지교통");
		waypagebt1.setBounds(100,350,100,30);
		waypagebt1.addActionListener(this);
		add(waypagebt1); //소양강댐을 갈 수 있는 방법을 소개하는 버튼입니다.


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt1)
		{
			setVisible(false);
			Damdetail dd = new Damdetail();
		}
		
		if(arg1.getSource() == waypagebt1)
		{
			setVisible(false);
			Damway dw = new Damway();
		}
		
		
	}
}


