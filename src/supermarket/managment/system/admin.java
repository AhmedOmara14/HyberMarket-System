/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

/**
 *
 * @author Ahmed
 */
public class admin {
    private  String Username,Password;
    private Object Depart;
    public admin() {
    }

    public admin(String Username, String Password, Object Depart) {
        this.Username = Username;
        this.Password = Password;
        this.Depart = Depart;
    }

    public Object getDepart() {
        return Depart;
    }

    public void setDepart(String Depart) {
        this.Depart = Depart;
    }


 
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    
}
