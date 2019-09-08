package jv16;

import java.awt.*;
import java.awt.event.*;

public class TextEventEx extends Frame implements TextListener, ActionListener{
	TextField tf = new TextField(37);
	Button input = new Button("입력");
	TextArea ta = new TextArea(100,100);  //영역의 크기가 별 의미 없음
	Button exit = new Button("종료"); 
    
	public TextEventEx(){
		super("TextEvent 테스트");
        
		setLayout(new BorderLayout());
        input.setEnabled(false);
 
        Panel p = new Panel();
        p.add(new Label("제목:"));
        p.add(tf);
        p.add(input);
        
	    add("North",p);
        add("Center",ta);
        add("South",exit);       
        
        setBounds(300,300,400,300);
        setVisible(true);

        tf.addTextListener(this);
        tf.addActionListener(this);
        input.addActionListener(this);
        exit.addActionListener(this);
	}
	
	public static void main (String args[]){
		new TextEventEx();
    }
	
	public void actionPerformed (ActionEvent e){
		String str = e.getActionCommand();
				
		if (str.equals("입력")){
			ta.append(tf.getText()+"\n");
			tf.setText("");
			tf.requestFocus();
		}
		else 
		{
			String text = tf.getText();
	        ta.append(text + "\n");
	        tf.setText("");
	        tf.requestFocus();
	  	}
		
		if (str.equals("종료"))
			System.exit(0);
	
	}
         
	public void textValueChanged(TextEvent e){
		if (tf.getText().equals("")) 
			input.setEnabled(false);
		else 
			input.setEnabled(true);
   }
}