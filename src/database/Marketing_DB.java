/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import static database.Admin_DB.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import supermarket.managment.system.Markets_Report;
import supermarket.managment.system.Markets_offer;
import supermarket.managment.system.admin;

/**
 *
 * @author Ahmed
 */
public class Marketing_DB {
     public static Connection connect() throws ClassNotFoundException{ 

    Connection con =null; 

    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    String connectionURL="jdbc:sqlserver://localhost:1433;databaseName=pro_db;user=admin;password=admin"; 

    try{

    con=DriverManager.getConnection(connectionURL);
    System.out.println("Connection is successfull");

    }

    catch(SQLException e){

     System.out.println(e.getMessage());

    }
        return con;
    }

    //...................insert in database in table 'user'.............
    //.....................................................
    public static void insert(String offer,String date,String pro_name,String report) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("insert into Marketing values (?,?,?,?)");
            ps.setString(1, offer); 
            ps.setString(2, date); 
            ps.setString(3, report);
            ps.setString(4, pro_name);            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Markets_Report> List_report() throws SQLException, ClassNotFoundException {
        ArrayList<Markets_Report> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Marketing");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new Markets_Report(rs.getString("Date"),rs.getString("report")));
            }
        return list;
    }
    public static ArrayList<Markets_offer> get_offer() throws SQLException, ClassNotFoundException {
        ArrayList<Markets_offer> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Marketing");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new Markets_offer(rs.getString("Date"),rs.getString("pro_name"), rs.getString("offer")));
        }
        return list;
    }
}