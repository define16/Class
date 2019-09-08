package Homework4;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Face extends JPanel{
	
	public void paint(Graphics g)
	{
        g.drawRect(70, 20, 250, 250);
        g.fillOval(130, 70, 30, 30);
        g.fillOval(230, 70, 30, 30);
        g.drawOval(210, 50, 70, 70);
        g.drawOval(110, 50, 70, 70);
        g.drawRect(180, 110, 30, 80);
        g.drawOval(147, 205, 100, 50);
        g.setColor(Color.RED);
        g.fillOval(171, 235, 50, 20);
       
	}
}
