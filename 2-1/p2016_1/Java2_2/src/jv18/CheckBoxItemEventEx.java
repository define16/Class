package jv18;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox [] fruits = new JCheckBox [3]; // 체크박스 배열
	String [] names = {"사과", "배", "체리"}; // 체크박스 문자열로 사용할 문자열 배열
	JLabel sumLabel; // 계산 합을 출력할 레이블
	int sum = 0; // 가격의 합
	
	CheckBoxItemEventEx() {
		setTitle("체크박스와 ItemEvent  예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("사과  100원, 배 500원, 체리 20000원"));
		
		....

		
		setSize(250,200);
		setVisible(true);
	}
	
	// Item 리스너 구현
	class MyItemListener implements ItemListener {
		// 체크박스의 선택 상태가 변하면 itemStateChanged()가 호출됨
		public void itemStateChanged(ItemEvent e) {


			...


		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 