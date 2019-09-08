package excersie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CardLayoutTest1 implements ActionListener{
	 JButton btn1, btn2, btn3;
	 CardLayout cardLayoutSet;
	 JPanel cardPanel;
	 
	 public CardLayoutTest1(){}
	 
	 public Container panel1(){
	  JPanel panel = new JPanel();
	  JLabel label = new JLabel("1�� �г�");
	  panel.add(label);
	  return panel;
	 }
	 
	 public Container panel2(){
	  JPanel panel = new JPanel();
	  JLabel label = new JLabel("2�� �г�");
	  panel.add(label);
	  return panel;
	  
	 }
	 public Container panel3(){
	  JPanel panel = new JPanel();
	  JLabel label = new JLabel("3�� �г�");
	  panel.add(label);
	  return panel;
	 }
	 
	 public Container makeCardLayout(){
	  cardLayoutSet = new CardLayout();
	  cardPanel = new JPanel();
	  // �Ϲ� �г��� cardPanel�� ī�� ���̾ƿ��� cardLayoutSet���� �����Ͽ���
	  cardPanel.setLayout(cardLayoutSet);
	  CardLayoutTest1 test = new CardLayoutTest1();
	  // �̸��� ����
	  cardPanel.add("card1", test.panel1());
	  cardPanel.add("card2", test.panel2());
	  cardPanel.add("card3", test.panel3());
	  JPanel panel = new JPanel(new BorderLayout());
	  panel.add(cardPanel);
	  
	  btn1 = new JButton("����1");
	  btn2 = new JButton("����2");
	  btn3 = new JButton("����3");
	  JPanel buttonLayout = new JPanel(new BorderLayout());
	  buttonLayout.add(btn1, BorderLayout.LINE_START);
	  buttonLayout.add(btn2, BorderLayout.CENTER);
	  buttonLayout.add(btn3, BorderLayout.LINE_END);
	  btn1.addActionListener(this);
	  btn2.addActionListener(this);
	  btn3.addActionListener(this);
	  panel.add(buttonLayout, BorderLayout.PAGE_END);
	  
	  return panel;
	 }
	 
	 public void createFrame(){
	  JFrame frame = new JFrame("��ư���� �г� ����");
	  frame.setSize(300, 300);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.add(makeCardLayout());
	  frame.pack();
	  frame.setVisible(true);
	 }
	 
	 @Override
	 public void actionPerformed(ActionEvent e) {
	  // TODO Auto-generated method stub
	  // ī�� ���̾ƿ��� �θ� �����ϰ� ī�� ���̾ƿ����� ������ �ڽ��� �����ϰ�,
	  // �ڽ��� �ڽ��� �ҷ��� �г��� �̸��� ���´�
	  if(e.getSource() == btn1)
	   cardLayoutSet.show(cardPanel, "card1");
	  else if(e.getSource() == btn2)
	   cardLayoutSet.show(cardPanel, "card2");
	  else if(e.getSource() == btn3)
	   cardLayoutSet.show(cardPanel, "card3");;
	 }
	 
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  CardLayoutTest1 test = new CardLayoutTest1();
	  test.createFrame();
	 }
	}
