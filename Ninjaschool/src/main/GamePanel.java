package main;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
    
    public GamePanel(){

    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.fillRect(20, 20, 50, 50);
    }
}
