/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teacher;

import Main.MainFrame;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author saigovardhan
 */
public class coursePanel extends JPanel{
   public JButton go;
    JLabel cn;
    JLabel sub;
    int height;
    int cid;
    MainFrame frame;
    MainMenu menu;
    String classname;
    String subject;
    public coursePanel(MainFrame frame,MainMenu menu,int cid,String classname,String subject){
        this.menu=menu;
        this.frame=frame;
        this.cid=cid;
        this.classname=classname;
        this.subject=subject;
       go=new JButton("GO");
        height=60;
        go.setActionCommand(classname+subject);
       go.addActionListener((ActionEvent e)->{JButton temp=(JButton)e.getSource();
      coursePanel tt=(coursePanel)temp.getParent();
      courseMenu n=new courseMenu(frame,frame.s,tt.classname,tt.subject,cid);
       frame.changeFrame(menu,n);
       });
        setLayout(new FlowLayout());
    setPreferredSize(new Dimension(400,height));
           Font fon=new Font("Arial",Font.BOLD,12);
    cn=new JLabel("ClassName:"+classname);
    cn.setFont(fon);
    sub=new JLabel("Subject:"+subject);
 sub.setFont(fon);
   cn.setPreferredSize(new Dimension(120,height-15));
    sub.setPreferredSize(new Dimension(120,height-15));
    go.setPreferredSize(new Dimension(90,height-15));
    go.setBackground(Color.cyan);
   setBackground(Color.white);
    add(cn);
    add(sub);
    add(go);
    
    }
}
