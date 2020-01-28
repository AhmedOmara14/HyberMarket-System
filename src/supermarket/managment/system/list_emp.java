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
public class list_emp extends JPanel  {
    JTable jTable;
    JScrollPane jsp;
    String a[][];
    String header[]={"id","username","password","Age","Department","Gender"};
    ArrayList<user> arr;
    public list_emp() throws SQLException, ClassNotFoundException {
        this.arr = database.Admin_DB.List();
        this.setLayout(null);
        a=new String[arr.size()][6];
        for(int i=0;i<arr.size();i++)
        {
            a[i][0]=arr.get(i).getId()+"";
            a[i][1]=arr.get(i).getFname();
            a[i][2]=arr.get(i).getLname();
            a[i][3]=arr.get(i).getAge()+"";
            a[i][4]=arr.get(i).getDepartment();
            a[i][5]=arr.get(i).getGender();   
        }
        
        jTable=new JTable(a, header);
        jsp =new JScrollPane(jTable);
        jsp.setBounds(0, 0, 750, 400);
        add(jsp);
        
    }
    
   
    
}
