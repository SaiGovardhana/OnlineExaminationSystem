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
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author saigovardhan
 */
public class coursePanel extends JPanel {
   public int courseid;
   public String classname;
   public String subject;
   JButton button;
   final static int  width=390;
   final static int height=60;
   coursePanel(MainFrame  ff,MainMenu m,int courseid,String classname,String subject){
       Font f=new Font("Arial",Font.BOLD,12);
       this.classname=classname;
       this.subject=subject;
      System.out.println(courseid+"  "+classname+"   "+subject);
       this.courseid=courseid;
       setBackground(Color.cyan);
       FlowLayout fl=new FlowLayout();
       fl.setHgap(0);
       setLayout(fl);
   setPreferredSize(new Dimension(width,height));
   JLabel clas=new JLabel("CLASS:"+classname);
   clas.setFont((f));
   clas.setPreferredSize(new Dimension(120,height-15));
   JLabel sub=new JLabel("SUBJECT:"+subject);
   sub.setPreferredSize(new Dimension(170,height-15));
   sub.setFont(f);
   button=new JButton("GO");
   button.addActionListener((ae)->{ff.changeFrame(m,new CourseMenu(ff,m.user,classname,subject,courseid));
   ff.revalidate();ff.repaint();
   });
   button.setBackground(Color.white);
   add(clas);
   add(sub);
   add(button);
   }
   public boolean equals(Object obj){
   if(!(obj instanceof coursePanel))
   return false;
   if(this.courseid==((coursePanel)obj).courseid)return true;
   else return false;
   } 
}
