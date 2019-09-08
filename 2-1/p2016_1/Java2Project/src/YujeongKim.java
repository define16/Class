

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


class YujeongKimdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public YujeongKimdetail(){
		super("김유정 문학관 주변 관광지");
		setSize(500,560);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶김유정역 폐역");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,190,187);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>김유정역에 나와서 좌측으로 가면 쉽게 김유정폐역을 볼 수 있습니다."
				+ "옛날 기차역을 모습을 그대로 간직하고 있으며 여러가지의 재치있는 멘트가 쓰여진 이정표들과 "
				+ "운행하지 않은 기차를 이용해 그안에 북카페가 마련되 있습니다.");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKim2.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(205,22,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		
		titlelabel2 = new JLabel(" ▶레일파크");
		titlelabel2.setBounds(10,224,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,250,460,75);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>김유정역 근방에 레일파크가 있는데 이곳에서 레일바이크를 탑승할 수 있습니다. "
				+ "김유정역 부터 강촌역까지 가는 코스 입니다. 인기가 많아 예약을 하지 않으면 탑승하기 힘드므로 "
				+ "예약하는 것을 권장드립니다.<br>시간 : 9~18시까지 매정시에 출발, 가격 : 2인승 25000원, 4인승 35000원");
		add(Textlabel2);

		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/YujeongKim3.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(10,320,310,200);
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
			YujeongKimway yw = new YujeongKimway();
		}
		
	}
}

class YujeongKimway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;
	
	public YujeongKimway(){
		super("김유정 문학관으로 가는법");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶대중교통");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>버스 이용시 : 1번,67번 버스<br>지하철 이용시 : 경춘선 김유정역에서 하차");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,135,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,165,460,100);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>춘천IC-춘천시 동내면-46번국도-춘천시 신동면-70번 "
				+ "지방도-김유정역-김유정 문학촌<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKimmap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,275,310,200);
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
			YujeongKimdetail yd = new YujeongKimdetail();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
		}
	}
	
}



public class YujeongKim extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt2,waypagebt2;
	
	
	public YujeongKim()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(13,15,450,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>1930년대 우리나라 농촌의 실상과 그 삶을 탁월한 언어감각과 "
				+ "투박하면서도 정확한 문장, 그리고 독특한 해학의 능청으로 묘사하고 있는 한국 단편문학의 대표적 작가인 "
				+ "소 설가 김유정(1908~1937)의 고향인 실레마을에 생가를 복원하고, 전시관을 건립하는 등 마을전체를 "
				+ "‘김유정문학촌’이라는 문학공간으로 탄생시켰다.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKim.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(90,105,450,250);
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
			YujeongKimdetail yd = new YujeongKimdetail();
		}
		
		if(arg1.getSource() == waypagebt2)
		{
			setVisible(false);
			YujeongKimway yw = new YujeongKimway();
		}
		
		
	}
}
