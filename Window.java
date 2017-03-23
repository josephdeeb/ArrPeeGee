import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.*;

public class Window extends JFrame {
    private Camera cam;
    
    public Window(int width, int height, String name) {
        this.setSize(width, height);
        this.setName(name);
        this.setVisible(true);
    }
}
