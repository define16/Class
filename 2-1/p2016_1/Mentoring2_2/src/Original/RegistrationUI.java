package Original;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistrationUI extends JFrame implements WindowListener, ActionListener, MouseListener {

	private JButton okBtn, cBtn, dBtn;
	private JLabel title, nameL, stuL, genL, ageL;
	private JTextField name, studentID, age;
	private JRadioButton male, female;
	private mainUI mainUI;
	
	private PrintWriter out;
	private BufferedReader in;
	private final String filename = "studentinfo.txt";
	private File file;

	public RegistrationUI(mainUI mainUI)
	{
		super("회원등록");
		setSize(400,380);
		setLocation(400,300);
		setLayout(null);
		ButtonGroup bG = new ButtonGroup();
		title = new JLabel("회원등록");
		title.setBounds(180, 30, 60, 30);
		add(title);

		nameL = new JLabel("이름");
		nameL.setBounds(80, 90, 60, 30);
		add(nameL);

		name = new JTextField();
		name.setBounds(130, 90, 120, 30);
		add(name);

		stuL = new JLabel("학번");
		stuL.setBounds(80, 140, 60, 30);
		add(stuL);

		studentID = new JTextField();
		studentID.setBounds(130, 140, 120, 30);
		studentID.addMouseListener(this);
		add(studentID);

		dBtn = new JButton("중복 확인");
		dBtn.setBounds(275, 140, 90, 30);
		dBtn.addActionListener(this);
		add(dBtn);

		genL = new JLabel("성별");
		genL.setBounds(80, 180, 60, 30);
		add(genL);

		male = new JRadioButton("남성");
		male.setBounds(130, 180, 60, 30);
		add(male);
		bG.add(male);

		female = new JRadioButton("여성");
		female.setBounds(200, 180, 60, 30);
		add(female);
		bG.add(female);

		ageL = new JLabel("나이");
		ageL.setBounds(80, 220, 60, 30);
		add(ageL);

		age = new JTextField();
		age.setBounds(130, 220, 120, 30);
		add(age);



		okBtn = new JButton("확인");
		okBtn.setBounds(100, 280, 80, 30);
		okBtn.addActionListener(this);
		add(okBtn);


		cBtn = new JButton("취소");
		cBtn.setBounds(200, 280, 80, 30);
		cBtn.addActionListener(this);
		add(cBtn);

		file = new File(filename);
		this.mainUI = mainUI;
		setResizable(false);
		setVisible(false);			
		addWindowListener(this);

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		mainUI.setVisible(true);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == dBtn)
		{
			if(studentID.equals(""))
			{
				JOptionPane.showMessageDialog(null, "학번을 입력하세요");
			}
			if(!file.exists())
			{
				JOptionPane.showMessageDialog(null, "어떠한 정보도 가지고있지 않습니다.");
				okBtn.setEnabled(true);
			}else
			{
				String data = "";
				boolean flag = true;
				try {
					in = new BufferedReader(new FileReader(filename));
					while((data=in.readLine())!=null)
					{
						String search[] = data.split("/");
						if(search[1].equals(studentID.getText()))
						{
							JOptionPane.showMessageDialog(null, "중복된 학번 입니다.");
							in.close();
							flag = false;
							break;
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag)
				{

					JOptionPane.showMessageDialog(null, "등록이 가능한 학번 입니다.");
					okBtn.setEnabled(true);
				}
			}
		}

		if(e.getSource() == okBtn)
		{
			try {
				this.out = new PrintWriter(new FileWriter(filename, true));
				if(male.isSelected()){
					out.println(name.getText()+"/"+studentID.getText()+"/"+male.getText()+"/"+age.getText());
				}else
				{
					out.println(name.getText()+"/"+studentID.getText()+"/"+female.getText()+"/"+age.getText());
				}
				out.flush();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "회원 등록을 환영합니다!!");
			setVisible(false);
			mainUI.visible(true);
		}

		if(e.getSource() == cBtn)
		{
			setVisible(false);
			mainUI.visible(true);
		}

	}

	public void init()
	{
		//name, studentID, age;
		name.setText("");
		studentID.setText("");
		age.setText("");
		male.setSelected(true);
		female.setSelected(false);		
		okBtn.setEnabled(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == studentID)
		{
			if(studentID.getText().equals(""))
			{
				okBtn.setEnabled(false);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}