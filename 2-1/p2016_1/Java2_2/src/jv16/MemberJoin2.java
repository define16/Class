package jv16;

import java.awt.*;  
import java.awt.event.*;
import javax.swing.*;


// 윈도우 화면에 배경색 지정하기

public class MemberJoin2 extends JFrame {
 
 JFrame  f;

 public MemberJoin2(){
 
  f = new JFrame  ("회 원 가 입");
  f.setSize(900,800);      
  f.setVisible(true);
  
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  f.setLocation(400,100);   

  JPanel a = new JPanel();
   
  a.setBackground(Color.RED);
  f.add(a);
  f.setVisible(true);   
 }
 

 public static void main(String[] args){
 
  MemberJoin2 e = new MemberJoin2();

 }
}
