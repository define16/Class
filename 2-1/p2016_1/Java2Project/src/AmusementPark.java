import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

class AmusementParkdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public AmusementParkdetail(){
		super("강촌랜드에는");
		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶강촌랜드는");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,190,200);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>강촌랜드에는 유명한 놀이기구가 2가지가 있습니다. 하나는 바이킹이고 다른 하나는 "
				+ "디스코팡팡입니다. 바이킹은 90도까지 올라가는 걸로 유명하고 웬만한 바이킹보다 스릴있는것으로 유명합니다"
				+ "디스코팡팡은 DJ의 센스있는 어투로 많은 사람들이 재미를 즐기고 가는 곳으로 유명합니다.");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/amusementpark2.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(205,35,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/amusementpark3.png");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(205,215,310,200);
		imagelabel2.setText(null);
		add(imagelabel2);
		
		titlelabel2 = new JLabel(" ▶요금안내");
		titlelabel2.setBounds(10,235,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,260,190,230);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>허리케인 <br>대인 4천원, 소인 3천5백원<br>바이킹"
				+ "<br>대인 4천원, 소인 3천5백원<br>디스코팡팡<br> 대인,소인 4천원<br>미니바이킹<br>소인 4천원<br>"
				+ " 범버카<br>대인 4천원, 소인 3천5백원<br>회전목마<br>대인 4천원, 소인 3천원 ");
		add(Textlabel2);

	

		nextbt = new JButton("처음으로");
		nextbt.setBounds(300, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(300, 450, 100, 30);
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
			AmusementParkway apw = new AmusementParkway();
		}
		
	}
}

class AmusementParkway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;
	
	public AmusementParkway(){
		super("강촌랜드으로 가는법");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶대중교통");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,50);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>지하철<br>경춘선 강촌역에서 하차후 북쪽으로 500m 직진");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,80,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,105,460,70);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.강촌검문소→46번국도 춘천방면→강촌삼거리→강촌교→강촌랜드<br>"
				+ "2. 시외버스터미널→88공원→의암터널→강촌삼거리→강촌교→강촌랜드<br>"
				+ "3. 강촌IC→남춘천IC→의암터널→강촌삼거리→강촌교→강촌랜드");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,185,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/amusementparkmap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(15,210,310,250);
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
			AmusementParkdetail apd = new AmusementParkdetail();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
		}
	}
	
}
public class AmusementPark extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt1,waypagebt1;

	
	public AmusementPark()
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
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/amusementpark.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(80,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt1 = new JButton("자세히");
		detailpagebt1.setBounds(280,350,100,30);
		detailpagebt1.addActionListener(this);
		add(detailpagebt1);
		
		waypagebt1 = new JButton("현지교통");
		waypagebt1.setBounds(100,350,100,30);
		waypagebt1.addActionListener(this);
		add(waypagebt1);


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt1)
		{
			setVisible(false);
			AmusementParkdetail apd = new AmusementParkdetail();
		}
		
		if(arg1.getSource() == waypagebt1)
		{
			setVisible(false);
			AmusementParkway apw = new AmusementParkway();
		}
		
		
	}
}
