

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
		super("������ ���а� �ֺ� ������");
		setSize(500,560);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ���������� ��");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,190,187);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���������� ���ͼ� �������� ���� ���� ���������� �� �� �ֽ��ϴ�."
				+ "���� �������� ����� �״�� �����ϰ� ������ ���������� ��ġ�ִ� ��Ʈ�� ������ ����ǥ��� "
				+ "�������� ���� ������ �̿��� �׾ȿ� ��ī�䰡 ���õ� �ֽ��ϴ�.");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKim2.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(205,22,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		
		titlelabel2 = new JLabel(" ��������ũ");
		titlelabel2.setBounds(10,224,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,250,460,75);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>�������� �ٹ濡 ������ũ�� �ִµ� �̰����� ���Ϲ���ũ�� ž���� �� �ֽ��ϴ�. "
				+ "�������� ���� ���̿����� ���� �ڽ� �Դϴ�. �αⰡ ���� ������ ���� ������ ž���ϱ� ����Ƿ� "
				+ "�����ϴ� ���� ����帳�ϴ�.<br>�ð� : 9~18�ñ��� �����ÿ� ���, ���� : 2�ν� 25000��, 4�ν� 35000��");
		add(Textlabel2);

		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/YujeongKim3.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(10,320,310,200);
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
			YujeongKimway yw = new YujeongKimway();
		}
		
	}
}

class YujeongKimway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;
	
	public YujeongKimway(){
		super("������ ���а����� ���¹�");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����߱���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���� �̿�� : 1��,67�� ����<br>����ö �̿�� : ���ἱ ������������ ����");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,135,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,165,460,100);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>��õIC-��õ�� ������-46������-��õ�� �ŵ���-70�� "
				+ "���浵-��������-������ ������<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKimmap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,275,310,200);
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
		Textlabel.setText("<html>1930��� �츮���� ������ �ǻ�� �� ���� Ź���� ������ "
				+ "�����ϸ鼭�� ��Ȯ�� ����, �׸��� ��Ư�� ������ ��û���� �����ϰ� �ִ� �ѱ� �������� ��ǥ�� �۰��� "
				+ "�� ���� ������(1908~1937)�� ������ �Ƿ������� ������ �����ϰ�, ���ð��� �Ǹ��ϴ� �� ������ü�� "
				+ "�������������̡��̶�� ���а������� ź�����״�.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/YujeongKim.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(90,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt2 = new JButton("�ڼ���");
		detailpagebt2.setBounds(280,350,100,30);
		detailpagebt2.addActionListener(this);
		add(detailpagebt2);
		
		waypagebt2 = new JButton("��������");
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
