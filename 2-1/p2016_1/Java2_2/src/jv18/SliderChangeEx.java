import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class SliderChangeEx extends JFrame {
	Container contentPane;	
	JLabel colorLabel;
	JSlider [] sl = new JSlider [3]; // 3���� �����̴� �迭 ����
	SliderChangeEx() {
		setTitle("�����̴��� ChangeEvent ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());		

		colorLabel = new JLabel("        SLIDER EXAMPLE        ");
		

		// �����̴��� 3 �� �����ϰ� ����� �����Ѵ�.



		....

		
		contentPane.add(colorLabel);		
		setSize(300,230);
		setVisible(true);
	}

	// Change ������ ����
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) { //�����̴� ������Ʈ�� ���� ����Ǹ� ȣ���

			...

		}
	}
	public static void main(String [] args) {
		new SliderChangeEx();
	}
} 




