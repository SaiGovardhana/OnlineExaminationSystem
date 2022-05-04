/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Main.MainFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import static java.awt.font.TextAttribute.FONT;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.border.Border;
import others.MYJPanel;

/**
 *
 * @author saigovardhan
 */
public class Home extends MYJPanel{
    MainFrame f;
    Socket s;
    
  public  Home(MainFrame f,Socket s)throws IOException{
     this.s=s;
      this.f=f;
        setSize(800,600);
        setLayout(null);
        JButton log=new JButton("LOGIN");
        JButton Create=new JButton("CREATE AN ACCOUNT");
        log.addActionListener(
        (ActionEvent e)->{ try{
        f.changeFrame(this, new login.Login(f,s));}
        catch(IOException re){}
        });
         Create.addActionListener(
        (ActionEvent e)->{ try{
        f.changeFrame(this, new login.CreateAccount(f,s));}
        catch(IOException re){}
        });
        log.setBounds(275,200,200,100);
        Create.setBounds(275,330,200,100);
        Create.setBackground(Color.white);
        Create.setFocusPainted(false);
        Create.setBorderPainted(false);
        log.setFocusPainted(false);
        log.setOpaque(false);
        log.setBackground(Color.white);
        add(log);
        add(Create);
        
       
    }
    public void paintComponent(Graphics h){
        super.paintChildren(h);
    h.setColor(Color.white);
    h.fillRect(0, 0, 800,600);
    h.setColor(Color.cyan);
    h.fillRect(0,0,800,230);
    
     h.fillRect(0,350,800,220);
    h.setColor(Color.black);
    h.setFont(new Font("Berlin Sans FB",Font.BOLD,30));
    h.drawString("ONLINE EXAMINATION PLATFORM",150,100);
    
    }
}
