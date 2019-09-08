package test;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class clicklist extends JFrame{
	 DefaultListModel leftModel, rightModel; 
	   JList leftList, rightList; 
	   JScrollPane sp1, sp2; 
	   JButton button; 
	   public clicklist() { 
	      setLayout( new GridLayout(1, 3)); 
	      leftModel = new DefaultListModel(); 
	      leftModel.addElement("가가가"); 
	      leftModel.addElement("나나나"); 
	      leftModel.addElement("다다다"); 
	      rightModel = new DefaultListModel(); 
	      leftList = new JList( leftModel ); 
	      MouseListener mouseListener = new MouseAdapter() { 
	         public void mouseClicked(MouseEvent mouseEvent) {     
	            if (mouseEvent.getClickCount() == 2) { 
	               int index = leftList.locationToIndex(mouseEvent.getPoint()); 
	               if (index >= 0) { 
	                  Object o = leftModel.getElementAt(index); 
	                  rightModel.addElement( o ); 
	                  leftModel.remove(index); 
	               } 
	            } 
	         } 
	      }; 
	      leftList.addMouseListener(mouseListener); 
	      rightList = new JList( rightModel ); 

	      button = new JButton("▶"); 
	      button.addActionListener( new ActionListener() { 
	         @Override 
	         public void actionPerformed(ActionEvent e) { 
	            int index = leftList.getSelectedIndex(); 

	            if( index != -1 && leftModel.size() != 0 ) { 
	               Object o = leftModel.getElementAt(index); 
	               rightModel.addElement( o ); 
	               leftModel.remove(index); 
	            } 
	         } 
	      }); 
	      JPanel p = new JPanel( new FlowLayout() );   
	      p.add(button); 
	      sp1 = new JScrollPane( leftList ); 
	      sp2 = new JScrollPane( rightList ); 
	      add( sp1 ); 
	      add( p ); 
	      add( sp2 ); 
	      setSize(300, 300); 
	      setDefaultCloseOperation(EXIT_ON_CLOSE); 
	      setVisible( true ); 
	   } 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new clicklist();
	}

}
