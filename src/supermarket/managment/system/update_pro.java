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
import static javax.swing.JComponent.TOOL_TIP_TEXT_KEY;
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
public class update_pro extends JPanel implements ActionListener {

    JTable tabel;
    JScrollPane jsp;
    JLabel pro_id, pro_name, pro_price, pro_ammount;
    JTextField pro_id1, pro_name1, pro_price1, pro_ammount1;
    JButton Update;
    JOptionPane jop;
    String a[][];
    String header[] = {"pro Id", "pro Name", "pro Price", "pro Ammount"};
    ArrayList<products> arr;
    private Component frame;

    public update_pro() throws SQLException, ClassNotFoundException {
        this.arr = database.inventory_db.List();
        this.setLayout(null);
        a = new String[arr.size()][4];
        for (int i = 0; i < arr.size(); i++) {
            a[i][0] = Integer.toString(arr.get(i).getPro_id());
            a[i][1] = arr.get(i).getPro_name();
            a[i][2] = Float.toString(arr.get(i).getPro_price());
            a[i][3] = Float.toString(arr.get(i).getPro_ammount());

        }
        tabel = new JTable(a, header);
        jsp = new JScrollPane(tabel);
        jsp.setBounds(0, 0, 300, 400);
        add(jsp);
        //***********************************
        pro_id = new JLabel("Id");
        pro_id.setBounds(315, 10, 100, 30);
        pro_id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(pro_id);
        pro_id1 = new JTextField();
        pro_id1.setBounds(390, 10, 170, 30);
        add(pro_id1);

        pro_name = new JLabel("pro Name");
        pro_name.setBounds(315, 50, 100, 30);
        pro_name.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(pro_name);
        pro_name1 = new JTextField();
        pro_name1.setBounds(390, 50, 170, 30);
        add(pro_name1);

        pro_price = new JLabel("pro Price");
        pro_price.setBounds(315, 90, 100, 30);
        pro_price.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 13));
        add(pro_price);
        pro_price1 = new JTextField();
        pro_price1.setBounds(390, 90, 170, 30);
        add(pro_price1);

        pro_ammount = new JLabel("pro Ammount");
        pro_ammount.setBounds(315, 130, 100, 30);
        pro_ammount.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 11));
        add(pro_ammount);
        pro_ammount1 = new JTextField();
        pro_ammount1.setBounds(388, 130, 170, 30);
        add(pro_ammount1);

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
                if (pro_name1.getText().isEmpty() && pro_price1.getText().isEmpty() && pro_ammount1.getText().isEmpty() && pro_id1.isEditable()) {
                    jop.showMessageDialog(frame, "Enter items !!");
                } else if (pro_id1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter id !!");
                } else if (pro_name1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter first name !!");
                } else if (pro_price1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter last name !!");
                } else if (pro_ammount1.getText().isEmpty()) {
                    jop.showMessageDialog(frame, "Enter Age of Employee !!");
                } else {

                    database.inventory_db.update(Integer.parseInt(pro_id1.getText()), pro_name1.getText(),
                            Float.parseFloat(pro_price1.getText()), Float.parseFloat(pro_ammount1.getText()));
                    jop.showMessageDialog(frame, "Updated Successfull");
                    a = new String[arr.size()][4];
                    for (int i = 0; i < arr.size(); i++) {
                        a[i][0] = Integer.toString(arr.get(i).getPro_id());
                        a[i][1] = arr.get(i).getPro_name();
                        a[i][2] = Float.toString(arr.get(i).getPro_price());
                        a[i][3] = Float.toString(arr.get(i).getPro_ammount());

                    }
                   
                }
            } catch (Exception j) {
                System.out.println(j.getMessage());
            }
        }

    }
}
