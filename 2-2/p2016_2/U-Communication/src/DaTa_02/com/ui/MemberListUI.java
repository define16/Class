package DaTa_02.com.ui;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import DaTa_02.com.datatype.Member;
import DaTa_02.com.function.Function;
import DaTa_02.com.function.Resolution;

public class MemberListUI extends JFrame{
	private JList infoArea;
	
	private Function function = new Function();

	
	public MemberListUI()
	{
		super("List");
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(Resolution.x/2-150,Resolution.y/2-200,270,250);
		setResizable(false);
	
		
		infoArea = new JList();
		infoArea.setBounds(0,0,270,250);
		infoArea.setListData(function.Print());
		add(infoArea);
		
		setVisible(true);
		
	}
}
