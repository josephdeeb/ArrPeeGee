import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Camera extends JPanel {
    private int xcoord;
    private int ycoord;
    private Map map;
    
    public Camera(int x, int y, int initWidth, int initHeight, Map initMap) {
        xcoord = x;
        ycoord = y;
        map = initMap;
        this.setSize(initWidth, initHeight);
        this.setLayout(null);
    }
    
    public BufferedImage getMap() {
        BufferedImage pic = map.getPart(xcoord, ycoord, this.getWidth(), this.getHeight());
        return pic;
    }
    
    public boolean checkCoordinates(Character character) {
        return true;
    }
    
    public void setScreen(Character[] objects) {
        BufferedImage pic = getMap();
        int charXcoord = 0;
        int charYcoord = 0;
        for (int x = 0; x < objects.length; x++) {
            BufferedImage charPic = objects[x].getPicture();
            charXcoord = objects[x].getX();
            charYcoord = objects[x].getY();
            
        }
        
    }
}
