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
		super("����/�ܿ� ����������"); //�������ũ,���̽�Ű��
		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ���������ũ");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html>������������ ���ߵǾ� ������̳� ��ۿ����� ����� �Ͽ�����"
				+ "���� ������������ �����Ͽ� �ܱ��� ��� ��Ը��� ATV��ȸ���� ������ �ֽ��ϴ�. "
				+ "���α������ ����� �з��Ǿ� ���������� �� �� ���ٴ°� ���������� ������ �����ϰ�"
				+ "���������� ������ �ٷ� ž���� �����ϱ� ������ ATV�� �ŷ��� ������ �� �ֽ��ϴ�."
				+ "��� �ȳ� : 1�ð� : 2���� ,2�ð� : 2��5õ��, 3�ð� : 3����");
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
		
		titlelabel2 = new JLabel(" �����̿����þȽ�Ű��");
		titlelabel2.setBounds(10,290,160,30);
		add(titlelabel2);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>��Ű�� �����ð� <br> �ְ�� : 9~17��30�� / �����ð� : 17��30��~19�� "
				+ " <br> �߰�� : 19~24�� / �ɾ߿ : 22~4�� <br> ����� <br>4�ð� : ����-5��4õ��,���� 3��7õ��  "
				+ " <br> 6�ð� : ����-6��4õ��, ����-4��4õ��  <br> 8�ð� : ����-7��4õ��,����-5��1õ�� <br>"
				+ "�߰� : ����-6����,����-4��2õ��(19~24��) <br> �ɾ� : ����-5����,����-3��5õ��(22~4��) <br> "
				+ "��� : ����-4����,����-2��8õ��(24~4��)");
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
		
				Leisuresummer ls = new Leisuresummer();

		}
		
	}
}

class Leisuresummer  extends JFrame implements ActionListener{

	JLabel titlelabel1,titlelabel2,titlelabel3,Textlabel1,Textlabel2,imagelabel1,imagelabel2;
	JButton nextbt, backbt;
	
	public Leisuresummer(){
		super("���� ����������"); //��Ʈ��Ű �ٳ�����Ʈ �������� ���̺�� ��� �뷫���� ����ǥ ���

		setSize(510,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		titlelabel1 = new JLabel(" ������Ű & ����ũ����");
		titlelabel1.setBounds(10,5,160,30);
		add(titlelabel1);
		
		Textlabel1 = new JLabel();
		Textlabel1.setBounds(10,30,475,100);
		Textlabel1.setBackground(Color.white);
		EtchedBorder eborder=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel1.setBorder(eborder);
		Textlabel1.setText("<html> ����Ű�� ���ͺ��忡 �޸� ���� ��� ��Ʈ�� �̲������鼭 ������ �޷�����"
				+ "���ǵ带 ���� �������Դϴ�. ����ũ���嵵 ���������� ����Ű�� �Ŵ� ��ſ� ����ũ���带 Ÿ�� "
				+ "����� �پ��� ����� �����ϴ� ������ �Դϴ�."
				+ "��� �ȳ� : 1ȸ ���� : 2����(���� ������), �������Խ� 1ȸ ���� : 4��5õ�� ");
		add(Textlabel1);
	
		imagelabel1 = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/Leisure4.png");
		imagelabel1.setIcon(damjpg);
		imagelabel1.setBounds(90,115,310,200);
		imagelabel1.setText(null);
		add(imagelabel1);
		
	
		
		titlelabel3 = new JLabel(" ���ٳ�����Ʈ & �����ẸƮ & �ö��� �ǽ�");
		titlelabel3.setBounds(10,290,300,30);
		add(titlelabel3);
	
		
		Textlabel2 = new JLabel();
		Textlabel2.setBounds(10,315,320,200);
		Textlabel2.setBackground(Color.white);
		EtchedBorder eborder2=new EtchedBorder(EtchedBorder.RAISED);
		Textlabel2.setBorder(eborder2);
		Textlabel2.setText("<html>1. �ٳ�����Ʈ : �ٳ��� ����� ��Ʈ�� ���ͺ�Ʈ�� �̿��Ͽ� �������� �޸��� ������"
				+ "����Ű�� �������� ���ĳ��� ���� �����������Դϴ�.<br> �ݾȳ� : 1ȸ - 1���� (5���̻� �Ⱦ�����)<br> "
				+ "�����ẸƮ ���� ���� ��Ʈ�� Ÿ�� ����̳� ���� �޷��� Ÿ�� ���������� �Դϴ�.<br>��ݾȳ� :"
				+ " 1ȸ-1��5õ�� <br> �ö��� �ǽ� : ��Ʈ�� ���ͺ�Ʈ�� �����ѵ� ��ó�� �ϴÿ� �� �� �ִ� ���������� �Դϴ�."
				+ "<br> ��ݾȳ� : 1ȸ-1��5õ��");
		add(Textlabel2);
		
		
		nextbt = new JButton("����");
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
		Textlabel.setText("<html>���̿��� 4������ũ�� Ż �� �ִ� �ڽ��� ���� �Ǿ� �ְ� ���Ѱ��� ���� ������� "
				+ "�������� ������������ ��� �� �ִ� ���� ���� �Ǿ��ֽ��ϴ�. �ٳ�����Ʈ���� ����Ű���� "
				+ "Ż �� �ְ� �ܿ￡�� ��Ű�忡�� ��Ű�� ���带 ��� �� �� �ֽ��ϴ�.<br>");
		add(Textlabel);
		
		
		imagelabel = new JLabel();
		ImageIcon damjpg = new ImageIcon("src/image/Leisure.JPG");
		imagelabel.setIcon(damjpg);
		imagelabel.setBounds(75,105,450,250);
		imagelabel.setText(null);
		add(imagelabel);
	

		detailpagebt3 = new JButton("����/�ܿ�");
		detailpagebt3.setBounds(280,350,100,30);
		detailpagebt3.addActionListener(this);
		add(detailpagebt3);
		
		summerbt = new JButton("����");
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

