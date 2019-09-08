package Self;

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


public class RegistrationUI extends JFrame implements ActionListener, WindowListener, MouseListener{
	private JButton okBtn,cBtn,dBtn;
	private MainUI mainUI;
	private JLabel title, name,studentID,gender,age;
	private JTextField namefield,sIDfield,genderfield, agefield;
	private JRadioButton male,female;
	private PrintWriter out;
	private BufferedReader in;
	private final String filename = "studentinfo.txt";
	private File file;

	public RegistrationUI(MainUI mainUI){
		super("회원등록");
		setSize(500,500);
		setLocation(400,300);
		setLayout(null);
		ButtonGroup bG = new ButtonGroup();
		title = new JLabel("회원등록");
		title.setBounds(180,30,60,30);
		add(title);

		name = new JLabel("이름");
		name.setBounds(80,90,60,30);
		add(name);

		namefield = new JTextField();
		namefield.setBounds(130,90,120,30);
		add(namefield);


		studentID = new JLabel("학번");
		studentID.setBounds(80,140,60,30);
		add(studentID);

		sIDfield = new JTextField();
		sIDfield.setBounds(130,140,120,30);
		add(sIDfield);

		dBtn = new JButton("중복 확인");
		dBtn.setBounds(275,140,90,30);
		dBtn.addActionListener(this);
		add(dBtn);

		gender = new JLabel("성별");
		gender.setBounds(80,180,60,30);
		add(gender);

		male = new JRadioButton("남자");
		male.setBounds(130,180,60,30);
		add(male);
		bG.add(male);

		female = new JRadioButton("여성");
		female.setBounds(200,180,60,30);
		add(female);
		bG.add(female);
	
		age = new JLabel("나이");
		age.setBounds(80,220,60,30);
		add(age);

		agefield = new JTextField();
		agefield.setBounds(130,220,120,30);
		add(agefield);

		okBtn = new JButton("OK");
		okBtn.setBounds(100,280,80,30);
		okBtn.addActionListener(this);
		add(okBtn);	

		cBtn = new JButton("Cancel");
		cBtn.setBounds(200,280,80,30);
		cBtn.addActionListener(this);
		add(cBtn);	

		file = new File(filename);
		this.mainUI = mainUI;

		this.mainUI = mainUI;
		setResizable(false);
		setVisible(false);
		addWindowListener(this);

		setResizable(false);

	}

	public void visible(boolean flag)
	{
		setVisible(flag);
	}

	public void init()
	{
		namefield.setText("");
		sIDfield.setText("");
		agefield.setText("");
		male.setSelected(true);
		female.setSelected(false);
		okBtn.setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == dBtn)
		{

			if(sIDfield.getText().equals(""))
				JOptionPane.showMessageDialog(null,"학번을 입력하세요");
			if(!file.exists())
			{
				JOptionPane.showMessageDialog(null,"어떠한 정보도 가지고 있지 않습니다.");
				okBtn.setEnabled(true);
			}else
			{
				String data = "";
				boolean flag = true;

				try {
					in = new BufferedReader(new FileReader(filename));
					while((data = in.readLine()) != null)
					{
						String search[] = data.split("/");
						if(search[1].equals(sIDfield.getText()));
						{
							JOptionPane.showMessageDialog(null,"중복된 학번 입니다.");
							in.close();
							flag = false;
							break;
						}
					}
				} catch (IOException e1) {
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
				this.out = new PrintWriter(new FileWriter(filename,true));
				if(male.isSelected()){
					out.println(namefield.getText() + "/" + sIDfield.getText() + "/" + male.getText() + "/" + agefield.getText());
				}
				else
				{
					out.println(namefield.getText() + "/" + sIDfield.getText() + "/" + female.getText() + "/" + agefield.getText());
				}
				out.flush();
				out.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			JOptionPane.showMessageDialog(null,"회원 등록을 환영합니다!!");
			setVisible(false);
			mainUI.visible(true);
		}
		if(e.getSource() == cBtn)
		{
			setVisible(false);
			mainUI.visible(true);
		}

	}


	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		mainUI.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		visible(false);
		this.mainUI.visible(true);

	}

	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == sIDfield)
		{
			if(sIDfield.getText().equals(""))
			{
				okBtn.setEnabled(false);
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
