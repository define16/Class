package excersie;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MainPanel extends JFrame implements ActionListener{
	
	JLabel introlabel,namelabel,agelabel,populationlabel;
	JTextField nametxt,agetxt,populationtxt;
	JButton joinbt;
	
	MainPanel()
	{
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		introlabel = new JLabel("이름과 나이, 인원수를 넣어 주세요!!");
		introlabel.setBounds(10,10,300, 23);
		add(introlabel);
		
		namelabel = new JLabel("이름 : ");
		namelabel.setBounds(40,50,180, 23);
		add(namelabel);
	
		nametxt = new JTextField(3);
		nametxt.setBounds(100,50,100, 23);
		add(nametxt);
		
		agelabel = new JLabel("나이 : ");
		agelabel.setBounds(40,90,180, 23);
		add(agelabel);
		
		agetxt = new JTextField(3);
		agetxt.setBounds(100,90,100, 23);
		add(agetxt);
		
		populationlabel = new JLabel("인원수 : ");
		populationlabel.setBounds(40,130,180, 23);
		add(populationlabel);
		
		populationtxt = new JTextField(3);
		populationtxt.setBounds(100,130,100, 23);
		add(populationtxt);
		
		
		joinbt = new JButton("다음으로");
		joinbt.setBounds(130, 180, 100, 30);
		joinbt.addActionListener(this);
		add(joinbt);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
public class MainLay {
	public static void main(String args[])
	{
		MainPanel mp = new MainPanel();
	}
	

}
