package jv11;

import java.awt.*;
import javax.swing.*;


class TestF extends JFrame{
	public TestF(){
		setSize(500,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׽�Ʈ ������");
		JPanel panel = new JPanel();
		JLabel label = new JLabel("�ڹٴ� ����ֳ���?");
		JButton button1 = new JButton("Yes");
		JButton button2 = new JButton("No");
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		add(panel);
		setVisible(true);
	}
}
public class TestFrame{
	public static void main(String[] args){
		TestF f = new TestF();
	}
}
