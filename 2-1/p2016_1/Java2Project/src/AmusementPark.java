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
		super("���̷��忡��");
		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����̷����");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,190,200);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>���̷��忡�� ������ ���̱ⱸ�� 2������ �ֽ��ϴ�. �ϳ��� ����ŷ�̰� �ٸ� �ϳ��� "
				+ "���������Դϴ�. ����ŷ�� 90������ �ö󰡴� �ɷ� �����ϰ� ������ ����ŷ���� �����ִ°����� �����մϴ�"
				+ "���������� DJ�� �����ִ� ������ ���� ������� ��̸� ���� ���� ������ �����մϴ�.");
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
		
		titlelabel2 = new JLabel(" ����ݾȳ�");
		titlelabel2.setBounds(10,235,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,260,190,230);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>�㸮���� <br>���� 4õ��, ���� 3õ5���<br>����ŷ"
				+ "<br>���� 4õ��, ���� 3õ5���<br>��������<br> ����,���� 4õ��<br>�̴Ϲ���ŷ<br>���� 4õ��<br>"
				+ " ����ī<br>���� 4õ��, ���� 3õ5���<br>ȸ����<br>���� 4õ��, ���� 3õ�� ");
		add(Textlabel2);

	

		nextbt = new JButton("ó������");
		nextbt.setBounds(300, 390, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		super("���̷������� ���¹�");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" �����߱���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,50);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>����ö<br>���ἱ ���̿����� ������ �������� 500m ����");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,80,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,105,460,70);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1.���̰˹��ҡ�46������ ��õ���氭�̻�Ÿ��氭�̱��氭�̷���<br>"
				+ "2. �ÿܹ����͹̳Ρ�88�������Ǿ��ͳΡ氭�̻�Ÿ��氭�̱��氭�̷���<br>"
				+ "3. ����IC�泲��õIC���Ǿ��ͳΡ氭�̻�Ÿ��氭�̱��氭�̷���");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,185,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/amusementparkmap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(15,210,310,250);
		imagelabel.setText(null);
		add(imagelabel);
		
		nextbt = new JButton("����");
		nextbt.setBounds(350, 330, 100, 30);
		nextbt.addActionListener(this);
		add(nextbt);
		
		backbt = new JButton("�ڷ�");
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
		Textlabel.setText("<html>���� �ִ� �Ը� �ڶ��ϴ� �ٸ���������, "
				+ "�� ���븸ŭ�̳� �ֺ������ �Ƹ��ٿ� ������ ��ҷ� �����ް� �ֽ��ϴ�. "
				+ "�����忡�� �踦 Ÿ�� ���� �����꿡 ��ġ�� ����ô� ������ û��縦 �湮�Ҽ� �ֽ��ϴ�.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/amusementpark.png");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(80,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt1 = new JButton("�ڼ���");
		detailpagebt1.setBounds(280,350,100,30);
		detailpagebt1.addActionListener(this);
		add(detailpagebt1);
		
		waypagebt1 = new JButton("��������");
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
