import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;



class Waterfalldetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,imagelabel1,imagelabel2;
	JButton nextbt, backbt;

	
	public Waterfalldetail(){
		super("구곡폭포 주변 관광지");

		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶문배마을");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,120);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>구곡폭포 입구에서 오른쪽 능선 길로 들어서 40여분 정도 오르면 산 정상처럼 보이는 "
				+ "분지마을이 나타나는데 이곳이 바로 문배마을이다. 2만여 평의 분지인 이곳 문배의 시골 풍경은 "
				+ "한 폭의 풍경화처럼 우리의 고향 정취를 맛보게 한다. 오르고 내려오는 도중의 산행 길은 가족 또는 친구끼리 "
				+ "오붓한 대화를 나누며 등산을 즐길 수 있는 산책로 가 조성되어 있다. 이곳에서 맛보는 산채비빔밥도 일품이다");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/waterfall2.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(80,140,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/waterfall3.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(30,320,310,200);
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
			Waterfallway wfw = new Waterfallway();
		}
}
}

class Waterfallway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;

	
	public Waterfallway(){
		super("구곡폭포로 가는법");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶대중교통");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,80);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>버스 이용시 : 50번,50-1번 버스<br>"
				+ "지하철 이용시 : 경춘선 상봉역→강촌역→강촌유원지-구곡폭포,문배마을");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,115,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,145,460,120);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. 강촌검문소→46번국도 춘천방면→강촌삼거리→강촌교→강촌유원지-구곡폭포,문배마을<br>"
				+ "2. 시외버스터미널→88공원→의암터널→강촌삼거리→강촌교→강촌유원지-구곡폭포,문배마을<br>"
				+ "3. 강촌IC→남춘천IC→의암터널→강촌삼거리→강촌교→강촌유원지→구곡폭포,문배마을<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/waterfallmap.jpg");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,280,310,200);
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
				Waterfalldetail wfd = new Waterfalldetail();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
		
		}
	}
	
}


public class Waterfall  extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt3,waypagebt3;

	public Waterfall()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(5,15,465,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>매표소에서 폭포까지 가는 700m의 등산로는 가족나들이와 친구들의 우정 코스로도 "
				+ "인기가 좋으며 구곡폭포입구에서 오른쪽 능선을 따라 오르면 분지마을이 "
				+ "나오는데 이곳에 문배마을이 있다.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/waterfall.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(85,105,450,250);
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
					Waterfalldetail wfd = new Waterfalldetail();
		
		}
		
		if(arg1.getSource() == waypagebt3)
		{
			setVisible(false);
			Waterfallway wfw = new Waterfallway();
	
		}
		
	}

	}

