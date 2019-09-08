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
		super("���̼��� ���ؼ�");

		setSize(500,570);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����̼�");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,460,55);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���̼����� �Ƹ��ٿ� ��å��� ����, ��̵��� ���� �¸������� �־ "
				+ "������� ������ ��� �� �ְ� ������ �Ǿ� �ֽ��ϴ�. <br>"
				+ "��ݾȳ� : ���� 1����, ��-����л� 8õ��, 36����- �ʵ��л� 4õ��");
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

		nextbt = new JButton("ó������");
		nextbt.setBounds(350, 400, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		super("���̼����� ���¹�");

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
		Textlabel1.setText("<html>1.��Ʋ���� �̿��<br> �λ絿 ���-9��30��(ž������� ������������)"
				+ "���빮 ���-9��30��(���ʹ����� ��������������)<br>���̼����-16��<br> ��ݾȳ� 2��5õ��"
				+ "<br>2.����ö �̿�� : ���ἱ ������氡�򿪡浵���� �� 20��(��1.9km)");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,150,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,175,460,60);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. ������õ��ӵ��Ρ�ݳ�IC�����ϷΡ氡�򿪻�Ÿ�����Ѱ�����-���̼�<br>"
				+ "2. 46�����������Ρ氡�򿪻�Ÿ�����Ѱ�����-���̼�<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,245,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/namisummap.png");
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
		Textlabel.setText("<html>���̼��� ���Ѱ��� �� �ִ� �ݴ� ����� ���̼��� ���� ���� �ƴϾ�����, "
				+ "û����� �������鼭 ������ ���� ��� ���� �Ǿ�����. "
				+ "���̼� �����忡�� ��� ���� ���� ���� ������ �� ���� �� ���� �̸��� ������ �����屺�� ���Ұ� "
				+ "�ִ��Ͽ� ���̼��̶�� �Ҹ��ٰ� ���ϰ� �ֽ��ϴ�. ���� "
				+ "2010�� 12�� ���迡�� 14��°, �ѱ������� ���ʷ� ���ϼ��� ���ģȭ������ �����Ǳ⵵ �߽��ϴ�.<br>");

		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/namisum.png");
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
			Namisumdetail nd = new Namisumdetail();
		}
		
		if(arg1.getSource() == waypagebt3)
		{
			setVisible(false);
			Namisumway nw = new Namisumway();
			
		}
		
	}


}
