package jv19;

import java.awt.event.*;
import javax.swing.*;

public class SWINGComponent extends JFrame implements ActionListener{
  SWINGComponent(String title){
    super(title);
    JMenuBar mb = new JMenuBar();
    JMenu fileMenu = new JMenu("파일");
    fileMenu.add(new JMenuItem("열기"));
    fileMenu.add(new JMenuItem("저장"));
    fileMenu.addSeparator();
    fileMenu.add(new JMenuItem("인쇄"));
    fileMenu.addSeparator();
    JMenuItem exitMenu = new JMenuItem("종료");
    fileMenu.add(exitMenu);
    exitMenu.setActionCommand("종료");
    exitMenu.addActionListener(this);
    mb.add(fileMenu);
    setJMenuBar(mb);
    
    JButton b = new JButton("종료");
    getContentPane().add(b, "South");
    b.addActionListener(this);
    
    JTextArea ta = new JTextArea();
    getContentPane().add(ta, "Center");
    ta.setText("JMenuBar, JMenu, JMenuItem, \n"
    + " JButton, JTextArea 등 \n" 
    + " SWING 컴포넌트로 변경한 프로그램입니다.");
  }
  
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(cmd.equals("종료")) System.exit(0);
  }
  
  public static void main(String args[]){
    SWINGComponent f = new SWINGComponent("SWING 프로그램");
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
