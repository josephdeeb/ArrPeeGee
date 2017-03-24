import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Test {
    public static void main(String[] args) {
        Character[] objects = new Character[128];
        
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("src/circle.png"));
        }
        catch (IOException e) {}
        
        Character carl = new Character(resizeImage(50, 50, img));
        
        objects[0] = carl;
        
                
                
        
        Window test = new Window(800, 800, "TEST", carl);
        test.initializeCamera();
        test.updateCamera(objects);
        test.addKeyListener(test);
        
        public void keyTyped(KeyEvent e) {}
        public void keyReleased(KeyEvent e) {}
        
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                carl.moveY(5);
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                carl.moveX(5);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                carl.moveY(-5);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                carl.moveX(-5);
            }
        }
        
/*        
        for (int z = 0; z < 250; z++) {
            carl.moveX(1);
            carl.moveY(1);
            stop(10);
            test.updateCamera(objects);
        }
*/
        System.out.println(carl.getXcoord());
        
    }
    
    public static BufferedImage resizeImage(int newWidth, int newHeight, BufferedImage original) {
        BufferedImage resized = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(original, 0, 0, newWidth, newHeight, 0, 0, original.getWidth(), original.getHeight(), null);
        g.dispose();
        return resized;
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
