import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class TestMap {
    public static void main(String[] args) {
        
        Map test = new Map();
        test.initializeImage("src/Map.jpg", 800, 800);
        
        JFrame window = new JFrame("Game");
        window.setSize(800, 800);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        
        JPanel game = new JPanel();
        game.setVisible(true);
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(test.getFullImage()));
        
        game.add(label);
        window.add(game);
        window.pack();
        
        JLabel c1 = new JLabel();
        
/*        
        int y = 0;
        
        for(int x = 0;(x < 200) && (y < 200);x+=1, y+=1) {
            stop(10);
            int x2 = x + 200;
            int y2 = y + 200;
            System.out.println(x2 + "\t" + y2);
            label.setIcon(new ImageIcon(test.getPart(x, y, x2, y2)));
        }
*/
    }
    
    public static void stop(int time) {
        try {
            Thread.sleep(time);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
