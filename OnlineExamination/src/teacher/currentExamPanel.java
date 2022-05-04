/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

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
public class currentExamPanel extends JPanel{
    int eid;
    String ename;
    String duration;
    JLabel leid,lename,lduration;
    JButton start;
    int length,height;
    currentExamPanel(int eid,String ename,String duration,currentMenu menu){
        length=100;height=70;
    setPreferredSize(new Dimension(570,70));
    setLayout(new FlowLayout(FlowLayout.LEFT));
    setBackground(Color.cyan);
    Font f=new Font("Arial",Font.BOLD,14);
    this.eid=eid;
    this.ename=ename;
    this.duration=duration;
    leid=new JLabel("EID:"+Integer.toString(eid));
    leid.setFont(f);
    lename=new JLabel("EXAM:"+ename);
    lename.setFont(f);
    lduration=new JLabel("TIME:"+duration);
    lduration.setFont(f);
    start=new JButton("START");
    start.setBackground(Color.white);
    leid.setPreferredSize(new Dimension(length,height-15));
    lename.setPreferredSize(new Dimension(length,height-15));
    lduration.setPreferredSize(new Dimension(length,height-15));
    start.setPreferredSize(new Dimension(length,height-15));
    start.addActionListener((ea)->{
        menu.out.println(9);
        menu.out.println(eid);
        menu.out.println(menu.cid);
        menu.out.println(ename);
        menu.out.println(duration);
        menu.out.flush();
      
                });
    add(leid);
    add(lename);;
    add(lduration);
    add(start);
    }


}
