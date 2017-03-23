import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Window extends JFrame {
    private Camera cam;
    private Game game;
    
    public Window(int width, int height, String name) {
        this.setSize(width, height);
        this.setName(name);
        this.setVisible(true);
    }
    
    public void initializeCamera() {
        Map test = new Map();
        test.initializeImage("src/Map.jpg", 800, 800);
        cam = new Camera(0, 0, 800, 800, test);
        this.add(cam);
    }
    
    public void updateCamera(Character[] objects) {
        cam.setScreen(objects);
    }
}
