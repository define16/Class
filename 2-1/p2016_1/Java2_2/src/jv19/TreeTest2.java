package jv19;

 import java.awt.*;
 import javax.swing.*;
 import javax.swing.tree.*;
 
class TreePanel2 extends JPanel{
	     TreePanel2(){
	         setLayout(new BorderLayout());
	 
	         DefaultMutableTreeNode root = new DefaultMutableTreeNode("JTree");
	    DefaultMutableTreeNode parent = new DefaultMutableTreeNode("color");
	    root.add(parent);
	    
	    parent.add(new DefaultMutableTreeNode("blue"));
	    parent.add(new DefaultMutableTreeNode("red"));
	    parent.add(new DefaultMutableTreeNode("yellow"));
	
	    parent = new DefaultMutableTreeNode("sports");
	    parent.add(new DefaultMutableTreeNode("basketball"));
	    parent.add(new DefaultMutableTreeNode("soccer"));
	    parent.add(new DefaultMutableTreeNode("football"));
	    root.add(parent);
	
	    JTree tree = new JTree(root);
	    add(new JScrollPane(tree));
	}
}

class TreeTest2 {
  public static void main(String args[]){
    JFrame f = new JFrame("JTree Test");
    TreePanel2 tree = new TreePanel2();
    f.getContentPane().add(tree);
    f.setSize(300, 200);
    f.setVisible(true);
  }
}