import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Character extends JLabel {
    private int health = 0;
    private double xcoord = 0;
    private double ycoord = 0;
    private BufferedImage picture;
    private ImageIcon icon;
    
    public Character(BufferedImage img) {
        picture = img;
        icon = new ImageIcon(img);
        this.setSize(picture.getWidth(), picture.getHeight());
        this.setIcon(icon);
        this.setVisible(true);
    }
    
    public BufferedImage getPicture() {
        return picture;
    }
    
    public int getXcoord() {
        int x = (int) Math.round(xcoord);
        return x;
    }
    
    public int getYcoord() {
        int y = (int) Math.round(ycoord);
        return y;
    }
    
    public void moveX(double amount) {
        xcoord += amount;
    }
    
    public void moveY(double amount) {
        ycoord += amount;
    }
    
}
