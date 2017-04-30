/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegistroPersona;


import java.awt.Component;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author FGALLARDO
 */
public class MyIcon implements Icon{
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y){
        ImageIcon image = new ImageIcon("/Imagenes/check-in122x122px.png");
        ImageIcon ico = new ImageIcon(image.getImage().getScaledInstance(getIconWidth(), getIconHeight(), Image.SCALE_DEFAULT));
        //g.drawImage(ico, x, y, c);
    }
    
    @Override
    public int getIconWidth(){
        return 50;
    }
    
    @Override
    public int getIconHeight(){
        return 50;
    }
}
