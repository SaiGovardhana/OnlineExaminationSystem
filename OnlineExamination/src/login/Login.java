/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Main.MainFrame;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import others.MYJPanel;
import teacher.MainMenu;

public class Login extends MYJPanel{
    Socket s;
    Scanner sc=null;
    PrintWriter out;
    private CheckboxGroup bg;
    private MainFrame f;
    private Checkbox teacher;
    private Checkbox student;
    private JTextField t1;
    private JPasswordField t2;
    private int response=-1;
    
    public Login(MainFrame f,Socket s) throws IOException{
        sc=new Scanner(s.getInputStream());
        this.s=s;
        out=new PrintWriter(s.getOutputStream());
        this.f=f;
        bg=new CheckboxGroup();
        teacher=new Checkbox("Teacher",bg,false);
        teacher.setBackground(Color.white);
        student=new Checkbox("Student",bg,true);
        student.setBackground(Color.white);
        teacher.setFocusable(false);
        student.setFocusable(false);
        JButton log=new JButton("Login");
        JButton bac=new JButton("BACK");
        log.setBackground(Color.white);
        bac.setBackground(Color.white);
        bac.addActionListener((ActionEvent e)->{
        f.goToPrevious(this);
        });
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        JPanel p4=new JPanel();
        p4.setLayout(new FlowLayout());
        p4.add(teacher);
        p4.add(student);
        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p3.add(bac);
        p3.add(log);
        t1=new JTextField(15);
        JLabel  l1=new JLabel("Username:");
         t2=new JPasswordField(15);
        JLabel  l2=new JLabel("Password:");
        log.addActionListener(new createAdapter());
        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p1.setBounds(200,170,250,60);
        p1.setBackground(Color.cyan);
        p2.setBackground(Color.white);
        p2.setBounds(200,240,250,60); 
        p3.setBackground(Color.cyan);
        p3.setBounds(220,380,250,70); 
        p4.setBackground(new Color(0,0,0,0));
        p4.setBounds(220,310,250,70);
        setLayout(null);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        revalidate();
        repaint();
    }
    
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
    g.fillRect(0, 0, 800,600);
    g.setColor(Color.cyan);
    g.fillRect(0,0,800,230);
    
     g.fillRect(0,350,800,220);
    g.setFont(new Font("Berlin Sans FB",Font.BOLD,30));
     g.setColor(Color.black);
    g.drawString("LOGIN TO YOUR ACCOUNT",150,100);
        
    
    }
    class createAdapter implements ActionListener{
    public void actionPerformed(ActionEvent e){try{
        System.out.println("HERE");
                String name=t1.getText();
                String password=String.valueOf(t2.getPassword());
                int x=0;
                if(bg.getSelectedCheckbox()==teacher)x=1;
                out.println(1);
                out.println(x);
                out.println(name);
                out.println(password);
                out.flush();
                System.out.println(name+"\n"+password);
               int result=Integer.valueOf(sc.nextLine());
               if(result==-1)System.out.println("ERROR");
               if(result==0)System.out.println("NO ACCOUNT");
              if(result==1){
                  if(x==1){//OPEN TEACHERS MENU
                  MainMenu temp=new MainMenu(f,s,name);
                  f.changeFrame(getCurrent(),temp);
                  
                  }
              if(x==0){//OPEN STUDENTS MENU
                  System.out.println("HERE IN MEMI");
              student.MainMenu temp=new student.MainMenu(f,s,name);
              System.out.println("HERE IN MEMI");
              f.changeFrame(getCurrent(),temp);
              }
             }}
    catch(Exception ep){
    }
    System.out.println("INSIDE");
                
    
    }
    
    }
    
}
