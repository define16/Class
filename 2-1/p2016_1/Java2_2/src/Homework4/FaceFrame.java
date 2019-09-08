package Homework4;

import java.awt.Dimension;

import javax.swing.JFrame;

public class FaceFrame extends JFrame
{
	public FaceFrame()
	{
		
		Face f = new Face();
		setTitle("로그인완료");
		setPreferredSize(new Dimension(420, 320));
		
		add(f);
	
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
