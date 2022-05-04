/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

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
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
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
public class QuestionPrepare extends MYJPanel{
    JPanel top;
    CheckboxGroup cgp;
    Checkbox A,B,C,D;
    JTextArea jtextques,jtextoA,jtextoB,jtextoC,jtextoD;
int n;
int current;
String question[];
int qcount[];
String answers[][];
int acount[][];
int key[];
int time;
JButton back;
JPanel navigator;
JButton navbut[];
String classname,subject;
int cid;
PrintWriter out;
Scanner sc;
MainFrame frame;
courseMenu menu;
String exname;
    QuestionPrepare(MainFrame frame,courseMenu menu,int n,int time,int cid,String classname,String subject,String exname){
        this.exname=exname;
        this.frame=frame;
        this.menu=menu;
        this.cid=cid;
        this.classname=classname;
        this.subject=subject;
        this.time=time;
        try{    out=new PrintWriter(frame.s.getOutputStream());
        sc=new Scanner(frame.s.getInputStream());
        }catch(Exception e)
        {System.out.println(e);
        }
        this.n=n;
        current=1;
        navbut=new JButton[n];
        question=new String[n];
        qcount=new int[n];
        answers=new String[n][4];
        acount=new int[n][4];
        for(int i=0;i<n;i++)
            for(int j=0;j<4;j++)
            {answers[i][j]="";
                acount[i][j]=1;
               }
        for(int i=0;i<n;i++)
        { question[i]="";
          qcount[i]=1;
        }
        key=new int[n];
        FlowLayout fl=new FlowLayout();
        fl.setVgap(0);
        fl.setHgap(0);
        fl.setAlignment(FlowLayout.LEFT);
        setLayout(fl);
this.n=n;
//INTITALIZING TOP
top=new JPanel();
JButton submit=new JButton("SUBMIT");
FlowLayout tfl=new FlowLayout();
tfl.setAlignment(FlowLayout.LEFT);
tfl.setHgap(50);
top.setLayout(tfl);
top.setPreferredSize(new Dimension(800,90));
top.setBackground(Color.cyan);
back=new JButton("BACK");
back.addActionListener((e)->{frame.goToPrevious(this);});
back.setBackground(Color.red);
back.setPreferredSize(new Dimension(150,70));
submit.setPreferredSize(new Dimension(120,70));
JLabel Qno=new JLabel("QUESTION NO:1");
Qno.setFont(new Font("Arial",Font.BOLD,30));
Qno.setHorizontalTextPosition(JLabel.LEFT);
submit.setBackground(Color.green);
submit.addActionListener((ActionEvent e)->{
 String cu=jtextques.getText();
 question[current-1]=cu;
 qcount[current-1]=lineCount(cu);
 cu=jtextoA.getText();
 answers[current-1][0]=cu;
 acount[current-1][0]=lineCount(cu);
  cu=jtextoB.getText();
  answers[current-1][1]=cu;
 acount[current-1][1]=lineCount(cu);
  cu=jtextoC.getText();
  answers[current-1][2]=cu;
 acount[current-1][2]=lineCount(cu);
  cu=jtextoD.getText();
  answers[current-1][3]=cu;
 acount[current-1][3]=lineCount(cu);
 
for(int i=0;i<n;i++)
    if(key[i]==0){System.out.println("HAVE INCOMPLETE QUES");return;}
File f=new File("C:/users/saigovardhan/Desktop/A.txt");
File ke=new File("C:/users/saigovardhan/Desktop/Keys.txt");
PrintWriter fout=null;

try{
 fout=new PrintWriter(frame.s.getOutputStream());

}
catch(Exception ew){}
fout.println(7);
fout.println(exname);
fout.println(time);
fout.println(n);
fout.println(cid);
fout.println(classname);
fout.println(subject);
 //PRINT NUMBER OF QUES
for(int i=0;i<n;i++){//print qnum and ques
fout.println(qcount[i]);
fout.println(question[i]);
for(int j=0;j<4;j++){
fout.println(acount[i][j]);
fout.println(answers[i][j]);
}

}
for(int i=0;i<n;i++)
fout.println(key[i]);
fout.flush();
   frame.remove(this);
   frame.add(menu);
   menu.revalidate();
   frame.revalidate();
   frame.repaint();
    }
);
top.add(back);
top.add(Qno);
top.add(submit);
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
 if(key[current-1]!=0)navbut[current-1].setBackground(Color.green);
 int next=Integer.valueOf(kkr.getText());
 Qno.setText("QUESTION NO:"+next);
   Color a=Color.white, b=Color.WHITE, c=Color.WHITE,d=Color.WHITE;
   int s=key[next-1];
    if(s==1)a=Color.green;
    else if(s==2)b=Color.green;
          else if(s==3)c=Color.green;
          else if(s==4)d=Color.green;
      jtextoA.setBackground(a);
      jtextoB.setBackground(b);
      jtextoC.setBackground(c);
      jtextoD.setBackground(d);
      Checkbox cs=null;
      if(s==1)cs=A;
      if(s==2)cs=B;
      if(s==3)cs=C;
      if(s==4)cs=D;
 cgp.setSelectedCheckbox(cs);
 String cu=jtextques.getText();
 question[current-1]=cu;
 qcount[current-1]=lineCount(cu);
 cu=jtextoA.getText();
 answers[current-1][0]=cu;
 acount[current-1][0]=lineCount(cu);
  cu=jtextoB.getText();
  answers[current-1][1]=cu;
 acount[current-1][1]=lineCount(cu);
  cu=jtextoC.getText();
  answers[current-1][2]=cu;
 acount[current-1][2]=lineCount(cu);
  cu=jtextoD.getText();
  answers[current-1][3]=cu;
 acount[current-1][3]=lineCount(cu);
 
 jtextques.setText(question[next-1]);
 jtextoA.setText(answers[next-1][0]);
 jtextoB.setText(answers[next-1][1]);
 jtextoC.setText(answers[next-1][2]);
 jtextoD.setText(answers[next-1][3]);
 current=next;
 };
 for(int i=1;i<=n;i++)
 {JButton tem=new JButton(Integer.toString(i));
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
   jtextques=new JTextArea("",7,30);
  JScrollPane jspques=new JScrollPane(jtextques); 
  JLabel oA=new JLabel("OPTION--A");
  oA.setFont(new Font("Arial",Font.BOLD,20));
   jtextoA=new JTextArea("",3,30);
  JScrollPane jspoA=new JScrollPane(jtextoA); 
   JLabel oB=new JLabel("OPTION--B");
  oB.setFont(new Font("Arial",Font.BOLD,20));
   jtextoB=new JTextArea("",3,30);
  JScrollPane jspoB=new JScrollPane(jtextoB); 
  JLabel oC=new JLabel("OPTION--C");
  oC.setFont(new Font("Arial",Font.BOLD,20));
   jtextoC=new JTextArea("",3,30);
  JScrollPane jspoC=new JScrollPane(jtextoC);
  JLabel oD=new JLabel("OPTION--D");
  oD.setFont(new Font("Arial",Font.BOLD,20));
   jtextoD=new JTextArea("",3,30);
  JScrollPane jspoD=new JScrollPane(jtextoD); 
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
    cgp=new CheckboxGroup();
     A=new Checkbox("A",cgp,false);
     B=new Checkbox("B",cgp,false);
     C=new Checkbox("C",cgp,false);
     D=new Checkbox("D",cgp,false);
     MouseAdapter ms=new MouseAdapter(){
    public void mouseClicked(MouseEvent e){
        Color a=Color.white, b=Color.WHITE, c=Color.WHITE,d=Color.WHITE;
   String k=(((Checkbox)e.getSource()).getLabel());
    if(k.equals("A")){a=Color.green;key[current-1]=1;}
    else if(k.equals("B")){b=Color.green;key[current-1]=2;}
          else if(k.equals("C")){c=Color.green;key[current-1]=3;}
          else if(k.equals("D")){d=Color.green;key[current-1]=4;}
      jtextoA.setBackground(a);
      jtextoB.setBackground(b);
      jtextoC.setBackground(c);
      jtextoD.setBackground(d);
    }
    };
        A.addMouseListener(ms);
        B.addMouseListener(ms);
        C.addMouseListener(ms);
        D.addMouseListener(ms);
     JLabel spaceadj=new JLabel();
        spaceadj.setPreferredSize(new Dimension(160,20));
    editor.add(spaceadj);
    editor.add(A);
    editor.add(B);
    editor.add(C);
    editor.add(D);
    //END OF EDITOR
    add(editor);
 
 
 
    }
    static int lineCount(String q){
    StringTokenizer st=new StringTokenizer(q,"\n");
    char a[]=q.toCharArray();
    int count=1;
    for(int i=0;i<a.length;i++)
        if(a[i]=='\n')count++;
    return count;
    }
    
  
    
}
