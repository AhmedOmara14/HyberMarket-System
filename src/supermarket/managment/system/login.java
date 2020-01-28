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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static sun.security.jgss.GSSUtil.login;

/**
 *
 * @author Ahmed
 */
public class login extends JFrame implements ActionListener {

    JLabel user, password, show,depart1;
    JTextField user_name;
    JPasswordField pass_word;
    JButton Login;
    JComboBox department;
    JOptionPane message;
    image im = new image();
    String[] items={"Admin","Inventory","Cashier","Marketing"}; 
    private Component frame;

    public login() {

    }

    public void show_first_screen() {

        user = new JLabel("Username");
        password = new JLabel("Password");
        depart1=new JLabel("Department");
        department = new JComboBox(items);
        user.setBounds(170, 130, 100, 20);
        password.setBounds(170, 170, 100, 30);
        depart1.setBounds(170, 210, 100, 30);
        im.add(user);
        im.add(password);
        im.add(depart1);
        //............
        user_name = new JTextField();
        pass_word = new JPasswordField();
       
        user_name.setBounds(280, 130, 160, 25);
        pass_word.setBounds(280, 170, 160, 25);
        department.setBounds(280, 210, 160, 25);

        im.add(user_name);
        im.add(pass_word);
       im.add(department);
        Login = new JButton("Login");

        Login.setBounds(250, 260, 100, 25);
        Login.setBackground(Color.WHITE);
        Login.addActionListener(this);
        im.add(Login);

        //.................
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(600, 380);

        add(im);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login) {
            int i;
            try {
                i = database.Admin_DB.Check(user_name.getText(), pass_word.getText(),  department.getSelectedItem());
                if (i == 0) {
                    message.showMessageDialog( frame , "Username wrong");
                } else if (i == 1) {
                    
                    if( department.getSelectedItem().equals("Admin") ){
                          this.dispose();
                          new admin_screen().show_second_screen();
                    }
                    else if (department.getSelectedItem().equals("Inventory")){
                          this.dispose();
                          new inventory_screen().show_inventory_screen();
                    }
                    else if (department.getSelectedItem().equals("Marketing")){
                          this.dispose();
                           new Marketing_Screen();
                          // put calling to Marketting screen
                    }
                     else if (department.getSelectedItem().equals("Cashier")){
                          this.dispose();
                          new Cashier_Screen().show_Casier_Screen();
                          // put calling to Sales screen
                    }
                 
                    message.showMessageDialog( frame , "Wellcome " + department.getSelectedItem() + " Employee");
                    
                    
                } else if (i == 2) {
                    message.showMessageDialog( frame , "password wrong");
                    //System.out.println("password wrong");
                }
                else if(i==3){
                message.showMessageDialog( frame , "department wrong");
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
