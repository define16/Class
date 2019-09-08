package jv12;

import javax.swing.*;
import java.awt.event.*;
 
class MyFrame extends JFrame implements ActionListener {
       private JButton button;
 
       public MyFrame() {
             this.setSize(300, 200);
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.setTitle("이벤트 예제");
             JPanel panel = new JPanel();
             button = new JButton("버튼을 누르시오");
             button.addActionListener(this);
             panel.add(button);
             this.add(panel);
             this.setVisible(true);
       }
   	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
               button.setText("버튼이 눌려졌습니다");
        }
  }
}

public class EventEx2{
  public static void main(String[] args) {
        MyFrame t = new MyFrame();
  }
}
