/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import database.Admin_DB;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class add_emp extends JPanel implements ActionListener {

    JLabel id,user_name, pass_word, age, add, gender;
    JTextField id1,fname1, lname1, age1, add1, gender1;
    JButton add_Em, new1,back;
    JOptionPane jop;
    private Component frame;

    public add_emp() {
        this.setLayout(null);
        id=new JLabel("ID");
        user_name = new JLabel("Username");
        pass_word = new JLabel("Password");
        age = new JLabel("Age");
        add = new JLabel("Department");
        gender = new JLabel("Gender");
        id.setBounds(180, 10, 100, 30);
        user_name.setBounds(180, 50, 100, 30);
        pass_word.setBounds(180, 90, 100, 30);
        age.setBounds(180, 130, 100, 30);
        add.setBounds(180, 170, 100, 30);
        gender.setBounds(180, 210, 100, 30);
        id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        user_name.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        pass_word.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        age.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        add.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        gender.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 14));
        add(id);
        add(user_name);
        add(pass_word);
        add(age);
        add(add);
        add(gender);
        //..................
        id1=new JTextField();
        fname1 = new JTextField();
        lname1 = new JTextField();
        age1 = new JTextField();
        add1 = new JTextField();
        gender1 = new JTextField();
        id1.setBounds(290, 10, 150, 30);
        fname1.setBounds(290, 50, 150, 30);
        lname1.setBounds(290, 90, 150, 30);
        age1.setBounds(290, 130, 150, 30);
        add1.setBounds(290, 170, 150, 30);
        gender1.setBounds(290, 210, 150, 30);
        add(id1);
        add(fname1);
        add(lname1);
        add(age1);
        add(add1);
        add(gender1);
        //.................
        add_Em = new JButton("ADD");
        add_Em.setAlignmentX(CENTER_ALIGNMENT);
        add_Em.setBounds(200, 270, 80, 25);
        add_Em.setBackground(Color.white);
        add_Em.addActionListener(this);
        add(add_Em);
        new1 = new JButton("NEW");
        new1.setBounds(290, 270, 80, 25);
        new1.setBackground(Color.white);
        new1.addActionListener(this);
        add(new1);
        back = new JButton("Back");
        back.setBounds(380, 270, 80, 25);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new1) {
            id1.setText("");
            fname1.setText("");
            lname1.setText("");
            age1.setText("");
            add1.setText("");
            gender1.setText("");
        }
         if(e.getSource()==back){
             this.setVisible(false);
             new login().show_first_screen();
         }
          if (e.getSource() == add_Em) {
              try{
                   if(fname1.getText().isEmpty()&&lname1.getText().isEmpty()&&age1.getText().isEmpty()&&
                          add1.getText().isEmpty()&&gender1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter items !!");
                  }
                   else if(id1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter id !!");
                  }
                else if(fname1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter first name !!");
                  }
                else if(lname1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter last name !!");
                  }
                else if(age1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter Age of Employee !!");
                  }
                 else if(add1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter Department !!");
                  }
                  else if(gender1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter Gender of employee !!");
                  }
                  else if(fname1.getText().isEmpty()&&lname1.getText().isEmpty()&&age1.getText().isEmpty()&&
                          add1.getText().isEmpty()&&gender1.getText().isEmpty()){
                      jop.showMessageDialog(frame, "Enter items !!");
                  }
                  else{
              database.Admin_DB.insert(Integer.parseInt(id1.getText()),fname1.getText(), 
                                          lname1.getText(), Integer.parseInt(age1.getText()), add1.getText(), gender1.getText());
              
                jop.showMessageDialog(frame, "Successfull !!");
                  }
              }
              catch(Exception j){
                  System.out.println(j.getMessage());
              }
          }
          
              
    }

}
