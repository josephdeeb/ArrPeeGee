import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Character {
    private int health = 0;
    private double xcoord = 0;
    private double ycoord = 0;
    private BufferedImage picture;
    
    public Character(BufferedImage img) {
        picture = img;
    }
    
    public BufferedImage getPicture() {
        return picture;
    }
    
    public int getX() {
        int x = (int) Math.round(xcoord);
        return x;
    }
    
    public int getY() {
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
