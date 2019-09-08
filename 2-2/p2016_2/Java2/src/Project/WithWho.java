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
    //유명관광지에 대해 설명하는 프레임으로 넘어가는 버튼들입니다.
      alonebt = new JButton("나만의 여행");
      alonebt.setBounds(0, 10, 160, 60); 

      friendbt = new JButton("친구들과 여행");
      friendbt.setBounds(190, 10, 160, 60);

      loverbt = new JButton("연인과 여행");
      loverbt.setBounds(0, 110, 160, 60);

      familybt = new JButton("가족들과 여행");
      familybt.setBounds(190, 110, 160, 60);

      add(alonebt);
      add(friendbt);
      add(loverbt);
      add(familybt);
      
      alonebt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);  //현재의 프레임을 종료해줍니다.
               AloneFrame af = new AloneFrame();
            }
           });
      
      friendbt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //현재의 프레임을 종료해줍니다.
               FriendFrame ff = new FriendFrame();
            }
           });
      
      loverbt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //현재의 프레임을 종료해줍니다.
               LoverFrame lf = new LoverFrame();
            }
           });
      
      familybt.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {
               ww.setVisible(false);   //현재의 프레임을 종료해줍니다.
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
   private final String filename = "visiterinfo.txt"; //방명록이 기록되는 파일입니다.
   private ChangePanel ww; 

   public WithWho() {
      setSize(500, 500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocation(200,100);
      setTitle("환영합니다!");
      setLayout(null);
  
      imagepanel = new JPanel();
      imagepanel.setBounds(10, 10, 420, 170);

      imagelabel = new JLabel();
      ImageIcon logo = new ImageIcon("src/image/title2.png");
      imagelabel.setIcon(logo); // 인사말이 이미지 입니다.
      imagelabel.setText(null);

      add(imagepanel);
      imagepanel.add(imagelabel);
      
      panel = new JPanel(null);
      panel.setBounds(60,200,400,400);
      
      mainpanel = new JPanel(null);
      mainpanel.setBounds(40,0,350,350);
     
      introlabel = new JLabel("이름과 나이, 인원수를 넣어 주세요!!");
      introlabel.setBounds(30,10,300, 23);
      mainpanel.add(introlabel);
      
      namelabel = new JLabel("이름 : ");
      namelabel.setBounds(40,50,180, 23);
      mainpanel.add(namelabel);
   
      nametxt = new JTextField(5);
      nametxt.setBounds(100,50,100, 23); 
      mainpanel.add(nametxt); //이름을 입력하는 텍스트 필드입니다.
      
      agelabel = new JLabel("나이 : ");
      agelabel.setBounds(40,90,180, 23);
      mainpanel.add(agelabel);
      
      agetxt = new JTextField(5);
      agetxt.setBounds(100,90,100, 23);
      mainpanel.add(agetxt); //나이을 입력하는 텍스트 필드입니다.
      
      populationlabel = new JLabel("인원수 : ");
      populationlabel.setBounds(40,130,180, 23);
      mainpanel.add(populationlabel); 
      
      populationtxt = new JTextField(5);
      populationtxt.setBounds(100,130,100, 23);
      mainpanel.add(populationtxt); //몇명왔는지를 입력하는 텍스트 필드입니다.
      
      joinbt = new JButton("다음으로");
      joinbt.setBounds(150, 180, 100, 30);
      joinbt.addActionListener(this);
      mainpanel.add(joinbt);

      panel.add(mainpanel);
      
      ww = new ChangePanel(this); //다음 패널을 생성을 합니다.
      
      add(panel);
      
      setResizable(false);
      setVisible(true);
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == joinbt)
      {		if (nametxt.getText().equals("")) {  JOptionPane.showMessageDialog(null, "이름을 입력하세요");   }  // 이름,나이,인원수중 하나라도 
           else if (agetxt.getText().equals("")) { JOptionPane.showMessageDialog(null, "나이을 입력하세요");  }// 작성을 안하면 메세지를 띄워줍니다.
           else if (populationtxt.getText().equals("")) {  JOptionPane.showMessageDialog(null, "인원수을 입력하세요");   } 
           else { try { 
               this.out = new PrintWriter(new FileWriter(filename, true));
               out.println(nametxt.getText()+"/"+agetxt.getText()+"/"+populationtxt.getText());
               out.flush(); //텍스트필드에 작성한 것을 차례대로 저장을 해줍니다.
               out.close();
            } catch (IOException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            panel.add(ww); // 다음 패널을 불러오고 
            mainpanel.setVisible(false);// 현재보고 있는 패널을 닫아줍니다.
         }
         }
      } 
   }

