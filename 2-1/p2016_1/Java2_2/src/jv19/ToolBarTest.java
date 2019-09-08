package jv19;

import javax.swing.*;
import java.awt.*;
     
class ToolbarPanel extends JPanel
{
     ToolbarPanel()
     {
         setLayout(new BorderLayout());
         JToolBar toolbar = new JToolBar();
        
        // Toolbar에 세개의 JCheckbox를 추가한다.
        for (int i=1; i<4; i++)
        {
            toolbar.add(new JCheckBox("Checkbox #" + i));
        }
       
        toolbar.add(new JButton(new ImageIcon("duke.gif")));
       
        String citems[] = {"One", "Two", "Tree"};
        toolbar.add(new JComboBox(citems));
       
        add(toolbar, BorderLayout.NORTH);
    }
}
 
class ToolBarTest {
  public static void main(String args[]){
    JFrame f = new JFrame("JToolBar Test");
    ToolbarPanel bar = new ToolbarPanel();
    f.getContentPane().add(bar);
    f.setSize(700, 200);
    f.setVisible(true);
  }
}