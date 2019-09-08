import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


class Leisureother extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;

	
	public Leisureother(){
		super("춘추/겨울 레져스포츠"); //사륜바이크,강촌스키장
		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶사륜바이크");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>원래농장용기계로 개발되어 농업용이나 운송용으로 사용을 하였으나"
				+ "점차 레저스포츠로 발전하여 외국의 경우 대규모의 ATV대회까지 열리고 있습니다. "
				+ "도로교통법상 농기계로 분류되어 도로주행을 할 수 없다는게 단점이지만 남녀노소 간단하게"
				+ "안전교육을 받으면 바로 탑승이 가능하기 때문에 ATV의 매력을 느끼실 수 있습니다."
				+ "요금 안내 : 1시간 : 2만원 ,2시간 : 2만5천원, 3시간 : 3만원");
		add(Textlabel1);
	
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/Leisure2.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(10,115,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		
		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/Leisure3.png");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(255,115,310,200);
		imagelabel2.setText(null);
		add(imagelabel2);
		
		titlelabel2 = new JLabel(" ▶강촌엘리시안스키장");
		titlelabel2.setBounds(10,290,160,30);
		add(titlelabel2);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>스키장 영업시간 <br> 주간운영 : 9~17시30분 / 정설시간 : 17시30분~19시 "
				+ " <br> 야간운영 : 19~24시 / 심야운영 : 22~4시 <br> 입장료 <br>4시간 : 대인-5만4천원,소인 3만7천원  "
				+ " <br> 6시간 : 대인-6만4천원, 소인-4만4천원  <br> 8시간 : 대인-7만4천원,소인-5만1천원 <br>"
				+ "야간 : 대인-6만원,소인-4만2천원(19~24시) <br> 심야 : 대인-5만원,소인-3만5천원(22~4시) <br> "
				+ "백야 : 대인-4만원,소인-2만8천원(24~4시)");
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
		
				Leisuresummer ls = new Leisuresummer();

		}
		
	}
}

class Leisuresummer  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public Leisuresummer(){
		super("여름 레져스포츠"); //제트스키 바나나보트 나머지는 레이블로 언급 대략적인 가격표 언급

		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ▶수상스키 & 웨이크보드");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html> 수상스키는 모터보드에 달린 줄을 잡고 보트에 이끌려가면서 물위를 달려가며"
				+ "스피드를 즐기는 스포츠입니다. 웨이크보드도 마찬가지로 수상스키를 신는 대신에 웨이크보드를 타고 "
				+ "묘기와 다양한 기술을 구사하는 스포츠 입니다."
				+ "요금 안내 : 1회 각각 : 2만원(교육 불포함), 교육포함시 1회 각각 : 4만5천원 ");
		add(Textlabel1);
	
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/Leisure4.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(90,115,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
	
		
		titlelabel3 = new JLabel(" ▶바나나보트 & 더블땅콩보트 & 플라이 피쉬");
		titlelabel3.setBounds(10,290,300,30);
		add(titlelabel3);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. 바나나보트 : 바나나 모양의 보트를 모터보트를 이용하여 수면위를 달리는 것으로"
				+ "수상스키와 레프팅을 합쳐놓은 듯한 레저스포츠입니다.<br> 금안내 : 1회 - 1만원 (5인이상 픽업가능)<br> "
				+ "더블땅콩보트 고무로 만든 보트를 타고 계곡이나 강의 급류를 타는 레져스포츠 입니다.<br>요금안내 :"
				+ " 1회-1만5천원 <br> 플라이 피쉬 : 보트를 모터보트에 연결한뒤 연처럼 하늘에 날 수 있는 레저스포츠 입니다."
				+ "<br> 요금안내 : 1회-1만5천원");
		add(Textlabel2);
		
		
		nextbt = new JButton("다음");
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
			Leisureother lo = new Leisureother();
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
		}
	}
	
}


public class Leisure extends JPanel implements ActionListener{
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt3,summerbt;

	
	public Leisure()
	{

		setLayout(null);
		Textlabel = new JLabel();
		Textlabel.setBounds(5,15,465,100);
		Textlabel.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel.setBorder(eborder);
		Textlabel.setText("<html>강촌에는 4륜바이크를 탈 수 있는 코스가 마련 되어 있고 북한강을 따라 상류에는 "
				+ "여러가지 레저스포츠를 즐길 수 있는 곳이 마련 되어있습니다. 바나나보트부터 수상스키까지 "
				+ "탈 수 있고 겨울에는 스키장에서 스키와 보드를 즐기 실 수 있습니다.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/Leisure.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(75,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt3 = new JButton("춘추/겨울");
		detailpagebt3.setBounds(280,350,100,30);
		detailpagebt3.addActionListener(this);
		add(detailpagebt3);
		
		summerbt = new JButton("여름");
		summerbt.setBounds(100,350,100,30);
		summerbt.addActionListener(this);
		add(summerbt);


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt3)
		{
			setVisible(false);
			Leisureother lo = new Leisureother();
		}
		
		if(arg1.getSource() == summerbt)
		{
			setVisible(false);
			Leisuresummer ls = new Leisuresummer();
		}
		
	}

}

