import javax.swing.*;
import java.awt.*;

public class GraphicsDrawImageEx1 extends JFrame {
	Container contentPane;
	GraphicsDrawImageEx1() {
		setTitle("drawImage 사용  예제 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		MyPanel panel = new MyPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		setSize(300, 400);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		.....

		}	
	}
	
	public static void main(String [] args) {
		new GraphicsDrawImageEx1();
	}
} 