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
		super("�������� �ֺ� ������");

		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����踶��");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,120);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>�������� �Ա����� ������ �ɼ� ��� �� 40���� ���� ������ �� ����ó�� ���̴� "
				+ "���������� ��Ÿ���µ� �̰��� �ٷ� ���踶���̴�. 2���� ���� ������ �̰� ������ �ð� ǳ���� "
				+ "�� ���� ǳ��ȭó�� �츮�� ���� ���븦 ������ �Ѵ�. ������ �������� ������ ���� ���� ���� �Ǵ� ģ������ "
				+ "������ ��ȭ�� ������ ����� ��� �� �ִ� ��å�� �� �����Ǿ� �ִ�. �̰����� ������ ��ä����䵵 ��ǰ�̴�");
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

		nextbt = new JButton("ó������");
		nextbt.setBounds(350, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		super("���������� ���¹�");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����߱���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,80);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���� �̿�� : 50��,50-1�� ����<br>"
				+ "����ö �̿�� : ���ἱ ������氭�̿��氭��������-��������,���踶��");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,115,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,145,460,120);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. ���̰˹��ҡ�46������ ��õ���氭�̻�Ÿ��氭�̱��氭��������-��������,���踶��<br>"
				+ "2. �ÿܹ����͹̳Ρ�88�������Ǿ��ͳΡ氭�̻�Ÿ��氭�̱��氭��������-��������,���踶��<br>"
				+ "3. ����IC�泲��õIC���Ǿ��ͳΡ氭�̻�Ÿ��氭�̱��氭���������汸������,���踶��<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/waterfallmap.jpg");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,280,310,200);
		imagelabel.setText(null);
		add(imagelabel);
		
		nextbt = new JButton("����");
		nextbt.setBounds(350, 320, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		Textlabel.setText("<html>��ǥ�ҿ��� �������� ���� 700m�� ���δ� ���������̿� ģ������ ���� �ڽ��ε� "
				+ "�αⰡ ������ ���������Ա����� ������ �ɼ��� ���� ������ ���������� "
				+ "�����µ� �̰��� ���踶���� �ִ�.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/waterfall.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(85,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt3 = new JButton("�ڼ���");
		detailpagebt3.setBounds(280,350,100,30);
		detailpagebt3.addActionListener(this);
		add(detailpagebt3);
		
		waypagebt3 = new JButton("������");
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

