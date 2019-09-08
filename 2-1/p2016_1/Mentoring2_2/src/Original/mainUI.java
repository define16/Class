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
		super("ȸ�� ����"); //Title bar �̸�
		setSize(300,400); //â ũ��
		setLocation(400,300); //â�� ��ġ
		setLayout(null); //���̾ƿ� ����
		
		tLabel = new JLabel("ȸ�� ����");
		tLabel.setBounds(120, 30, 200, 30);
		add(tLabel);
		
		rBtn = new JButton("1. ȸ�����");
		rBtn.setBounds(100, 80, 100, 30);
		rBtn.addActionListener(this);
		add(rBtn);
		
		mBtn = new JButton("2. ȸ������");
		mBtn.setBounds(100, 130, 100, 30);
		mBtn.addActionListener(this);
		add(mBtn);
		
		sBtn = new JButton("3. ȸ���˻�");
		sBtn.setBounds(100, 180, 100, 30);
		sBtn.addActionListener(this);
		add(sBtn);
		
		dBtn = new JButton("4. ȸ������");
		dBtn.setBounds(100, 230, 100, 30);
		dBtn.addActionListener(this);
		add(dBtn);
		
		pBtn = new JButton("5. ȸ�����");
		pBtn.setBounds(100, 280, 100, 30);
		pBtn.addActionListener(this);
		add(pBtn);
		
		rUI = new RegistrationUI(this);

		setResizable(false); //â ũ�� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //X��ư ������ ����
		setVisible(true);//ȭ�� ����
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