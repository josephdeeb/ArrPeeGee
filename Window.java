import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Window extends JFrame implements KeyListener {
    private Camera cam;
    private Game game;
    private Character carl;
    
    public Window(int width, int height, String name, Character guy) {
        this.setSize(width, height);
        this.setName(name);
        this.setVisible(true);
        carl = guy;
        this.addKeyListener(this);
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
