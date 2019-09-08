package DaTa_04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;


public class StopWatchUI extends JFrame implements ActionListener{

	private JToggleButton startbt = null; 
	private JButton lepbt = null;
	private JLabel countlb = null;
	private ThreadOperation th = null;
	private JList list = null;
	private JScrollPane list_scroll;
	private Vector vec;

	

	public StopWatchUI()
	{
		super("stopwatch");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	setResizable(false);
		setBounds(100,100,240,300);
		
		startbt = new JToggleButton("Start");
		startbt.setBounds(10,10,100,20);
		startbt.addActionListener(this);
		
		lepbt = new JButton("Lap");
		lepbt.setBounds(120,10,100,20);
		lepbt.addActionListener(this);
		
		countlb = new JLabel("00h : 00m : 00s");
		countlb.setBounds(10,40,200,20);
		
		list = new JList();
		
		list_scroll = new JScrollPane(list);
		list_scroll.setBounds(10, 60, 200, 200);

		add(startbt);
		add(lepbt);
		add(countlb);
		add(list_scroll);
	
		vec = new Vector();
		th = new ThreadOperation(countlb);
		th.start();
		
		setVisible(true);
		}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		
		
		if(o == startbt)
		{	
		
			if(startbt.getText() == "Start")
			{
				startbt.setText("Stop");
				th.threadFlag();
			}
			else
			{
				startbt.setText("Start");
				th.threadFlag();				
			}		
		}
		else if(o == lepbt)
		{
			list.setListData(th.print(vec));
		}
	}
}
