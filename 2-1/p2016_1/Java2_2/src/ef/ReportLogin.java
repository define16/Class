package ef;


import java.awt.*;
import javax.swing.*;
class ReportLogin extends JFrame {
	
	public ReportLogin() {
		JFrame frame = new JFrame("¾ó±¼");
        frame.setLocation(500, 200);
        frame.setPreferredSize(new Dimension(400, 400));
        Container contentPane = frame.getContentPane();
        CarDrawingPanel drawingPanel = new CarDrawingPanel();
        contentPane.add(drawingPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
	
	public void visible(boolean flag) {
		visible(flag);
	}
}

class CarDrawingPanel extends JPanel {
    public void paint(Graphics g)  {
    	g.clearRect(0, 0, getWidth(), getHeight());
       
        g.drawRect(40, 30, 300, 300);
        g.drawOval(80, 80, 50, 50);
        g.drawOval(250, 80, 50, 50);
        g.drawRect(170, 90, 40, 140);
        g.drawRect(90, 250, 200, 40);
        g.setColor(Color.GRAY);
        g.fillOval(100, 90, 30, 30);
        g.fillOval(250, 90, 30, 30);


     }
}