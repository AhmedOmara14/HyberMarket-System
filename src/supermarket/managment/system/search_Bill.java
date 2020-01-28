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
import java.awt.print.PrinterException;
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

/**
 *
 * @author Ahmed
 */
public class search_Bill extends JPanel implements ActionListener {

    JLabel search;
    JTextField search1;
    JTable table;
    JButton searc,print;
    JScrollPane jsp;
    String a[][] = null;
    JOptionPane jop;
    String header[] = {"Quantity", "Name", "Product Id", "Price"};
    ArrayList<Cashier1> arr;
    private Component frame;

    public search_Bill() throws SQLException, ClassNotFoundException {
        this.setLayout(null);
        search = new JLabel("Enter Bill num");
        search.setBounds(300, 100, 200, 30);
        search.setFont(new Font(TOOL_TIP_TEXT_KEY, Font.BOLD, 15));
        add(search);
        search1 = new JTextField();
        search1.setBounds(430, 100, 200, 30);
        add(search1);
        searc = new JButton("Search");
        searc.setBounds(330, 150, 100, 30);
        searc.addActionListener(this);
        
        print = new JButton("Print");
        print.setBounds(460, 150, 100, 30);
        print.setBackground(Color.white);
        print.addActionListener(this);
        add(print);
        searc.setBackground(Color.white);
        add(searc);
        a = new String[20][6];

        table = new JTable(a, header);
        jsp = new JScrollPane(table);
        jsp.setBounds(0, 200, 1000, 800);
        add(jsp);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == print) {
            MessageFormat format = new MessageFormat("Super Market");
            MessageFormat format2 = new MessageFormat("page 1");

            try {
                table.print(JTable.PrintMode.NORMAL, format, format2);
            } catch (PrinterException ex) {
                Logger.getLogger(search_Bill.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == searc) {
            if (search1.getText().isEmpty()) {
                jop.showMessageDialog(frame, "Enter bill num !!");
            } else {
                a = new String[20][6];

                table = new JTable(a, header);
                jsp = new JScrollPane(table);
                jsp.setBounds(0, 200, 1000, 800);
                add(jsp);
                try {

                    this.arr = database.Cashier.search(Integer.parseInt(search1.getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(search_Bill.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(search_Bill.class.getName()).log(Level.SEVERE, null, ex);
                }

                for (int i = 0; i < arr.size(); i++) {
                    a[i][0] = arr.get(i).getQuantity() + "";
                    a[i][1] = arr.get(i).getName();
                    a[i][2] = arr.get(i).getRoduct_id() + "";
                    a[i][3] = arr.get(i).getPrice() + "";

                }
                table = new JTable(a, header);
                jsp = new JScrollPane(table);
                jsp.setBounds(0, 200, 1000, 800);
                add(jsp);

            }

        }
        if (e.getSource() == print) {
            MessageFormat format = new MessageFormat("Super Market");
            MessageFormat format2 = new MessageFormat("page 1");

            try {
                table.print(JTable.PrintMode.NORMAL, format, format2);
            } catch (PrinterException ex) {
                Logger.getLogger(search_Bill.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
