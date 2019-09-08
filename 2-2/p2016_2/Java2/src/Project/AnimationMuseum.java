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
		super("�ִϸ��̼� �ڹ��� �ڼ��� ����");
		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ���ڹ����� ���ؼ�");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,80);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>�ִϸ��̼ǹڹ��������� ���̵�� ��� ��� ü���� �� �ֵ��� �ü��� ������ "
				+ "����Դ� �� ��ȭ�� �߾��� ���̵鿡�Դ� �츮������ ��ȭ�� ����� ü���� �� �� �ֽ��ϴ�. "
				+ "�����ô��� ��ȭ�� �پ��� ������ ��ȭ���� ���õǾ� �־� ���̵�� �θ��� ���밨�� ������ �� �ִ�"
				+ "�� �Դϴ�.");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ��1�����ð�");
		titlelabel2.setBounds(10,110,160,30);
		add(titlelabel2);
		
		titlelabel3 = new JLabel(" ��2�����ð�");
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
		
		titlelabel3 = new JLabel(" ������� �� �����ð�");
		titlelabel3.setBounds(10,290,160,30);
		add(titlelabel3);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>�ִϸ��̼ǹڹ��� + ���̷κ���<br> �Ϲ� 9600�� / û�ҳ�,��� 8000��<br><br>  "
				+ "�ִϸ��̼ǹڹ���<br>�Ϲ� 5000�� / û�ҳ�,��� 4000��<br><br>  "
				+ "���̷κ���<br>�Ϲ� 7000�� / û�ҳ�,��� 6000��<br><br> "
				+ "�����ð� : 10~18��<br>(�������бⰣ�� 19���� �����ð� ����)");
		add(Textlabel2);
		
		
		nextbt = new JButton("ó������");
		nextbt.setBounds(360, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		super("�ִϸ��̼ǹڹ������� ���¹�");

		setSize(500,520);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����߱���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,50);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>82�� (�߾ӷ�,�Ҿ��),83�� (��õ��/�ָ�,�����Ͽ��� �),<br> "
				+ "81��(�ÿܹ����͹̳�) ���� ���� �� �ִϸ��̼ǹڹ��� �� ����");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,80,160,32);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,110,460,155);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.����IC �� ���̱� �� �Ǿϴ�(ȭõ���) �� ���ο� �� �ִϸ��̼ǹڹ���<br>"
				+ "2.��õIC �� ����õ �� �Ҿ�2��(ȭõ���) �� ������������(��ȸ��) �� "
				+ "�ŸŴ뱳(�������) �� �ִϸ��̼ǹڹ���<br> 3.����õIC �� �����̰� �� �ȹ̸��ŵб����� �� "
				+ "ĥ������Ÿ�(��ȸ�� �Ǿϴ���) �� ���ο� �� �ִϸ��̼ǹڹ���<br>"
				+ "4.������(46�� ���ᱹ�� �̿�)  ���� �� ���� �� û�� �� ���� �� ���� �� ȭõ��� �������� �� ���� �� �ִϸ��̼ǹڹ���");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,265,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/animationmuseummap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,283,310,200);
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
		Textlabel.setText("<html>�ִϸ��̼ǿ� ���� �ڷḦ �߱�,����,���� ���� ���������ν� �̿� ���� "
				+ "�ùٸ� �νİ� �� �������� �ϱ��� ���� ���Ź�ȭ�� �� ���������� ������� ��õ�ÿ� "
				+ "��õ��ȭ������������ ��ϴ� �츮���� ������ �ִϸ��̼� �ڹ������� â�� ����ǰ���μ�, "
				+ "���� ǥ�� ��ü�μ� �ڸ� ��� �ִ� �ִϸ��̼ǿ� ���� ���ο� �ν��� �������� �̷������ �ٰ��� "
				+ "�����ϰ� �츮 �ִϸ��̼��� ����� ���縦 �����ϱ� ���� �Ǹ��Ǿ���.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/animationmuseum.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(90,117,450,250);
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
				AnimationMuseumdetail amd = new AnimationMuseumdetail();
		}
		
		if(arg1.getSource() == waypagebt2)
		{
			setVisible(false);
			AnimationMuseumway amw = new AnimationMuseumway();
		}
		
		
	}

}
