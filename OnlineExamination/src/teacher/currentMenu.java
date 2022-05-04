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
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author saigovardhan
 */
public class currentMenu extends JPanel {
    JScrollPane jsp;
    JPanel exams;
    int cid;
    ArrayList<currentExamPanel>exp;
    PrintWriter out;
    Scanner sc;
    courseMenu men;
    currentMenu(MainFrame f,int cid,courseMenu men){
        this.cid=cid;
   setLayout(new BorderLayout());
   try{
      out= new PrintWriter(f.s.getOutputStream());
      sc=new Scanner(f.s.getInputStream());
   }catch(Exception e){
   System.out.println(e);
   }
   out.println(8);
   out.println(cid);
   out.flush();
      //  setPreferredSize(new Dimension(500,460));
      int x=Integer.valueOf(sc.nextLine());
      
      exams=new JPanel();
        exams.setBackground(Color.white);
        exams.setLayout(new FlowLayout());
        if(x==-2)
        {exams.setLayout(new BorderLayout());
               JLabel lb=new JLabel("THERE IS AN EXAM ALREADY RUNNING");
            lb.setFont(new Font("Arial",Font.BOLD,28));
            exams.add(lb);
       }
        if(x==0)
            {exams.setLayout(new BorderLayout());
               JLabel lb=new JLabel("THERE ARE NO EXAMS TO BE CONDUCTED");
            lb.setFont(new Font("Arial",Font.BOLD,24));
            exams.add(lb);
       }
        if(x>0)    
        exams.setPreferredSize(new Dimension(500,80*x));
        for(int i=0;i<x;i++){
            int a=Integer.valueOf(sc.nextLine());
            String b=sc.nextLine();
            String c=sc.nextLine();
            exams.add(new currentExamPanel(a,b,c,this));
        }
            jsp=new JScrollPane(exams);
           
            //jsp.setPreferredSize(new Dimension(490,450));
            add(jsp);
        
        
    }

    
}
