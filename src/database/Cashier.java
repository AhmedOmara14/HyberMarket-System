/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.Admin_DB.connect;
import static database.Admin_DB.get_info;
import static database.inventory_db.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import supermarket.managment.system.Cashier1;
import supermarket.managment.system.admin;
import supermarket.managment.system.products;
import supermarket.managment.system.user;

/**
 *
 * @author Ahmed
 */
public class Cashier {

    public static Connection connect() throws ClassNotFoundException {

        Connection con = null;

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=pro_db;user=admin;password=admin";

        try {

            con = DriverManager.getConnection(connectionURL);
            System.out.println("Connection is successfull");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
        return con;
    }

       //********************
    public static ArrayList<Cashier1> List() throws SQLException, ClassNotFoundException {
        ArrayList<Cashier1> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from cashier");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            list.add(
                    new Cashier1(rs.getInt("Quantity"),
                            rs.getString("product_name"), rs.getInt("product_id"),
                            rs.getInt("price")));
        }

        return list;
    }
       
    //*******************

     public static void insert(int bill_num,String customer_name,int product_id
              ,String product_name,int Quantity,String Date1,int price) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("insert into cashier values (?,?,?,?,?,?,?)");
            ps.setInt(1, bill_num); 
            ps.setString(2, customer_name);
            ps.setInt(3, product_id);
            ps.setString(4, product_name);
            ps.setInt(5, Quantity);
            ps.setString(6, Date1);
            ps.setInt(7, price);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
       public static ArrayList<Cashier1> get_info() throws SQLException, ClassNotFoundException {
        ArrayList<Cashier1> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from cashier");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Cashier1(rs.getString("product_name")));
        }
        return list;
    }
        
    
     public static int Check(String name) throws SQLException, ClassNotFoundException {
        ArrayList<Cashier1> arrayList = get_info();
        int x = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getName().equals(name)) {
                    x = 1;
                    //successfull
                    break;  
                }
            else x=3; 
              
        }
        
        return x;
    }
      public static ArrayList<Cashier1> search(int bill_num) throws SQLException, ClassNotFoundException {
        ArrayList<Cashier1> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from cashier where bill_num=?");
        ps.setInt(1 , bill_num);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(
                    new Cashier1
                   (rs.getInt("Quantity"),rs.getString("product_name"),
                    rs.getInt("product_id"), rs.getInt("price" )));
            }
        return list;
    }
}
     