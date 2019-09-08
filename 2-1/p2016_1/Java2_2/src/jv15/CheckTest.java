package jv15;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
 
import javax.swing.*;
 
class MyFrame3 extends JFrame implements ActionListener {
 
       private JButton buttonOK;
       private JCheckBox onion, cheese, tomato;
 
       public MyFrame3() {
             setTitle("체크박스 테스트");
             setSize(300, 130);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
             JLabel label = new JLabel("햄버거에 무엇을 추가하시겠습니까?");
             JPanel topPanel = new JPanel();
             topPanel.add(label);
             add(topPanel, BorderLayout.NORTH);
          // 체크 박스 생성 및 추가
             JPanel panel = new JPanel();
             onion = new JCheckBox("양파");
             panel.add(onion);
             cheese = new JCheckBox("치즈");
             panel.add(cheese);
             tomato = new JCheckBox("토마토");
             panel.add(tomato);
             add(panel, BorderLayout.CENTER);
 
             // 버튼 생성 및 추가
             buttonOK = new JButton("OK");
             JPanel bottomPanel = new JPanel();
             bottomPanel.add(buttonOK);
             add(bottomPanel, BorderLayout.SOUTH);
             buttonOK.addActionListener(this);
 
             setVisible(true);
       }
       public void actionPerformed(ActionEvent e) {
           if (e.getSource() == buttonOK) {
                  String msg = "";
                  if (onion.isSelected())
                         msg += "양파\n";
                  if (cheese.isSelected())
                         msg += " 치즈";
                  if (tomato.isSelected())
                         msg += " 토마토";
                  msg = "선택한 옵션은 다음과 같습니다.\n " + msg;
                  System.out.println(msg);
                  onion.setSelected(false);
                  cheese.setSelected(false);
                  tomato.setSelected(false);
           }
     }
}

public class CheckTest extends JFrame {
     public static void main(String[] args) {
           new MyFrame3();
     }
}

