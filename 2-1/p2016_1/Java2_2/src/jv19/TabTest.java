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
    
             //각 탭에 컴포넌트를 추가한다. 
        private void populateTabbedPane() {
            tabbedPane.addTab("Button",                     	// Title
                        		 null,			// Icon
                          		 new JPanel(),                     // Component
                           	"버튼을 보여주는 패널");         // Tooltip
    
          
           tabbedPane.addTab("ProgressBar",
                           null,
                           new JPanel(),
                           "ProgressBar를 보여주는 패널");          
    
          
            tabbedPane.addTab("Toolbar",
                           null,
                           new JPanel(),
                           "Toolbar를 보여주는 패널");
    
         
           tabbedPane.addTab("ChooserPane",
                           null,
                           new JPanel(),
                           "JFileChooser와 JColorChooser를 보여주는 패널");                  
        }
    }
