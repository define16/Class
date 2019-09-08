package Project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

class AnimationMuseumdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel1,imagelabel2,imagelabel3;
	JButton nextbt, backbt;

	
	public AnimationMuseumdetail(){
		super("애니메이션 박물관 자세히 보기");
		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶박물관에 대해서");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,80);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>애니메이션박물관에서는 아이들과 어른들 모두 체험할 수 있도록 시설이 있으며 "
				+ "어른에게는 옛 만화의 추억을 아이들에게는 우리나라의 만화의 역사와 체험을 할 수 있습니다. "
				+ "여러시대의 만화와 다양한 국가의 만화들이 전시되어 있어 아이들과 부모간의 유대감을 형성할 수 있는"
				+ "곳 입니다.");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶1층전시관");
		titlelabel2.setBounds(10,110,160,30);
		add(titlelabel2);
		
		titlelabel3 = new JLabel(" ▶2층전시관");
		titlelabel3.setBounds(260,110,160,30);
		add(titlelabel3);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/animationmuseum1.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(10,115,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		
		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/animationmuseum2.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(260,115,310,200);
		imagelabel2.setText(null);
		add(imagelabel2);
		
		titlelabel3 = new JLabel(" ▶입장료 및 관람시간");
		titlelabel3.setBounds(10,290,160,30);
		add(titlelabel3);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>애니메이션박물관 + 토이로봇관<br> 일반 9600원 / 청소년,어린이 8000원<br><br>  "
				+ "애니메이션박물관<br>일반 5000원 / 청소년,어린이 4000원<br><br>  "
				+ "토이로봇관<br>일반 7000원 / 청소년,어린이 6000원<br><br> "
				+ "관람시간 : 10~18시<br>(여름방학기간엔 19까지 관람시간 연장)");
		add(Textlabel2);
		
		
		nextbt = new JButton("처음으로");
		nextbt.setBounds(360, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(360, 450, 100, 30);
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
			AnimationMuseumway amw = new AnimationMuseumway();
		}
		
	}
}

class AnimationMuseumway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;

	
	public AnimationMuseumway(){
		super("애니메이션박물관으로 가는법");

		setSize(500,520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶대중교통");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,50);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>82번 (중앙로,소양로),83번 (춘천역/주말,공휴일에만 운영),<br> "
				+ "81번(시외버스터미널) 버스 승차 후 애니메이션박물관 앞 하차");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,80,160,32);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,110,460,155);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.강촌IC → 강촌교 → 의암댐(화천방면) → 덕두원 → 애니메이션박물관<br>"
				+ "2.춘천IC → 공지천 → 소양2교(화천방면) → 인형극장사거지(좌회전) → "
				+ "신매대교(서울방향) → 애니메이션박물관<br> 3.남춘천IC → 덕만이고개 → 팔미리거둔교차로 → "
				+ "칠전동사거리(좌회전 의암댐방면) → 덕두원 → 애니메이션박물관<br>"
				+ "4.서울방면(46번 경춘국도 이용)  서울 → 구리 → 청평 → 가평 → 강촌 → 화천방면 우측전입 후 직진 → 애니메이션박물관");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/animationmuseummap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,283,310,200);
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
			AnimationMuseumdetail amd = new AnimationMuseumdetail();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);		
		}
	}
	
}


public class AnimationMuseum extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt2,waypagebt2;

	
	
	public AnimationMuseum()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(13,15,450,120);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>애니메이션에 관한 자료를 발굴,수집,보관 전시 연구함으로써 이에 대한 "
				+ "올바른 인식과 그 소중함을 일깨워 국민 정신문화의 산 교육장으로 만들고자 춘천시와 "
				+ "춘천문화산업진흥재단이 운영하는 우리나라 유일의 애니메이션 박물관으로 창작 예술품으로서, "
				+ "삶의 표현 매체로서 자리 잡고 있는 애니메이션에 대한 새로운 인식을 바탕으로 미래산업의 근간을 "
				+ "마련하고 우리 애니메이션의 위상과 역사를 조명하기 위해 건립되었다.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/animationmuseum.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(90,117,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt2 = new JButton("자세히");
		detailpagebt2.setBounds(280,350,100,30);
		detailpagebt2.addActionListener(this);
		add(detailpagebt2);
		
		waypagebt2 = new JButton("현지교통");
		waypagebt2.setBounds(100,350,100,30);
		waypagebt2.addActionListener(this);
		add(waypagebt2);


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt2)
		{
			setVisible(false);
				AnimationMuseumdetail amd = new AnimationMuseumdetail();
		}
		
		if(arg1.getSource() == waypagebt2)
		{
			setVisible(false);
			AnimationMuseumway amw = new AnimationMuseumway();
		}
		
		
	}

}
