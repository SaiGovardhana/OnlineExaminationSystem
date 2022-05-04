/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author saigovardhan
 */
public class currentExam extends JPanel{
    CourseMenu m;
    PrintWriter out;
    Scanner sc;
    int eid;
    String start,end,ename;
    JButton startb;
    currentExam(CourseMenu m,PrintWriter out,Scanner sc){
    this.sc=sc;
    this.out=out;
    this.m=m;
    out.println(10);
    out.println(m.cid);
    out.flush();
    this.eid=Integer.valueOf(sc.nextLine());
    if(eid==-1){setBackground(Color.white);
        setLayout(new BorderLayout());
    JLabel nill=new JLabel("THERE IS NO EXAM RUNNNING");
    nill.setFont(new Font("Arial",Font.BOLD,34));
    add(nill);
    return;
    }
    FlowLayout fl=new FlowLayout(FlowLayout.CENTER);
    fl.setVgap(25);
    setBackground(Color.white);
    setLayout(fl);
    this.ename=sc.nextLine();
    this.start=sc.nextLine();
    this.end=sc.nextLine();
    Font f=new Font("Arial",Font.BOLD,28);
    JLabel leid=new JLabel("EID:"+this.eid);
    JLabel lename=new JLabel("EXAM:"+this.ename);
    JLabel lstart=new JLabel("STARTTIME:"+start);
    JLabel lend=new JLabel("ENDTIME:"+end);
     startb=new JButton("START EXAM");
    startb.setFont(f);
    leid.setFont(f);
    lename.setFont(f);
    lstart.setFont(f);
    lend.setFont(f);
    add(leid);
    add(lename);
    add(lend);
    add(lstart);
    startb.setBackground(Color.red);
    startb.addActionListener((ae)->{startExam();});
    add(startb);
    
   
    }
    void startExam(){
            out.println(11);
            System.out.println(m.sid+""+m.cid);
            out.println(m.sid);
            out.println(m.cid);
            out.flush();
            System.out.println("STARTED");
            if(sc.nextLine().equals("-1")){    System.out.println("STARTED MEOW");;return;}
            m.frame.remove(m);
            m.frame.add(new ExamRunner(m.frame,sc,out,m));
            m.frame.revalidate();
            m.frame.repaint();
            System.out.println("HERE");
    
    }
    
}
