import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class Control2 extends JFrame implements ActionListener {

	JButton backbt;
	private JTable infoArea;
	private final String filename = "visiterinfo.txt";

	
	public Control2()
	{
		super("관리자창");
		setSize(415,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		String data= "";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((data=in.readLine())!=null)
			{
				data.replace("/", "\t");
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String header[] = {"이름","나이","인원수"};
		String content[][];
		
		//System.out.println(info);
		infoArea = new JTable();
		infoArea.setBounds(10, 10, 380, 360);

		infoArea.setEnabled(false);
		add(infoArea);
		
		
		backbt = new JButton("메인화면으로");
		backbt.setBounds(50,400, 140, 33);
		backbt.addActionListener(this);
		add(backbt);
		
	    setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == backbt)
		{
			setVisible(false);
			MainFrame mf = new MainFrame(); 
		}
		
	}
}
