package Image;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;



public class ImageTest extends JFrame {

	private DefaultListModel model = new DefaultListModel();
	private static ArrayList<Data> webview;
	private JList web;
	JScrollPane list_scroll;
	public ImageTest(){
		// TODO Auto-generated method stub
		super("web view");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,1000);
		//setResizable(false);
		webview = Parser.webview();
		
		list_scroll = new JScrollPane(web);
		
		web = new JList(model);
		web.setBounds(0,0,600,3);
		web.setBorder(new EtchedBorder());
		
		list_scroll = new JScrollPane(web);
		list_scroll.setBounds(20, 60, 300, 560);
		
		int cnt = webview.size();
		
		for(int i = 0; i < cnt; i++ ){
		model.addElement(webview.get(i).getImage());
		}
		
		add(web);
		
	
		setVisible(true);
	}
	
	

}
