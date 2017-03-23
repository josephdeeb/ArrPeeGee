import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {
    public static void main(String[] args) {
        Character[] objects = new Character[128];
        
        BufferedImage img = null;
        
        try {
            img = ImageIO.read(new File("src/circle.png"));
        }
        catch (IOException e) {}
        
        Character carl = new Character(resizeImage(25, 25, img));
        
        objects[0] = carl;
                
                
        
        Window test = new Window(800, 800, "TEST");
        test.initializeCamera();
        test.updateCamera(objects);
    }
    
    public static BufferedImage resizeImage(int newWidth, int newHeight, BufferedImage original) {
        BufferedImage resized = new BufferedImage(newWidth, newHeight, original.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(original, 0, 0, newWidth, newHeight, 0, 0, original.getWidth(), original.getHeight(), null);
        g.dispose();
        return resized;
    }
}
