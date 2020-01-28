/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 *
 * @author Ahmed
 */
public class Cashier_Screen extends JFrame{
    JTabbedPane jtp;
    create_Bill CB;
    search_Bill SB;
    product_info pi;

    public Cashier_Screen() {
    }
    
    public void show_Casier_Screen() throws SQLException, ClassNotFoundException{
        
        CB = new create_Bill();
        SB = new search_Bill();
        pi=new product_info();
      
        jtp = new JTabbedPane();
        jtp.setSize(100, 100);
        jtp.add("Create Bill", CB);
        jtp.add("Search Bill",SB);
        jtp.add("Product Information",pi);
      
        add(jtp);
      
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(1000, 700);
    }
}