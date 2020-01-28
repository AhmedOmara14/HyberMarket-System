/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import javax.swing.JFrame;

/**
 *
 * @author Ahmed
 */
public class third extends JFrame {

    public third() {
    }
    
    public void show(){
        setTitle("SuperMarket Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        setSize(600, 400);
    }
}
