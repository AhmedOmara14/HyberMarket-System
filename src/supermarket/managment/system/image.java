/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

import com.sun.javafx.tk.Toolkit;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Ahmed
 */
public class image extends JPanel{
    private ImageIcon img;

    public image() {
        this.setLayout(null);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        img=new ImageIcon(getClass().getResource("cart.jpg"));
        img.paintIcon(this, g, 0, 0);
    }
    
}
