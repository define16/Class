import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


class Namisumdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,Textlabel1,imagelabel1,imagelabel2;
	JButton nextbt, backbt;

	public Namisumdetail(){
		super("남이섬에 대해서");

		setSize(500,570);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶남이섬");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,55);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>남이섬에는 아름다운 산책길과 정원, 어린이들을 위한 태마마을이 있어서 "
				+ "남여노소 누구나 즐길 수 있게 구성이 되어 있습니다. <br>"
				+ "요금안내 : 대인 1만원, 중-고등학생 8천원, 36개월- 초등학생 4천원");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/namisum2.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(15,90,500,300);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/namisum3.png");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(15,360,310,200);
		imagelabel2.setText(null);
		add(imagelabel2);

		nextbt = new JButton("처음으로");
		nextbt.setBounds(350, 400, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(350, 460, 100, 30);
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
		}
		if(e.getSource() == backbt)
		
			{
				setVisible(false);
				Namisumway nw = new Namisumway();
			}
		}
		
	}


class Namisumway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;

	
	public Namisumway(){
		super("남이섬으로 가는법");

		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶대중교통");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,120);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>1.셔틀버스 이용시<br> 인사동 출발-9시30분(탑골공원옆 관광버스대기소)"
				+ "남대문 출발-9시30분(숭례문광장 관광버스정류장)<br>남이섬출발-16시<br> 요금안내 2만5천원"
				+ "<br>2.지하철 이용시 : 경춘선 상봉역→가평역→도보로 약 20분(약1.9km)");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,150,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,175,460,60);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. 서울춘천고속도로→금남IC→경춘북로→가평역삼거리→북한강변로-남이섬<br>"
				+ "2. 46번국도→경춘로→가평역삼거리→북한강변로-남이섬<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,245,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/namisummap.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,270,310,200);
		imagelabel.setText(null);
		add(imagelabel);
		
		nextbt = new JButton("다음");
		nextbt.setBounds(350, 320, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(350, 390, 100, 30);
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
			Namisumdetail nd = new Namisumdetail();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);

		}
	}
	
}

public class Namisum  extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt3,waypagebt3;
	
	public Namisum()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(5,15,465,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>남이섬은 북한강에 떠 있는 반달 모양의 남이섬은 원래 섬이 아니었으나, "
				+ "청평댐이 세워지면서 주위가 물에 잠겨 섬이 되었습다. "
				+ "남이섬 선착장에서 곧게 뻗은 길을 따라 섬으로 들어가 보면 이 섬의 이름이 유래된 남이장군의 묘소가 "
				+ "있다하여 남이섬이라고 불린다고 전하고 있습니다. 또한 "
				+ "2010년 12월 세계에서 14번째, 한국에서는 최초로 유니세프 어린이친화공원에 선정되기도 했습니다.<br>");

		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/namisum.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(75,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt3 = new JButton("자세히");
		detailpagebt3.setBounds(280,350,100,30);
		detailpagebt3.addActionListener(this);
		add(detailpagebt3);
		
		waypagebt3 = new JButton("교통편");
		waypagebt3.setBounds(100,350,100,30);
		waypagebt3.addActionListener(this);
		add(waypagebt3);


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt3)
		{
			setVisible(false);
			Namisumdetail nd = new Namisumdetail();
		}
		
		if(arg1.getSource() == waypagebt3)
		{
			setVisible(false);
			Namisumway nw = new Namisumway();
			
		}
		
	}


}
