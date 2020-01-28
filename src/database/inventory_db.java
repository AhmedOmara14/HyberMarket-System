package database;

import com.mysql.jdbc.PreparedStatement;
import static database.Admin_DB.get_info;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import supermarket.managment.system.Cashier1;
import supermarket.managment.system.admin;
import supermarket.managment.system.products;
import supermarket.managment.system.user;

public class inventory_db {
    
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
    public static void insert(int pro_id,String pro_name,float pro_price,float pro_ammount) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("insert into products values (?,?,?,?)");
            ps.setInt(1, pro_id); 
            ps.setString(2, pro_name);
            ps.setFloat(3, pro_price);
            ps.setFloat(4, pro_ammount);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
    
    
    //get info about products ..................
    //...........................................
     public static ArrayList<products> List() throws SQLException, ClassNotFoundException {
        ArrayList<products> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from products");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new products(rs.getInt("pro_id"),rs.getString("pro_name"),rs.getFloat("pro_price"),
                    rs.getFloat("pro_amount") ) );
            }
        
        return list;
    }
      public static ArrayList<products> List_id_pro() throws SQLException, ClassNotFoundException {
        ArrayList<products> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from products");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new products(rs.getInt("pro_id"),rs.getString("pro_name") ) );
            }
        
        return list;
    }
     // get id for search on products
     public static ArrayList<products> List_id_amount() throws SQLException, ClassNotFoundException {
        ArrayList<products> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from products ");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
            list.add(new products(rs.getFloat("pro_amount") ) );
            }
        
        return list;
    }
     
     public static ArrayList<products> search(int pro_id) throws SQLException, ClassNotFoundException {
        ArrayList<products> list = new ArrayList<>();
        Connection con = connect();
        java.sql.PreparedStatement ps = con.prepareStatement("select * from products where pro_id=?");
        ps.setInt(1 , pro_id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        
             list.add(new products(rs.getInt("pro_id"),rs.getString("pro_name"),rs.getFloat("pro_price"),
                    rs.getFloat("pro_amount") ) );
            
            }
        return list;
    }
     //search
     
            //update products
     
       public static void update(int pro_id,String pro_name,float pro_price,float pro_ammount ) throws ClassNotFoundException{
        try {
            Connection con=connect();
          
             java.sql.PreparedStatement ps = con.prepareStatement("update products set  pro_name=?, pro_price=?, "
                   + "pro_ammount=?   WHERE pro_id=? ");
            ps.setString(1, pro_name);
            ps.setFloat(2, pro_price);
            ps.setFloat(3, pro_ammount);
            ps.setInt(4, pro_id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
     
       //************update amount
        public static void update_amount(int pro_id,float pro_ammount ) throws ClassNotFoundException{
        try {
            Connection con=connect();
          
             java.sql.PreparedStatement ps = con.prepareStatement("update products set pro_ammount=?   WHERE pro_id=? ");
          
           
           
            ps.setFloat(3, pro_ammount);
            ps.setInt(4, pro_id);
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
     
       
       
       // delete form products
    public static void delete(int pro_id) throws ClassNotFoundException{
        try {
            Connection con=connect();
            java.sql.PreparedStatement ps = con.prepareStatement("delete from products where pro_id =?");
            ps.setInt(1, pro_id); 
          
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }
    
     public static int Check_id(int  id, String pro_name) throws SQLException, ClassNotFoundException {
        ArrayList<products> arrayList = List_id_pro();
        int x = 0;
        for (int i = 0; i < arrayList.size(); i++) {
             if (arrayList.get(i).getPro_id()==id){
                if (arrayList.get(i).getPro_name().equals(pro_name)) {         
                    x = 1;
                    //successfull
                    break;
                    
                }else x=2;
             }else x=3; 
        }
        
        return x;
    }
     public static float select(int pid,float pammount) throws SQLException, ClassNotFoundException{
            ArrayList<products> arr=new ArrayList<>();
           arr= search(pid);
           
            
         
         float ammount=arr.get(0).getPro_ammount();
          ammount =ammount-pammount;
            System.out.println("succ");
    
            return ammount;
        }
      public static int make_order(int pid,float pammount) throws SQLException, ClassNotFoundException{
            Connection con = connect();
            float f;
            f=select( pid, pammount);
            java.sql.PreparedStatement pp = con.prepareStatement("update products set pro_amount=? where pro_id=?");
            pp.setFloat(1, f);
            pp.setInt(2,pid );
            pp.executeUpdate();
            
            if (f <= 20){
               return 1;
            }
            
            else if (f==0) 
                return 0;
            
            else return 2;
            
        
    }
     

   
  
}
