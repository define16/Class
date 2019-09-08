package Original;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainUI extends JFrame implements ActionListener{
	
	private RegistrationUI rUI;
	private PrintUI pUI;
	private JButton rBtn, mBtn, sBtn, dBtn, pBtn;
	private JLabel tLabel;
	
	public mainUI()
	{
		super("회원 관리"); //Title bar 이름
		setSize(300,400); //창 크기
		setLocation(400,300); //창의 위치
		setLayout(null); //레이아웃 설정
		
		tLabel = new JLabel("회원 관리");
		tLabel.setBounds(120, 30, 200, 30);
		add(tLabel);
		
		rBtn = new JButton("1. 회원등록");
		rBtn.setBounds(100, 80, 100, 30);
		rBtn.addActionListener(this);
		add(rBtn);
		
		mBtn = new JButton("2. 회원수정");
		mBtn.setBounds(100, 130, 100, 30);
		mBtn.addActionListener(this);
		add(mBtn);
		
		sBtn = new JButton("3. 회원검색");
		sBtn.setBounds(100, 180, 100, 30);
		sBtn.addActionListener(this);
		add(sBtn);
		
		dBtn = new JButton("4. 회원삭제");
		dBtn.setBounds(100, 230, 100, 30);
		dBtn.addActionListener(this);
		add(dBtn);
		
		pBtn = new JButton("5. 회원출력");
		pBtn.setBounds(100, 280, 100, 30);
		pBtn.addActionListener(this);
		add(pBtn);
		
		rUI = new RegistrationUI(this);

		setResizable(false); //창 크기 조절
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X버튼 누를시 종료
		setVisible(true);//화면 띄우기
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rBtn)
		{
			setVisible(false);
			rUI.init();
			rUI.setVisible(true);
		}
		if(e.getSource() == mBtn)
		{
			
		}
		if(e.getSource() == sBtn)
		{
			
		}
		if(e.getSource() == dBtn)
		{
			
		}
		if(e.getSource() == pBtn)
		{
			pUI = new PrintUI(this);
			pUI.setVisible(true);
		}
	}
	public void visible(boolean flag)
	{
		setVisible(flag);
	}
}