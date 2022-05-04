/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import Main.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.TOP;
import others.MYJPanel;

/**
 *
 * @author saigovardhan
 */
public class MainMenu extends MYJPanel{
    MainFrame f;
    JPanel mycourses;
    JPanel allcourses;
    JScrollPane myjsp;
    JTextField classname;
    JTextField subject;
    String user;
    Scanner sc;
    PrintWriter out;
    int x;
   public MainMenu(MainFrame f,Socket s,String user){
        this.f=f;
        this.user=user;
        try{
        sc=new Scanner(s.getInputStream());
        out=new PrintWriter(s.getOutputStream(),true);
        }
        catch(Exception e){
        System.out.println("Couldnt intialize io in student menu");
        }
        
        FlowLayout fl=new FlowLayout();
        fl.setHgap(0);
        fl.setVgap(0);
       setLayout(fl);
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
     mycourses=new JPanel();
   
   myjsp=new JScrollPane(mycourses);
   mycourses.setLayout(fl);
   mycourses.setBackground(Color.white);
   mycourses.setPreferredSize(new Dimension(365,100));
   myjsp.setPreferredSize(new Dimension(390,490));
    p1.setPreferredSize(new Dimension(392,600));
    p1.setBackground(Color.white);
    p2.setPreferredSize(new Dimension(392,600));
    myjsp.setBorder(null);
    
    Label l1=new Label("MY COURSES");
    l1.setFont(new Font("Arial",Font.BOLD,32));
    l1.setBackground(Color.white);
    JLabel l2=new JLabel("SEARCH COURSES");
       classname=new JTextField(15);
       subject=new JTextField(12);
    JLabel l3=new JLabel("ENTER COURSE NAME");
    JLabel l4=new JLabel("ENTER SUBJECT NAME");
    JButton search=new JButton("ADD");
        l4.setFont(new Font("Arial",Font.BOLD,20));
       l2.setFont(new Font("Arial",Font.BOLD,32));
        l2.setVerticalTextPosition(JLabel.TOP);
    l2.setBackground(Color.cyan);
    l3.setFont(new Font("Arial",Font.BOLD,20));
    l3.setPreferredSize(new Dimension(270,100));
     l4.setPreferredSize(new Dimension(270,100));       
        l3.setVerticalAlignment(JLabel.CENTER);
        l4.setVerticalAlignment(JLabel.CENTER);
  search.setBackground(Color.white);
       search.addActionListener((ActionEvent e)->{addCourse();});
  
       p1.add(l1);
    p2.add(l2);
    p2.add(l3);
    p2.add(classname);
    p2.add(l4);
    p2.add(subject);
    p2.add(search);
    p1.add(myjsp);
    p1.setBackground(Color.white);
    p2.setBackground(Color.cyan);
    add(p1);
    add(p2);
    out.println(5);
    out.println(user);
    out.flush();
    x=Integer.valueOf(sc.nextLine());
    
    mycourses.setPreferredSize(new Dimension(365,x*65));
    for(int i=0;i<x;i++)
    {int cid=Integer.valueOf(sc.nextLine());
        String cls=sc.nextLine();
        String su=sc.nextLine();
        coursePanel temp=new coursePanel(f,this,cid,cls,su);
        mycourses.add(temp);
    }
    mycourses.revalidate();
    revalidate();
    repaint();
    }
   void reArrange(coursePanel temp){
       x++;
       System.out.println("HERE IN REARRANGE");
       mycourses.add(temp);
       mycourses.setPreferredSize(new Dimension(365,x*65));
     
       mycourses.revalidate();;
       myjsp.revalidate();
       mycourses.repaint();
       
       myjsp.repaint();
   revalidate();
   repaint();
   }
    void addCourse(){
        String clas=classname.getText().trim();
        String sub=subject.getText().trim();
        out.println(6);
        out.println(user);
        out.println(clas);
        out.println(sub);
        out.flush();
        int response=Integer.valueOf(sc.nextLine());
        if(response>=1){System.out.println("HERE");
            System.out.println("HERE"+response);
        coursePanel temp=new coursePanel(f,this,response,clas,sub);
       
                reArrange(temp);
        }
    }
    
}
