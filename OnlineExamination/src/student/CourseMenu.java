/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import Main.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import others.MYJPanel;


/**
 *
 * @author saigovardhan
 */
 public class CourseMenu extends MYJPanel{
    int cid;
    String cname;
    String sub;
    String sid;
    MainFrame frame;
    PrintWriter out;
    Scanner sc;
    JPanel currentfram;
    public CourseMenu(MainFrame frame,String sid,String cname,String sub,int cid){
        this.frame=frame;
        this.sid=sid;
        setPreferredSize(new Dimension(800,600));
        this.sub=sub;
        this.cname=cname;
        this.cid=cid;
        FlowLayout fl=new FlowLayout();
      try{
      out=new PrintWriter(frame.s.getOutputStream());
        sc=new Scanner(frame.s.getInputStream());
      }
      catch(Exception e){
      System.out.println("ERROR IN INTITALIZING");
      }
        fl.setHgap(0);
        fl.setVgap(0);
        setLayout(fl);
        JLabel student=new JLabel(""+sid);
         JLabel course=new JLabel("COURSE:"+cname);
        JLabel subject=new JLabel("SUBJECT:"+sub);

        
       JPanel top=new JPanel();
        top.setPreferredSize(new Dimension(800,100));
        top.setBackground(Color.white);
        FlowLayout tf= new FlowLayout(FlowLayout.LEFT,0,0);
        top.setLayout(tf);
       
       JButton tt=new JButton("BACK");
       tt.addActionListener((ae)->{frame.goToPrevious(this);});
      tt.setPreferredSize(new Dimension(210,100));
      tt.setBackground(Color.white);
    JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        FlowLayout f2=new FlowLayout(FlowLayout.CENTER,0,50); 
      top.add(tt);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
     top.setBackground(Color.cyan);
            p2.setBackground(Color.cyan);
           
    p1.setPreferredSize(new Dimension(200,460));
    p2.setPreferredSize(new Dimension(580,460));
       p1.setLayout(f2);
       //ADDING BUTTONS
   
    JButton b2=new JButton("CURRENT EXAM");
    b2.setBackground(Color.white);
    JButton b3=new JButton("PREVIOUES EXAMS");
    b3.setBackground(Color.white);
 
    b3.setBackground(Color.white);

    b2.setPreferredSize(new Dimension(200,50));
    b3.setPreferredSize(new Dimension(200,50));
    JLabel welcome=new JLabel("WELCOME");
   
    welcome.setFont(new Font("Arial",Font.BOLD,37));
   // welcome.setPreferredSize(new Dimension(170,20));
    //welcome.se
    student.setFont(new Font("Arial",Font.BOLD,20));
    p1.add(b2);
    p1.add(b3);
    p1.add(welcome);
   p1.add(student);
    //END OF BUTTONS
    
 course.setHorizontalTextPosition(JLabel.RIGHT);
 course.setPreferredSize(new Dimension(250,70));
 Font f=new Font("Arial",Font.BOLD,25);
      course.setFont(f);
subject.setFont(f);
  top.add(course);
        top.add(subject);
   p1.setBackground(Color.cyan);
   //Intilialize createexam layou
 
   out.flush();
   p2.setLayout(new BorderLayout());
   p2.setBackground(Color.yellow);
   p2.add((currentfram=new currentExam(this,out,sc)));
   b2.addActionListener((ae)->{
       p2.remove(currentfram);
   currentfram=new currentExam(this,out,sc);
           p2.add(currentfram);
           p2.revalidate();
           p2.repaint();
           revalidate();
           repaint();
         });
    b3.addActionListener((ae)->{
       p2.remove(currentfram);
   currentfram=new completedMenu(this.frame,cid,this);
           p2.add(currentfram);
           p2.revalidate();
           p2.repaint();
           revalidate();
           repaint();
         });
    add(top);
    add(p1);
    add(p2);
  //  top.revalidate();
   // p1.revalidate();
    revalidate();
    System.out.println(getPreferredSize());
    }
}

    
    

