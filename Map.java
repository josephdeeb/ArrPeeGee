import java.awt.*;
import javax.swing.*;

public class Map {
    public static void main(String[] args) {
        JFrame window = new JFrame("Game");
        window.setSize(800, 800);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        JPanel game = new JPanel();
        game.setBackground(Color.BLACK);
        game.setVisible(true);
        window.add(game);
    }
}
