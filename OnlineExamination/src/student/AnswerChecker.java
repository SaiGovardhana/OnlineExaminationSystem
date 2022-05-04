/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import Main.MainFrame;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import others.MYJPanel;

/**
 *
 * @author saigovardhan
 */
public class AnswerChecker extends MYJPanel{
    JPanel top;
    CheckboxGroup cgp;
    Checkbox A,B,C,D;
    JTextArea jtextques,jtextoA,jtextoB,jtextoC,jtextoD;
    PrintWriter out;
    Scanner sc;
int n;
MainFrame f;
int current;
String question[];
String answers[][];
int key[];
int response[];
JButton back;
JPanel navigator;
JButton navbut[];
int score=0;
 public  AnswerChecker(MainFrame f,Scanner sc){
        this.f=f;
        this.sc=sc;
       current=1;
       
        parser();
         
        FlowLayout fl=new FlowLayout();
        fl.setVgap(0);
        fl.setHgap(0);
        fl.setAlignment(FlowLayout.LEFT);
        setLayout(fl);
//INTITALIZING TOP
top=new JPanel();

FlowLayout tfl=new FlowLayout();
tfl.setAlignment(FlowLayout.LEFT);
tfl.setHgap(50);
top.setLayout(tfl);
top.setPreferredSize(new Dimension(800,90));
top.setBackground(Color.cyan);
back=new JButton("BACK");
back.setBackground(Color.red);
back.setPreferredSize(new Dimension(150,70));
JLabel Qno=new JLabel("QUESTION NO:1");
Qno.setFont(new Font("Arial",Font.BOLD,25));
Qno.setHorizontalTextPosition(JLabel.LEFT);
JLabel sclab=new JLabel("SCORE:"+score+"/"+n);
sclab.setFont(new Font("Arial",Font.BOLD,25));
back.addActionListener((ar)->{f.goToPrevious(this);});
top.add(back);
top.add(Qno);
top.add(sclab);
add(top);


//END OF TOP

//Start Of Navigator Pane
 navigator=new JPanel();
 navigator.setBackground(Color.cyan);
 FlowLayout nfl=new FlowLayout(FlowLayout.LEFT);
 nfl.setHgap(5);
 nfl.setVgap(5);
 navigator.setLayout(nfl);
 navigator.setPreferredSize(new Dimension(280,470));
 JLabel navlab=new JLabel("  NAVIGATOR   ");
 navlab.setFont(new Font("Arial",Font.BOLD,39));
 navigator.add(navlab);
 ActionListener ac=(ActionEvent e)->{
 JButton kkr=(JButton)e.getSource();
 
 int next=Integer.valueOf(kkr.getText());
 Qno.setText("QUESTION NO:"+next);
   Color a=Color.white, b=Color.WHITE, c=Color.WHITE,d=Color.WHITE;
   int s=key[next-1];
    int r=response[next-1];
    if(r==1)a=Color.red;
    else if(r==2)b=Color.red;
          else if(r==3)c=Color.red;
          else if(r==4)d=Color.red;
    if(s==1)a=Color.green;
    else if(s==2)b=Color.green;
          else if(s==3)c=Color.green;
          else if(s==4)d=Color.green;
      jtextoA.setBackground(a);
      jtextoB.setBackground(b);
      jtextoC.setBackground(c);
      jtextoD.setBackground(d);
     
 jtextques.setText(question[next-1]);
 jtextoA.setText(answers[next-1][0]);
 jtextoB.setText(answers[next-1][1]);
 jtextoC.setText(answers[next-1][2]);
 jtextoD.setText(answers[next-1][3]);
 current=next;
 };
 for(int i=1;i<=n;i++)
 {JButton tem=new JButton(Integer.toString(i));
    if(key[i-1]==response[i-1])
        tem.setBackground(Color.green);
    else
        tem.setBackground(Color.red);
    if(response[i-1]==0)tem.setBackground(Color.white);
 tem.setFont(new Font("Arial",Font.BOLD,10));
 navbut[i-1]=tem;
 tem.addActionListener(ac);
 tem.setPreferredSize(new Dimension(40,25));
     navigator.add(tem);
 }
 add(navigator);
 //END OF NAVIGATOR
 
 //START OF EDITOR PANE
  JPanel editor=new JPanel();
  FlowLayout efl=new FlowLayout(FlowLayout.LEFT);
  JLabel ques=new JLabel("QUESTION");
  ques.setFont(new Font("Arial",Font.BOLD,20));
   jtextques=new JTextArea(question[0],7,30);
  jtextques.setFocusable(false);
  jtextques.setEditable(false);
 
  JScrollPane jspques=new JScrollPane(jtextques); 
  JLabel oA=new JLabel("OPTION--A");
  oA.setFont(new Font("Arial",Font.BOLD,20));
   jtextoA=new JTextArea(answers[0][0],3,30);
  JScrollPane jspoA=new JScrollPane(jtextoA); 
   JLabel oB=new JLabel("OPTION--B");
  oB.setFont(new Font("Arial",Font.BOLD,20));
   jtextoB=new JTextArea(answers[0][1],3,30);
  JScrollPane jspoB=new JScrollPane(jtextoB); 
  JLabel oC=new JLabel("OPTION--C");
  oC.setFont(new Font("Arial",Font.BOLD,20));
   jtextoC=new JTextArea(answers[0][2],3,30);
  JScrollPane jspoC=new JScrollPane(jtextoC);
  JLabel oD=new JLabel("OPTION--D");
  oD.setFont(new Font("Arial",Font.BOLD,20));
   jtextoD=new JTextArea(answers[0][3],3,30);
  JScrollPane jspoD=new JScrollPane(jtextoD); 
  jtextoA.setFocusable(false);
  jtextoA.setEditable(false);
  jtextoB.setFocusable(false);
  jtextoB.setEditable(false);
  jtextoC.setFocusable(false);
  jtextoC.setEditable(false);
  jtextoD.setFocusable(false);
  jtextoD.setEditable(false);
  //
  Color a=Color.white, b=Color.WHITE, c=Color.WHITE,d=Color.WHITE;
   int s=key[0];
    int r=response[0];
    if(r==1)a=Color.red;
    else if(r==2)b=Color.red;
          else if(r==3)c=Color.red;
          else if(r==4)d=Color.red;
    if(s==1)a=Color.green;
    else if(s==2)b=Color.green;
          else if(s==3)c=Color.green;
          else if(s==4)d=Color.green;
      jtextoA.setBackground(a);
      jtextoB.setBackground(b);
      jtextoC.setBackground(c);
      jtextoD.setBackground(d);
  
 //
  
  editor.setBackground(Color.white);
  editor.setPreferredSize(new Dimension(500,470));
  
    
       editor.setLayout(efl);
    editor.add(ques);
    editor.add(jspques);
    editor.add(oA);
    editor.add(jspoA);
    editor.add(oB);
    editor.add(jspoB);
    editor.add(oC);
    editor.add(jspoC);
    editor.add(oD);
    editor.add(jspoD);
     
  
     JLabel spaceadj=new JLabel();
        spaceadj.setPreferredSize(new Dimension(160,20));
    editor.add(spaceadj);
    
    //END OF EDITOR
    add(editor);

}
    
     void parser(){
         System.out.println("IN PARSER");
    n=Integer.valueOf(sc.nextLine());
    key=new int[n];
    navbut=new JButton[n];
     System.out.println("READ N"+n);
    question=new String[n];
    answers=new String[n][4];
    for(int i=0;i<n;i++){
    int qlines=Integer.valueOf(sc.nextLine());;
           String q="";
           for(int j=0;j<qlines;j++)
           {if(j!=0)q+="\n";
               q+=sc.nextLine();
           }
           question[i]=q;
           for(int a=0;a<4;a++)
           {int alines=Integer.valueOf(sc.nextLine());;
            String ans="";
              for(int j=0;j<alines;j++)
                 {if(j!=0)ans+="\n";
               ans+=sc.nextLine();}
              answers[i][a]=ans;
           }
           System.out.println("READ QUESTION"+(i+1));
    
    }
     int co=Integer.valueOf(sc.nextLine());
     if(co==-1)return;
      System.out.println("READ RESPONSES");
     for(int i=0;i<co;i++)
         key[i]=Integer.valueOf(sc.nextLine());
     response=new int [n];
     int re=Integer.valueOf(sc.nextLine());
     if(re!=0){
     for(int i=0;i<n;i++)
         response[i]=Integer.valueOf(sc.nextLine());
     }
     for(int i=0;i<n;i++)if(key[i]==response[i])score++;
     }}
   