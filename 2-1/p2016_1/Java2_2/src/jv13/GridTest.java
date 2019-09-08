package jv13;

import java.awt.*;
import javax.swing.*;
 
class MyFrameg extends JFrame {
       public MyFrameg() {
 
             setTitle("BorderLayoutTest");
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
             // 프레임은 디폴트로 BorderLayout 이므로 사실은 불필요
             setLayout(new BorderLayout());
 
             // 버튼을 추가한다.
             add(new JButton("Center"), BorderLayout.CENTER);
             add(new JButton("Line Start"), BorderLayout.LINE_START);
             add(new JButton("Line End"), BorderLayout.LINE_END);
             add(new JButton("Page Start"), BorderLayout.PAGE_START);
             add(new JButton("Page End"), BorderLayout.PAGE_END);
 
             pack();
             setVisible(true);
       }
}


public class GridTest {
	public static void main(String[] args){
		new MyFrameg();
	}
}
