import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Map {
    
    private BufferedImage fullImage;
    private int height = 0;
    private int width = 0;
    private int[][] blocks;
    private Character[] objects = new Character[10];
    
    public void initializeImage(String path, int imgHeight, int imgWidth) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(path));
        }
        catch (IOException e) {}
        fullImage = img;
        height = imgHeight;
        width = imgWidth;
        blocks = new int[width/50][height/50];
    }
    
    public BufferedImage getFullImage() {
        return fullImage;
    }
    
    public BufferedImage getPart(int x1, int y1, int x2, int y2) {
        x2 += -x1;
        y2 += -y1;
        BufferedImage img = fullImage.getSubimage(x1, y1, x2, y2);
        return img;
    }
    
    public void addObject(Character object, int entry) {
        objects[entry] = object;
    }
}
