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
public class products {
   private String pro_name;
   private int pro_id;
   private float pro_price,pro_ammount;

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public products(float pro_ammount) {
        this.pro_ammount = pro_ammount;
    }
    

    public products(String pro_name) {
        this.pro_name = pro_name;
    }

    public products( int pro_id,String pro_name) {
           this.pro_id = pro_id;
        this.pro_name = pro_name;
     
    }

    public products(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public void setPro_price(float pro_price) {
        this.pro_price = pro_price;
    }

    public void setPro_ammount(float pro_ammount) {
        this.pro_ammount = pro_ammount;
    }

    public String getPro_name() {
        return pro_name;
    }

    public int getPro_id() {
        return pro_id;
    }

    public float getPro_price() {
        return pro_price;
    }

    public float getPro_ammount() {
        return pro_ammount;
    }

    public products( int pro_id,String pro_name, float pro_price, float pro_ammount) {
        this.pro_name = pro_name;
        this.pro_id = pro_id;
        this.pro_price = pro_price;
        this.pro_ammount = pro_ammount;
    }





}

    
