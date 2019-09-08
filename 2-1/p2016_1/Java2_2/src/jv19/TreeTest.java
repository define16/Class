package jv19;

import java.awt.*;
import javax.swing.*;

class TreePanel extends JPanel{
  TreePanel(){
    setLayout(new BorderLayout());
    
    String[] data = { "blue", "red", "yellow"};
    JTree tree = new JTree(data);
    
    add(new JScrollPane(tree));
  }
}

class TreeTest {
  public static void main(String args[]){
    JFrame f = new JFrame("JTree Test");
    TreePanel tree = new TreePanel();
    f.getContentPane().add(tree);
    f.setSize(300, 200);
    f.setVisible(true);
  }
}