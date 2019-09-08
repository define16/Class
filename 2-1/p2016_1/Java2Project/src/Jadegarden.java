import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

class Jadegardendetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;


	public Jadegardendetail(){
		super("제이드가든에 대해서");

		setSize(500,570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶제이드가든");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,85);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>제이드가든은 만병초류, 단풍나무류, 비비추류, 목련류 등(총 3,904종류) 의 식물이 있고"
				+ "자연상태의 교육장을 마련이 되어 있고 누구나 자연의 편안함들 느낄수 있게 조성이 되어 있습니다.<br>"
				+ "요금안내 : 대인 7천원, 중-고등학생 6천원, 어린이 5천원");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/jadegarden2.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(15,105,500,300);
		imagelabel1.setText(null);
		add(imagelabel1);
		

		Textlabel2 = new JLabel();
		Textlabel2.setBounds(15,400,320,120);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>※유의 사항※<br>1. 동식물 및 토석을 채집할 수 없습니다."
				+ "<br>2.수목원 전 지역은 금연입니다. 인화성 물질의 반입도 금합니다.<br>"
				+ "3.애완 동물 및 자전거는 반입하실 수 없습니다.<br>"
				+ "4.체육 기자재를 이용한 운동 행위를 하실 수 없습니다.");
		add(Textlabel2);
		

		nextbt = new JButton("처음으로");
		nextbt.setBounds(350, 420, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("뒤로");
		backbt.setBounds(350, 480, 100, 30);
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
				Jadegardenway jgw = new Jadegardenway();
			}
		}
		
	}


class Jadegardenway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;

	
	public Jadegardenway(){
		super("제이드가든으로 가는법");

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
		Textlabel1.setText("<html>셔틀버스 이용시<br> 1.굴봉산역(제이드가든역) → 제이드가든 : 10시 45분(첫차)~16시 45분(막차)"
				+ "<br>2. 제이드가든 → 굴봉산역(제이드가든역) : 11시 10분(첫차)~17시 10분(막차)<br> 요금안내 2만5천원"
				+ "<br>지하철 이용시 : 경춘선 굴봉산역(제이드가든역) - 제이드가든 셔틀버스 운행");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ▶자가용");
		titlelabel2.setBounds(10,150,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,175,460,60);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.서울 - 춘천고속도로 - 화도IC - 가평, 청평방면 - 가평 - "
				+ "햇골교차로 우회전 - 마을길 1km"
				+ "2. 경기남부 - 구리, 퇴계원 - 춘천 청평 자동차 전용도로 - 호평 - 마석 - 청평 좌측 출구 - 대성리 "
				+ "- 가평햇골교차로 우회전 - 마을길 1km<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ▶약도");
		titlelabel3.setBounds(10,245,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/jadegardenmap.png");
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

				Jadegardendetail jgd = new Jadegardendetail();
			
			
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);

		}
	}
	
}

public class Jadegarden  extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt3,waypagebt3;

	public Jadegarden()
	{
		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(5,15,465,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>제이드가든은 숲속의 작은 유럽을 모토로 2011년 4월에 문을 열었다. "
				+ "유럽의 각국을 대표하는 정원에서 웃고, 이야기하고 추억을 만들기 위해 만들어졌습니다."
				+ " 새소리와 물소리가 어우러지고 웨딩가든에서는 초원을 배경으로 프로포즈하는 젊은이들의 사랑노래가 "
				+ "울려퍼집니다<br>");

		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/jadegarden.png");
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
			Jadegardendetail jgd = new Jadegardendetail();
		
			}
		
		if(arg1.getSource() == waypagebt3)
		{
			setVisible(false);
			Jadegardenway jgw = new Jadegardenway();
			
		}
		
	}

}
