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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class update_emp extends JPanel implements ActionListener {

    JTable tabel;
    JScrollPane jsp;
    JLabel id, fname, lname, age, add, gender;
    JTextField id1, fname1, lname1, age1, add1, gender1;
    JButton Update;
    JOptionPane jop;
    String a[][];
    String header[] = {"id", "username", "password", "Age", "Department", "Gender"};
    ArrayList<user> arr;
    private Component frame;

    public update_emp() throws SQLException, ClassNotFoundException {
        this.arr = database.Admin_DB.List();
        this.setLayout(null);
        a = new String[arr.size()][6];
        for (int i = 0; i < arr.size(); i++) {
            a[i][0] = arr.get(i).getId() + "";
            a[i][1] = arr.get(i).getFname();
            a[i][2] = arr.get(i).getLname();
            a[i][3] = arr.get(i).getAge() + "";
            a[i][4] = arr.get(i).getDepartment();
            a[i][5] = arr.get(i).getGender();

        }
        tabel = new JTable(a, header);
        jsp = new JScrollPane(tabel);
        jsp.setBounds(0, 0, 300, 400);
        add(jsp);
        //***********************************
        id = new JLabel("Id");
        id.setBounds(315, 10, 100, 30);
        id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(id);
        id1 = new JTextField();
        id1.setBounds(390, 10, 170, 30);
        add(id1);

        fname = new JLabel("username");
        fname.setBounds(315, 50, 100, 30);
        fname.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(fname);
        fname1 = new JTextField();
        fname1.setBounds(390, 50, 170, 30);
        add(fname1);

        lname = new JLabel("password");
        lname.setBounds(315, 90, 100, 30);
        lname.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(lname);
        lname1 = new JTextField();
        lname1.setBounds(390, 90, 170, 30);
        add(lname1);

        age = new JLabel("Age");
        age.setBounds(315, 130, 100, 30);
        age.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(age);
        age1 = new JTextField();
        age1.setBounds(390, 130, 170, 30);
        add(age1);
        add = new JLabel("Department");
        add.setBounds(315, 170, 100, 30);
        add.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 12));
        add(add);
        add1 = new JTextField();
        add1.setBounds(390, 170, 170, 30);
        add(add1);
        gender = new JLabel("Gender");
        gender.setBounds(315, 210, 100, 30);
        gender.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(gender);
        gender1 = new JTextField();
        gender1.setBounds(390, 210, 170, 30);
        add(gender1);
        //*******************************
        Update = new JButton("Update");
        Update.setBounds(370, 260, 100, 30);
        Update.setBackground(Color.WHITE);
        Update.addActionListener(this);
        add(Update);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Update) {
            try {
                if (fname1.getText().isEmpty() && lname1.getText().isEmpty() && age1.getText().isEmpty()
                        && add1.getText().isEmpty() && gender1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter items !!");
                } else if (id1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter id !!");
                } else if (fname1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter User name !!");
                } else if (lname1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter password !!");
                } else if (age1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter Age of Employee !!");
                } else if (add1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter Department !!");
                } else if (gender1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter Gender of employee !!");
                } else {

                    database.Admin_DB.update(Integer.parseInt(id1.getText()), fname1.getText(),
                            lname1.getText(), Integer.parseInt(age1.getText()), add1.getText(), gender1.getText());
                    jop.showMessageDialog(frame, "Updated");
                    this.arr = database.Admin_DB.List();
                    this.setLayout(null);
                    a = new String[arr.size()][6];
                    for (int i = 0; i < arr.size(); i++) {
                        a[i][0] = arr.get(i).getId() + "";
                        a[i][1] = arr.get(i).getFname();
                        a[i][2] = arr.get(i).getLname();
                        a[i][3] = arr.get(i).getAge() + "";
                        a[i][4] = arr.get(i).getDepartment();
                        a[i][5] = arr.get(i).getGender();

                    }
                    tabel = new JTable(a, header);
                    jsp = new JScrollPane(tabel);
                    jsp.setBounds(0, 0, 300, 400);
                    add(jsp);
                }
            } catch (Exception j) {
                System.out.println(j.getMessage());
            }
        }

    }
}
