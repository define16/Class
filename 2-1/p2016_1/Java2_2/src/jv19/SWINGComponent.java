package jv19;

import java.awt.event.*;
import javax.swing.*;

public class SWINGComponent extends JFrame implements ActionListener{
  SWINGComponent(String title){
    super(title);
    JMenuBar mb = new JMenuBar();
    JMenu fileMenu = new JMenu("����");
    fileMenu.add(new JMenuItem("����"));
    fileMenu.add(new JMenuItem("����"));
    fileMenu.addSeparator();
    fileMenu.add(new JMenuItem("�μ�"));
    fileMenu.addSeparator();
    JMenuItem exitMenu = new JMenuItem("����");
    fileMenu.add(exitMenu);
    exitMenu.setActionCommand("����");
    exitMenu.addActionListener(this);
    mb.add(fileMenu);
    setJMenuBar(mb);
    
    JButton b = new JButton("����");
    getContentPane().add(b, "South");
    b.addActionListener(this);
    
    JTextArea ta = new JTextArea();
    getContentPane().add(ta, "Center");
    ta.setText("JMenuBar, JMenu, JMenuItem, \n"
    + " JButton, JTextArea �� \n" 
    + " SWING ������Ʈ�� ������ ���α׷��Դϴ�.");
  }
  
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(cmd.equals("����")) System.exit(0);
  }
  
  public static void main(String args[]){
    SWINGComponent f = new SWINGComponent("SWING ���α׷�");
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
