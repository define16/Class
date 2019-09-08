package Practice;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class AloneFrame extends JFrame { 
	   JLabel a; 
	   public AloneFrame() { 
	      setSize(300, 300); 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	      setLayout(null); 
	      a = new JLabel("성공~"); 
	      a.setBounds(0, 10, 160, 60); 
	      add(a); 
	      setVisible(true); 
	   } 
	} 
	class ChangePanel extends JPanel { 
	   JButton alonebt; 
	   public ChangePanel() { 
	      setSize(350, 350); 
	      setLayout(null); 
	      alonebt = new JButton("버튼"); 
	      alonebt.setBounds(0, 10, 160, 60); 
	      add(alonebt); 
	      alonebt.addActionListener(new ActionListener() { 
	         public void actionPerformed(ActionEvent e) { 
	            // TODO Auto-generated method stub 
	            WithWho.ww.setVisible(false); 
	            AloneFrame af = new AloneFrame(); 
	         } 
	      }); 
	   } 
	} 
	public class WithWho extends JFrame implements ActionListener { 
	   JPanel imagepanel, cardPanel, mainpanel, changepanel, panel; 
	   JLabel imagelabel; 
	   JButton joinbt; 
	   CardLayout cardLayoutSet; 
	   JButton alonebt, friendbt, loverbt, familybt; 
	   JLabel introlabel, namelabel, agelabel, populationlabel; 
	   JTextField nametxt, agetxt, populationtxt; 
	   private PrintWriter out; 
	   private final String filename = "visiterinfo.txt"; 
	   private File file; 
	   boolean b; 
	   static WithWho ww; //** 
	   public WithWho() { 
	      setSize(500, 500); 
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	      setLayout(null); 

	      imagepanel = new JPanel(); 
	      imagepanel.setBounds(10, 10, 420, 170); 
	      imagelabel = new JLabel(); 
	      ImageIcon logo = new ImageIcon("title2.png"); 
	      imagelabel.setIcon(logo); 
	      imagelabel.setText(null); 
	      add(imagepanel); 
	      imagepanel.add(imagelabel); 
	      panel = new JPanel(null); 
	      panel.setBounds(60, 200, 400, 400); 
	      mainpanel = new JPanel(null); 
	      mainpanel.setBounds(40, 0, 350, 350); 
	      introlabel = new JLabel("이름과 나이, 인원수를 넣어 주세요!!"); 
	      introlabel.setBounds(30, 10, 300, 23); 
	      mainpanel.add(introlabel); 
	      namelabel = new JLabel("이름 : "); 
	      namelabel.setBounds(40, 50, 180, 23); 
	      mainpanel.add(namelabel); 
	      nametxt = new JTextField(5); 
	      nametxt.setBounds(100, 50, 100, 23); 
	      mainpanel.add(nametxt); 
	      agelabel = new JLabel("나이 : "); 
	      agelabel.setBounds(40, 90, 180, 23); 
	      mainpanel.add(agelabel); 
	      agetxt = new JTextField(5); 
	      agetxt.setBounds(100, 90, 100, 23); 
	      mainpanel.add(agetxt); 
	      populationlabel = new JLabel("인원수 : "); 
	      populationlabel.setBounds(40, 130, 180, 23); 
	      mainpanel.add(populationlabel); 
	      populationtxt = new JTextField(5); 
	      populationtxt.setBounds(100, 130, 100, 23); 
	      mainpanel.add(populationtxt); 
	      joinbt = new JButton("다음으로"); 
	      joinbt.setBounds(150, 180, 100, 30); 
	      joinbt.addActionListener(this); 
	      mainpanel.add(joinbt); 
	      panel.add(mainpanel); 
	      add(panel); 
	      setVisible(true); 
	   } 
	   @Override 
	   public void actionPerformed(ActionEvent e) { 
	      // TODO Auto-generated method stub 
	      if (e.getSource() == joinbt) { 
	         if (nametxt.getText().equals("")) { //** 
	            JOptionPane.showMessageDialog(null, "이름을 입력하세요"); 
	            } else if (agetxt.getText().equals("")) { //** 
	            JOptionPane.showMessageDialog(null, "나이을 입력하세요"); 
	            } else if (populationtxt.getText().equals("")) { //** 
	            JOptionPane.showMessageDialog(null, "인원수을 입력하세요"); 
	            } else { 
	            try { 
	               this.out = new PrintWriter(new FileWriter(filename, true)); 
	               out.println(nametxt.getText() + "/" + agetxt.getText() + "/" + populationtxt.getText()); 
	               out.flush(); 
	               out.close(); 
	               } catch (IOException e1) { 
	               // TODO Auto-generated catch block 
	               e1.printStackTrace(); 
	            } 
	            changepanel = new ChangePanel(); 
	            panel.add(changepanel); 
	            mainpanel.setVisible(false); 
	         } 
	      } 
	   } 
	   public static void main(String arge[]) { 
	      ww = new WithWho(); //** 
	   } 
	} 