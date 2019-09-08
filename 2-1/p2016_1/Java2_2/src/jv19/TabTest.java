package jv19; 

import javax.swing.*;
     import java.awt.*;
     import java.awt.event.*;
     
     public class TabTest extends JFrame{
     
         private JTextField textfield;
         private JTabbedPane tabbedPane;
    
        public static void main(String[] args) {
            TabTest tab = new TabTest();
            tab.setVisible(true);
        }
    
        public TabTest() {
            super("Swing Demo");
            setSize(500, 350);
        
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){ System.exit(0); }
            });
            textfield = new JTextField();
            getContentPane().add(textfield, BorderLayout.SOUTH);
    
            tabbedPane = new JTabbedPane();
            populateTabbedPane();
            getContentPane().add(tabbedPane, BorderLayout.CENTER);
        }
    
             //�� �ǿ� ������Ʈ�� �߰��Ѵ�. 
        private void populateTabbedPane() {
            tabbedPane.addTab("Button",                     	// Title
                        		 null,			// Icon
                          		 new JPanel(),                     // Component
                           	"��ư�� �����ִ� �г�");         // Tooltip
    
          
           tabbedPane.addTab("ProgressBar",
                           null,
                           new JPanel(),
                           "ProgressBar�� �����ִ� �г�");          
    
          
            tabbedPane.addTab("Toolbar",
                           null,
                           new JPanel(),
                           "Toolbar�� �����ִ� �г�");
    
         
           tabbedPane.addTab("ChooserPane",
                           null,
                           new JPanel(),
                           "JFileChooser�� JColorChooser�� �����ִ� �г�");                  
        }
    }
