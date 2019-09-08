package DaTa_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import DaTa_02.com.datatype.Member;
import DaTa_02.com.function.Function;
import DaTa_02.com.function.Resolution;


public class asdf extends JFrame{
	private JList infoArea;
	private Function function = new Function();
	
	public asdf(){
		super("List");
		setSize(415,415);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(200,100);
		setLayout(null);
		
		 ArrayList<Member> list = function.printMembers();
		Object[] strArray1 = list.toArray();

		infoArea = new JList();

		infoArea.setBounds(10, 10, 380, 360);
		JScrollPane scrollPane = new JScrollPane(infoArea);
		
		add(infoArea);
		
		
	    setResizable(false);
		setVisible(true);
		
	}
}