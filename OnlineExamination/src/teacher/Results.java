/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import Main.MainFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
public class Results extends MYJPanel{
    MainFrame f;
    Scanner sc;
    JPanel top;
    Results(MainFrame f,Scanner sc,int eid,String ename){
    this.f=f;
    setPreferredSize(new Dimension(800,600));
    FlowLayout fl=new FlowLayout(FlowLayout.LEFT);
    fl.setHgap(0);
    fl.setVgap(0);
    setLayout(fl);
    top=new JPanel();
    top.setPreferredSize(new Dimension(800,70));
    FlowLayout tfl=new FlowLayout();
    tfl.setHgap(15);
    top.setLayout(tfl);
    top.setBackground(Color.yellow);
    JButton back=new JButton("BACK");
    back.addActionListener((a)->{f.goToPrevious(this);f.revalidate();f.repaint();});
    back.setFont(new Font("Arial",Font.BOLD,30));
    JLabel leid=new JLabel("EID: "+eid);
    leid.setFont(new Font("Arial",Font.BOLD,30));
    JLabel lename=new JLabel("ENAME: "+ename);
    lename.setFont(new Font("Arial",Font.BOLD,30));
    top.add(back);
    top.add(leid);
    top.add(lename);
    JPanel bottom=new JPanel();
    bottom.setLayout(new FlowLayout());
   
    bottom.setBackground(Color.red);
    int n=Integer.valueOf(sc.nextLine());
    bottom.setPreferredSize(new Dimension(800,80*n));
    if(80*n<530)bottom.setPreferredSize(new Dimension(800,530));
    
    JScrollPane jsp=new JScrollPane(bottom);
       jsp.setBackground(Color.red);
    for(int i=0;i<n;i++)
    {JPanel temp=new JPanel();
        temp.setPreferredSize(new Dimension(800,75));
        temp.setBackground(Color.cyan);
        JLabel name=new JLabel("NAME   :"+sc.nextLine());
        name.setFont(new Font("Arial",Font.BOLD,25));
        name.setPreferredSize(new Dimension(300,75));
        int marks=Integer.valueOf(sc.nextLine());
        String q="MARKS:"+marks;
        if(marks==-2)q="ABSENT";
        JLabel maks=new JLabel(q);
        maks.setFont(new Font("Arial",Font.BOLD,25));
        maks.setPreferredSize(new Dimension(300,75));
        temp.add(name);
        temp.add(maks);
        bottom.add(temp);
    }
    add(top);
    add(jsp);
    }
}
