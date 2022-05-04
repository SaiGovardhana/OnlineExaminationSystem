/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import Main.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import others.MYJPanel;

/**
 *
 * @author saigovardhan
 */
public class courseMenu extends MYJPanel{
    int cid;
    String cname;
    String sub;
    PrintWriter out;
    Scanner sc;
    MainFrame f;
    JPanel presentframe;
    JPanel p2;
    public courseMenu(MainFrame f,Socket s,String cname,String sub,int cid){
        this.f=f;
        try{
        out=new PrintWriter(s.getOutputStream(),true);
        sc=new Scanner(s.getInputStream());
        }
        catch(Exception e){
        System.out.println(e);
        }
        setPreferredSize(new Dimension(800,600));
        this.sub=sub;
        this.cname=cname;
        this.cid=cid;
        FlowLayout fl=new FlowLayout();
      
        fl.setHgap(0);
        fl.setVgap(0);
        setLayout(fl);
        JLabel course=new JLabel("COURSE:"+cname);
        JLabel subject=new JLabel("SUBJECT:"+sub);
        course.setForeground(Color.black);
        subject.setForeground(Color.black);
        
       JPanel top=new JPanel();
        top.setPreferredSize(new Dimension(800,100));
        top.setBackground(Color.white);
        FlowLayout tf= new FlowLayout(FlowLayout.LEFT,0,0);
        top.setLayout(tf);
       
       JButton tt=new JButton("BACK");
       tt.addActionListener((e)->{f.goToPrevious(this);});
      tt.setPreferredSize(new Dimension(210,100));
      tt.setBackground(Color.white);
    JPanel p1=new JPanel();
         p2=new JPanel();
        FlowLayout f2=new FlowLayout(FlowLayout.CENTER,0,50); 
      top.add(tt);
      p2.setLayout(new FlowLayout(FlowLayout.LEFT));
     top.setBackground(Color.cyan);
            p2.setBackground(Color.white);
           
    p1.setPreferredSize(new Dimension(200,460));
    p2.setPreferredSize(new Dimension(580,460));
       p1.setLayout(f2);
       //ADDING BUTTONS
    JButton b1=new JButton("CREATE EXAM");
    b1.addActionListener((ae)->{p2.remove(presentframe);presentframe=new createMenu(f,this);
    p2.add(presentframe);p2.revalidate();p2.repaint();});
    b1.setBackground(Color.white);
    JButton b2=new JButton("CURRENT EXAMS");
      b2.addActionListener((ae)->{p2.remove(presentframe);presentframe=new currentMenu(f,cid,this);
    p2.add(presentframe);p2.revalidate();p2.repaint();});
    b2.setBackground(Color.white);
    JButton b3=new JButton("PREVIOUES EXAMS");
    b3.setBackground(Color.white);
     b3.addActionListener((ae)->{p2.remove(presentframe);presentframe=new completedMenu(f,cid,this);
    p2.add(presentframe);p2.revalidate();p2.repaint();});
   
    b1.setPreferredSize(new Dimension(200,50));
    b2.setPreferredSize(new Dimension(200,50));
    b3.setPreferredSize(new Dimension(200,50));
    p1.setBackground(Color.cyan);
    p1.add(b1);
    p1.add(b2);
    p1.add(b3);
 
    //END OF BUTTONS
    
 course.setHorizontalTextPosition(JLabel.RIGHT);
 course.setPreferredSize(new Dimension(250,70));
 Font fo=new Font("Arial",Font.BOLD,25);
      course.setFont(fo);
subject.setFont(fo);
  top.add(course);
        top.add(subject);
   p1.setBackground(Color.cyan);
   //Intilialize createexam layout
   p2.setLayout(new BorderLayout());
   p2.add((presentframe=new createMenu(f,this)));
    add(top);
    add(p1);
    add(p2);
  //  top.revalidate();
   // p1.revalidate();
    revalidate();
    System.out.println(getPreferredSize());
    }
}
