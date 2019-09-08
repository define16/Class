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
		super("���̵尡�翡 ���ؼ�");

		setSize(500,570);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����̵尡��");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,85);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���̵尡���� �����ʷ�, ��ǳ������, ����߷�, ��÷� ��(�� 3,904����) �� �Ĺ��� �ְ�"
				+ "�ڿ������� �������� ������ �Ǿ� �ְ� ������ �ڿ��� ����Ե� ������ �ְ� ������ �Ǿ� �ֽ��ϴ�.<br>"
				+ "��ݾȳ� : ���� 7õ��, ��-����л� 6õ��, ��� 5õ��");
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
		Textlabel2.setText("<html>������ ���ס�<br>1. ���Ĺ� �� �伮�� ä���� �� �����ϴ�."
				+ "<br>2.����� �� ������ �ݿ��Դϴ�. ��ȭ�� ������ ���Ե� ���մϴ�.<br>"
				+ "3.�ֿ� ���� �� �����Ŵ� �����Ͻ� �� �����ϴ�.<br>"
				+ "4.ü�� �����縦 �̿��� � ������ �Ͻ� �� �����ϴ�.");
		add(Textlabel2);
		

		nextbt = new JButton("ó������");
		nextbt.setBounds(350, 420, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		super("���̵尡������ ���¹�");

		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����߱���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,120);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>��Ʋ���� �̿��<br> 1.�����꿪(���̵尡�翪) �� ���̵尡�� : 10�� 45��(ù��)~16�� 45��(����)"
				+ "<br>2. ���̵尡�� �� �����꿪(���̵尡�翪) : 11�� 10��(ù��)~17�� 10��(����)<br> ��ݾȳ� 2��5õ��"
				+ "<br>����ö �̿�� : ���ἱ �����꿪(���̵尡�翪) - ���̵尡�� ��Ʋ���� ����");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,150,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,175,460,60);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.���� - ��õ��ӵ��� - ȭ��IC - ����, û���� - ���� - "
				+ "�ް����� ��ȸ�� - ������ 1km"
				+ "2. ��Ⳳ�� - ����, ���� - ��õ û�� �ڵ��� ���뵵�� - ȣ�� - ���� - û�� ���� �ⱸ - �뼺�� "
				+ "- �����ް����� ��ȸ�� - ������ 1km<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,245,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/jadegardenmap.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,270,310,200);
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
		Textlabel.setText("<html>���̵尡���� ������ ���� ������ ����� 2011�� 4���� ���� ������. "
				+ "������ ������ ��ǥ�ϴ� �������� ����, �̾߱��ϰ� �߾��� ����� ���� ����������ϴ�."
				+ " ���Ҹ��� ���Ҹ��� ��췯���� �������翡���� �ʿ��� ������� ���������ϴ� �����̵��� ����뷡�� "
				+ "��������ϴ�<br>");

		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/jadegarden.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(75,105,450,250);
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
			Jadegardendetail jgd = new Jadegardendetail();
		
			}
		
		if(arg1.getSource() == waypagebt3)
		{
			setVisible(false);
			Jadegardenway jgw = new Jadegardenway();
			
		}
		
	}

}
