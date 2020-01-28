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
public class Markets_offer {
     private String Date1;
     private String pro_name;
     private String offer;

    public Markets_offer(String Date1, String pro_name, String offer) {
        this.Date1 = Date1;
        this.pro_name = pro_name;
        this.offer = offer;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    } 

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String Date1) {
        this.Date1 = Date1;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }
     
    
    
}
