/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class Marketing_Screen extends JFrame implements ActionListener{
    JLabel offer;
    JTextField offer1;
    JLabel Date;
    JTextField Date1;
     JLabel pro_name;
    JTextField pro_name1;
    JLabel report;
    JTextArea report1;
    
    JButton Add;
    JButton back;
    JOptionPane jop;
    private Component frame;
    public Marketing_Screen() {
        this.setLayout(null);
        offer=new JLabel("Offer");
        offer1=new JTextField();
        offer.setBounds(150, 10, 100, 30);
        offer.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        offer1.setBounds(250, 10, 220, 30);
        add(offer);
        add(offer1);
        Date=new JLabel("Date");
        Date1=new JTextField();
        Date.setBounds(150, 60, 100, 30);
        Date.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        Date1.setBounds(250, 60, 220, 30);
        add(Date);
        add(Date1);
        pro_name=new JLabel("Product name");
        pro_name1=new JTextField();
        pro_name.setBounds(150, 110, 100, 30);
        pro_name.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        pro_name1.setBounds(250, 110, 220, 30);
        add(pro_name);
        add(pro_name1);
        report=new JLabel("Make Report");
        report1=new JTextArea();
        report.setBounds(150, 170, 100, 30);
        report.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        report1.setBounds(250, 170, 220, 150);
        add(report);
        add(report1);
        Add=new JButton("ADD !!");
        Add.setBounds(250, 350, 100, 30);
        Add.setBackground(Color.WHITE);
        Add.addActionListener(this);
        add(Add);
         back=new JButton("Back");
        back.setBounds(380, 350, 100, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(650, 450);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Add){
            if(offer1.getText().isEmpty()|| report1.getText().isEmpty()){
                 jop.showMessageDialog(frame, "Enter ALL information !!");
            }
            else{
                try {
                    database.Marketing_DB.insert(offer1.getText(),pro_name1.getText(), Date1.getText(), report1.getText());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Marketing_Screen.class.getName()).log(Level.SEVERE, null, ex);
                }
                 jop.showMessageDialog(frame, "Successfull !!");

            }
        }
         if(e.getSource()==back){
             this.dispose();
             new login().show_first_screen();
         }
    }
    
    
}
