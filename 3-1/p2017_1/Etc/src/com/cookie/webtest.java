package com.cookie;


import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class webtest extends JFrame {
	
	static int i =0;
	static byte[]image = null;
	static String Slink1 = null;
	static String Slink = null;
    static ImageIcon imageView;
    static JLabel label;
	public static void main(String[] args)
	   {
		webtest w = new webtest();;
		FlowLayout layout = new FlowLayout();
		JButton b = null;

		w.setLayout(null);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setBounds(290,160, 2000, 1000);
		w.setResizable(false);
		  
		JPanel panel = new JPanel();
		ScrollPane scroll = new ScrollPane();
		panel.setSize(600, 600);
		panel.setLayout(layout);
		
		String url = "http://zangsisi.net/?p=11994";	// 이미지가 있는 url입력
		InputStream in = URLManager.getURLInputStream(url, URLManager.USER_AGENT_PC);
		
		try{
			Document doc = Jsoup.parse(in, URLManager.ENCODING_UTF8,"");
			//Elements root = doc.select("div[class=separator]");
			//Elements rankList = root.select("a");
			
			Elements root = doc.select("p");
			Elements rankList = root.select("a");
		
			Slink = rankList.get(i).attr("href");
			
			System.out.println(Slink);
			
			image = URLManager.getImage(
					Slink,
		    		  url
		    		  );


			
			b = new JButton("보기");
			b.setBounds(1100,30,80,30);	
			b.addActionListener(new ActionListener() { 
	       // @Override 
	        public void actionPerformed(ActionEvent e) { 
	        	i++;
	        	System.out.println(i);
	        	Slink = rankList.get(i).attr("href");
	        	image = URLManager.getImage(
						Slink,
			    		  url
			    		  );

	        	  System.out.println(image);
	  			label.setIcon(new ImageIcon(image));
				label.revalidate();
				label.repaint();
				label.update(label.getGraphics());
	        }
	        
			}); 
		      

			      
		    imageView = new ImageIcon(image);
		    label = new JLabel(imageView);
		
		      scroll.setSize(1000,1000);
		      scroll.add(label);

		      
		      w.add(scroll); 	      
		      w.add(b); 	      

		      w.setVisible(true);
		      
	   }catch (Exception e) {
		// TODO: handle exception
	   }
}
}
