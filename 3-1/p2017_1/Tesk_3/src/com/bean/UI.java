package com.bean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class UI extends JFrame implements ActionListener{
	
	private JButton seachbt, monitoringbt = null;
	private JLabel editboxlb = null;
	private JTextField txt = null;
	//private ThreadOperation th = null;
	private JList list= null;
	private JScrollPane list_scroll= null;
	private String keyword;
	private DefaultListModel model= null;
	
	Renew rn = null;
	Parser p = null;
	
	public UI()
	{
		super("HOMEWORK3");
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		//setBounds(100,100,400,500);
		setBounds(100,100,465,500);
		
		editboxlb = new JLabel("Edit box :");
		editboxlb.setBounds(10,20,60,30);
		
		txt = new JTextField();
		txt.setBounds(70,20,200,30);
		
		
		seachbt = new JButton("검색");
		seachbt.setBounds(275,20,60,30);
		seachbt.addActionListener(this);
		
		monitoringbt = new JButton("모니터링");
		monitoringbt.setBounds(340,20,100,30);
		monitoringbt.addActionListener(this);
		
		list = new JList(new DefaultListModel());
		model = (DefaultListModel) list.getModel();
		
		list_scroll = new JScrollPane(list);
		list_scroll.setBounds(10, 60, 430, 390);
		

		
		add(editboxlb);
		add(txt);
		add(seachbt);
		add(monitoringbt);
		add(list_scroll);
		
		setVisible(true);
		
		p = new Parser();
		rn= new Renew();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		 
		int s = 0;
		
		if(o == seachbt)
		{	
			p.setflag(false);
			s = p.goodsSearch(txt.getText()).size();
			model.removeAllElements();
			for (int i = 0; i< s; i++)
				model.addElement(p.goodsSearch(txt.getText()).get(i).toString2()); 
		}
		
		if(o == monitoringbt)
		{	
			keyword = txt.getText();
			rn.setkeyword(keyword);
			rn.setarray(p.goodsSearch(txt.getText()));
			rn.start();
			
		}
	}


}
