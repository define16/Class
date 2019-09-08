package jv17;

import java.awt.event.*;        
import javax.swing.*;        
import javax.swing.table.*;  
      
class AddActionListener implements ActionListener {
    JTable table;
    JTextField text1, text2, text3;
    AddActionListener(JTable table, JTextField text1, 
                      JTextField text2, JTextField text3) {
        this.table = table;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }
    public void actionPerformed(ActionEvent e) {
        String arr[] = new String[3];
        arr[0] = text1.getText();
        text1.setText("");
        arr[1] = text2.getText();
        text2.setText("");
        arr[2] = text3.getText();
        text3.setText("");
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(arr);
    }
}
