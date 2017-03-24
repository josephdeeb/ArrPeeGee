import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Camera extends JLayeredPane {
    private int xcoord;
    private int ycoord;
    private JLabel background;
    private Map map;
    
    public Camera(int x, int y, int initWidth, int initHeight, Map initMap) {
        xcoord = x;
        ycoord = y;
        map = initMap;
        this.setSize(initWidth, initHeight);
        this.setLayout(null);
        background = new JLabel();
        background.setSize(initWidth, initHeight);
        background.setLocation(0, 0);
        this.add(background, 1);
        this.setVisible(true);
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
        background.setIcon(new ImageIcon(pic));
        int charXcoord = 0;
        int charYcoord = 0;
        for (int x = 0; x < objects.length; x++) {
            if (objects[x] == null)
                break;
            boolean check = checkCoordinates(objects[x]);
            if (!check)
                break;
            charXcoord = objects[x].getXcoord();
            charYcoord = objects[x].getYcoord();
            objects[x].setLocation(charXcoord, charYcoord);
            this.add(objects[x], 0);
        }
        
    }
}
