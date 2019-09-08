package jv15;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class WindowExample{
	public static void main(String[] args){
		JFrame frame = new JFrame("Hello K.E");
		frame.setPreferredSize(new Dimension(200, 80));
		frame.setLocation(500,400);
		Container contentPane = frame.getContentPane();
		JTextField text = new  JTextField();
		JButton button = new JButton("»Æ¿Œ");
		JLabel label = new JLabel("Hello");
		contentPane.add(text, BorderLayout.CENTER);
		contentPane.add(button, BorderLayout.EAST);
		contentPane.add(label, BorderLayout.SOUTH);

		ActionListener listener=new ConfirmButtonActionListener(text, label);
		button.addActionListener(listener);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}

class ConfirmButtonActionListener implements ActionListener{
		JTextField text;
		JLabel label;

	
		ConfirmButtonActionListener(JTextField text, JLabel label){
			this.text = text;
			this.label= label;
		}

		public void actionPerformed(ActionEvent e){
			String name = text.getText();
			label.setText("Hello, " + name);
		}
}
