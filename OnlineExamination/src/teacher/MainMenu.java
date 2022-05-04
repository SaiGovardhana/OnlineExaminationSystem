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
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import others.MYJPanel;

/**
 *
 * @author saigovardhan
 */
public class MainMenu extends MYJPanel{
    JPanel courses;
     JTextField sname;
      JTextField cname;
    ArrayList<coursePanel>cours;
    public String name;
     JScrollPane jsp;
    Scanner sc;
    PrintWriter out;
    MainFrame f;
     void resetPanel(coursePanel temp){
          out.println(3);
      out.println(name);
      int x=Integer.valueOf(sc.nextLine());
      cours.clear();
      for(int i=0;i<x;i++){
          int temp1=Integer.valueOf(sc.nextLine());
          String temp2=sc.nextLine();
          String temp3=sc.nextLine();
          cours.add(new coursePanel(f,this,temp1,temp2,temp3));
      }
      
      courses.removeAll();
      for(int i=0;i<x;i++)
          courses.add(cours.get(i));
      courses.revalidate();
      courses.setPreferredSize(new Dimension(250,65*cours.size()));
      jsp.revalidate();
      courses.repaint();
      repaint();
   }
  public  MainMenu(MainFrame f,Socket s,String name){
      setBackground(Color.white);
      cours=new ArrayList<coursePanel>();
      this.f=f;
      this.name=name;
      try {sc=new Scanner(s.getInputStream());
      out=new PrintWriter(s.getOutputStream(),true);
      }
      catch(Exception e){
      System.out.println("ERROR IN INTIALIZING"+e);
      }
      out.println(3);
      out.println(name);
  
         setLayout(null);
              JPanel p1=new JPanel();
              p1.setBackground(Color.white);
            p1.setLayout(new FlowLayout());
            JPanel p2=new JPanel();
            p2.setBackground(Color.white);
            p2.setLayout(new FlowLayout());
            cname=new JTextField(15);
            JLabel c=new JLabel("Class Name:");
               sname=new JTextField(15);
            JLabel ss=new JLabel("     Subject:");
             p1.add(c);
             p1.add(cname);
             p2.add(ss);
             p2.add(sname);
             JButton create=new JButton("CREATE");
             create.setBackground(Color.cyan);
             create.addActionListener((ActionEvent e)->{addCourse();});
             p1.setBounds(50,170,250,60);
             p2.setBounds(50,240,250,60);
            create.setBounds(150,310,80,60);
             add(p1);
             add(p2);
             add(create);
                 courses=new JPanel();
                System.out.println("HERE");
               jsp=new JScrollPane(courses);
               
              courses.setBackground(Color.cyan);
           
            
             courses.setLayout(new FlowLayout());
     
             jsp.setBounds(380,60,400,500);
             int x=Integer.valueOf(sc.nextLine());
           
             courses.setPreferredSize(new Dimension(250,67*x));
        for(int i=0;i<x;i++){
            int temp1=Integer.valueOf(sc.nextLine());
            String temp2=sc.nextLine();
            String temp3=sc.nextLine();
           
                        System.out.println("WATIN Started"+temp1+temp2);
          cours.add(new coursePanel(f,this,temp1,temp2,temp3));
 System.out.println("WATIN COMPLETED");
 }
      for(int i=0;i<x;i++)
          courses.add(cours.get(i));
      System.out.println("COMPLETED");
      courses.revalidate();
        add(jsp);
        System.out.println("MAINMENU END");
        repaint();
        }
        public void addCourse(){
        String co=cname.getText();
        String su=sname.getText();
        out.println(4);
        out.println(name);
                out.println(co);
                out.println(su);
                int code=Integer.valueOf(sc.nextLine());
                if(code>=1){
                resetPanel(new coursePanel(f,this,code,co,su));
                System.out.println("ADDED COURSE "+code);
                repaint();}
               }
    public void paintComponent(Graphics g){
    super.paintComponent(g);
     g.setFont(new Font("Berlin Sans FB",Font.BOLD,25));
    g.drawString("CREATE A NEW CLASS", 40, 50);
    g.drawString("YOUR CLASSES", 450,50);
    g.fillRect(350, 0,30 , 600);
        
    }
  
    
}
