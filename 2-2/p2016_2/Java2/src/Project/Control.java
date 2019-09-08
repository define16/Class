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
	private final String filename = "직원전용.txt"; // 아이디와 비밀번호가 저장되 있는 파일
	public static String search[];
	
	JPanel panel1,panel2,panel3,panel,picpanel,empty;
	JLabel IDlabel,PWlabel,piclabel;
	JTextField IDtxt,PWtxt;
	JButton joinbt,backbt;
	
	public Control()
	{
		super("관리자전용");
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
		
		IDlabel = new JLabel("아이디 : ");
		IDlabel.setPreferredSize(new Dimension(90, 23));
		IDtxt = new JTextField(10);
		IDtxt.setPreferredSize(new Dimension(90, 23));
		PWlabel = new JLabel("비밀번호 : ");
		PWlabel.setPreferredSize(new Dimension(90, 23));
		PWtxt = new JTextField(10);
		PWtxt.setPreferredSize(new Dimension(90, 23));
		
		 joinbt = new JButton("확인");
		 joinbt.setBounds(60,10, 70, 33);
		 joinbt.addActionListener(this);
		 backbt = new JButton("뒤로");
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
				in = new BufferedReader(new FileReader(filename)); // 직원전용.txt파일을 읽어 드립니다.
				while((data=in.readLine())!=null)
				{
					String search[] = data.split("/"); 
					if(search[0].equals(IDtxt.getText()) && search[1].equals(PWtxt.getText()))
						{ // 첫번째 아이디 적힌 텍스트와 두번째 비밀번호가 적힌 텍스트가 같으면 로그인이 성공 됩니다.
							JOptionPane.showMessageDialog(null, "로그인 성공.");
						Control2 cl2 = new Control2();
							flag = false; // flag라는 변수를 이용해 만약 다른 아이디와 비밀번호가 생겼을 때 값이 일치하면 false을 내보내서 밑에
												//밑에 있는 if문을 비활성화 시킵니다.
							setVisible(false);
							break; }
				} in.close();	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(); }
			if(flag){
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 들렸습니다.");
			IDtxt.setText(""); PWtxt.setText(""); }
		} if(e.getSource() == backbt) {
			setVisible(false); // 다시 첫 번째 프레임으로 되돌아 갑니다.
			MainFrame mf = new MainFrame(); }
	}
}
