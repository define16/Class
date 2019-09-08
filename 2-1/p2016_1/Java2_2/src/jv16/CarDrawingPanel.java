package jv16;
import javax.swing.*;        

import java.awt.*;      

class CarDrawingPanel extends JPanel {
    public void paint(Graphics g)  {
    	g.clearRect(0, 0, getWidth(), getHeight());
       
        g.drawRect(100, 110, 200, 40);
        g.drawRect(150, 70, 100, 40);
        g.setColor(Color.RED);
        g.fillOval(125, 150, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(245, 150, 30, 30);
        g.drawLine(50, 180, 350, 180);
     }
}
