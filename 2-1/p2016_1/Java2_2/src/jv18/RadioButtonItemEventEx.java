import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RadioButtonItemEventEx extends JFrame {
	Container contentPane;
	JRadioButton [] radio = new JRadioButton [3];// ������ư �迭
	String [] text = {"���", "��", "ü��"}; // ������ư�� ���ڿ�
	ImageIcon [] image = {  // �̹��� ��ü �迭
			new ImageIcon("images/apple.jpg"), 
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")};
	JLabel imageLabel = new JLabel(); // �̹����� ��µ� ���̺� ������Ʈ
	
	RadioButtonItemEventEx() {
		setTitle("������ư Item Event ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		.....

		
		setSize(250,200);		
		setVisible(true);
	}
	
	// Item ������ ����
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			......


		}
	}
	
	public static void main(String [] args) {
		new RadioButtonItemEventEx();
	}
} 




