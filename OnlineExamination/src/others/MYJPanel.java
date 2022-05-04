/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;

import javax.swing.JPanel;

/**
 *
 * @author saigovardhan
 */
public class MYJPanel extends JPanel {
    private MYJPanel next;
    private MYJPanel prev;
    public MYJPanel(){
    
    }
    public MYJPanel getCurrent(){
    return this;
    }
    public void setNext(MYJPanel temp){
    next=temp;
    }
    public void setPrev(MYJPanel temp){
        prev=temp;
            }
    public MYJPanel getNext(){
    return next;
    }
    public MYJPanel getPrev(){
    return prev;
    }
    
}
