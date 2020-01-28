/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import sun.security.x509.DeltaCRLIndicatorExtension;

/**
 *
 * @author Ahmed
 */
public class inventory_screen extends JFrame {

    JTabbedPane jtp;
    add_pro AD;
    list_pro ls;
    search_pro sc;
    update_pro up;
    delete_pro de;
    Marketing_Offer of;

    public inventory_screen() {
    }

    public void show_inventory_screen() throws SQLException, ClassNotFoundException {

        AD = new add_pro();
        ls = new list_pro();
        sc=new search_pro();
        up=new update_pro();
        de=new delete_pro();
        of=new Marketing_Offer();
        jtp = new JTabbedPane();
        jtp.add("ADD Product", AD);
        jtp.add("Search on product",sc);
        jtp.add("List Of Products", ls);
        jtp.add("Update product",up);
        jtp.add("Offer",of);
        
        jtp.add("Delete product",de);
        add(jtp);
        
        //.................
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(650, 400);
    }

}
