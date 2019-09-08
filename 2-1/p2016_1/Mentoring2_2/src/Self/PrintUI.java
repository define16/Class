package Self;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PrintUI extends JFrame implements WindowListener {
	private JTextArea infoArea;
	private final String filename = "studentinfo.txt";
	private MainUI mainUI;
	
	public PrintUI(MainUI mainUI)
	{
		super("���� ����");
		setSize(400,380);
		setLocation(400, 300);
		setLayout(null);
		
		String data = "";
		String info = "	�̸�\t	�й�\t����\t����\n";
		File file = new File(filename);
		
		if(!file.exists())
		{
			JOptionPane.showMessageDialog(null,"������ �����ϴ�!!");
		}
		try{
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((data = in.readLine()) != null)
			{
				info += data.replace("/","\t")+"\n";
			}
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(info);
		infoArea = new JTextArea(info);
		infoArea.setBounds(10,100,380,360);
		infoArea.setBackground(new Color(0,0,0));
		add(infoArea);
		infoArea.setEnabled(false);
		
		this.mainUI = mainUI;
		
		addWindowListener(this);
		
		setResizable(false);
		setVisible(true);
	}
	public void init()
	{
		infoArea.setText("");
	}



	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
	}

	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
}
