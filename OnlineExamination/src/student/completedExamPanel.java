/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author saigovardhan
 */
public class completedExamPanel extends JPanel{
    int eid;
    String ename;
    String duration;
    JLabel leid,lename,lduration;
    JButton start;
    int length,height;
    completedExamPanel(int eid,String ename,String duration,completedMenu menu){
        length=100;height=70;
    setPreferredSize(new Dimension(570,70));
    setLayout(new FlowLayout(FlowLayout.LEFT));
    setBackground(Color.cyan);
    Font f=new Font("Arial",Font.BOLD,12);
    this.eid=eid;
    this.ename=ename;
    this.duration=duration;
    leid=new JLabel("EID:"+Integer.toString(eid));
    leid.setFont(f);
    lename=new JLabel("EXAM:"+ename);
    lename.setFont(f);
    lduration=new JLabel("TIME:"+duration);
    lduration.setFont(f);
    start=new JButton("VIEW");
    start.setBackground(Color.white);
    leid.setPreferredSize(new Dimension(length,height-15));
    lename.setPreferredSize(new Dimension(length,height-15));
    lduration.setPreferredSize(new Dimension(length,height-15));
    start.setPreferredSize(new Dimension(length,height-15));
    start.addActionListener((ea)->{
        menu.out.println(13);
     menu.out.println(eid);
     menu.out.println(menu.men.sid);
     menu.out.flush();
     if(menu.sc==null)System.out.println("DOESNT EXIST");
     int n=Integer.valueOf(menu.sc.nextLine());
     if(n==1)
     menu.f.changeFrame(menu.men,new AnswerChecker(menu.f,menu.sc));
     
                });
    add(leid);
    add(lename);;
    add(lduration);
    add(start);
    }


}


