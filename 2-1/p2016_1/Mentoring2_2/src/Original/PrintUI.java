package Original;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class PrintUI extends JFrame implements WindowListener{
	private JTextArea infoArea;
	private final String filename = "studentinfo.txt";
	private mainUI mainUI;
	
	public PrintUI(mainUI mainUI)
	{
		super("가입 정보");
		setSize(400,380);
		setLocation(400,300);
		setLayout(null);
		
		String data = "";
		String info = "이름\t학번\t성별\t나이\n";
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			while((data=in.readLine())!=null)
			{
				info += data.replace("/", "\t")+"\n";
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println(info);
		infoArea = new JTextArea(info);
		infoArea.setBounds(10, 10, 380, 360);
		add(infoArea);
		infoArea.setEnabled(false);
		
		this.mainUI = mainUI;
		
		addWindowListener(this);
		
		setResizable(false);
		setVisible(false);
	}
	
	public void init()
	{
		infoArea.setText("");
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
}
