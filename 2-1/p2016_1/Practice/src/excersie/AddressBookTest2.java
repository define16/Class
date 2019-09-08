package excersie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel1 extends JPanel{
	
	 JLabel lb1;
	 JButton btn1, btn2;
	 
	 MyPanel1(){
	  lb1 = new JLabel("1번 패널");
	  add(lb1);  
	  btn1 = new JButton("1번");
	  add(btn1);
	  setBounds(0, 0, 200, 150);
	 }
	}
	class MyPanel2 extends JPanel{
	 JLabel lb2;
	 JButton btn1, btn2;
	 MyPanel2(){
	  lb2 = new JLabel("2번 패널");
	  btn1 = new JButton("1번");
	  add(btn1);
	  add(lb2);
	  setBounds(0, 0, 200, 150);
	 }
	}
	class MyFrame extends JFrame{
	 JPanel pnl1, pnl2, buttonPanel, pnlPanel;
	 JButton btn1, btn2;
	 
	 MyFrame(){
	  pnl1 = new MyPanel1();
	  pnl2 = new MyPanel2();
	  btn1 = new JButton("1번 패널");
	  btn2 = new JButton("2번 패널");
	  buttonPanel = new JPanel(new GridLayout(0,2));
	  
	  pnlPanel = new JPanel(null);
	  add(pnlPanel);
	  pnlPanel.add(pnl1);
	  pnlPanel.add(pnl2);
	  
	  add(buttonPanel, BorderLayout.SOUTH);
	  buttonPanel.add(btn1);
	  buttonPanel.add(btn2);
	  
	  btn1.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    pnl1.setVisible(true);
	    pnl2.setVisible(false);
	   }
	  });
	  btn2.addActionListener(new ActionListener() {  
	   public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    pnl1.setVisible(false);
	    pnl2.setVisible(true);
	   }
	  });
	  
	  setSize(200, 150);
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  setVisible(true);
	 }
	}
	public class AddressBookTest2{
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  new MyFrame();
	 }
	}