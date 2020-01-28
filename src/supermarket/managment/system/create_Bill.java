/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import static database.Cashier.connect;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ahmed
 */
public class create_Bill extends JPanel implements ActionListener {

    JLabel Billnum, Customername, Product_id, name_pro, quantity, Date, price, total;
    JTextField Billnum1, Customername1, Product_id1, name_pro1, quantity1, Date1, price1, total1;
    JButton add_Em, new1, back, print;
    JOptionPane jop;
    JTable table;
    JTable table2;
    JScrollPane jsp;
    int sum = 0;
    String a[][];
    String b[][];
    String header[] = {"Quantity", "Name", "Product Id", "Price"};
    ArrayList<Cashier1> arr;
    private Component frame;

    public create_Bill() throws SQLException, ClassNotFoundException {
        this.setLayout(null);
        Billnum = new JLabel("Bill num");
        Customername = new JLabel("Customer name");
        Product_id = new JLabel("Product Id");
        name_pro = new JLabel("Product Name");
        quantity = new JLabel("Quantity");
        price = new JLabel("Price");
        Date = new JLabel("Date");
        total = new JLabel("Total");
        Billnum.setBounds(20, 50, 150, 30);
        Customername.setBounds(20, 100, 150, 30);
        Product_id.setBounds(20, 150, 150, 30);
        name_pro.setBounds(20, 200, 150, 30);
        quantity.setBounds(20, 250, 150, 30);
        price.setBounds(20, 300, 150, 30);
        Date.setBounds(650, 46, 150, 30);
        total.setBounds(650, 530, 150, 30);
        Billnum.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        Customername.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        Product_id.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        name_pro.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        quantity.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        price.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        total.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));

        Date.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));

        add(Billnum);
        add(Customername);
        add(Product_id);
        add(name_pro);
        add(quantity);
        add(Date);
        add(price);
        add(total);
        Billnum1 = new JTextField();
        Customername1 = new JTextField();
        Product_id1 = new JTextField();
        name_pro1 = new JTextField();
        quantity1 = new JTextField();
        price1 = new JTextField();
        Date1 = new JTextField();
        total1 = new JTextField();
        Billnum1.setBounds(210, 50, 170, 30);
        Customername1.setBounds(210, 100, 170, 30);
        Product_id1.setBounds(210, 150, 170, 30);
        name_pro1.setBounds(210, 200, 170, 30);
        quantity1.setBounds(210, 250, 170, 30);
        Date1.setBounds(710, 47, 180, 30);
        total1.setBounds(710, 530, 170, 30);

        price1.setBounds(210, 300, 170, 30);

        add(Billnum1);
        add(Customername1);
        add(Product_id1);
        add(name_pro1);
        add(quantity1);
        add(Date1);
        add(price1);
        add(total1);
        add_Em = new JButton("ADD");
        add_Em.setBounds(50, 380, 80, 25);
        add_Em.setBackground(Color.white);
        add_Em.addActionListener(this);
        add(add_Em);
        new1 = new JButton("NEW");
        new1.setBounds(150, 380, 80, 25);
        new1.setBackground(Color.white);
        new1.addActionListener(this);
        add(new1);
        back = new JButton("Back");
        back.setBounds(250, 380, 80, 25);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);
        print = new JButton("Print");
        print.setBounds(700, 575, 100, 30);
        print.setBackground(Color.white);
        print.addActionListener(this);
        add(print);

        this.arr = database.Cashier.List();
         a = new String[arr.size()][5];

        for (int i = 0; i < arr.size(); i++) {
            a[i][0] = arr.get(i).getQuantity() + "";
            a[i][1] = arr.get(i).getName();
            a[i][2] = arr.get(i).getRoduct_id() + "";
            a[i][3] = arr.get(i).getPrice() + "";
            sum += arr.get(i).getPrice();

        }
        total1.setText(sum + "");

        table = new JTable(a, header);
        jsp = new JScrollPane(table);
        jsp.setBounds(540, 100, 430, 400);
        add(jsp);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == new1) {
            Billnum1.setText("");
            Customername1.setText("");
            Product_id1.setText("");
            name_pro1.setText("");
            quantity1.setText("");
            price1.setText("");
            total1.setText("");

           
           table.setModel(new DefaultTableModel(a, header));
           
        }
        if (e.getSource() == print) {
            MessageFormat format = new MessageFormat("Super Market");
            MessageFormat format2 = new MessageFormat("page 1");

            try {
                table.print(JTable.PrintMode.NORMAL, format, format2);
            } catch (PrinterException ex) {
                Logger.getLogger(create_Bill.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == add_Em) {
            try {
                 int i = database.inventory_db.Check_id(Integer.parseInt(Product_id1.getText()),name_pro1.getText());
                 
            
             //JOptionPane.showMessageDialog(frame , "the price of order is " +database.inventory_db.select(Integer.parseInt(Product_id1.getText()),Float.parseFloat( quantity1.getText()) );
            
                if (i == 3) {
                    jop.showMessageDialog( frame , "the product not found");
                } 
                else if(i==2){
                     jop.showMessageDialog( frame , "the product not found");
                }
                else if(i==1){
                     int x = database.inventory_db.make_order(Integer.parseInt(Product_id1.getText()),Float.parseFloat(quantity1.getText()));

                if (x == 1){
                    jop.showMessageDialog( frame , "be carefull product "+Product_id1.getText()+" become less than 20");
                 }
               else if (x==0){
                 
                    jop.showMessageDialog( frame , "Error :: the product "+Product_id1.getText()+" has no ammount in inventory");
               }
                database.Cashier.insert(Integer.parseInt(Billnum1.getText()),
                        Customername1.getText(), Integer.parseInt(Product_id1.getText()),
                        name_pro1.getText(), Integer.parseInt(quantity1.getText()),
                        Date1.getText(),
                        Integer.parseInt(price1.getText()));

                jop.showMessageDialog(frame, "Successfull !!");
                this.arr = database.Cashier.List();
                a = new String[arr.size()][5];
                
                for ( i = 0; i < arr.size(); i++) {
                    a[i][0] = arr.get(i).getQuantity() + "";
                    a[i][1] = arr.get(i).getName();
                    a[i][2] = arr.get(i).getRoduct_id() + "";
                    a[i][3] = arr.get(i).getPrice() + "";
                    sum += arr.get(i).getPrice();

                }
                total1.setText(sum + "");

                table = new JTable(a, header);
                jsp = new JScrollPane(table);
                jsp.setBounds(540, 100, 430, 400);
                add(jsp);
               
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(create_Bill.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(create_Bill.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if (e.getSource() == back) {
            this.setVisible(false);
            new login().show_first_screen();
        }
    }
}
