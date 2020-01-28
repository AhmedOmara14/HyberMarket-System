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
public class admin_screen extends JFrame {

    JTabbedPane jtp;
    add_emp AD;
    list_emp ls;
    search_emp sc;
    update_emp up;
    delete_emp de;
    Reports_emp re;

    public admin_screen() {
    }

    public void show_second_screen() throws SQLException, ClassNotFoundException {

        AD = new add_emp();
        ls = new list_emp();
        sc=new search_emp();
        up=new update_emp();
        de=new delete_emp();
        re=new Reports_emp();
        jtp = new JTabbedPane();
        jtp.add("ADD Employee", AD);
        jtp.add("Search",sc);
        jtp.add("List Of Employee", ls);
        jtp.add("Update",up);
        jtp.add("Delete",de);
        jtp.add("Reports",re);
        add(jtp);
        
        //.................
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(600, 400);
    }

}
