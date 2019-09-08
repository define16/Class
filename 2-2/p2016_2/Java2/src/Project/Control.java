package Project;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Control extends JFrame implements ActionListener {
	
	private BufferedReader in;
	private final String filename = "��������.txt"; // ���̵�� ��й�ȣ�� ����� �ִ� ����
	public static String search[];
	
	JPanel panel1,panel2,panel3,panel,picpanel,empty;
	JLabel IDlabel,PWlabel,piclabel;
	JTextField IDtxt,PWtxt;
	JButton joinbt,backbt;
	
	public Control()
	{
		super("����������");
		setSize(320,300);
		setLocation(200,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,240));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		picpanel = new JPanel();
		picpanel.setPreferredSize(new Dimension(300,100));
		picpanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		empty = new JPanel();
		empty.setPreferredSize(new Dimension(20,70));
		empty.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel1 = new JPanel();
		panel1.setPreferredSize(new Dimension(70,70));
		panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension(150,70));
		panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		piclabel = new JLabel();
		ImageIcon pic = new ImageIcon("src/image/controllogo.JPG");
		piclabel.setIcon(pic);
		
		panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension(300,70));
		panel3.setLayout(null);
		
		IDlabel = new JLabel("���̵� : ");
		IDlabel.setPreferredSize(new Dimension(90, 23));
		IDtxt = new JTextField(10);
		IDtxt.setPreferredSize(new Dimension(90, 23));
		PWlabel = new JLabel("��й�ȣ : ");
		PWlabel.setPreferredSize(new Dimension(90, 23));
		PWtxt = new JTextField(10);
		PWtxt.setPreferredSize(new Dimension(90, 23));
		
		 joinbt = new JButton("Ȯ��");
		 joinbt.setBounds(60,10, 70, 33);
		 joinbt.addActionListener(this);
		 backbt = new JButton("�ڷ�");
		 backbt.setBounds(160,10, 70, 33);
		 backbt.addActionListener(this);
		
		picpanel.add(piclabel);
		panel1.add(IDlabel); 
		panel1.add(PWlabel); 
		panel2.add(IDtxt);
		panel2.add(PWtxt); 
		panel3.add(joinbt); 
		panel3.add(backbt); 
		panel.add(picpanel);
		panel.add(empty);
		panel.add(panel1); 
		panel.add(panel2);
		panel.add(panel3);
		add(panel);
		setResizable(false);
		setVisible(true); 
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == joinbt)
		{
			String data = "";
			
			boolean flag = true;
			try {
				in = new BufferedReader(new FileReader(filename)); // ��������.txt������ �о� �帳�ϴ�.
				while((data=in.readLine())!=null)
				{
					String search[] = data.split("/"); 
					if(search[0].equals(IDtxt.getText()) && search[1].equals(PWtxt.getText()))
						{ // ù��° ���̵� ���� �ؽ�Ʈ�� �ι�° ��й�ȣ�� ���� �ؽ�Ʈ�� ������ �α����� ���� �˴ϴ�.
							JOptionPane.showMessageDialog(null, "�α��� ����.");
						Control2 cl2 = new Control2();
							flag = false; // flag��� ������ �̿��� ���� �ٸ� ���̵�� ��й�ȣ�� ������ �� ���� ��ġ�ϸ� false�� �������� �ؿ�
												//�ؿ� �ִ� if���� ��Ȱ��ȭ ��ŵ�ϴ�.
							setVisible(false);
							break; }
				} in.close();	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); }
			if(flag){
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� ��Ƚ��ϴ�.");
			IDtxt.setText(""); PWtxt.setText(""); }
		} if(e.getSource() == backbt) {
			setVisible(false); // �ٽ� ù ��° ���������� �ǵ��� ���ϴ�.
			MainFrame mf = new MainFrame(); }
	}
}
