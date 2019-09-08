package Project;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
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


class ChangePanel extends JPanel {
   
   JButton alonebt, friendbt, loverbt, familybt;
   private WithWho ww; 

   public ChangePanel(WithWho ww)
   {
      setSize(350,350);
      setLayout(null);
    //����������� ���� �����ϴ� ���������� �Ѿ�� ��ư���Դϴ�.
      alonebt = new JButton("������ ����");
      alonebt.setBounds(0, 10, 160, 60); 

      friendbt = new JButton("ģ����� ����");
      friendbt.setBounds(190, 10, 160, 60);

      loverbt = new JButton("���ΰ� ����");
      loverbt.setBounds(0, 110, 160, 60);

      familybt = new JButton("������� ����");
      familybt.setBounds(190, 110, 160, 60);

      add(alonebt);
      add(friendbt);
      add(loverbt);
      add(familybt);
      
      alonebt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);  //������ �������� �������ݴϴ�.
               AloneFrame af = new AloneFrame();
            }
           });
      
      friendbt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //������ �������� �������ݴϴ�.
               FriendFrame ff = new FriendFrame();
            }
           });
      
      loverbt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //������ �������� �������ݴϴ�.
               LoverFrame lf = new LoverFrame();
            }
           });
      
      familybt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //������ �������� �������ݴϴ�.
               FamilyFrame faf = new FamilyFrame();
            }
           });
      
   }

   
 }



public class WithWho extends JFrame implements ActionListener{

   JPanel imagepanel,  mainpanel, changepanel,panel;
   JLabel imagelabel;
   JButton joinbt;
   JLabel introlabel,namelabel,agelabel,populationlabel;
   JTextField nametxt,agetxt,populationtxt;
   
   private PrintWriter out;
   private final String filename = "visiterinfo.txt"; //������ ��ϵǴ� �����Դϴ�.
   private ChangePanel ww; 

   public WithWho() {
      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(200,100);
      setTitle("ȯ���մϴ�!");
      setLayout(null);
  
      imagepanel = new JPanel();
      imagepanel.setBounds(10, 10, 420, 170);

      imagelabel = new JLabel();
      ImageIcon logo = new ImageIcon("src/image/title2.png");
      imagelabel.setIcon(logo); // �λ縻�� �̹��� �Դϴ�.
      imagelabel.setText(null);

      add(imagepanel);
      imagepanel.add(imagelabel);
      
      panel = new JPanel(null);
      panel.setBounds(60,200,400,400);
      
      mainpanel = new JPanel(null);
      mainpanel.setBounds(40,0,350,350);
     
      introlabel = new JLabel("�̸��� ����, �ο����� �־� �ּ���!!");
      introlabel.setBounds(30,10,300, 23);
      mainpanel.add(introlabel);
      
      namelabel = new JLabel("�̸� : ");
      namelabel.setBounds(40,50,180, 23);
      mainpanel.add(namelabel);
   
      nametxt = new JTextField(5);
      nametxt.setBounds(100,50,100, 23); 
      mainpanel.add(nametxt); //�̸��� �Է��ϴ� �ؽ�Ʈ �ʵ��Դϴ�.
      
      agelabel = new JLabel("���� : ");
      agelabel.setBounds(40,90,180, 23);
      mainpanel.add(agelabel);
      
      agetxt = new JTextField(5);
      agetxt.setBounds(100,90,100, 23);
      mainpanel.add(agetxt); //������ �Է��ϴ� �ؽ�Ʈ �ʵ��Դϴ�.
      
      populationlabel = new JLabel("�ο��� : ");
      populationlabel.setBounds(40,130,180, 23);
      mainpanel.add(populationlabel); 
      
      populationtxt = new JTextField(5);
      populationtxt.setBounds(100,130,100, 23);
      mainpanel.add(populationtxt); //���Դ����� �Է��ϴ� �ؽ�Ʈ �ʵ��Դϴ�.
      
      joinbt = new JButton("��������");
      joinbt.setBounds(150, 180, 100, 30);
      joinbt.addActionListener(this);
      mainpanel.add(joinbt);

      panel.add(mainpanel);
      
      ww = new ChangePanel(this); //���� �г��� ������ �մϴ�.
      
      add(panel);
      
      setResizable(false);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == joinbt)
      {		if (nametxt.getText().equals("")) {  JOptionPane.showMessageDialog(null, "�̸��� �Է��ϼ���");   }  // �̸�,����,�ο����� �ϳ��� 
           else if (agetxt.getText().equals("")) { JOptionPane.showMessageDialog(null, "������ �Է��ϼ���");  }// �ۼ��� ���ϸ� �޼����� ����ݴϴ�.
           else if (populationtxt.getText().equals("")) {  JOptionPane.showMessageDialog(null, "�ο����� �Է��ϼ���");   } 
           else { try { 
               this.out = new PrintWriter(new FileWriter(filename, true));
               out.println(nametxt.getText()+"/"+agetxt.getText()+"/"+populationtxt.getText());
               out.flush(); //�ؽ�Ʈ�ʵ忡 �ۼ��� ���� ���ʴ�� ������ ���ݴϴ�.
               out.close();
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            panel.add(ww); // ���� �г��� �ҷ����� 
            mainpanel.setVisible(false);// ���纸�� �ִ� �г��� �ݾ��ݴϴ�.
         }
         }
      } 
   }

