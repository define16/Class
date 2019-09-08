package Self;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MainUI extends JFrame implements ActionListener {
	
	private RegistrationUI rUI;
	private JButton rBtn,mBtn,sBtn,dBtn,pBtn;
	private JLabel tLabel;
	private PrintUI pui;
	
	public MainUI()
	{
		super("ȸ�� ����");
		setSize(300,400);
		setLocation(400,300);
		setLayout(null);
		
		tLabel = new JLabel("ȸ������");
		tLabel.setBounds(100,10,100,15);
		add(tLabel);
		
		rBtn = new JButton("1. ȸ�����");
		rBtn.setBounds(100,60,100,30);
		rBtn.addActionListener(this);
		add(rBtn);
		
		sBtn = new JButton("3. ȸ���˻�");
		sBtn.setBounds(100,100,100,30);
		sBtn.addActionListener(this);
		add(sBtn);

		dBtn = new JButton("4. ȸ������");
		dBtn.setBounds(100,140,100,30);
		dBtn.addActionListener(this);
		add(dBtn);
		

		pBtn = new JButton("5. ȸ�����");
		pBtn.setBounds(100,180,100,30);
		pBtn.addActionListener(this);
		add(pBtn);
		
		rUI = new RegistrationUI(this);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}

	public void visible(boolean flag)
	{
		setVisible(flag);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == rBtn)
		{
			setVisible(false);
			rUI.init();
			rUI.visible(true);
		}
		
		if(e.getSource() == mBtn)
		{
		}
		
		if(e.getSource() == sBtn)
		{
			pui = new PrintUI(this);
			pui.setVisible(true);
		}
			
		
	}
	
	
}
