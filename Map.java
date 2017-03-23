

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
    
    public BufferedImage getPart(int x, int y, int width, int height) {
        BufferedImage img = fullImage.getSubimage(x, y, width, height);
        return img;
    }
    
    public int[][] getBlocks() {
        return blocks;
    }
}
