import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class ObjectHandler {
    
    // Fix so that it actually checks to see if it's possible for the block to be there in order to not go out of bounds.
    // Can possibly reduce CPU strain by having seperate checkBounds for each side, calling each one depending on movement.
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
    
    public void addObject(Map map, Character character, int x, int y, int width, int height) {
        int entry = map.nextAvailableEntry();
        if (entry == 999)
            return;
        if (!checkBounds(x, y, width, height, map.getBlocks()))
            return;
        map.addObject(character, entry);
        // WIP
        
    }
}
