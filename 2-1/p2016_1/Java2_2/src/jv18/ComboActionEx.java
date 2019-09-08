import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ComboActionEx extends JFrame {
	Container contentPane;
	String [] fruits = {"apple", "banana", "kiwi", "mango"}; // 콤보박스의 아이템
	ImageIcon [] images = { // 이미지 객체 배열
			new ImageIcon("images/apple.jpg"),
			new ImageIcon("images/banana.jpg"),
			new ImageIcon("images/kiwi.jpg"),
			new ImageIcon("images/mango.jpg")};
	JLabel imgLabel = new JLabel(images[0]); // 이미지 레이블 컴포넌트 생성
	
	ComboActionEx() {
		setTitle("콤보박스 활용  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());


		....

		
		setSize(300,250);
		setVisible(true);
	}
	
	public static void main(String [] args) {
		new ComboActionEx();
	}
} 




