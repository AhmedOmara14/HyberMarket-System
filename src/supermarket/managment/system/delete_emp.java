/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class delete_emp extends JPanel implements ActionListener{
    JLabel de;
    JOptionPane jop;
    JTextField tx;
    JButton del;
    private Component frame;

    public delete_emp() {
        this.setLayout(null);
        de=new JLabel("Enter the id of Employee");
        de.setBounds(100, 100, 200, 30);
        add(de);
        tx=new JTextField();
        tx.setBounds(250, 100, 170, 30);
        add(tx);
        del=new JButton("Delete");
        del.setBounds(220, 155, 100, 30);
        del.setBackground(Color.WHITE);
        del.addActionListener(this);
        add(del);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==del){
             if(tx.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter id !!");
                  }
                  else{
               
                 try {
                     database.Admin_DB.delete(Integer.parseInt(tx.getText()));
                 } catch (ClassNotFoundException ex) {
                     Logger.getLogger(delete_emp.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
             jop.showMessageDialog(frame, "Delete Employee");
             }
        }
    }
    
}
