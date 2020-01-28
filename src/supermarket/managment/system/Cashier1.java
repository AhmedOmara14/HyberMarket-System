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
public class Cashier1 {
    private int Bill_num;
    private int Quantity;
    private String Name;
    private int Roduct_id;
    private int Price;

    public Cashier1() {
    }

    public int getBill_num() {
        return Bill_num;
    }

    public void setBill_num(int Bill_num) {
        this.Bill_num = Bill_num;
    }

    public Cashier1(int Quantity, String Name, int Roduct_id, int Price) {
        this.Quantity = Quantity;
        this.Name = Name;
        this.Roduct_id = Roduct_id;
        this.Price = Price;
    }

    public Cashier1(String Name) {
        this.Name = Name;
    }

   
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRoduct_id() {
        return Roduct_id;
    }

    public void setRoduct_id(int Roduct_id) {
        this.Roduct_id = Roduct_id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }
    
    
}
