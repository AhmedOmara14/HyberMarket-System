/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import supermarket.managment.system.admin;
import supermarket.managment.system.user;

public class Admin_DB {
    
    //..................to make a conection..................
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
    public static void insert(int id,String User_name,String Pass_word,int age,String add,String gender) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("insert into Employee values (?,?,?,?,?,?)");
            ps.setInt(1, id); 
            ps.setString(2, User_name);
            ps.setString(3, Pass_word);
            ps.setInt(4, age);
            ps.setString(5, add);
            ps.setString(6, gender);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    //......................... get info from database from tabel 'admin' and i will use it in check ...........
    //..........................................
    public static ArrayList<user> get_info() throws SQLException, ClassNotFoundException {
       ArrayList<user> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Employee");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new user(rs.getString("Username"),rs.getString("password"),
                     rs.getString("Department")
                    ));
            }
        return list;
    }
    //get info about employees ..................
    //...........................................
     public static ArrayList<user> List() throws SQLException, ClassNotFoundException {
        ArrayList<user> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Employee");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new user(rs.getInt("id"),rs.getString("Username"),rs.getString("password"),
                    rs.getInt("age"), rs.getString("Department"),
                    rs.getString("gender")));
            }
        return list;
    }
     // get id for search ...............
     //................................
     
     public static ArrayList<user> search(int id) throws SQLException, ClassNotFoundException {
        ArrayList<user> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Employee where id=?");
        ps.setInt(1 , id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new user(rs.getInt("id"),rs.getString("Username"),rs.getString("password"),
                    rs.getInt("age"), rs.getString("Department"),
                    rs.getString("gender")));
            }
        return list;
    }
      public static ArrayList<user> search_join(int id) throws SQLException, ClassNotFoundException {
        ArrayList<user> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from Employee.Username,Marketing.offer from orders inner join "
                + "cashier on  Employee.id=cashier.id");
        ps.setInt(1 , id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new user(rs.getInt("id"),rs.getString("Username"),rs.getString("password"),
                    rs.getInt("age"), rs.getString("Department"),
                    rs.getString("gender")));
            }
        return list;
    }

     
       public static void update(int id,String fname,String lname,int age,String add,String gender) throws ClassNotFoundException{
        try {
            Connection con=connect();
          
             java.sql.PreparedStatement ps = con.prepareStatement("update Employee set Username=?, password=?, age=?, "
                   + "Department=? ,gender=?  WHERE id=? ");
          
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setInt(3, age);
            ps.setString(4, add);
            ps.setString(5, gender);
            ps.setInt(6, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
        public static void update2(int id,String fname,String lname,int age,String gender) throws ClassNotFoundException{
        try {
            Connection con=connect();
          
             java.sql.PreparedStatement ps = con.prepareStatement("update Employee set Username=?, password=?, age=?, "
                   + "gender=?  WHERE id=? ");
          
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setInt(3, age);
           
            ps.setString(4, gender);
            ps.setInt(5, id);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
        }
     //cheack...................
     //.........................
    public static int Check(String us_name, String pass_wo,Object depart) throws SQLException, ClassNotFoundException {
        ArrayList<user> arrayList = get_info();
        int x = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getUser_name().equals(us_name)) {
                
                if (arrayList.get(i).getPassword().equals(pass_wo)) {
                    
                    if ( arrayList.get(i).getDepartment().equals(depart)) {
                        
                    x = 1;
                    //successfull
                    break;
                    
                }else x=3; 
                
                }else x=2;
                   
                }
            else x=0;
             
        }
        
        return x;
    }
    
    //**************************
    public static void delete(int id) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("delete from Employee where id =?");
            ps.setInt(1, id); 
            ps.executeUpdate();
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }
}
