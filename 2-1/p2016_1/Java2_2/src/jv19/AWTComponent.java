package jv19;

import java.awt.*;
import java.awt.event.*;

public class AWTComponent extends Frame implements ActionListener{
  AWTComponent(String title){
    super(title);
    MenuBar mb = new MenuBar();
    Menu fileMenu = new Menu("����");
    fileMenu.add(new MenuItem("����"));
    fileMenu.add(new MenuItem("����"));
    fileMenu.addSeparator();
    fileMenu.add(new MenuItem("�μ�"));
    fileMenu.addSeparator();
    MenuItem exitMenu = new MenuItem("����");
    fileMenu.add(exitMenu);
    exitMenu.setActionCommand("����");
    exitMenu.addActionListener(this);
    mb.add(fileMenu);
    setMenuBar(mb);
    
    Button b = new Button("����");
    add(b, "South");
    b.addActionListener(this);
    
    TextArea ta = new TextArea();
    add(ta, "Center");
    ta.setText
    ("MenuComponent�� Button, TextField �� \n"
    + " AWT ������Ʈ�� �̿��� ���α׷��Դϴ�.");
  }
 
  public void actionPerformed(ActionEvent e){
    String cmd = e.getActionCommand();
    if(cmd.equals("����")) System.exit(0);
  }  

  public static void main(String args[]){
    AWTComponent f = new AWTComponent("AWT ������Ʈ");
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
