package jv18;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox [] fruits = new JCheckBox [3]; // üũ�ڽ� �迭
	String [] names = {"���", "��", "ü��"}; // üũ�ڽ� ���ڿ��� ����� ���ڿ� �迭
	JLabel sumLabel; // ��� ���� ����� ���̺�
	int sum = 0; // ������ ��
	
	CheckBoxItemEventEx() {
		setTitle("üũ�ڽ��� ItemEvent  ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());

		contentPane.add(new JLabel("���  100��, �� 500��, ü�� 20000��"));
		
		....

		
		setSize(250,200);
		setVisible(true);
	}
	
	// Item ������ ����
	class MyItemListener implements ItemListener {
		// üũ�ڽ��� ���� ���°� ���ϸ� itemStateChanged()�� ȣ���
		public void itemStateChanged(ItemEvent e) {


			...


		}
	}
	public static void main(String [] args) {
		new CheckBoxItemEventEx();
	}
} 