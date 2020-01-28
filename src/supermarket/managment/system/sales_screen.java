/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 *
 * @author ME2
 */
public class sales_screen extends JFrame implements ActionListener{
    JTabbedPane jtp;

    list_pro ls;
    search_pro sc;
    JTextField pid,pammount;
    JButton m_order,k_order;
    JLabel make,cancel;
            
    
    public void show_sales_screen () throws SQLException, ClassNotFoundException{
    ls = new list_pro();
    sc=new search_pro();
    jtp = new JTabbedPane();
    jtp.add("Search on product",sc);
    jtp.add("List Of Products", ls);
    add(jtp);
    
    make=new JLabel("pro id");
    cancel = new JLabel("pro price");
    make.setBounds(180, 10, 100, 30);
    cancel.setBounds(180, 90, 100, 30);
    
    make.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14)); 
    cancel.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
    
    add(make);
        add(cancel);
        
        pid=new JTextField();
        pammount = new JTextField();
        
        pid.setBounds(290, 10, 150, 30);
        pammount.setBounds(290, 90, 150, 30);
        
        add(pid);
        add(pammount);
        
        //.................
        m_order = new JButton("make order");
        m_order.setAlignmentX(CENTER_ALIGNMENT);
        m_order.setBounds(220, 270, 80, 25);
        m_order.setBackground(Color.white);
        m_order.addActionListener((ActionListener) this);
        add(m_order);
        k_order = new JButton("cancel order");
        k_order.setAlignmentX(CENTER_ALIGNMENT);
        k_order.setBounds(310, 270, 80, 25);
        k_order.setBackground(Color.white);
        k_order.addActionListener((ActionListener) this);
        add(k_order);
        //.................
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(600, 400);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == m_order) {
            
            
        }
          if (e.getSource() == k_order) {
              try{
                   
                 
                  
                  
                  
              
              }
              catch(Exception j){
                  j.getLocalizedMessage();
              }
          }
    }
    
}
