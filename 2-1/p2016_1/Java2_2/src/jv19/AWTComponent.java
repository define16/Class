package jv19;

import java.awt.*;
import java.awt.event.*;

public class AWTComponent extends Frame implements ActionListener{
  AWTComponent(String title){
    super(title);
    MenuBar mb = new MenuBar();
    Menu fileMenu = new Menu("파일");
    fileMenu.add(new MenuItem("열기"));
    fileMenu.add(new MenuItem("저장"));
    fileMenu.addSeparator();
    fileMenu.add(new MenuItem("인쇄"));
    fileMenu.addSeparator();
    MenuItem exitMenu = new MenuItem("종료");
    fileMenu.add(exitMenu);
    exitMenu.setActionCommand("종료");
    exitMenu.addActionListener(this);
    mb.add(fileMenu);
    setMenuBar(mb);
    
    Button b = new Button("종료");
    add(b, "South");
    b.addActionListener(this);
    
    TextArea ta = new TextArea();
    add(ta, "Center");
    ta.setText
    ("MenuComponent와 Button, TextField 등 \n"
    + " AWT 컴포넌트를 이용한 프로그램입니다.");
  }
 
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(cmd.equals("종료")) System.exit(0);
  }  

  public static void main(String args[]){
    AWTComponent f = new AWTComponent("AWT 컴포넌트");
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
