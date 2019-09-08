import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RadioButtonItemEventEx extends JFrame {
	Container contentPane;
	JRadioButton [] radio = new JRadioButton [3];// 라디오버튼 배열
	String [] text = {"사과", "배", "체리"}; // 라디오버튼의 문자열
	ImageIcon [] image = {  // 이미지 객체 배열
			new ImageIcon("images/apple.jpg"), 
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")};
	JLabel imageLabel = new JLabel(); // 이미지가 출력될 레이블 컴포넌트
	
	RadioButtonItemEventEx() {
		setTitle("라디오버튼 Item Event 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		.....

		
		setSize(250,200);		
		setVisible(true);
	}
	
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {

			......


		}
	}
	
	public static void main(String [] args) {
		new RadioButtonItemEventEx();
	}
} 




