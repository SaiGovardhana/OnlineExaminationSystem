package Main;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.UIManager;
import others.MYJPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saigovardhan
 */
public class MainFrame extends javax.swing.JFrame {
  public   Socket s;
  public int actualwidth,actualheight;
    public void closeSocket() throws IOException{
    
    s.close();
    }
   public void goToPrevious(MYJPanel temp){
        MYJPanel current=temp.getPrev();
        current.setNext(null);
        remove(temp);
        add(current);
        revalidate();
        repaint();
    }
    public void changeFrame(MYJPanel from,MYJPanel to){
    from.setNext(to);
    to.setPrev(from);
    remove(from);
    add(to);
    revalidate();
    repaint();
    
    }
    public void changeFrame(MYJPanel temp){
    
    System.out.println("MAINMENU CHANGE");
    add(temp);
    System.out.println("MAINMENU CHANGE");
    revalidate();
    repaint();
    temp.repaint();
    }
  
    public MainFrame()  {
        setTitle("OnlineExamination-CLIENT");
        File fil=new File("ip.txt");
        String q="localhost";
        System.out.println(q);
        try{
            Scanner sc=new Scanner(new FileInputStream(fil));
        if(fil.exists()){q=sc.nextLine().trim();}
      
        }
        catch(Exception e){}
        try{
        Socket s=new Socket(q,4105);
        if(s==null){setVisible(false);setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);dispose();System.exit(0);}
        else{this.s=s;
        initComponents();
        setResizable(false);
        setLayout(new BorderLayout());
       add(new login.Home(this,s));
    
         setSize(800,600);}
        setVisible(true);
        System.out.println("HEIGHT UPDATED");
        actualheight=this.getInsets().top+this.getInsets().bottom;
        actualwidth=this.getInsets().left+this.getInsets().right;
        }
    catch(Exception e){}
     
       
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             
                new MainFrame();
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
System.out.println(screenSize);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
