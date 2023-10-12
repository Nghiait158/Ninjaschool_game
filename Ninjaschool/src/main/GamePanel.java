package main;
import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.Keyboardinput;
import inputs.Mouseinput;

public class GamePanel extends JPanel {
    
    private Mouseinput mouseinput;
    public GamePanel(){

        mouseinput= new Mouseinput();
        addKeyListener(new Keyboardinput());
        addMouseListener(mouseinput);
        addMouseMotionListener(mouseinput);
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);

        g.fillRect(100, 100, 50, 50);
    }
}
