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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author saigovardhan
 */
public class createMenu extends JPanel{
    JTextField ftime;
    JTextField fques;
    JTextField ex;
    JLabel in=new JLabel("INPUT MUST BE AN INTEGER");
    boolean flag=false;
    createMenu(MainFrame f,courseMenu m){
        setBackground(Color.white);
        setPreferredSize(new Dimension(500,460));
        setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel cr=new JLabel("CREATE AN EXAM");
           
           cr.setFont(new Font("Arial",Font.BOLD,38));
           cr.setPreferredSize(new Dimension(480,100));
           JLabel et=new JLabel("ENTER EXAM DURATION IN MINUTES");
           et.setFont(new Font("Arial",Font.BOLD,30));
            ftime=new JTextField(10);
           JLabel q=new JLabel("ENTER THE NO.OF QUESTIONS");
             JLabel exname=new JLabel("ENTER THE NAME OF EXAM");
             ex=new JTextField(10);
             exname.setFont(new Font("Arial",Font.BOLD,34));
           q.setFont(new Font("Arial",Font.BOLD,34));
           fques=new JTextField(10);
            JButton create=new JButton("CREATE");
            create.addActionListener((e)->{
                String tt=ftime.getText().trim();
                String ff=fques.getText().trim();
                if(tt.length()==0||ff.length()==0||ex.getText().trim().length()==0){
                {if(!flag)add(new JLabel("INPUT MUST BE IN INTEGERS"));
                    flag=true;revalidate();return;}}
                for(char x:tt.toCharArray())
                    if(!(x>='0'&&x<='9')){if(!flag)add(new JLabel("INPUT MUST BE IN INTEGERS"));
                    flag=true;revalidate();return;}
                for(char x:ff.toCharArray())
                    if(!(x>='0'&&x<='9')){if(!flag)add(new JLabel("INPUT MUST BE IN INTEGERS"));
                    flag=true;revalidate();return;}
                   QuestionPrepare qp= new QuestionPrepare(f,m,Integer.valueOf(ff),Integer.valueOf(tt),m.cid,m.cname,m.sub,ex.getText().trim());
          f.changeFrame(m,qp);
            });
            add(cr);
            add(et);
            add(ftime);
            create.setBackground(Color.white);
            add(q);
            add(fques);
            JLabel padder1=new JLabel("");
            JLabel padder2=new JLabel("");
            padder1.setPreferredSize(new Dimension(150,30));
            padder2.setPreferredSize(new Dimension(50,30));
            add(padder1);
            add(exname);
            add(padder2);
            add(ex);
            add(create);
            
            
                   
            
    
    }
    
}
