import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Game{
    private Character[] objects = new Character[128];
    
    public Game() {
        
    }
    
    public void addObject(Character object, int entry) {
        objects[entry] = object;
    }
    
    public int nextAvailableEntry() {
        for (int x = 0; x < objects.length; x++) {
            if (objects[x] == null) {
                return x;
            }
        }
        return 999;
    }
    
    public void addObject(Character character, Map map) {
        int x = character.getX();
        int y = character.getY();
        int entry = nextAvailableEntry();
        if (entry == 999)
            return;
        if (!checkBounds(x, y, character.getWidth(), character.getHeight(), map.getBlocks()))
            return;
        objects[entry] = character;
        // Do code to actually apply sprite to map
           
    }
    
    // Code taken from http://stackoverflow.com/questions/4216123/how-to-scale-a-bufferedimage
    public BufferedImage resizeImage(int newWidth, int newHeight, BufferedImage original) {
        BufferedImage resized = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(original, 0, 0, newWidth, newHeight, 0, 0, original.getWidth(), original.getHeight(), null);
        g.dispose();
        return resized;
    }
    
    public boolean checkBounds(int x, int y, int width, int height, int[][] blocks) {
        if ((x < 0) || (y < 0) || (width < 0) || (height < 0))
            return false;
        
        // check top
        int xBlock = x / 50;
        int yBlock = (y - (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check top-right
        xBlock = (x + (width / 2)) / 50;
        yBlock = (y - (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check right
        xBlock = (x + (width / 2)) / 50;
        yBlock = y / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check bottom-right
        xBlock = (x + (width / 2)) / 50;
        yBlock = (y + (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check bottom
        xBlock = x / 50;
        yBlock = (y + (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check bottom-left
        xBlock = (x - (width / 2)) / 50;
        yBlock = (y + (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check left
        xBlock = (x - (width / 2)) / 50;
        yBlock = y / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        
        // check top-left
        xBlock = (x - (width / 2)) / 50;
        yBlock = (y - (height / 2)) / 50;
        if (blocks[xBlock][yBlock] == 0)
            return false;
        return true;
    }
}
