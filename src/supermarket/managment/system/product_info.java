/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Ahmed
 */
public class product_info extends JPanel {
    JTable jTable;
    JScrollPane jsp;
    String a[][];
    ArrayList<products> arr;
    String header[] = {"pro Id", "pro Name", "pro Price", "pro Ammount"};

    public product_info() throws SQLException, ClassNotFoundException {
        this.arr = database.inventory_db.List();
        this.setLayout(null);
        a=new String[arr.size()][4];
        for(int i=0;i<arr.size();i++)
        {
            a[i][0] = Integer.toString( arr.get(i).getPro_id());
            a[i][1] = arr.get(i).getPro_name();
            a[i][2] =Float.toString( arr.get(i).getPro_price());
            a[i][3] =Float.toString( arr.get(i).getPro_ammount());
            
        }
        jTable=new JTable(a, header);
        jsp =new JScrollPane(jTable);
        jsp.setBounds(0, 0, 1000, 900);
        add(jsp);
        
    }
    
    
}
