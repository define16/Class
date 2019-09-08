import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


class Damdetail extends JFrame implements ActionListener{
	
	JLabel titlelabel1,titlelabel2,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public Damdetail(){
		super("�Ҿ簭 �� �ֺ� ������");
		setSize(500,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ���Ȱ���");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,190,200);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>����ð�<br> ������(12~2��) - 10~16�� <br> ������(3~11��) - 10~17��<br> "
				+ "�츮���� �ִ��� �ٸ������� <br>�Ҿ簭�� ������ �ɾ �Ȱ��� <br>��������� �պ� �� �� �ֽ��ϴ�.");
		add(Textlabel1);
		
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dam2.JPG");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(205,35,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
		titlelabel2 = new JLabel(" ��û���");
		titlelabel2.setBounds(10,235,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,270,460,70);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html> �������� �°��� â���ϰ� ��ϼ����̶� �̸��� �������� ���� �� ���� û���� "
				+ "�̸��� �ٲ��. ���� û���� ���� ���� ��164ȣ�� û��� ȸ������ �ض��������� �ִ�.");
		add(Textlabel2);

		imagelabel2 = new JLabel();
		ImageIcon damjpg2 = new ImageIcon("src/image/dam3.JPG");
		imagelabel2.setIcon(damjpg2);
		imagelabel2.setBounds(10,330,310,200);
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

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == nextbt)
		{
			setVisible(false);  // �� ���������� �ǵ��� ���� ��ư�Դϴ�.
		}
		if(e.getSource() == backbt)
		{
			setVisible(false);
			Damway dw = new Damway(); //���������� ���������� ���� ��ư�Դϴ�.
		}
		
	}
}

class Damway  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel;
	JButton nextbt, backbt;
	
	public Damway(){
		super("�Ҿ簭 ������ ���¹�");
		setSize(500,520);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ���ó�����");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,35,460,20);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>11��,12��,150�� ����<br>");
		add(Textlabel1);
		
		titlelabel2 = new JLabel(" ���ڰ���");
		titlelabel2.setBounds(10,55,160,30);
		add(titlelabel2);
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,80,460,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. ���̻�Ÿ����Ǿ��ͳΡ���õ����ȭõ��� 5�� ��������2�Ҿ米��"
				+ "�籸��� ��ȸ�����λ��Ÿ�(���ž)�������.�籸��� ��ȸ��������3����"
				+ "�Ҿ簭�� �Ա� ������(��õ��-12km-�Ҿ��)<br><br> 2. ���̻�Ÿ����Ǿϴ뱳���Ǿ��ͳΡ�"
				+ "�ȹ̸� I.C���ȸ������ ���� -���� ������ ��Ÿ������ȸ����200m���ȸ����"
				+ "�Ҿ簭�� �� ��������Ҿ簭�� �Ա� ������<br><br>"
				+ "3. ��õIC��ŵ�������ݴ���Ÿ��游õJC��õ����Ÿ������ֱ׷�������Ʈ��Ҿ�ȣ<br>");
		add(Textlabel2);
		
		
		titlelabel3 = new JLabel(" ���൵");
		titlelabel3.setBounds(10,275,80,30);
		add(titlelabel3);
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dammap.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(10,285,310,200);
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
			Damdetail dd = new Damdetail(); // �Ҿ簭 �� �ֺ�
		}
		if(e.getSource() == backbt)
		{
			setVisible(false); // �� ���������� �ǵ��� ���� ��ư�Դϴ�.
		}
	}
	
}


public class Dam extends JPanel implements ActionListener{
	//�� ��° �����ӿ� ������ �г��Դϴ�.
	
	JLabel Textlabel,imagelabel;
	JButton detailpagebt1,waypagebt1;
	
	
	public Dam()
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
		// �Ҿ簭 �￡ ���� �����Դϴ�.
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/dam.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(80,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt1 = new JButton("�ڼ���");
		detailpagebt1.setBounds(280,350,100,30);
		detailpagebt1.addActionListener(this);
		add(detailpagebt1); // �Ҿ簭 �� ��ó�� ������Ҹ� �˷��ִ� ��ư�Դϴ�.
		
		waypagebt1 = new JButton("��������");
		waypagebt1.setBounds(100,350,100,30);
		waypagebt1.addActionListener(this);
		add(waypagebt1); //�Ҿ簭���� �� �� �ִ� ����� �Ұ��ϴ� ��ư�Դϴ�.


	}
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
		// TODO Auto-generated method stub
		
		if(arg1.getSource() == detailpagebt1)
		{
			setVisible(false);
			Damdetail dd = new Damdetail();
		}
		
		if(arg1.getSource() == waypagebt1)
		{
			setVisible(false);
			Damway dw = new Damway();
		}
		
		
	}
}


